package com.immobel.controller;

import com.immobel.entity.Referral;
import com.immobel.service.ReferralService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.util.SimpleOrderedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/referrals")
public class ReferralController {

    private final ReferralService referralService;

    private final SolrClient solrClient;

    @Autowired
    public ReferralController(ReferralService referralService, SolrClient solrClient) {
        this.referralService = referralService;
        this.solrClient = solrClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Referral> getReferralById(@PathVariable Long id) {
        Referral referral = referralService.getReferralById(id);
        return ResponseEntity.ok(referral);
    }

    @GetMapping("/solr/{id}")
    public ResponseEntity<List<SolrDocument>> getReferralFromSolr(@PathVariable String id) {
        try {
            // Construct the Solr query
            SolrQuery query = new SolrQuery("recordType:referral-analytics AND referral_id:" + id);
            query.setFields("*");  // Retrieve all fields

            // Execute the query and get the response
            QueryResponse response = solrClient.query(query);

            // Extract results (assuming response is a SimpleOrderedMap)
            List<SolrDocument> docs = new ArrayList<>();
            if (response.getResponse() instanceof SimpleOrderedMap) {
                SimpleOrderedMap<Object> responseMap = (SimpleOrderedMap<Object>) response.getResponse();
                SolrDocumentList responseDocs = (SolrDocumentList) response.getResponse().get("response");

                for (SolrDocument doc : responseDocs) {
                    docs.add(doc);
                }
            }

            // Handle empty results gracefully (optional for clarity)
            if (docs.isEmpty()) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(docs);
        } catch (Exception e) {
            // Log the exception with a more informative message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/solr/check")
    public ResponseEntity<String> checkSolrConnection() {
        try {
            solrClient.ping();
            return ResponseEntity.ok("Solr connection is successful.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to establish Solr connection: " + e.getMessage());
        }
    }

}

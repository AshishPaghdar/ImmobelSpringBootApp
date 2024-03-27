package com.immobel.controller;

import com.immobel.entity.Referral;
import com.immobel.exception.ErrorResponse;
import com.immobel.service.ReferralService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
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
    public ResponseEntity<?> getReferralFromSolr(@PathVariable String id) {
        try {
            // Construct the Solr query
            SolrQuery query = new SolrQuery("recordType:referral-analytics AND referral_id:" + id);
            query.setFields("*");  // Retrieve all fields

            // Execute the query and get the response
            QueryResponse response = solrClient.query(query);

            // Extract results
            SolrDocumentList docs = response.getResults();

            // If no documents found, return a user-friendly error response
            if (docs.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Referral not found for ID: " + id));
            }

            // Return the documents
            List<SolrDocument> documents = new ArrayList<>(docs);
            return ResponseEntity.ok(documents);
        } catch (SolrException e) {
            // Log the exception with a more informative message
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException(e);
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

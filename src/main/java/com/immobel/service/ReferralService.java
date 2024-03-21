package com.immobel.service;

import com.immobel.entity.Referral;
import com.immobel.exception.ReferralNotFoundException;
import com.immobel.repository.ReferralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReferralService {
    private final ReferralRepository referralRepository;

    @Autowired
    public ReferralService(ReferralRepository referralRepository) {
        this.referralRepository = referralRepository;
    }

    public Referral getReferralById(Long id) {
        Optional<Referral> referralOptional = referralRepository.findById(id);
        return referralOptional.orElseThrow(() -> new ReferralNotFoundException("Referral not found with id: " + id));
    }
}

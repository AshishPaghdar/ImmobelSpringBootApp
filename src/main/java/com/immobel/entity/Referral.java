package com.immobel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "referrals", schema = "demodb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Referral {
    @Id
    private Long id;

    @Column(name = "awarding_date")
    private LocalDateTime awardingDate;

    @Column(name = "closing_date")
    private LocalDateTime closingDate;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "guid")
    private String guid;

    @Column(name = "referral_type")
    private Integer referralType;

    @Column(name = "status")
    private Integer status;

    @Column(name = "visibility")
    private Integer visibility;

    @Column(name = "receiving_profile")
    private Long receivingProfile;

    @Column(name = "receiving_profile_rating")
    private Long receivingProfileRating;

    @Column(name = "referral_cancel")
    private Long referralCancel;

    @Column(name = "sending_profile")
    private Long sendingProfile;

    @Column(name = "sending_profile_rating")
    private Long sendingProfileRating;

    @Column(name = "payed_for_docu_sign", nullable = false, columnDefinition = "boolean default false")
    private boolean payedForDocuSign;

    @Column(name = "paid_for_docusign", nullable = false, columnDefinition = "boolean default false")
    private boolean paidForDocusign;

    @Column(name = "paid_for_docu_sign", nullable = false, columnDefinition = "boolean default false")
    private boolean paidForDocuSign;

    @Column(name = "sending_agent")
    private Long sendingAgent;

    @Column(name = "receiving_agent")
    private Long receivingAgent;

    @Column(name = "latest_contract_id")
    private Long latestContractId;

    @Column(name = "head_start")
    private boolean headStart;

    @Column(name = "requested_agent")
    private Long requestedAgent;

    @Column(name = "shieldpay_project_id")
    private Long shieldPayProjectId;

    @Column(name = "requested_agent_mandatory")
    private boolean requestedAgentMandatory;

    @Column(name = "potential_incoming_commission_usd")
    private Double potentialIncomingCommissionUsd;

    @Column(name = "potential_referral_commission_usd")
    private Double potentialReferralCommissionUsd;

    @Column(name = "waiting_for_shieldpay_info")
    private Boolean waitingForShieldPayInfo;

    @Column(name = "transaction_status", length = 255)
    private String transactionStatus;

    @Column(name = "sending_profile_country", length = 255)
    private String sendingProfileCountry;

    @Column(name = "sending_profile_state", length = 255)
    private String sendingProfileState;

    @Column(name = "sending_email_to_relo_date")
    private LocalDateTime sendingEmailToReloDate;

    @Column(name = "brand_id", nullable = false, columnDefinition = "bigint default 1")
    private Long brandId;

    @Column(name = "other_brands_visible", nullable = false)
    private Boolean otherBrandsVisible;

    @Column(name = "other_brands_head_start", nullable = false)
    private Boolean otherBrandsHeadStart;

    @Column(name = "other_brands_head_start_end")
    private LocalDateTime otherBrandsHeadStartEnd;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "payment_platform", nullable = false, columnDefinition = "integer default 0")
    private Integer paymentPlatform;

    @Column(name = "payment_transfer_method")
    private Integer paymentTransferMethod;

    @Column(name = "payment_office_name")
    private String paymentOfficeName;

    @Column(name = "payment_office_address")
    private String paymentOfficeAddress;

    @Column(name = "payment_bank_name")
    private String paymentBankName;

    @Column(name = "payment_bank_address")
    private String paymentBankAddress;

    @Column(name = "payment_account_name")
    private String paymentAccountName;

    @Column(name = "payment_account_number")
    private String paymentAccountNumber;

    @Column(name = "payment_swift_code")
    private String paymentSwiftCode;

    @Column(name = "payment_iban_code")
    private String paymentIbanCode;

    @Column(name = "payment_comment")
    private String paymentComment;

    @Column(name = "payment_account_currency")
    private String paymentAccountCurrency;

    @Column(name = "successfully_closing_date")
    private LocalDateTime successfullyClosingDate;

    @Column(name = "original_service", length = 50)
    private String originalService;

    @Column(name = "original_id", length = 255)
    private String originalId;

    @Column(name = "is_internal_referral")
    private boolean isInternalReferral;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

    @Column(name = "created_by")
    private Long createdBy;

    @Column(name = "client_type", length = 255)
    private String clientType;

    @Column(name = "primary_preferred_mode_of_contact", length = 255)
    private String primaryPreferredModeOfContact;

    @Column(name = "primary_phone_type", length = 255)
    private String primaryPhoneType;

    @Column(name = "country_code", length = 255)
    private String countryCode;

    @Column(name = "secondary_preferred_mode_of_contact", length = 255)
    private String secondaryPreferredModeOfContact;

    @Column(name = "secondary_phone_type", length = 255)
    private String secondaryPhoneType;

    @Column(name = "additional_property_info")
    private String additionalPropertyInfo;

    @Column(name = "planned_visit_destination_market", length = 255)
    private String plannedVisitDestinationMarket;

    @Column(name = "planned_lease_period", length = 255)
    private String plannedLeasePeriod;

    @Column(name = "sending_relo")
    private Long sendingRelo;

    @Column(name = "receiving_relo")
    private Long receivingRelo;

    @Column(name = "is_credit_wanted", nullable = false)
    private Boolean isCreditWanted;

    @Column(name = "dont_have_any_colleagues")
    private Boolean dontHaveAnyColleagues;

    @Column(name = "integration_referral_id", length = 255)
    private String integrationReferralId;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "primary_client_preferred_phone_contact_mode", length = 255)
    private String primaryClientPreferredPhoneContactMode;

    @Column(name = "primary_client_time_zone", length = 255)
    private String primaryClientTimeZone;

    @Column(name = "referral_fee_percentage")
    private Double referralFeePercentage;

    @Column(name = "referral_fee_type", length = 255)
    private String referralFeeType;

    @Column(name = "referral_fee_value")
    private Double referralFeeValue;

    @Column(name = "rebate_to_client")
    private Double rebateToClient;

    @Column(name = "rebate_to_sending_side")
    private Double rebateToSendingSide;

    @Column(name = "rebate_to_brand")
    private Double rebateToBrand;

    @Column(name = "brand_fee_percentage")
    private Double brandFeePercentage;

    @Column(name = "counts_for_production", length = 255)
    private String countsForProduction;

    @Column(name = "rebate_reason", length = 255)
    private String rebateReason;

    @Column(name = "counts_for_revenue_generating_credit", length = 255, columnDefinition = "default 'NO'")
    private String countsForRevenueGeneratingCredit;

    @Column(name = "is_enabled_sync", nullable = false)
    private Boolean isEnabledSync;

    public boolean isPayedForDocuSign() {
        return payedForDocuSign;
    }

    public boolean isPaidForDocusign() {
        return paidForDocusign;
    }

    public boolean isPaidForDocuSign() {
        return paidForDocuSign;
    }

}

package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

/**
 * Detailed information about the retailer.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class RetailerDetailedInfo {

    private Integer id;
    private String name;
    private String slug;
    private Boolean available;
    private String key;
    private Integer position;
    @JsonProperty("created_at")
    private ZonedDateTime createdAt;
    @JsonProperty("legal_name")
    private String legalName;
    private String inn;
    private String phone;
    @JsonProperty("legal_address")
    private String legalAddress;
    @JsonProperty("contract_type")
    private String contractType;
    @JsonProperty("home_page_departments_depth")
    private Integer homePageDepartmentsDepth;
    @JsonProperty("short_name")
    private String shortName;
    private String description;
    @JsonProperty("secondary_color")
    private String secondaryColor;
    @JsonProperty("retailer_category_id")
    private Integer retailerCategoryId;
    @JsonProperty("seo_category")
    private String seoCategory;
    @JsonProperty("is_agent_contract_types")
    private Boolean isAgentContractTypes;
    @JsonProperty("phone_transfer")
    private String phoneTransfer;
    @JsonProperty("replacement_phone")
    private String replacementPhone;
    @JsonProperty("available_order_api_settings")
    private Boolean availableOrderApiSettings;
    @JsonProperty("is_certificates")
    private Boolean isCertificates;

    @JsonProperty("retailer_agreement")
    private RetailerAgreement retailerAgreement;
    private Appearance appearance;
    @JsonProperty("retailer_service_config")
    private RetailerServiceConfig retailerServiceConfig;
    @JsonProperty("promo_shield")
    private PromoShield promoShield;
    @JsonProperty("master_retailer")
    private RetailerReference masterRetailer;
    @JsonProperty("key_account_manager")
    private KeyAccountManager keyAccountManager;
    @JsonProperty("slave_retailers")
    private List<RetailerReference> slaveRetailers;
}

package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StorePaymentMethod {

    private Integer id;
    @JsonProperty("store_id")
    private Integer storeId;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("payment_method")
    private PaymentMethod paymentMethod;
}

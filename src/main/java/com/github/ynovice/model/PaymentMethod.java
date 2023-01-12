package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PaymentMethod {

    private Integer id;
    private String name;
    private Environment environment;
    private Key key;

    @Getter
    @AllArgsConstructor
    public enum Environment {
        PRODUCTION("production");

        @JsonValue
        private final String value;
    }

    @Getter
    @AllArgsConstructor
    public enum Key {
        TRANSFER("transfer"),
        CARD_SBER("card_sber"),
        SBER_PAY("sber_pay"),
        SBER_BNPL("sber_bnpl"),
        SBBOL_INSTALLMENT_PLAN("sbbol_installment_plan"),
        CARD_TO_COURIER("card_to_courier"),
        CARD("card"),
        CASH("cash"),
        EXTERNAL_PARTNER_PAY("external_partner_pay"),
        CASH_DESK("cash_desk"),
        SBBOL_CASH_HOLD("sbbol_cash_hold");

        @JsonValue
        private final String value;
    }
}

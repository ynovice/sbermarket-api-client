package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.TimeZone;

/**
 * Detailed information about the store.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class StoreDetailedInfo {

    /**
     * The id of a particular store, unique for each store in the retail chain.
     */
    private Integer id;
    /**
     * The uuid of the retailer
     */
    private String uuid;
    @JsonProperty("retailer_store_id")
    private String retailerStoreId;
    private String name;


    @JsonProperty("time_zone")
    private TimeZone timeZone;
    @JsonProperty("opening_time")
    private LocalTime openingTime;
    @JsonProperty("closing_time")
    private LocalTime closingTime;


    @JsonProperty("delivery_forecast_text")
    private String deliveryForecastText;
    @JsonProperty("pickup_instruction")
    private String pickupInstruction;
    private String phone;


    @JsonProperty ("assembly_dispatch")
    private Boolean assemblyDispatch;
    @JsonProperty("parallel_assembly")
    private Boolean parallelAssembly;
    @JsonProperty("external_assembly")
    private Boolean externalAssembly;
    @JsonProperty("seconds_for_assembly_item")
    private Integer secondsForAssemblyItem;
    @JsonProperty("additional_seconds_for_assembly")
    private Integer additionalSecondsForAssembly;


    @JsonProperty("city_id")
    private String cityId;
    @JsonProperty("on_demand")
    private Boolean onDemand;
    @JsonProperty("on_demand_raw")
    private Boolean onDemandRaw;
    @JsonProperty("available_on")
    private ZonedDateTime availableOn;
    @JsonProperty("has_conveyor")
    private Boolean hasConveyor;
    @JsonProperty("auto_routing")
    private Boolean autoRouting;
    @JsonProperty("express_delivery")
    private Boolean expressDelivery;
    @JsonProperty("import_key_postfix")
    private String importKeyPostfix;
    private Boolean active;
    @JsonProperty("box_scanning")
    private Boolean boxScanning;
    private Boolean training;

    private RetailerShortInfo retailer;
    private Location location;
    private Config config;
    @JsonProperty("operational_zone")
    private OperationalZone operationalZone;
    private City city;
}

package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.github.ynovice.deserializer.LocalTimeDeserializer;
import com.github.ynovice.deserializer.DayOfWeekDeserializer;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class DeliveryTime {

    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime start;
    @JsonDeserialize(using = LocalTimeDeserializer.class)
    private LocalTime end;

    @JsonProperty("orders_limit")
    private Integer ordersLimit;
    @JsonProperty("surge_amount")
    private Integer surgeAmount;

    @JsonProperty("shipment_min_kilos")
    private Double shipmentMinKilos;
    @JsonProperty("shipment_max_kilos")
    private Double shipmentMaxKilos;
    @JsonProperty("shipments_excess_kilos")
    private Double shipmentsExcessKilos;
    @JsonProperty("shipments_excess_items_count")
    private Integer shipmentsExcessItemsCount;

    @JsonProperty("closing_time_gap")
    private Integer closingTimeGap;
    private DeliveryKind kind;

    @JsonProperty("store_zone_ids")
    private List<Integer> storeZoneIds;
    @JsonProperty("slot_active_days")
    @JsonDeserialize(using = DayOfWeekDeserializer.class)
    private Set<DayOfWeek> slotActiveDays;
}

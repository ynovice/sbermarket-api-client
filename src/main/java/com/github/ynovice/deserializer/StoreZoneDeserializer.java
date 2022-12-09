package com.github.ynovice.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.github.ynovice.model.Area;
import com.github.ynovice.model.GeographicCoordinate;
import com.github.ynovice.model.StoreZone;

import java.io.IOException;

public class StoreZoneDeserializer extends StdDeserializer<StoreZone> {

    public StoreZoneDeserializer() {
        super(StoreZone.class);
    }

    @Override
    public StoreZone deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

        JsonNode storeZoneNode = jp.getCodec().readTree(jp);

        StoreZone storeZone = new StoreZone();

        Integer id = storeZoneNode.get("id").isNull() ? null : storeZoneNode.get("id").intValue();
        storeZone.setId(id);

        String name = storeZoneNode.get("name").isNull() ? null : storeZoneNode.get("name").textValue();
        storeZone.setName(name);

        JsonNode areasNode = storeZoneNode.get("area");

        for(JsonNode areaNode : areasNode) {

            Area area = new Area();

            for(JsonNode geographicCoordinateNode : areaNode) {

                Double lon = geographicCoordinateNode.get(0).doubleValue();
                Double lat = geographicCoordinateNode.get(1).doubleValue();

                area.addDot(new GeographicCoordinate(lon, lat));
            }

            storeZone.addArea(area);
        }

        return storeZone;
    }
}

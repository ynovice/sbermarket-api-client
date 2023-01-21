package com.github.ynovice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PromoBadge {

    private Integer id;
    private String type;
    private Attributes attributes;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public static class Attributes {

        private String name;
        private Options options;


        @JsonIgnoreProperties(ignoreUnknown = true)
        @Getter
        @Setter
        public static class Options {

            private Option active;
            private Option inactive;


            @JsonIgnoreProperties(ignoreUnknown = true)
            @Getter
            @Setter
            public static class Option {

                private String title;
                @JsonProperty("title_short")
                private String titleShort;
                private String tooltip;
                private String url;
                @JsonProperty("button_text")
                private String buttonText;
                @JsonProperty("image_url")
                private String imageUrl;
                @JsonProperty("position_top")
                private Boolean positionTop;
            }
        }
    }
}

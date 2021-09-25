package me.dgahn.extractor;

import lombok.*;

public class ExtractorDto {

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExtractorInputFormDto {
        private String url;
        private FilterType type;
        private int bundleUnit;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ExtractorOutputFormDto {
        private String quotient;
        private String remainder;
    }

}

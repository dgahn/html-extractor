package me.dgahn.extractor;

public class ExtractorDto {

    public static class ExtractorInputFormDto {
        private String url;
        private FilterType type;
        private int bundleUnit;

        public ExtractorInputFormDto() { }

        public ExtractorInputFormDto(String url, FilterType type, int bundleUnit) {
            this.url = url;
            this.type = type;
            this.bundleUnit = bundleUnit;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public FilterType getType() {
            return type;
        }

        public void setType(FilterType type) {
            this.type = type;
        }

        public int getBundleUnit() {
            return bundleUnit;
        }

        public void setBundleUnit(int bundleUnit) {
            this.bundleUnit = bundleUnit;
        }

        @Override
        public String toString() {
            return "ExtractorInputFormDto{" +
                    "url='" + url + '\'' +
                    ", type=" + type +
                    ", bundleUnit=" + bundleUnit +
                    '}';
        }
    }

    public static class ExtractorOutputFormDto {
        private String quotient;
        private String remainder;

        public ExtractorOutputFormDto() { }

        public ExtractorOutputFormDto(String quotient, String remainder) {
            this.quotient = quotient;
            this.remainder = remainder;
        }

        public String getQuotient() {
            return quotient;
        }

        public void setQuotient(String quotient) {
            this.quotient = quotient;
        }

        public String getRemainder() {
            return remainder;
        }

        public void setRemainder(String remainder) {
            this.remainder = remainder;
        }
    }

}

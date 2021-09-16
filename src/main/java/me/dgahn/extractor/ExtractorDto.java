package me.dgahn.extractor;

public class ExtractorDto {

    public static class ExtractorInputFormDto {
        private String url;
        private FilterType type;
        private int bundleUnit;

        public ExtractorInputFormDto() { };

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

}

package me.dgahn.extractor;

public class Extractor {
    private FilterType filterType;
    private Html html;

    public Extractor(FilterType filterType, Html html) {
        this.filterType = filterType;
        this.html = html;
    }

    public String run() {
        return filterTag();
    }

    private String filterTag() {
        if(isDeleteTag()) {
            return html.getContent().replaceAll("<[^>]*>", "");
        }
        return html.getContent();
    }

    private Boolean isDeleteTag() {
        return filterType == FilterType.TAG;
    }
}

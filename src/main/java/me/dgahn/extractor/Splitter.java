package me.dgahn.extractor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Splitter {
    private String content;
    private int bundleUnit;

    public String getQuotient() {
        int contentLength = content.length();
        StringBuilder sb = new StringBuilder();
        sb.append(content, 0, contentLength / bundleUnit * bundleUnit);
        for (int j = 0; j < contentLength / bundleUnit - 1; j++) {
            sb.insert((1 + bundleUnit) * j + bundleUnit, "\n");
        }
        return sb.toString();
    }

    public String getRemainder() {
        int contentLength = content.length();
        int remainderSize = contentLength % bundleUnit;
        return content.substring(contentLength - remainderSize);
    }
}

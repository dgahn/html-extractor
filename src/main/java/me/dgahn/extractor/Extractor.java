package me.dgahn.extractor;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Math.max;

@AllArgsConstructor
public class Extractor {
    private FilterType filterType;
    private Html html;

    public String run() {
        return sort(filterAlphabetAndNumber(filterTag()));
    }

    private String sort(String content) {
        List<Character> capitals = extractCharacters("[^A-Z]", content);
        List<Character> smalls = extractCharacters("[^a-z]", content);
        List<Character> numbers = extractCharacters("[^0-9]", content);
        return combine(capitals, smalls, numbers);
    }

    private String combine(List<Character> capitals, List<Character> smalls, List<Character> numbers) {
        StringBuilder builder = new StringBuilder();
        List<Character> english = combine(capitals, smalls);
        int max = max(english.size(), numbers.size());
        for (int i = 0; i < max; i++) {
            if(english.size() > i) {
                builder.append(english.get(i));
            }
            if(numbers.size() > i) {
                builder.append(numbers.get(i));
            }
        }
        return builder.toString();
    }

    private List<Character> combine(List<Character> capitals, List<Character> smalls) {
        Stream<Character> combine = Stream.of();
        for (int i = 65; i <= 90; i++) {
            final int capital = (char) i;
            Stream<Character> capitalStream = capitals.stream().filter(c -> c == capital);
            Stream<Character> smallStream = smalls.stream().filter(c -> Character.toUpperCase(c) == capital);
            combine = Stream.concat(combine, Stream.concat(capitalStream, smallStream));
        }
        return combine.collect(Collectors.toList());
    }

    private List<Character> extractCharacters(String regex, String content) {
        return content.replaceAll(regex, "").chars()
                .sorted()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());
    }

    private String filterAlphabetAndNumber(String content) {
        return content.replaceAll("[^0-9a-zA-Z]", "");
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

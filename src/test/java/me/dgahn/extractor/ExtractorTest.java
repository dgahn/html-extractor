package me.dgahn.extractor;

import me.dgahn.extractor.exception.HtmlCreationFailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExtractorTest {

    @Autowired
    private HtmlFactory htmlFactory;

    @Test
    void HTML으로부터_내용을_추출할_때_HTML에서_태그를_포함할_수_있다() throws HtmlCreationFailException {
        Extractor extractor = createNoneTypeExtractor(FilterType.NONE);
        String actual = extractor.run();
        Assertions.assertEquals(8647, actual.length());
    }

    @Test
    void HTML으로부터_내용을_추출할_때_HTML에서_태그를_미포함할_수_있다() throws HtmlCreationFailException {
        Extractor extractor = createNoneTypeExtractor(FilterType.TAG);
        String actual = extractor.run().trim();
        Assertions.assertEquals(3116, actual.length());
    }

    @Test
    void HTML으로부터_추출한_내용은_영소문자와_숫자만_포함한다() throws HtmlCreationFailException {
        Extractor extractor = createNoneTypeExtractor(FilterType.TAG);
        String actual = extractor.run();
        Assertions.assertFalse(actual.contains("위메프"));
    }

    @Test
    void HTML으로부터_추출한_내용은_영대문자_숫자_영소문자_숫자순으로_정렬한다() throws HtmlCreationFailException {
        Extractor extractor = createNoneTypeExtractor(FilterType.TAG);
        String actual = extractor.run();
        Assertions.assertTrue(actual.startsWith("A0A0A0A0A0A0A0A0a0a0a0a0a0a0a0"));
    }

    private Extractor createNoneTypeExtractor(FilterType none) throws HtmlCreationFailException {
        String url = "http://company.wemakeprice.com/wmp/";
        Html html = htmlFactory.create(url);
        FilterType filterType = none;
        return new Extractor(filterType, html);
    }

}
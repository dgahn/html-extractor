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
        String url = "http://company.wemakeprice.com/wmp/";
        Html html = htmlFactory.create(url);
        FilterType filterType = FilterType.NONE;
        Extractor extractor = new Extractor(filterType, html);
        Assertions.assertTrue(extractor.run().trim().contains("!doctype html"));
    }

    @Test
    void HTML으로부터_내용을_추출할_때_HTML에서_태그를_미포함할_수_있다() throws HtmlCreationFailException {
        String url = "http://company.wemakeprice.com/wmp/";
        Html html = htmlFactory.create(url);
        FilterType filterType = FilterType.TAG;
        Extractor extractor = new Extractor(filterType, html);
        String actual = extractor.run().trim();
        Assertions.assertFalse(actual.contains("!doctype html"));
    }

    @Test
    void HTML으로부터_추출한_내용은_영소문자와_숫자만_포함한다() throws HtmlCreationFailException {
        String url = "http://company.wemakeprice.com/wmp/";
        Html html = htmlFactory.create(url);
        FilterType filterType = FilterType.TAG;
        Extractor extractor = new Extractor(filterType, html);
        String actual = extractor.run().trim();
        Assertions.assertFalse(actual.contains("위메프"));
    }

}
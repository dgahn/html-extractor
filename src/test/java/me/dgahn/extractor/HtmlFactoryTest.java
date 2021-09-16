package me.dgahn.extractor;

import me.dgahn.extractor.exception.HtmlCreationFailException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HtmlFactoryTest {

    @Autowired
    private HtmlFactory htmlFactory;

    @Test
    void url로부터_HTML_정보를_가져올_수_있다() throws HtmlCreationFailException {
        String url = "http://company.wemakeprice.com/wmp/";
        Html html = htmlFactory.create(url);
        Assertions.assertTrue(html.getContent().trim().startsWith("<!doctype html>"));
    }

}
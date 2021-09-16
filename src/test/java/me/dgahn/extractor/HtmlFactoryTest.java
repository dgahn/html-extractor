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

    @Test
    void test() {
        String str = "abc" +
                "asd" +
                "asd" +
                "asd" +
                "asd" +
                "asd" +
                "asd" +
                "asd" +
                "asd" +
                "111" +
                "11";
        StringBuilder sb = new StringBuilder();
        int i = str.length() % 3;
        sb.append(str, 0, str.length() / 3 * 3);
        for (int j = 0; j < str.length() / 3; j++) {
            sb.insert((1 + 3) * j + (3), "\n");
        }
        System.out.println(sb.toString());
    }

}
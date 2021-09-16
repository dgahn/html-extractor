package me.dgahn.extractor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SplitterTest {

    @Test
    void 묶음별_테스트_1() {
        Splitter splitter = new Splitter("aaa", 3);
        Assertions.assertEquals("aaa", splitter.getQuotient());
        Assertions.assertEquals(splitter.getRemainder(), "");
    }

    @Test
    void 묶음별_테스트_2() {
        Splitter splitter = new Splitter("aaabbbc", 3);
        Assertions.assertEquals("aaa\nbbb", splitter.getQuotient());
        Assertions.assertEquals("c", splitter.getRemainder());
    }


    @Test
    void 묶음별_테스트_3() {
        Splitter splitter = new Splitter("aaabbbcc", 3);
        Assertions.assertEquals("aaa\nbbb", splitter.getQuotient());
        Assertions.assertEquals("cc", splitter.getRemainder());
    }

}
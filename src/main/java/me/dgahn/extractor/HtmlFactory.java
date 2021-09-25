package me.dgahn.extractor;

import me.dgahn.extractor.exception.HtmlCreationFailException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

@Component
public class HtmlFactory {

    public Html create(String urlPath) throws HtmlCreationFailException {
        StringBuilder builder = new StringBuilder();

        try {
            BufferedReader buff = getHtmlBufferedReader(urlPath);
            htmlToString(builder, buff);
            return new Html(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
            throw new HtmlCreationFailException();
        }
    }

    private void htmlToString(StringBuilder builder, BufferedReader buff) throws IOException {
        String pageContents;
        while ((pageContents = buff.readLine()) != null) {
            builder.append(pageContents);
            builder.append("\r\n");
        }

        buff.close();
    }

    private BufferedReader getHtmlBufferedReader(String urlPath) throws IOException {
        URL url = new URL(urlPath);
        URLConnection con = url.openConnection();
        InputStreamReader reader = new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8);
        return new BufferedReader(reader);
    }
}

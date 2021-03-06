package me.dgahn.extractor;

import lombok.RequiredArgsConstructor;
import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;
import me.dgahn.extractor.ExtractorDto.ExtractorOutputFormDto;
import me.dgahn.extractor.exception.HtmlCreationFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExtractorService {

    private final HtmlFactory htmlFactory;

    public ExtractorOutputFormDto extract(ExtractorInputFormDto inputForm) throws HtmlCreationFailException {
        Html html = htmlFactory.create(inputForm.getUrl());
        Extractor extractor = new Extractor(inputForm.getType(), html);
        String content = extractor.run();
        Splitter splitter = new Splitter(content, inputForm.getBundleUnit());
        return new ExtractorOutputFormDto(splitter.getQuotient(), splitter.getRemainder());
    }

}

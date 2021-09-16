package me.dgahn.extractor;

import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;
import me.dgahn.extractor.ExtractorDto.ExtractorOutputFormDto;
import me.dgahn.extractor.exception.HtmlCreationFailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExtractorController {

    private final ExtractorService extractorService;

    @Autowired
    public ExtractorController(ExtractorService extractorService) {
        this.extractorService = extractorService;
    }

    @PostMapping("/extractors")
    public String extract(
            @ModelAttribute("inputForm") ExtractorInputFormDto inputForm,
            RedirectAttributes redirectAttributes
    ) throws HtmlCreationFailException {
        ExtractorOutputFormDto outputForm  = extractorService.extract(inputForm);
        redirectAttributes.addFlashAttribute("outputForm", outputForm);
        return "redirect:/index";
    }

}

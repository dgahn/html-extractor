package me.dgahn.extractor;

import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;
import me.dgahn.extractor.ExtractorDto.ExtractorOutputFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ExtractorController {

    @PostMapping("/extractors")
    public String extract(
            @ModelAttribute("inputForm") ExtractorInputFormDto form,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addFlashAttribute("outputForm", new ExtractorOutputFormDto("output", "output"));
        return "redirect:/index";
    }

}

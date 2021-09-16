package me.dgahn.extractor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;

@Controller
public class ExtractorController {

    @PostMapping("/extractors")
    public String extractor(@ModelAttribute("form") ExtractorInputFormDto form) {
        return "redirect:/index";
    }

}

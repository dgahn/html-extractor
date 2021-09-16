package me.dgahn.home;

import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;
import me.dgahn.extractor.ExtractorDto.ExtractorOutputFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home(Model model) {
        ExtractorInputFormDto inputForm = new ExtractorInputFormDto();
        model.addAttribute("inputForm", inputForm);
        return "index";
    }

}

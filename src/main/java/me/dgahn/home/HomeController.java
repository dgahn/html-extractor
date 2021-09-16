package me.dgahn.home;

import me.dgahn.extractor.ExtractorDto.ExtractorInputFormDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String home(Model model) {
        ExtractorInputFormDto formDto = new ExtractorInputFormDto();
        model.addAttribute("form", formDto);
        return "index";
    }

}

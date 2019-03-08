package monitor.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chart")
public class CreateRecordController {

    @GetMapping
    public String index() {
        return "chart/index";
    }
}

package lt.justas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkOrdersController {
    @GetMapping({"/work-orders"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        return "workorders";
    }
}

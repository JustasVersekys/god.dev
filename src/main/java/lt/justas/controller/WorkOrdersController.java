package lt.justas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WorkOrdersController {
    @GetMapping({"/work-orders"})
    public String hello() {
        return "work-order";
    }
}

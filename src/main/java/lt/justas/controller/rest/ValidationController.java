package lt.justas.controller.rest;

import lombok.extern.slf4j.Slf4j;
import lt.justas.dao.model.ValidationResultDAO;
import lt.justas.dto.model.WorkOrder;
import lt.justas.service.ValidationService;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("validation")
public class ValidationController {
    private final ValidationService validationService;

    public ValidationController(ValidationService service) {
        this.validationService = service;
    }

    @PostMapping
    public ValidationResultDAO validateWorkOrder(@RequestBody WorkOrder workOrder) {
        return validationService.validate(workOrder);
    }

    @GetMapping("history")
    public Iterable<ValidationResultDAO> getValidationResultHistory() {
        return validationService.findAll();
    }
}

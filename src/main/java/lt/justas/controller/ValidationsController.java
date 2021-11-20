package lt.justas.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lt.justas.dao.model.ValidationResultDAO;
import lt.justas.dto.model.WorkOrder;
import lt.justas.service.ValidationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ValidationsController {
    private final ObjectMapper objectMapper;
    private final ValidationService validationService;

    public ValidationsController(ObjectMapper objectMapper, ValidationService validationService) {
        this.objectMapper = objectMapper;
        this.validationService = validationService;
    }

    @GetMapping({"/validation-result"})
    public String getValidationResult(@RequestParam(value = "workOrder") String workOrderJson, ModelMap model) {
        try {
            WorkOrder workOrder = objectMapper.readValue(workOrderJson, WorkOrder.class);
            ValidationResultDAO validationResult = validationService.validate(workOrder);
            model.addAttribute("validationResult", objectMapper.writeValueAsString(validationResult));
        } catch (JsonProcessingException e) {
            model.addAttribute("validationResult", "Work order has invalid structure");
        }
        return "validation-result";
    }

    @SneakyThrows
    @GetMapping({"/validation-history"})
    public String getValidationHistory(ModelMap model) {
        Iterable<ValidationResultDAO> validationResults = validationService.findAll();
        model.addAttribute("validationHistory", validationResults);
        return "validation-history";
    }

}

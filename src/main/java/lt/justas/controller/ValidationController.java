package lt.justas.controller;

import lombok.extern.slf4j.Slf4j;
import lt.justas.model.WorkOrder;
import lt.justas.persistence.model.ValidationResultDAO;
import lt.justas.persistence.model.WorkOrderDAO;
import lt.justas.service.WorkOrderService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("work-order")
public class ValidationController {
    private WorkOrderService workOrderService;

    public ValidationController(WorkOrderService service) {
        this.workOrderService = service;
    }

    @GetMapping("validation-result")
    public ValidationResultDAO getValidationResult(@PathVariable Long workOrderId) {
        log.info("getValidationResult");
        return new ValidationResultDAO();
    }

    @PostMapping
    @Transactional
    public WorkOrderDAO putWorkOrder(@RequestBody WorkOrder workOrder) {
        return workOrderService.save(workOrder);
    }

    @GetMapping("all")
    public Iterable<WorkOrderDAO> getWorkOrders() {
        return workOrderService.findAll();
    }
}

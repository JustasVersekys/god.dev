package lt.justas.service;

import lombok.extern.slf4j.Slf4j;
import lt.justas.model.ValidationResult;
import lt.justas.model.WorkOrder;
import lt.justas.model.WorkOrderPart;
import lt.justas.persistence.model.WorkOrderDAO;
import lt.justas.persistence.model.WorkOrderPartDAO;
import lt.justas.persistence.repo.WorkOrderRepo;
import lt.justas.service.validators.WorkOrderValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class WorkOrderService {

    private final WorkOrderRepo workOrderRepo;
    private final List<WorkOrderValidator> workOrderValidators;

    public WorkOrderService(WorkOrderRepo workOrderRepo, List<WorkOrderValidator> validators) {
        this.workOrderRepo = workOrderRepo;
        this.workOrderValidators = validators;
    }

    public ValidationResult save(WorkOrder workOrder) {
        return ValidationResult.builder()
                .validationMessages(validate(workOrder))
                .build();
    }

    private List<String> validate(WorkOrder workOrder) {
        return workOrderValidators
                .stream()
                .filter(workOrderValidator -> workOrderValidator.isApplicable(workOrder))
                .map(workOrderValidator -> workOrderValidator.validate(workOrder))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Iterable<WorkOrderDAO> findAll() {
        return workOrderRepo.findAll();
    }

    public WorkOrderDAO map(WorkOrder workOrder) {
        WorkOrderDAO result = WorkOrderDAO.builder()
                .type(workOrder.getType().name())
                .department(workOrder.getDepartment())
                .startDate(workOrder.getStartDate())
                .endDate(workOrder.getEndDate())
                .currency(workOrder.getCurrency())
                .cost(workOrder.getCost())
                .build();
        workOrder.getParts()
                .forEach(part -> result.addPart(map(part)));
        return result;
    }

    private WorkOrderPartDAO map(WorkOrderPart workOrderPart) {
        return WorkOrderPartDAO.builder()
                .inventoryNumber(workOrderPart.getInventoryNumber())
                .name(workOrderPart.getName())
                .count(workOrderPart.getCount())
                .build();
    }
}

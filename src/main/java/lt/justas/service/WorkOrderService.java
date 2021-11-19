package lt.justas.service;

import lombok.extern.slf4j.Slf4j;
import lt.justas.model.ValidationResult;
import lt.justas.model.WorkOrder;
import lt.justas.persistence.model.ValidationResultDAO;
import lt.justas.persistence.repo.ValidationResultRepo;
import lt.justas.service.validators.WorkOrderValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
public class WorkOrderService {

    private final ValidationResultRepo validationResultRepo;
    private final List<WorkOrderValidator> workOrderValidators;

    public WorkOrderService(ValidationResultRepo validationResultRepo, List<WorkOrderValidator> validators) {
        this.validationResultRepo = validationResultRepo;
        this.workOrderValidators = validators;
    }

    public ValidationResultDAO validate(WorkOrder workOrder) {
        List<String> validationMessages = getValidationMessages(workOrder);
        ValidationResult validationResult = ValidationResult.builder()
                .validationRequestDate(LocalDate.now().toString())
                .workOrderType(workOrder.getType())
                .department(workOrder.getDepartment())
                .valid(validationMessages.isEmpty())
                .validationMessages(validationMessages)
                .build();
        return validationResultRepo.save(map(validationResult));
    }

    private List<String> getValidationMessages(WorkOrder workOrder) {
        return workOrderValidators
                .stream()
                .filter(workOrderValidator -> workOrderValidator.isApplicable(workOrder))
                .map(workOrderValidator -> workOrderValidator.validate(workOrder))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public Iterable<ValidationResultDAO> findAll() {
        return validationResultRepo.findAll();
    }

    public ValidationResultDAO map(ValidationResult validationResult) {
        return ValidationResultDAO.builder()
                .validationRequestDate(validationResult.getValidationRequestDate())
                .workOrderType(validationResult.getWorkOrderType())
                .department(validationResult.getDepartment())
                .valid(validationResult.isValid())
                .validationMessages(validationResult.getValidationMessages())
                .build();
    }
}

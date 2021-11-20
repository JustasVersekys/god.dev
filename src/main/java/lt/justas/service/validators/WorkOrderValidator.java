package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;

import java.util.Optional;

public interface WorkOrderValidator {
    Optional<String> validate(WorkOrder workOrder);

    boolean isApplicable(WorkOrder workOrder);
}

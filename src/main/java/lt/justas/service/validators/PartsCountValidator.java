package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class PartsCountValidator extends RepairWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getParts()) && !workOrder.getParts().isEmpty() ?
                empty() : of("Work parts cannot be empty");
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

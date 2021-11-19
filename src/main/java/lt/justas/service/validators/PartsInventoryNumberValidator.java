package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import lt.justas.model.WorkOrderPart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class PartsInventoryNumberValidator extends ReplacementWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getParts()) &&
                !workOrder.getParts().isEmpty() &&
                allPartsContainInventoryNumber(workOrder.getParts()) ?
                empty() : of("Work parts must contain inventory number");
    }

    private boolean allPartsContainInventoryNumber(Set<WorkOrderPart> parts){
        return parts
                .stream()
                .noneMatch(workOrderPart -> notEmpty(workOrderPart.getInventoryNumber()));
    }

    private boolean notEmpty(String s){
        return nonNull(s) && !s.isEmpty();
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

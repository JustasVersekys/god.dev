package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class ResponsiblePersonValidator extends RepairWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getResponsiblePerson()) && !workOrder.getResponsiblePerson().isEmpty() ?
                empty() : of(format("Responsible person '%s' is not valid", workOrder.getAnalysisDate()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

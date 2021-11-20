package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class FactoryNameValidator extends ReplacementWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getFactoryName()) && !workOrder.getFactoryName().isEmpty() ?
                empty() : of(format("Factory name '%s' is not valid", workOrder.getFactoryName()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

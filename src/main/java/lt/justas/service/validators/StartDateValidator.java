package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class StartDateValidator extends AllWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getStartDate()) && LocalDate.parse(workOrder.getStartDate()).isBefore(LocalDate.now()) ?
                empty() : of(format("Start date '%s' is not valid", workOrder.getStartDate()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

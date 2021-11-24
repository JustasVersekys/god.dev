package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class EndDateValidator extends AllWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        if (isNull(workOrder.getStartDate())) {
            return empty();
        }
        return nonNull(workOrder.getEndDate()) &&
                LocalDate.parse(workOrder.getEndDate()).isAfter(LocalDate.parse(workOrder.getStartDate())) ?
                empty() : of(format("End date '%s' is not valid", workOrder.getEndDate()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

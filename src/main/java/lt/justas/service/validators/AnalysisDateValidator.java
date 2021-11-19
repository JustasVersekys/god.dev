package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class AnalysisDateValidator extends RepairWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        if (isNull(workOrder.getStartDate())) {
            return empty();
        }
        if (isNull(workOrder.getEndDate())) {
            return empty();
        }
        if (isNull(workOrder.getAnalysisDate())) {
            return of("Analysis date cannot be empty");
        }

        LocalDate analysisDate = LocalDate.parse(workOrder.getAnalysisDate());
        LocalDate startDate = LocalDate.parse(workOrder.getStartDate());
        LocalDate endDate = LocalDate.parse(workOrder.getEndDate());
        return analysisDate.isAfter(startDate) && analysisDate.isBefore(endDate) ?
                empty() : of(format("Analysis date '%s' is not valid", workOrder.getAnalysisDate()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

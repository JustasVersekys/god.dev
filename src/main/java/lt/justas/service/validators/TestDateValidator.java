package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.isNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class TestDateValidator extends RepairWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        if (isNull(workOrder.getEndDate())) {
            return empty();
        }
        if (isNull(workOrder.getAnalysisDate())) {
            return empty();
        }
        if (isNull(workOrder.getTestDate())) {
            return of("Test date cannot be empty");
        }

        LocalDate endDate = LocalDate.parse(workOrder.getEndDate());
        LocalDate analysisDate = LocalDate.parse(workOrder.getAnalysisDate());
        LocalDate testDate = LocalDate.parse(workOrder.getTestDate());
        return testDate.isAfter(analysisDate) && testDate.isBefore(endDate) ?
                empty() : of(format("Analysis data '%s' is not valid", workOrder.getAnalysisDate()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

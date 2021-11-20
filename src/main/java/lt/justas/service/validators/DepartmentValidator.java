package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.of;

@Component
public class DepartmentValidator extends AllWorkOrdersValidator implements WorkOrderValidator {
    List<String> DEPARTMENTS = List.of("GOoD analysis department", "GOoD repair department", "GOoD replacement department");

    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getDepartment()) && DEPARTMENTS.contains(workOrder.getDepartment()) ? Optional.empty() :
                of(format("Department '%s' is not valid", workOrder.getDepartment()));
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Pattern;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.of;

@Component
public class FactoryOrderNumberValidator extends ReplacementWorkOrdersValidator implements WorkOrderValidator {
    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getFactoryOrderNumber()) && isFactoryOrderNumberValid(workOrder.getFactoryOrderNumber()) ?
                empty() : of(format("Factory name '%s' is not valid", workOrder.getFactoryOrderNumber()));
    }

    private boolean isFactoryOrderNumberValid(String factoryOrderNumber) {
        if (factoryOrderNumber.length() != 10) {
            return false;
        }
        Pattern pattern = Pattern.compile("[a-zA-Z]{2}\\d{8}");
        return pattern.matcher(factoryOrderNumber).matches();
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

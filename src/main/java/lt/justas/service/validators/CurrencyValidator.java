package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.Objects.nonNull;
import static java.util.Optional.of;

@Component
public class CurrencyValidator extends AllWorkOrdersValidator implements WorkOrderValidator {

    @Override
    public Optional<String> validate(WorkOrder workOrder) {
        return nonNull(workOrder.getCurrency()) && currencyFormatIdValid(workOrder.getCurrency()) ? Optional.empty() :
                of(format("Currency '%s' is not valid", workOrder.getCurrency()));
    }

    private boolean currencyFormatIdValid(String currencyCode) {
        try {
            Currency.getInstance(currencyCode);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean isApplicable(WorkOrder workOrder) {
        return super.isApplicable(workOrder);
    }
}

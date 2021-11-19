package lt.justas.service.validators;

import lt.justas.model.WorkOrder;

import static lt.justas.service.WorkOrderType.REPLACEMENT;

public class ReplacementWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == REPLACEMENT;
    }
}

package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;

import static lt.justas.dto.model.WorkOrderType.REPLACEMENT;

public class ReplacementWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == REPLACEMENT;
    }
}

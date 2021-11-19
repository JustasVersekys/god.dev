package lt.justas.service.validators;

import lt.justas.model.WorkOrder;

import static lt.justas.service.WorkOrderType.*;

public class AllWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == ANALYSIS || workOrder.getType() == REPAIR || workOrder.getType() == REPLACEMENT;
    }
}

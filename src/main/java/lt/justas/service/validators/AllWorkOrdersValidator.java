package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;

import static lt.justas.dto.model.WorkOrderType.*;

public class AllWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == ANALYSIS || workOrder.getType() == REPAIR || workOrder.getType() == REPLACEMENT;
    }
}

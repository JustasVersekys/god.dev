package lt.justas.service.validators;

import lt.justas.model.WorkOrder;

import static lt.justas.service.WorkOrderType.REPAIR;

public class RepairWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == REPAIR;
    }
}

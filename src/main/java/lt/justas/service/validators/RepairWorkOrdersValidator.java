package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;

import static lt.justas.dto.model.WorkOrderType.REPAIR;

public class RepairWorkOrdersValidator {
    protected boolean isApplicable(WorkOrder workOrder) {
        return workOrder.getType() == REPAIR;
    }
}

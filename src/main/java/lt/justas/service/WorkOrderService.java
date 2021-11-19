package lt.justas.service;

import lombok.extern.slf4j.Slf4j;
import lt.justas.model.WorkOrder;
import lt.justas.model.WorkOrderPart;
import lt.justas.persistence.model.WorkOrderDAO;
import lt.justas.persistence.model.WorkOrderPartDAO;
import lt.justas.persistence.repo.WorkOrderRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class WorkOrderService {

    private final WorkOrderRepo workOrderRepo;

    public WorkOrderService(WorkOrderRepo workOrderRepo) {
        this.workOrderRepo = workOrderRepo;
    }

    public WorkOrderDAO save(WorkOrder workOrder){
        WorkOrderDAO workOrderDAO = map(workOrder);
        return workOrderRepo.save(workOrderDAO);
    }

    public Iterable<WorkOrderDAO> findAll() {
        return workOrderRepo.findAll();
    }

    public WorkOrderDAO map(WorkOrder workOrder){
        WorkOrderDAO result = WorkOrderDAO.builder()
                .type(workOrder.getType())
                .department(workOrder.getDepartment())
                .startDate(workOrder.getStartDate())
                .endDate(workOrder.getEndDate())
                .currency(workOrder.getCurrency())
                .cost(workOrder.getCost())
                .build();
        workOrder.getParts()
                .forEach(part -> result.addPart(map(part)));
        return result;
    }

    private WorkOrderPartDAO map(WorkOrderPart workOrderPart){
        return WorkOrderPartDAO.builder()
                .inventoryNumber(workOrderPart.getInventoryNumber())
                .name(workOrderPart.getName())
                .count(workOrderPart.getCount())
                .build();
    }
}

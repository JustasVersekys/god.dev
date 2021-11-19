package lt.justas.model;

import lombok.Data;

import java.util.Set;

@Data
public class WorkOrder {
    private String type;
    private String department;
    private String startDate;
    private String endDate;
    private String currency;
    private Long cost;

    private Set<WorkOrderPart> parts;
}

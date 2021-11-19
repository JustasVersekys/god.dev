package lt.justas.model;

import lombok.Data;

@Data
public class WorkOrderPart {
    private String inventoryNumber;
    private String name;
    private Long count;
}

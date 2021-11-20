package lt.justas.dto.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkOrderPart {
    private String inventoryNumber;
    private String name;
    private Long count;
}

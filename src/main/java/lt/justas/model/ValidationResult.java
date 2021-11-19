package lt.justas.model;

import lombok.Builder;
import lombok.Data;
import lt.justas.service.WorkOrderType;

import java.util.List;

@Data
@Builder
public class ValidationResult {
    private String validationRequestDate;
    private WorkOrderType workOrderType;
    private String department;
    private boolean valid;
    private List<String> validationMessages;
}

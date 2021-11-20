package lt.justas.dto.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class WorkOrder {
    private WorkOrderType type;
    private String department;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("analysis_date")
    private String analysisDate;
    @JsonProperty("test_date")
    private String testDate;
    @JsonProperty("responsible_person")
    private String responsiblePerson;
    @JsonProperty("factory_name")
    private String factoryName;
    @JsonProperty("factory_order_number")
    private String factoryOrderNumber;
    private String currency;
    private Long cost;

    private Set<WorkOrderPart> parts;
}

package lt.justas.persistence.model;

import lombok.*;
import lt.justas.service.WorkOrderType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ValidationResultDAO {
    @Id
    @GeneratedValue
    private Long id;
    private String validationRequestDate;
    private WorkOrderType workOrderType;
    private String department;
    private boolean valid;
    @ElementCollection
    private List<String> validationMessages;
}

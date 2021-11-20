package lt.justas.dao.model;

import lombok.*;
import lt.justas.dto.model.WorkOrderType;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

import static java.lang.String.join;

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

    @Override
    public String toString() {
        return "{\"id\":" + id +
                ",\"validationRequestDate\":\"" + validationRequestDate +
                "\",\"workOrderType\":\"" + workOrderType +
                "\",\"department\":\"" + department +
                "\",\"valid\":" + valid +
                ",\"validationMessages\":[" + this.getMessagesString() + "]}";
    }

    private String getMessagesString() {
        return this.validationMessages.isEmpty() ? "" : "\"" + join("\",\"", this.validationMessages) + "\"";
    }
}

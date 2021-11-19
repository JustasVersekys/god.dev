package lt.justas.persistence.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class WorkOrderDAO {
    @Id
    @GeneratedValue
    private Long workOrderId;
    private String type;
    private String department;
    private String startDate;
    private String endDate;
    private String currency;
    private Long cost;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "workOrderEntity", orphanRemoval = true)
    @JsonManagedReference
    private Set<WorkOrderPartDAO> parts;

    public void addPart(WorkOrderPartDAO part){
        if(isNull(this.parts)) this.parts = new HashSet<>();
        this.parts.add(part);
        part.setWorkOrderDAO(this);
    }
}

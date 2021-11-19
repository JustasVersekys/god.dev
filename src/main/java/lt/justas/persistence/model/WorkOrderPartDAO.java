package lt.justas.persistence.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkOrderPartDAO {
    @Id
    @GeneratedValue
    private Long id;

    private String inventoryNumber;
    private String name;
    private Long count;

    @Setter
    @ManyToOne(fetch = LAZY)
    @JsonBackReference
    @JoinColumn(name = "workOrderId", nullable = false)
    private WorkOrderDAO workOrderDAO;
}

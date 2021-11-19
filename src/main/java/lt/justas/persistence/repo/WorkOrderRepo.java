package lt.justas.persistence.repo;

import lt.justas.persistence.model.WorkOrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkOrderRepo extends JpaRepository<WorkOrderDAO, Long> {
}

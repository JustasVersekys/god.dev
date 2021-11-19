package lt.justas.persistence.repo;

import lt.justas.persistence.model.ValidationResultDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationResultRepo extends CrudRepository<ValidationResultDAO, Long> {
}

package lt.justas.repo;

import lt.justas.dao.model.ValidationResultDAO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValidationResultRepo extends CrudRepository<ValidationResultDAO, Long> {
}

package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.junit.jupiter.api.Test;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EndDateValidatorTest {

    @Test
    void validate() {
        EndDateValidator validator = new EndDateValidator();
        assertEquals(empty(), validator.validate(WorkOrder.builder().startDate("2020-08-13").endDate("2020-08-15").build()));
    }
}
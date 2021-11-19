package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepartmentValidatorTest {

    @Test
    void validate() {
        DepartmentValidator validator = new DepartmentValidator();
        assertEquals(Optional.empty(), validator.validate(WorkOrder.builder().department("GOoD repair department").build()));
        assertEquals(Optional.of("Department 'GOoD' is not valid"), validator.validate(WorkOrder.builder().department("GOoD").build()));
    }


}
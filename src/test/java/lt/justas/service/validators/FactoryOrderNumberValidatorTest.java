package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import org.junit.jupiter.api.Test;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;

class FactoryOrderNumberValidatorTest {

    @Test
    void validate() {
        FactoryOrderNumberValidator validator = new FactoryOrderNumberValidator();
        assertEquals(empty(), validator.validate(WorkOrder.builder().factoryOrderNumber("DE12345678").build()));
        assertEquals(of("Factory name 'DE123456789' is not valid"), validator.validate(WorkOrder.builder().factoryOrderNumber("DE123456789").build()));
        assertEquals(of("Factory name '=E12345678' is not valid"), validator.validate(WorkOrder.builder().factoryOrderNumber("=E12345678").build()));
    }
}
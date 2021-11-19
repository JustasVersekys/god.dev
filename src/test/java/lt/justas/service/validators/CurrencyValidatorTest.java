package lt.justas.service.validators;

import lt.justas.model.WorkOrder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;

class CurrencyValidatorTest {

    @Test
    void validate() {
        CurrencyValidator validator = new CurrencyValidator();
        assertEquals(empty(), validator.validate(WorkOrder.builder().currency("USD").build()));
        assertEquals(of("Currency 'USD1' is not valid"), validator.validate(WorkOrder.builder().currency("USD1").build()));
    }
}
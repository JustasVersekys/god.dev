package lt.justas.service.validators;

import lt.justas.dto.model.WorkOrder;
import org.junit.jupiter.api.Test;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.*;

class AnalysisDateValidatorTest {

    @Test
    void validate() {
        AnalysisDateValidator validator = new AnalysisDateValidator();
        assertEquals(empty(), validator.validate(WorkOrder.builder()
                .startDate("2020-01-01")
                .endDate("2020-12-31")
                .analysisDate("2020-05-01")
                .build()));
        assertEquals(of("Analysis date '2021-05-01' is not valid"), validator.validate(WorkOrder.builder()
                .startDate("2020-01-01")
                .endDate("2020-12-31")
                .analysisDate("2021-05-01")
                .build()));
        assertEquals(of("Analysis date cannot be empty"), validator.validate(WorkOrder.builder()
                .startDate("2020-01-01")
                .endDate("2020-12-31")
                .analysisDate(null)
                .build()));
    }
}
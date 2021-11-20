package lt.justas.controller.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.justas.dao.model.ValidationResultDAO;
import lt.justas.dto.model.WorkOrder;
import lt.justas.dto.model.WorkOrderPart;
import lt.justas.repo.ValidationResultRepo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Set;

import static lt.justas.dto.model.WorkOrderType.REPAIR;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ValidationControllerIntegrationTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ValidationResultRepo repo;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
    }

    @Test
    void validateWorkOrder() throws Exception {
        given(repo.save(any())).willReturn(ValidationResultDAO.builder().valid(false).build());
        mvc.perform(post("/api/validation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(workOrder())))
                .andExpect(status().isOk()).andExpect(jsonPath("$.valid", is(false)));
    }

    @Test
    void getValidationResultHistory() throws Exception {
        given(repo.findAll()).willReturn(List.of(ValidationResultDAO.builder().valid(true).build()));
        mvc.perform(get("/api/validation/history"))
                .andExpect(status().isOk()).andExpect(jsonPath("$[0].valid", is(true)));
    }

    private WorkOrder workOrder(){
        return WorkOrder.builder()
                .type(REPAIR)
                .parts(Set.of(workOrderPart()))
                .build();
    }

    private WorkOrderPart workOrderPart(){
        return WorkOrderPart.builder()
                .inventoryNumber("i")
                .count(1L)
                .name("name")
                .build();
    }
}

UI:
- http://localhost:8080/work-orders -> work orders validation page
- http://localhost:8080/validation-result?workOrder={encodedWorkOrder} -> can be used directly to validate work order, must be used with encoded WorkOrder object
- http://localhost:8080/validation-history -> validation history page
- http://localhost:8080/ui -> swagger documentation for rest endpoints

Maintenance:
- Adding new validators -> add new validator to package **[lt.justas.service.validators](src/main/java/lt/justas/service/validators)** implement **[WorkOrderValidator](src/main/java/lt/justas/service/validators/WorkOrderValidator.java)**
- Adding new type -> just add one to **[WorkOrderType](src/main/java/lt/justas/dto/model/WorkOrderType.java)** and update validators _isApplicable_ method if needed.
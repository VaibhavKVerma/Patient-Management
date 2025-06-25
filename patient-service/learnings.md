## STRUCTURE

```
│   PatientServiceApplication.java
│   
├───controller
│       PatientController.java
│       
├───dto
│   │   PatientRequestDTO.java
│   │   PatientResponseDTO.java
│   │   
│   └───validators
│           CreatePatientValidationGroup.java
│           
├───exception
│       EmailAlreadyExistsException.java
│       GlobalExceptionHandler.java
│       PatientNotFoundException.java
│
├───mapper
│       PatientMapper.java
│
├───model
│       Patient.java
│
├───repository
│       PatientRepository.java
│
└───service
        PatientService.java
    
  ```

Controller will receive and sent the result as DTO.

Service will receive and send the result as DTO.

Service will call Repository to get data and mutate the data using Mapper toDTO and from DTO toObject.

Validation dependency is required to use it in Request DTO to throw errors. @Valid or @Validated to be used.

Validators folder inside dto to be used to handle validation of incoming requests by the class group type. Default is Default.class.

Can create custom class to handle validation by using @Validated({ClassName.class})

Use GlobalExceptionHandler annotated by @ControllerAdvice or @RestControllerAdvice to show errors of Validation dependency in a good fashion of type MethodArgumentNotValidException.

For throwing Custom Errors use the same by Creating a class extending to Runtime Exception.



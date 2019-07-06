package Domain;

import Service.ExaminatorService;

public class ExaminatorValidator implements IValidator<Examinator> {

    @Override
    public void validate(Examinator A) {
        if(A.getCnp() <= 0) throw new RuntimeException("CNP trebuie sa fie pozitiv!");
    }
}
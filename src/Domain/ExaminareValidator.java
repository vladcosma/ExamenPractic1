package Domain;

public class ExaminareValidator implements IValidator<Examinare> {

    @Override
    public void validate(Examinare A) {
        if(A.getRezultat() != Boolean.parseBoolean(null)) {
            throw new RuntimeException("Trebuie introdus rezultatul!");
        }
    }
}
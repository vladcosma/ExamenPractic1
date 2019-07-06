package Domain;

import java.util.Objects;

public class Examinator extends Entity {

    private String nume;
    private double cnp;

    public Examinator(String id, String nume, double cnp) {
        super(id);
        this.nume = nume;
        this.cnp = cnp;

    }

    public Examinator(String nume, double cnp) {
        this.nume = nume;
        this.cnp = cnp;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Examinator examinator = (Examinator) o;
        return Double.compare(examinator.cnp, cnp) == 0 &&

                nume.equals(examinator.nume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nume, cnp);
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String model) {
        this.nume = nume;
    }

    public double getCnp() {
        return cnp;
    }

    public void setCnp(double cnp) {
        this.cnp = cnp;
    }




    public String toString() {
        return this.getNume()+"Nume"+this.getCnp();
    }
}

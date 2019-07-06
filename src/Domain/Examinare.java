package Domain;

import java.util.Objects;

public class Examinare extends Entity {

    private boolean rezultat;
    private double ziua,idexam;

    public Examinare(String id, double idexam, boolean rezultat, double ziua) {
        super(id);
        this.idexam = idexam;
        this.rezultat = rezultat;
        this.ziua = ziua;
    }

    public Examinare(double idexam, boolean rezultat, double ziua) {
        this.idexam = idexam;
        this.rezultat = rezultat;
        this.ziua = ziua;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Examinare that = (Examinare) o;
        return Double.compare(that.idexam, idexam) == 0 &&
                Double.compare(that.ziua, ziua) == 0 ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idexam, rezultat, ziua);
    }

    public double getIdexam() {
        return idexam;
    }

    public void setIdexam(double idexam) {
        this.idexam = idexam;
    }

    public boolean getRezultat() {
        return rezultat;
    }

    public void setRezultat(boolean rezultat) {
        this.rezultat = rezultat;
    }

    public double getZiua() {
        return ziua;
    }

    public void setZiua(double ziua) {
        this.ziua = ziua;
    }

    public String toString() {
        return this.getIdexam()+"Examinare"+this.getRezultat();
    }
}

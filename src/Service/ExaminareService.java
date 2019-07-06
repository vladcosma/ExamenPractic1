package Service;
import Domain.Examinare;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExaminareService {

    private IRepository<Examinare> repository;

    public ExaminareService(IRepository<Examinare> repository) {
        this.repository = repository;
    }

    public void add(String id, double idexam, boolean rezulat, double ziua) {
        Examinare temp = new Examinare(id,idexam,rezulat,ziua);
        repository.upsert(temp);
    }

    public List<Examinare> sort() {

        List<Examinare> examinares= new ArrayList<>(repository.getAll());
        Comparator<Examinare> byRezultat = (d1 , d2) -> {
            int t1=0,t2=0;
            for(Examinare t : repository.getAll()){
                if(t.getRezultat()==(d1.getRezultat()))
                    t1 += t.getIdexam();
                if(t.getRezultat()==(d2.getRezultat()))
                    t2 += t.getIdexam();
            }
            return t1-t2;
        };

        List<Examinare> temp = new ArrayList<>(repository.getAll());
        temp.sort(byRezultat);
        return temp;
    }

    public List<Examinare> cautareIdexamen (String idexam) {

        List<Examinare> temp = new ArrayList<>();
        for(Examinare t:repository.getAll()) {
            if(t.getIdexam().contains(idexam))
                temp.add(t);

        return temp;
    }

        public List<Examinare> getAll() {
            return repository.getAll();
        }

}}

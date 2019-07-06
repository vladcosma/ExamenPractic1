package Service;
import Domain.Examinare;
import Domain.Examinator;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExaminatorService {

    private IRepository<Examinator> repository;

    public ExaminatorService(IRepository<Examinator> repository) {
        this.repository = repository;
    }

    public void add(String id, String nume, double cnp) {
        Examinator temp = new Examinator(id,nume,cnp);
        repository.upsert(temp);
    }

    public List<Examinator> sort() {

        List<Examinator> examinators= new ArrayList<>(repository.getAll());
        Comparator<Examinator> byCnp = (d1 , d2) -> {
            int t1=0,t2=0;
            for(Examinator t : repository.getAll()){
                if(t.getNume().equals(d1.getNume()))
                    t1 += t.getCnp();
                if(t.getNume().equals(d2.getNume()))
                    t2 += t.getCnp();
            }
            return t1-t2;
        };

        List<Examinator> temp = new ArrayList<>(repository.getAll());
        temp.sort(byCnp);
        return temp;
    }

    public List<Examinator> cautareNume (String nume) {

        List<Examinator> temp = new ArrayList<>();
        for(Examinator t:repository.getAll())
            if(t.getNume().contains(nume))
                temp.add(t);

        return temp;
    }

    public List<Examinator> getAll() {
        return repository.getAll();
    }



}

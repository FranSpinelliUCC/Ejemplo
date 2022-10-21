package repository.dao;

import model.Papeleria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface PapeleriaCrudRepository extends CrudRepository<Papeleria,Integer> {

    //JPQL
    @Query("select c.categoria, COUNT(c.categoria) from Papeleria AS c group by c.categoria order by COUNT(c.categoria) desc")
    public List<Object[]> countTotalPapeleriaByCategoria();

    //QUERY METHODS!
    public List<Papeleria> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);

    public List<Papeleria> findAllByDescription(String descriptionAAA);
}

package service;

import model.Categoria;
import model.Papeleria;
import repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAll(){
        return  categoriaRepository.getAll();
    }
    public Optional<Categoria> getCategoria(int id){
        return categoriaRepository.getCategoria(id);
    }

    public Categoria save(Categoria p){
        if(p.getId()==null){
            return categoriaRepository.save(p);
        }else{
            Optional<Categoria> paux=categoriaRepository.getCategoria(p.getId());
            if(paux.isEmpty()){
                return categoriaRepository.save(p);
            }else{
                return p;
            }
        }
    }
    public Categoria update(Categoria c){
        if(c.getId()!=null){
            Optional<Categoria>g=categoriaRepository.getCategoria(c.getId());
            if(!g.isEmpty()){
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoriaRepository.save(g.get());

            }
        }
        return c;

    }
   //FORMA 1;
    public boolean deleteCategory(int id){
        Boolean d= getCategoria(id).map(category -> {
            categoriaRepository.delete(category);
            return true;
        }).orElse(false);
        return d;
    }
    //FORMA 2
    public boolean deleteCategory2(int id){
        Optional<Categoria> c=getCategoria(id);
        if(!c.isEmpty()){
            categoriaRepository.delete(c.get());
            return true;
        }
        return false;

    }



}

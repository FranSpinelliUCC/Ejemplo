package controller;


import model.Papeleria;
import model.custom.CountCategoria;
import model.custom.DescriptionAmount;
import service.PapeleriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Papeleria")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class PapeleriaController {

    @Autowired
    private PapeleriaService papeleriaService;

    @GetMapping("/all")
    public List<Papeleria> getPapelerias(){
        return papeleriaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Papeleria> getPapeleria(@PathVariable("id") int id)
    {
        return papeleriaService.getPapeleria(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria save(@RequestBody Papeleria p){
        return papeleriaService.save(p);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Papeleria update(@RequestBody Papeleria p){
        return papeleriaService.update(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deletePapeleria(@PathVariable("id") int id){
        return papeleriaService.deleteCategory(id);
    }

   

    @GetMapping("/report-status")
    public DescriptionAmount getPapeleriaDescritionStatus(){
        return papeleriaService.getStatusReport();
    }
    @GetMapping("/report-categoria")
    public List<CountCategoria> getCountCategoria(){
        return papeleriaService.getTopCategorias();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Papeleria> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
       return papeleriaService.getPapeleriaPeriod(d1,d2);
    }




}

package com.gestion.concour.Controller;

import com.gestion.concour.Service.CondidatService;
import com.gestion.concour.model.Condidats;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CondidatController {
    private CondidatService condidats;

    public CondidatController(CondidatService condidats) {
        this.condidats = condidats;
    }

    @GetMapping("/candidat")
    public  List<Condidats> showAll(){
        return  condidats.FindAll();
    }
    @GetMapping("/canditat/{id}")
    public Condidats showById(@PathVariable int id){
        return condidats.FindById(id);
    }
    @PostMapping("/post-candidat")
    public  Condidats post(@RequestBody Condidats condidat){
        return condidats.register(condidat);
    }
    @PutMapping("/update-candidat/{id}")
    public  Condidats update(@PathVariable  int id , @RequestBody Condidats condidat){
        return condidats.Update(id,condidat);
    }
    @DeleteMapping("/delete-candidat/{id}")
    public List<Condidats> delete(@PathVariable int id ){
        return  condidats.delete(id);
    }
}

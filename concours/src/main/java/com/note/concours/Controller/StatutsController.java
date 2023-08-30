package com.note.concours.Controller;
import com.note.concours.Service.StatusService;
import com.note.concours.model.Statuts;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class StatutsController {
    private StatusService status;

    public StatutsController(StatusService status) {
        this.status = status;
    }
    @GetMapping("/status/{id}")
    public Statuts FindById(@PathVariable int id){
        return status.FindById(id);
    }
    @GetMapping("/status")
    public List<Statuts> FindAll(){
        return status.FindAll();
    }
    @PostMapping("/post-status")
    public Statuts Post(@RequestBody Statuts statuts){
        return status.Post(statuts);
    }
    @PutMapping("/update-status/{id}")
    public Statuts Update(@PathVariable int id, @RequestBody Statuts statuts){
        return status.Update(id,statuts);
    }
    @DeleteMapping("/delete-status/{id}")
    public List<Statuts> Delete(@PathVariable int id){
        return status.delete(id);
    }

}

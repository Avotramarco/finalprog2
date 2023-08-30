package com.note.concours.Controller;


import com.note.concours.Service.NoteService;
import com.note.concours.model.Note;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController

public class NoteController {

    private NoteService service;
    public NoteController(NoteService service) {
        this.service = service;
    }
    @GetMapping("/note/{id}")
    public Note showById(@PathVariable  int id )  {
        return  service.showById(id);
    }
    @GetMapping("/note")
    public List<Note> showAll(){
        return  service.showAll();
    }
    @PostMapping("/post-note")
    public Note post(@RequestBody  Note notes){
        return service.post(notes);
    }
    @PutMapping("/update-note/{id}")
    public Note Update(@PathVariable  int id , @RequestBody  Note notes){
        return  service.Update(id,notes);
    }
    @DeleteMapping("/delete-note/{id}")
    public  List<Note> Delete(@PathVariable int id ){
        return service.Delete(id);
    }

}

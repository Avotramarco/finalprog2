package com.gestion.concour.Service;

import com.gestion.concour.Repository.NoteDAO;
import com.gestion.concour.model.Note;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
@Service

public class NoteService {
    private NoteDAO note ;

    public NoteService(NoteDAO note) {
        this.note = note;
    }
    public Note showById(int id )  {
        return  note.FindById(id);
    }
    public List<Note> showAll(){
        return  note.FindAll();
    }
    public Note post(Note notes){
        return note.register(notes);
    }
    public Note Update(int id ,Note notes){
        return  note.update(id,notes);
    }
    public  List<Note> Delete(int id ){
        return note.delete(id);
    }

}

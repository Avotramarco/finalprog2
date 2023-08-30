package com.note.concours.Service;

import com.note.concours.Repository.NoteDAO;
import com.note.concours.model.Note;
import org.springframework.stereotype.Service;

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

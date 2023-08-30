package com.note.concours.Service;

import com.note.concours.Repository.StatusDAO;
import com.note.concours.model.Statuts;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StatusService {
    private StatusDAO status;

    public StatusService(StatusDAO status) {
        this.status = status;
    }
    public Statuts FindById(int id){
        return status.findById(id);
    }
    public List<Statuts> FindAll(){
        return status.FindAll();
    }
    public Statuts Post(Statuts statuts){
        return status.post(statuts);
    }
    public Statuts Update(int id, Statuts statuts){
        return status.update(id,statuts);
    }

    public List<Statuts> delete(int id){return status.delete(id);}

}

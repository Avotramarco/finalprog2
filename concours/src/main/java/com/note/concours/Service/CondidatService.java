package com.note.concours.Service;

import com.note.concours.Repository.CondidatDAO;
import com.note.concours.model.Condidats;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class CondidatService {
    private CondidatDAO condidat;

    public CondidatService(CondidatDAO condidat) {
        this.condidat = condidat;
    }

    public Condidats FindById(int id){
        return  condidat.finById(id);
    }
    public List<Condidats>  FindAll(){
        return condidat.findAll();
    }
    public  Condidats register(Condidats condidats){
        return condidat.insert(condidats);
    }
    public Condidats Update(int id ,Condidats condidats){
        return condidat.Update(id,condidats);
    }
    public  List<Condidats> delete(int id ){
        return condidat.delete(id);
    }
}

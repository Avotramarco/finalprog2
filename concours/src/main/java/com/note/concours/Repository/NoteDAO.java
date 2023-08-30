package com.note.concours.Repository;

import com.gestion.concour.BaseConnection.Connections;
import com.note.concours.model.Note;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gestion.concour.BaseConnection.Connections.connection;
@Repository
public class NoteDAO {
    public Note FindById(int id ) {
        Connections.getConnection();
        try{
            String sql = "select  * from notes where id_notes = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Note(
                        resultSet.getInt("id_notes"),
                        resultSet.getFloat("note_mathematique"),
                        resultSet.getFloat("note_francais")
                );
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Note> FindAll(){
        Connections.getConnection();
        List<Note> notes = new ArrayList<>();
        try{
            String sql = "select  * from notes";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                  notes.add(
                        new Note(
                        resultSet.getInt("id_notes"),
                        resultSet.getFloat("note_mathematique"),
                        resultSet.getFloat("note_francais")
                        )
                );
            }
            return  notes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Note register(Note note){
        Connections.getConnection();
        try{
            String sql = "insert into notes (id_notes,note_mathematique,note_francais) values(?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,note.getId_notes());
            statement.setFloat(2,note.getNote_mathematique());
            statement.setFloat(3,note.getNote_francais());
            int row = statement.executeUpdate();
            return  FindById(note.getId_notes());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Note update(int id , Note note){
        Connections.getConnection();
        try{
            String sql = "update notes set note_mathematique = ? ,note_francais = ? where id_notes = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setFloat(1,note.getNote_mathematique());
            statement.setFloat(2,note.getNote_francais());
            statement.setInt(3,id);
            int row = statement.executeUpdate();
            return FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List< Note> delete(int id ){
        Connections.getConnection();
        try{
            String sql = "delete from notes where id_notes = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            return FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

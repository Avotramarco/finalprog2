package com.gestion.concour.Repository;

import ch.qos.logback.core.status.Status;
import ch.qos.logback.core.status.StatusUtil;
import com.gestion.concour.BaseConnection.Connections;
import com.gestion.concour.model.Statuts;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gestion.concour.BaseConnection.Connections.connection;
@Repository
public class StatusDAO {
    public Statuts findById(int id){
        Connections.getConnection();
        try{
            String sql = "select * from statuts where id_statuts = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                return new Statuts(
                        resultSet.getInt("id_statuts"),
                        resultSet.getInt("id_candidat"),
                        resultSet.getInt("id_note"),
                        resultSet.getBoolean("admis"));

            }
            else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Statuts> FindAll(){
        Connections.getConnection();
        List<Statuts> status= new ArrayList<>();
        try{
            String sql = "select * from statuts";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                status.add(
                        new Statuts(
                                resultSet.getInt("id_statuts"),
                                resultSet.getInt("id_candidat"),
                                resultSet.getInt("id_note"),
                                resultSet.getBoolean("admis")
                ));
            }
            return status;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Statuts post(Statuts statuts){
        Connections.getConnection();
        try{
            String sql = "insert into statuts (id_statuts ,id_candidat,id_note, admis) values (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,statuts.getId_statuts());
            statement.setInt(2,statuts.getId_candidat());
            statement.setInt(3,statuts.getId_note());
            statement.setBoolean(4,statuts.isAdmis());
            int row = statement.executeUpdate();
            return findById(statuts.getId_statuts());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Statuts update(int id ,Statuts statuts){
        Connections.getConnection();
        try{
            String sql = "update statuts set id_candidat = ? , id_note = ? , admis = ? where id_statuts = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(4,id);
            statement.setBoolean(3, statuts.isAdmis());
            statement.setInt(2,statuts.getId_note());
            statement.setInt(1,statuts.getId_candidat());
            int row = statement.executeUpdate();
            return findById(statuts.getId_statuts());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  List<Statuts> delete(int id ){
        Connections.getConnection();
        try{
            String sql = "delete from statuts where id_statuts = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            return FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

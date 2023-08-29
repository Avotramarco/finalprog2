package com.gestion.concour.Repository;

import com.gestion.concour.BaseConnection.Connections;
import com.gestion.concour.model.Condidats;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gestion.concour.BaseConnection.Connections.connection;
@Repository

public class CondidatDAO {
    public Condidats finById(int id){
        Connections.getConnection();
        try{
            String sql = "select * from candidats where id_candidats = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
             if (resultSet.next()){
                 return  new Condidats(
                         resultSet.getInt("id_candidats"),
                         resultSet.getString("nom"),
                         resultSet.getString("prenom"),
                         resultSet.getBoolean("statut_admission")
                 );
             }else {
                 return  null;
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Condidats> findAll(){
        Connections.getConnection();
        List<Condidats> listCondidats = new ArrayList<>();
        try {
            String sql = "select  * from candidats";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                listCondidats.add( new Condidats(
                        resultSet.getInt("id_candidats"),
                        resultSet.getString("nom"),
                        resultSet.getString("prenom"),
                        resultSet.getBoolean("statut_admission")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return  listCondidats;
    }

    public  Condidats insert(Condidats condidats){
        Connections.getConnection();
        try {
            String sql = "insert into candidats (id_candidats,nom,prenom,statut_admission) values(?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,condidats.getId_candidats());
            statement.setString(2,condidats.getNom());
            statement.setString(3, condidats.getPrenom());
            statement.setBoolean(4,condidats.isStatut_admission());

            int rows = statement.executeUpdate();
            return finById(condidats.getId_candidats());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Condidats Update(int id , Condidats condidats){
        Connections.getConnection();
        try {
            String sql = "update candidats set nom = ? , prenom = ? ,statut_admission = ? where id_candidats = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,condidats.getNom());
            statement.setString(2,condidats.getPrenom());
            statement.setBoolean(3,condidats.isStatut_admission());
            statement.setInt(4,id);
            int row = statement.executeUpdate();
            return finById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Condidats> delete(int id){
        Connections.getConnection();
        try{
            String sql = "delete from candidats where id_candidats = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            return findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

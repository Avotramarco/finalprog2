package com.gestion.concour.Repository;

import com.gestion.concour.BaseConnection.Connections;
import com.gestion.concour.model.Session;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.gestion.concour.BaseConnection.Connections.connection;
@Repository
public class SessionDAO {
    public Session FindById(int id ){
        Connections.getConnection();
        try{
            String sql = "select * from sessions where id_sessions = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                return new Session(
                        resultSet.getInt("id_sessions"),
                        resultSet.getDate("date_session"),
                        resultSet.getString("lieu")
                );
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Session> FindAll(){
        Connections.getConnection();
        List<Session> sessions = new ArrayList<>();
        try{
            String sql = "select * from sessions";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                sessions.add( new Session(
                                resultSet.getInt("id_sessions"),
                                resultSet.getDate("date_session"),
                                resultSet.getString("lieu")
                        ));
            }
            return sessions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Session register(Session session){
        Connections.getConnection();
        try{
            String sql = "insert into sessions (id_sessions,date_session,lieu) values (?,?,?) ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,session.getId_sessions());
            statement.setDate(2,session.getDate_session());
            statement.setString(3,session.getLieu());
            int row = statement.executeUpdate();
            return FindById(session.getId_sessions());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public  Session update(int id , Session session){
        Connections.getConnection();
        try{
            String sql = "update sessions set date_session =  ? , lieu = ? where id_sessions = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1,session.getDate_session());
            statement.setString(2,session.getLieu());
            statement.setInt(3,id);
            int row = statement.executeUpdate();
            return FindById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Session> delete(int id){
        Connections.getConnection();
        try{
            String sql = "delete from sessions where id_sessions = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            int row = statement.executeUpdate();
            return FindAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

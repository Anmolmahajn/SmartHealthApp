package com.smarthealth.dao;
import com.smarthealth.dao.interfaces.DoctorDaoInterface;
import com.smarthealth.model.Doctor;
import com.smarthealth.util.DBConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDao implements DoctorDaoInterface {

    public void save(Doctor doctor) throws Exception {
        String checkSql = "select * from doctors where name = ? and specialization = ? and contact = ?";
        String insertSql = "insert into doctors (name,specialization,location,contact) values(?,?,?,?)";

        try(Connection conn = DBConnector.getConnection();
        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
        PreparedStatement insertStmt = conn.prepareStatement(insertSql);){
            checkStmt.setString(1, doctor.getName());
            checkStmt.setString(2, doctor.getSpecialization());
            checkStmt.setString(3, doctor.getContact());

            ResultSet rs = checkStmt.executeQuery();

            if(rs.next() && rs.getInt(1) >0) {
                throw new Exception("Doctor already exists");
            }

            insertStmt.setString(1, doctor.getName());
            insertStmt.setString(2, doctor.getSpecialization());
            insertStmt.setString(3, doctor.getLocation());
            insertStmt.setString(4, doctor.getContact());

            insertStmt.executeUpdate();

        }catch(Exception e) {
            throw new Exception(e.getMessage());
        }
    }

   @Override
    public List<Doctor> findAll() {
       List<Doctor> doctors = new ArrayList<>();
       String sql = "select * from doctors";

       try(Connection conn = DBConnector.getConnection();
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery(sql)){
           while(rs.next()){
               Doctor doctor = new Doctor();
               doctor.setId(rs.getInt("id"));
               doctor.setName(rs.getString("name"));
               doctor.setSpecialization(rs.getString("specialization"));
               doctor.setLocation(rs.getString("location"));
               doctor.setContact(rs.getString("contact"));
               doctors.add(doctor);
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }
        return doctors;
    }

    @Override
    public boolean deleteById(int id) throws SQLException {
        String delsql = "delete from doctors where id = ?";
        String countsql = "select count(*) from doctors";
        String resetsql = "alter table doctors auto_increment=1";

        try(Connection conn = DBConnector.getConnection();
        PreparedStatement delstmt = conn.prepareStatement(delsql);
        Statement stmt = conn.createStatement()){

            delstmt.setInt(1, id);
            int affectedRows = delstmt.executeUpdate();

             if(affectedRows > 0){
                 ResultSet rs = stmt.executeQuery(countsql);
                 if(rs.next() && rs.getInt(1)== 0) {
                     stmt.execute(resetsql);
                 }
             }
            return affectedRows>0;
        }

    }
}

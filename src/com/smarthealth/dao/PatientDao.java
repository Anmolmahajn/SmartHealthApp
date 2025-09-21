package com.smarthealth.dao;
import com.smarthealth.dao.interfaces.PatientDaoInterface;
import com.smarthealth.model.Patient;
import com.smarthealth.util.DBConnector;

import java.sql.*;


public class PatientDao implements PatientDaoInterface {


    @Override
    public void save(Patient patient) throws Exception {
        String query = "insert into Patients(name, email, password, contact) values(?,?,?,?)";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, patient.getName());
            statement.setString(2, patient.getEmail());
            statement.setString(3, patient.getPassword());
            statement.setString(4, patient.getContact());
            statement.executeUpdate();
        } catch (SQLIntegrityConstraintViolationException e) {
            throw new Exception("Email exists", e);
        } catch (SQLException e) {
            throw new Exception(e.getMessage(), e);
        }
    }

    @Override
    public Patient getPatientbyEmail(String email, String password) {
        String query = "select * from Patients where email = ? and password = ?";
        try (Connection conn = DBConnector.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Patient(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("contact")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



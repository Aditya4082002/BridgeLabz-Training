package com.healthclinicapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.healthclinicapp.model.Patient;
import com.healthclinicapp.util.DBConnection;

public class PatientDao {

	public boolean isPatientExists(String phone, String email) {

        String sql = "SELECT patient_id FROM patients WHERE phone = ? OR email = ?";
        boolean exists = false;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, phone);
            ps.setString(2, email);

            ResultSet rs = ps.executeQuery();
            exists = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
	
	public int insertPatient(Patient patient) {

        int generatedId = 0;
        String sql = """
                INSERT INTO patients
                (name, dob, phone, email, address, blood_group)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps =
                     con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, patient.getName());
            ps.setString(2, patient.getDob());
            ps.setString(3, patient.getPhone());
            ps.setString(4, patient.getEmail());
            ps.setString(5, patient.getAddress());
            ps.setString(6, patient.getBloodGroup());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                generatedId = rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return generatedId;
    }
}
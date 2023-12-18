package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource) {
        this.dataSource = dataSource;

    }
    // Create a new dealership
    public void createDealership(Dealership dealership) {
        String query = "INSERT INTO dealerships (name, location) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());

            int rowsAffected = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Read all dealerships
    public List<Dealership> getAllDealerships() {
        List<Dealership> dealerships = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Dealership dealership = new Dealership(123, "ChrisGs Dealership", "Dallas,TX", 123123);
                dealership.setId(rs.getInt("id"));
                dealership.setName(rs.getString("name"));
                dealership.setAddress(rs.getString("location"));

                dealerships.add(dealership);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dealerships;
    }

    // Get a dealership by ID
    public Dealership getDealershipById(int id) {
        Dealership dealership = null;
        String query = "SELECT * FROM dealerships WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    dealership.setId(rs.getInt("id"));
                    dealership.setName(rs.getString("name"));
                    dealership.setAddress(rs.getString("location"));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dealership;
    }

    // Update a dealership
    public void updateDealership(Dealership dealership) {
        String query = "UPDATE dealerships SET name = ?, location = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setInt(3, dealership.getId());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) ;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Delete a dealership by ID
    public void deleteDealership(int id) {
        String query = "DELETE FROM dealerships WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}




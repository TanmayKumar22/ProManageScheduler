package dao;

import db.DBConnection;
import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    // 🔹 ADD PROJECT
    public void addProject(Project p) {

        String sql = "INSERT INTO projects (title, total_days, completed_days, revenue, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTitle());
            ps.setInt(2, p.getTotalDays());
            ps.setInt(3, p.getCompletedDays());
            ps.setInt(4, p.getRevenue());
            ps.setString(5, p.getStatus());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 🔹 FETCH ALL PROJECTS
    public List<Project> getAllProjects() {

        List<Project> list = new ArrayList<>();
        String sql = "SELECT * FROM projects";

        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Project(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getInt("total_days"),
                        rs.getInt("completed_days"),
                        rs.getInt("revenue"),
                        rs.getString("status")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔥 🔥 🔥 THIS METHOD WAS MISSING 🔥 🔥 🔥
    public void updateProjectStatus(Project p) {

        String sql = "UPDATE projects SET completed_days = ?, status = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getCompletedDays());
            ps.setString(2, p.getStatus());
            ps.setInt(3, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

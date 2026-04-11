package dao;

import db.DBConnection;
import model.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    // 🔹 ADD PROJECT
    public void addProject(Project p) {

        String sql = "INSERT INTO projects (title, total_days, completed_days, deadline_days, revenue, penalty_per_day, status, arrival_week, completion_week) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, p.getTitle());
            ps.setInt(2, p.getTotalDays());
            ps.setInt(3, p.getCompletedDays());
            ps.setInt(4, p.getDeadlineDays());
            ps.setInt(5, p.getRevenue());
            ps.setInt(6, p.getPenaltyPerDay());
            ps.setString(7, p.getStatus());
            ps.setInt(8, p.getArrivalWeek());
            ps.setInt(9, p.getCompletionWeek());

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
                        rs.getInt("deadline_days"),
                        rs.getInt("revenue"),
                        rs.getInt("penalty_per_day"),
                        rs.getString("status"),
                        rs.getInt("arrival_week"),
                        rs.getInt("completion_week")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 🔹 UPDATE PROJECT STATUS
    public void updateProjectStatus(Project p) {

        String sql = "UPDATE projects SET completed_days = ?, status = ?, completion_week = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, p.getCompletedDays());
            ps.setString(2, p.getStatus());
            ps.setInt(3, p.getCompletionWeek());
            ps.setInt(4, p.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
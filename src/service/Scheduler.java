package service;

import dao.ProjectDAO;
import model.Project;

import java.util.List;

public class Scheduler {

    public static void runWeeklyScheduler() {

        ProjectDAO dao = new ProjectDAO();
        int week = service.WeekManager.getCurrentWeek();

        System.out.println("\n===== SATURDAY PLANNING FOR WEEK " + week + " =====");

        List<Project> projects = dao.getAllProjects();

        // 🔹 Filter valid projects
        projects.removeIf(p ->
                p.getArrivalWeek() > week ||
                        p.getStatus().equalsIgnoreCase("COMPLETED"));

        // 🔹 Sort by score (highest first)
        projects.sort((a, b) ->
                Double.compare(b.getScore(), a.getScore()));

        int daysAvailable = 5;

        for (Project p : projects) {

            int workDays = Math.min(p.getRemainingDays(), daysAvailable);

            for (int i = 0; i < workDays; i++) {

                System.out.println("Week " + week +
                        " Day " + (6 - daysAvailable) +
                        " → " + p.getTitle());

                p.setCompletedDays(p.getCompletedDays() + 1);
                p.setStatus("IN_PROGRESS");

                daysAvailable--;
            }

            // 🔹 Mark completed
            if (p.getRemainingDays() == 0) {
                p.setStatus("COMPLETED");
                p.setCompletionWeek(week);
            }

            // 🔹 SAVE TO DB (FIXED)
            dao.updateProjectStatus(p);

            if (daysAvailable == 0)
                break;
        }

        System.out.println("===== WEEK " + week + " COMPLETED =====");

        service.WeekManager.nextWeek();
    }
}
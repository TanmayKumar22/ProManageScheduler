package service;

import dao.ProjectDAO;
import model.Project;

import java.util.Comparator;
import java.util.List;

public class Scheduler {

    private static final String[] DAYS = {
            "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"
    };

    // ✅ SAME METHOD NAME USED EVERYWHERE
    public static void generateSchedule(List<Project> projects) {

        projects.sort(Comparator.comparingInt(Project::getRevenue).reversed());

        ProjectDAO dao = new ProjectDAO();

        int dayIndex = 0;
        int week = 1;
        int totalRevenue = 0;

        System.out.println("\n📆 Week " + week);

        for (Project p : projects) {

            int remainingDays = p.getTotalDays() - p.getCompletedDays();

            while (remainingDays > 0) {

                if (dayIndex != 0 && dayIndex % 5 == 0) {
                    week++;
                    System.out.println("\n📆 Week " + week);
                }

                String dayName = DAYS[dayIndex % 5];
                System.out.println(dayName + " → " + p.getTitle());

                dayIndex++;
                remainingDays--;
                p.setCompletedDays(p.getCompletedDays() + 1);
            }

            if (p.getCompletedDays() == p.getTotalDays()) {
                p.setStatus("COMPLETED");
                totalRevenue += p.getRevenue();
            } else {
                p.setStatus("IN_PROGRESS");
            }

            // 🔥 Update DB
            dao.updateProjectStatus(p);
        }

        System.out.println("\n💰 Total Revenue: " + totalRevenue);
    }
}

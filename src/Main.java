import dao.ProjectDAO;
import model.Project;
import service.Scheduler;
import service.WeekManager;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();

        while (true) {

            System.out.println("\nCURRENT WEEK: " + WeekManager.getCurrentWeek());
            System.out.println("1. Add Project");
            System.out.println("2. View Projects");
            System.out.println("3. Run Weekly Planning");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Total Days Required: ");
                    int totalDays = sc.nextInt();

                    System.out.print("Deadline (Days): ");
                    int deadline = sc.nextInt();

                    System.out.print("Revenue: ");
                    int revenue = sc.nextInt();

                    System.out.print("Penalty Per Delay Day: ");
                    int penalty = sc.nextInt();

                    int arrivalWeek = WeekManager.getCurrentWeek();

                    dao.addProject(new Project(
                            title, totalDays, deadline,
                            revenue, penalty, arrivalWeek));

                    System.out.println("Project Added For Week " + arrivalWeek);
                    break;

                case 2:
                    dao.getAllProjects().forEach(System.out::println);
                    break;

                case 3:
                    Scheduler.runWeeklyScheduler();
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}
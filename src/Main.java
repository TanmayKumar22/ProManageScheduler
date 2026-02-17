import dao.ProjectDAO;
import model.Project;
import service.Scheduler;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProjectDAO dao = new ProjectDAO();

        while (true) {

            System.out.println("\n1. Add Project");
            System.out.println("2. View All Projects");
            System.out.println("3. Generate Schedule");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    System.out.print("Total Days Required: ");
                    int days = sc.nextInt();

                    System.out.print("Revenue: ");
                    int revenue = sc.nextInt();

                    dao.addProject(new Project(title, days, revenue));
                    System.out.println("✔ Project Added");
                    break;

                case 2:
                    List<Project> projects = dao.getAllProjects();
                    projects.forEach(System.out::println);
                    break;

                case 3:
                    List<Project> projectList = dao.getAllProjects();
                    Scheduler.generateSchedule(projectList); // ✅ FIXED
                    break;

                case 4:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}

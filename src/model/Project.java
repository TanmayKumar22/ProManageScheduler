package model;

public class Project {

    private int id;
    private String title;

    // total working days required to complete project
    private int totalDays;

    // days already completed
    private int completedDays;

    private int revenue;

    // PENDING / IN_PROGRESS / COMPLETED
    private String status;

    // 🔹 Default constructor
    public Project() {
    }

    // 🔹 Constructor without id (for insert)
    public Project(String title, int totalDays, int revenue) {
        this.title = title;
        this.totalDays = totalDays;
        this.revenue = revenue;
        this.completedDays = 0;
        this.status = "PENDING";
    }

    // 🔹 Full constructor (for DB fetch)
    public Project(int id, String title, int totalDays, int completedDays, int revenue, String status) {
        this.id = id;
        this.title = title;
        this.totalDays = totalDays;
        this.completedDays = completedDays;
        this.revenue = revenue;
        this.status = status;
    }

    // 🔹 Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

    public int getCompletedDays() {
        return completedDays;
    }

    public void setCompletedDays(int completedDays) {
        this.completedDays = completedDays;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // 🔹 For clean console output
    @Override
    public String toString() {
        return "Project{" +
                "ID=" + id +
                ", Title='" + title + '\'' +
                ", TotalDays=" + totalDays +
                ", CompletedDays=" + completedDays +
                ", Revenue=" + revenue +
                ", Status='" + status + '\'' +
                '}';
    }
}

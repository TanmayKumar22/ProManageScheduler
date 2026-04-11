package model;

public class Project {

    private int id;
    private String title;
    private int totalDays;
    private int completedDays;
    private int deadlineDays;
    private int revenue;
    private int penaltyPerDay;
    private String status;
    private int arrivalWeek;
    private int completionWeek;

    public Project() {}

    public Project(String title, int totalDays, int deadlineDays,
                   int revenue, int penaltyPerDay, int arrivalWeek) {

        this.title = title;
        this.totalDays = totalDays;
        this.deadlineDays = deadlineDays;
        this.revenue = revenue;
        this.penaltyPerDay = penaltyPerDay;
        this.arrivalWeek = arrivalWeek;
        this.completedDays = 0;
        this.status = "PENDING";
        this.completionWeek = 0;
    }

    public Project(int id, String title, int totalDays, int completedDays,
                   int deadlineDays, int revenue, int penaltyPerDay,
                   String status, int arrivalWeek, int completionWeek) {

        this.id = id;
        this.title = title;
        this.totalDays = totalDays;
        this.completedDays = completedDays;
        this.deadlineDays = deadlineDays;
        this.revenue = revenue;
        this.penaltyPerDay = penaltyPerDay;
        this.status = status;
        this.arrivalWeek = arrivalWeek;
        this.completionWeek = completionWeek;
    }

    public int getRemainingDays() {
        return totalDays - completedDays;
    }

    public double getScore() {
        return (revenue / (double) totalDays)
                + (1.0 / deadlineDays)
                + (1.0 / arrivalWeek);  // older project priority
    }

    // Getters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getTotalDays() { return totalDays; }
    public int getCompletedDays() { return completedDays; }
    public int getDeadlineDays() { return deadlineDays; }
    public int getRevenue() { return revenue; }
    public int getPenaltyPerDay() { return penaltyPerDay; }
    public String getStatus() { return status; }
    public int getArrivalWeek() { return arrivalWeek; }
    public int getCompletionWeek() { return completionWeek; }

    // Setters
    public void setCompletedDays(int completedDays) { this.completedDays = completedDays; }
    public void setStatus(String status) { this.status = status; }
    public void setCompletionWeek(int completionWeek) { this.completionWeek = completionWeek; }

    @Override
    public String toString() {
        return "ID=" + id +
                ", Title=" + title +
                ", Remaining=" + getRemainingDays() +
                ", Status=" + status +
                ", ArrivalWeek=" + arrivalWeek +
                ", CompletionWeek=" + completionWeek;
    }
}
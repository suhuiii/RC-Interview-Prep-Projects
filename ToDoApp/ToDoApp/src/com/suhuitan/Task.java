package com.suhuitan;

public class Task {

    private String details;
    private boolean done;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (done != task.done) return false;
        return details != null ? details.equals(task.details) : task.details == null;

    }

    @Override
    public int hashCode() {
        int result = details != null ? details.hashCode() : 0;
        result = 31 * result + (done ? 1 : 0);
        return result;
    }

    public Task(String taskDetails) {
        details = taskDetails;
        done = false;
    }

    public String getDetails() {
        return details;
    }

    void setDetails(String details) {
        this.details = details;
    }

    boolean isDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }
}

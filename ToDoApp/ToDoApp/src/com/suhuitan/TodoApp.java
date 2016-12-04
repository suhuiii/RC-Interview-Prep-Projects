package com.suhuitan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TodoApp {
    List<Task> tasks;

    public TodoApp() {
        tasks = new ArrayList<>();
    }

    List getListOfTasks() {
        return tasks;
    }

    public void addTask(String taskDetails) {
       tasks.add(new Task(taskDetails));
    }

    public void deleteTask(int no){
        if(no < tasks.size() && no >= 0)
            tasks.remove(no);
    }

    public Task getTask(int no){
        if(no < tasks.size() && no >= 0)
            return tasks.get(no);
        else
            throw new IndexOutOfBoundsException("Task doesn't Exist");
    }

    public void editTask(int i, String edits) {
        Task task = getTask(i);
        task.setDetails(edits);
    }

    public void toggleDone(int i) {
        Task task = getTask(i);
        task.setDone(task.isDone()? false:true);
    }

    public List<String> getTasksAsListOfString() {
        return tasks.stream()
                    .map(task -> task.getDetails()+ (task.isDone() ? ": done": ""))
                    .collect(Collectors.toList());
    }
}

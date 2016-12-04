package com.suhuitan;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TodoAppTest {
    TodoApp toDo;
    @Before
    public void setUp(){
        toDo = new TodoApp();
    }

    @Test
    public void canary(){
        assertTrue(true);
    }

    @Test
    public void taskListIsEmptyOnStart(){
        assertTrue(toDo.getListOfTasks().isEmpty());
    }

    @Test
    public void addATask(){
        List<Task> expected = asList(new Task("Task 1"));
        toDo.addTask("Task 1");
        assertTrue(toDo.getListOfTasks().size() == 1);
        assertEquals(expected, toDo.getListOfTasks());
    }

    @Test
    public void deleteATask(){
        toDo.addTask("Task 1");
        toDo.deleteTask(0);
        assertTrue(toDo.getListOfTasks().isEmpty());
    }

    @Test
    public void deletesecondTask(){
        toDo.addTask("code");
        toDo.addTask("drink tea");
        toDo.addTask("play hooky");
        toDo.addTask("wave at people");
        toDo.deleteTask(2);

        List<Task> expected = asList(new Task("code"),new Task("drink tea"),new Task("wave at people"));
        assertEquals(expected, toDo.getListOfTasks());
    }

    @Test
    public void deleteAnOutOfRangeTaskDoesNothing(){
        toDo.addTask("code");
        toDo.deleteTask(2);
        assertEquals(asList(new Task("code")), toDo.getListOfTasks());
        toDo.deleteTask(-1);
        assertEquals(asList(new Task("code")), toDo.getListOfTasks());
    }

    @Test
    public void TaskIsNotDoneWhenAdded(){
        toDo.addTask("code");
        Task task = toDo.getTask(0);
        assertFalse(task.isDone());
    }

    @Test
    public void MarkATaskAsDone(){
        toDo.addTask("code");
        toDo.toggleDone(0);

        Task task = toDo.getTask(0);
        assertTrue(task.isDone());
    }

    @Test
    public void MarkADoneTaskAsUndone(){
        toDo.addTask("code");
        toDo.toggleDone(0);
        toDo.toggleDone(0);
        Task task = toDo.getTask(0);
        assertFalse(task.isDone());
    }

    @Test
    public void getTaskThatIsOutOfBoundsCausesException(){
        try{
            toDo.addTask("code");
            toDo.getTask(-1);
            Assert.fail("Expecting Index Out Of Bounds");
        }catch (IndexOutOfBoundsException ex){
            //:)
        }
    }

    @Test
    public void editATask(){
        toDo.addTask("code");
        toDo.editTask(0, "code a todo App");
        assertEquals(asList(new Task("code a todo App")), toDo.getListOfTasks());
    }

    @Test
    public void getTaskListAsString(){
        toDo.addTask("code");
        toDo.toggleDone(0);
        toDo.addTask("write UI");
        List<String> tasks = asList("code: done", "write UI");
        assertEquals(tasks, toDo.getTasksAsListOfString());
    }


}

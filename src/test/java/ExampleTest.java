import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import selenium_helper.pageobjects.TaskPage;
import selenium_helper.utils.KeyboardEmulation;

import static org.junit.Assert.assertEquals;

public class ExampleTest extends DriverFixture {

    private static TaskPage taskPage;
    private KeyboardEmulation keyboardEmulation = new KeyboardEmulation();

    @Before
    public void initializePages() {
        taskPage = new TaskPage(driver);
    }

    @Test
    public void createTask() {
        taskPage.openTaskPage(wait);
        String taskName = "Task1";
        taskPage.setTaskMame(taskName);
        keyboardEmulation.pressEnter();
        assertEquals(taskName, taskPage.getTaskName());
    }

    @Test
    public void editTask() {
        //Create task
        String taskName = "Task to edit1";
        taskPage.setTaskMame(taskName);
        keyboardEmulation.pressEnter();

        assertEquals(taskName, taskPage.getTaskName());
        //Edit the task
        String newTaskName = "Task Edited";
        taskPage.clickOnTaskName(taskName);
        //Not working, have no time to solve hoe to work with JS elements
        driver.findElement(By.className("editing")).findElement(By.tagName("label")).sendKeys("test ");
        keyboardEmulation.pressEnter();

        assertEquals("test", taskPage.getTaskName());
    }

    @Test
    public void deleteTask() {
        //Create task
        String taskName = "Task to edit1";
        taskPage.setTaskMame(taskName);
        keyboardEmulation.pressEnter();
        //Delete
        taskPage.clickChbx();
        taskPage.clickClear();
    }
}

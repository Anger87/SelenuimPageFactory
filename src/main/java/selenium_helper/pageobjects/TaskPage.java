package selenium_helper.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TaskPage extends AbstractPage {

    public TaskPage(WebDriver driver) {
        super(driver);
    }

    //Objects
    @FindBy(className = "new-todo")
    private WebElement inputField;

    @FindBy(className = "view")
    private WebElement viewMain;

    @FindBy(xpath = "//label")
    private List<WebElement> taskList;


    @FindBy(className = "toggle")
    private WebElement checkbox;

    @FindBy(className = "clear-completed")
    private WebElement clear;


    //Methods

    public void openTaskPage(WebDriverWait wait) {
        wait.until(ExpectedConditions.elementToBeClickable(inputField));
        inputField.click();
    }


    public String getTaskName() {
        return viewMain.findElement(By.tagName("label")).getText();
    }

    public void setTaskMame(String taskName) {
        inputField.sendKeys(taskName);
    }

    public void clickOnTaskName(String taskName) {
        for (WebElement e : taskList) {
            if (e.getText().equals(taskName)) {
                System.out.println("Double " + e.getText());
                doubleClick(e);
            }
        }
    }

    public void clickChbx(){
        waitElement(checkbox);
        checkbox.click();
    }

    public void clickClear(){
        clear.click();
    }
}

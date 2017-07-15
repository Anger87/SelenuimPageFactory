package selenium_helper.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
    public WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doubleClick(WebElement element) {
        try {
            Actions action = new Actions(driver).doubleClick(element);
            action.build().perform();

            System.out.println("Double clicked the element");
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document "
                    + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element " + element + " was not found in DOM "
                    + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }

    protected void waitElement(WebElement element) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver,  5);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}

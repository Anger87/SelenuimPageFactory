package selenium_helper.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class KeyboardEmulation {

    public void pressEnter() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
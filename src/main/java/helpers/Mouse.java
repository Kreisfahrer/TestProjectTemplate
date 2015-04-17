package helpers;

import java.awt.*;

public class Mouse {
    /*
      Away mouse to x,y coordinates
     */
    public static void awayMouse(int x,int y)
    {
        Robot robot = null;
        try
        {
            robot = new Robot();
        } catch (AWTException e)
        {
            e.printStackTrace();
        }
        robot.mouseMove(x,y);
    }
}

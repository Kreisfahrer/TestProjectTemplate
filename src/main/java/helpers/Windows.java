package helpers;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import static java.lang.Thread.sleep;

public class Windows {

    /**
     * Close switch to window (index)
     */
    public static void closeSwitchToWindow(int index)
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        ArrayList windowHandles = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String)windowHandles.get(index)).close();
    }

    /**
     * Close switch to window (title)
     */
    public static void closeSwitchToWindow(String title)
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        Set windowHandles = driver.getWindowHandles();
        Iterator var3 = windowHandles.iterator();

        do
        {
            if(!var3.hasNext())
            {
                throw new IllegalArgumentException("Window with title not found: " + title);
            }

            String windowHandle = (String)var3.next();
            driver.switchTo().window(windowHandle).close();
        } while(!title.equals(driver.getTitle()));

    }

    /**
     * click and switch to new window
     */
    public static void clickAndSwitchToNewWindow(final WebElement element)
    {
        Set<String> existingHandles = WebDriverRunner.getWebDriver().getWindowHandles();
        element.click();

        String foundHandle = null;
        long endTime = System.currentTimeMillis() + 1000;
        while (foundHandle == null && System.currentTimeMillis() < endTime)
        {
            Set<String> currentHandles = WebDriverRunner.getWebDriver().getWindowHandles();
            if (currentHandles.size() != existingHandles.size())
            {
                for (String currentHandle : currentHandles)
                {
                    if (!existingHandles.contains(currentHandle))
                    {
                        foundHandle = currentHandle;
                        break;
                    }
                }

            }

            if (foundHandle == null)
            {
                try
                {
                    sleep(1000);
                } catch (InterruptedException e)
                {
                    throw new IllegalArgumentException("Window with title not found");
                }
            }
        }

        if (foundHandle != null)
        {
            WebDriverRunner.getWebDriver().switchTo().window(foundHandle);
        } else
        {
            throw new IllegalArgumentException("Window with title not found");
        }
    }

    /**
     * Select the first window
     */
    public static void selectFirstWindow()
    {
        Object[] handles = WebDriverRunner.getWebDriver().getWindowHandles().toArray();
        WebDriverRunner.getWebDriver().switchTo().window((String) handles[0]);

    }

    /**
     * We expect the emergence of the new window and select it
     */
    public static void selectNewWindow()
    {
        Object[] handles = WebDriverRunner.getWebDriver().getWindowHandles().toArray();
        handles = WebDriverRunner.getWebDriver().getWindowHandles().toArray();
        WebDriverRunner.getWebDriver().switchTo().window((String) handles[handles.length - 1]);

    }

    /**
     * Select the last window
     */
    public static void selectLastWindow()
    {
        Object[] handles = WebDriverRunner.getWebDriver().getWindowHandles().toArray();
        WebDriverRunner.getWebDriver().switchTo().window((String) handles[handles.length - 1]);

    }

    /**
     * Open new window by hot keys Ctrl + N
     */
    public static void openNewWindow()
    {
        WebDriverRunner.getWebDriver().findElement(By.xpath("//body")).sendKeys(Keys.CONTROL, "n");
        Object[] headers = WebDriverRunner.getWebDriver().getWindowHandles().toArray();
        WebDriverRunner.getWebDriver().switchTo().window(headers[headers.length - 1].toString());
    }
}

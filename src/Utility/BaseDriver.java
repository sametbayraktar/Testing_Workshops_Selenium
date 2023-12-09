package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;


    static{

        CloseRemainings();

        //For Deleting Unnecessary System Logs in Run
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE); // Just showing error notifications

        //For Chrome connection error
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        //For waiting time to start website
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);

        //For waiting time to upload necessary elements
        driver.manage().timeouts().implicitlyWait(dr);


    }



    public static void WaitClose(){

        MyFunc.Wait(3);
        driver.quit();

    }

    //To clear cpu history about chrome driver
    public static void CloseRemainings(){

        try{

            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

        }catch (Exception ignored){

        }

    }

}

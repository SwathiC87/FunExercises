import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    static WebDriver webDriver;

    public static void main(String[] args) throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver",
                "/Users/Shared/Mani/chromedriver-mac-arm64/chromedriver");

        webDriver = new ChromeDriver();


        CheckersTests ct = new CheckersTests(webDriver);
        ct.runTest();

        Thread.sleep(2000);

        CardTests ct1 = new CardTests((webDriver));
        ct1.runTest();



    }
}
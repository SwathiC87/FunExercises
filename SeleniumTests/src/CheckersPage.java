import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

class CheckersPage {
    WebDriver driver;

    By Content = By.xpath("//div[@class='gameWrapper']");

    CheckersPage(WebDriver driver){
        this.driver = driver;
    }

    void navigate(){
        driver.get("https://www.gamesforthebrain.com/game/checkers/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Content));
    }


}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeckOfCards {
    WebDriver driver;

    By Title = By.xpath("//h1[text()='Deck of Cards']");

    DeckOfCards(WebDriver driver){
        this.driver = driver;
    }

    void navigate(){
        driver.get("https://www.deckofcardsapi.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Title));
    }
}

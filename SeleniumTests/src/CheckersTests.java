import org.openqa.selenium.WebDriver;

public class CheckersTests {

    WebDriver webDriver;

    public CheckersTests(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    void runTest() throws InterruptedException {
        CheckersPage checkersPage = new CheckersPage(getWebDriver());
        checkersPage.navigate();
        checkersPage.makeMoves(5);
    }

}

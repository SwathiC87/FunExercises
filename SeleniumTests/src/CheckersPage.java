import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

class CheckersPage {
    WebDriver driver;

    By Content = By.xpath("//div[@class='gameWrapper']");
    By Message = By.id("message");

    By Lines = By.xpath("//div[@class='line']");

    By OrangePieces = By.xpath("//img[contains(@src,'you1.gif')]");

    By GrayPieces = By.xpath("//img[contains(@src,'gray.gif')]");

    By Restart = By.xpath("//a[text()='Restart...']");

    By MakeAMove = By.xpath("//p[text()='Make a move.']");

    CheckersPage(WebDriver driver){
        this.driver = driver;
    }

    void navigate(){
        driver.get("https://www.gamesforthebrain.com/game/checkers/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Content));
    }

    void makeMoves(int count) throws InterruptedException {
        List<WebElement> lines = driver.findElements(Lines);

        int moves=0;
        for (WebElement line : lines){
            List<WebElement> orangePieces = line.findElements(OrangePieces);

            if(!orangePieces.isEmpty()){
                for(WebElement op: orangePieces){
                    String name = op.getAttribute("name");

                    name = name.substring(5,7);
                    System.out.println("name" + name);
                    int x= Integer.parseInt(String.valueOf(name.charAt(0)));
                    int y= Integer.parseInt(String.valueOf(name.charAt(1)));

                    if(!(x + 1 <= 7 && x - 1 >= 0 && y + 1 <= 7)) continue;

                    WebElement d1 = driver.findElement(By.name("space"+(x-1)+""+(y+1)));
                    WebElement d2 = driver.findElement(By.name("space"+(x+1)+""+(y+1)));
                    WebElement grayPiece = null;
                    if(d1 !=null && d1.getAttribute("src").contains("gray.gif")){
                        grayPiece=d1;
                    }

                    if(grayPiece == null && d2 !=null && d2.getAttribute("src").contains("gray.gif")){
                        grayPiece=d2;
                    }

                    op.click();
                    if(grayPiece != null) {
                        grayPiece.click();
                    }

                    Thread.sleep(2000);

                    moves =moves+1;

                    if(moves==count){
                        return;
                    }


                }
            }
        }
    }


}
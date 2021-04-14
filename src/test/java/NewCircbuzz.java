import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewCircbuzz {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.cricbuzz.com/");
        String baseTitle = driver.getTitle();
        System.out.println("title ="+ baseTitle);
        driver.manage().window().maximize();
        WebElement match = driver.findElement(By.xpath("//a[.='MATCHES']"));
        match.click();
        try {
            String LiveMatch = driver.findElement(By.xpath("//div[@class='cb-font-16 cb-col-rt']")).getText();
            if (LiveMatch.equalsIgnoreCase("There are no matches at the moment. Please check back later")) {
                System.out.println("There are no matches at the moment. Please check back later.");
            } else {
                WebElement elmnt1 = driver.findElement(By.xpath("//h3[@class='cb-lv-scr-mtch-hdr inline-block']"));
                elmnt1.click();
                String MatchBetween = driver.getTitle();
                System.out.println("MatchBetween = " + MatchBetween);
                WebElement elmnt2 = driver.findElement(By.xpath("//h2[@class='cb-font-20 text-bold inline-block ng-binding']"));
                System.out.println("Score = " + elmnt2.getText());
                WebElement MatchStatus = driver.findElement(By.xpath("(//div[@class='cb-text-inprogress'])[2]"));
                System.out.println("Status of Balls left = " + MatchStatus.getText());
            }
        }
        catch (Exception e) {
                driver.findElement(By.id("upcoming-tab")).click();
                WebElement elmnt3 = driver.findElement(By.xpath("(//a[@class='text-hvr-underline text-bold'])[1]"));
                elmnt3.click();
                String MatchBetween = driver.getTitle();
                System.out.println("MatchBetween >>>>>>>>>> " + MatchBetween);
                WebElement elmnt4 = driver.findElement(By.xpath("(//div[@class='ng-scope'])[3]"));
                System.out.println("Total time left for the match >>>>>>>>>> " + elmnt4.getText());
                WebElement elmn5 = driver.findElement(By.xpath("//span[@itemprop='startDate']"));
                System.out.println("Match starts at >>>>>>>> " + elmn5.getText());
        }
        driver.quit();
    }
}

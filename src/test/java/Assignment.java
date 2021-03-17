import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Assignment {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rarediseases.info.nih.gov/diseases/categories");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//nav[@id='myScrollspy']//a[normalize-space()='Find Diseases By Category']//following::li)[1]")).click();
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Autoimmune / Autoinflammatory diseases']")).getText());
        driver.findElement(By.xpath("//a[normalize-space()=\"Addison's disease\"]")).click();
        JavascriptExecutor js =  (JavascriptExecutor)driver;
        WebElement summary = driver.findElement(By.xpath("//span[normalize-space()='Summary']"));
        js.executeScript("arguments[0].scrollIntoView();",summary);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[.='View All'])[2]")));
        WebElement terms = driver.findElement(By.xpath("(//button[.='View All'])[2]"));
        js.executeScript("arguments[0].scrollIntoView();",terms);
        terms.click();
        driver.get("https://rarediseases.info.nih.gov/diseases/categories");
        driver.findElement(By.xpath("(//nav[@id='myScrollspy']//a[normalize-space()='Find Diseases By Category']//following::li)[3]")).click();
        System.out.println(driver.findElement(By.xpath("//h1[normalize-space()='Behavioral and mental disorders']")).getText());
        driver.findElement(By.xpath("//a[normalize-space()=\"Asperger syndrome\"]")).click();
        JavascriptExecutor scroll =  (JavascriptExecutor)driver;
        WebElement summary1 = driver.findElement(By.xpath("//span[normalize-space()='Summary']"));
        scroll.executeScript("arguments[0].scrollIntoView();",summary1);
        driver.quit();
    }

}

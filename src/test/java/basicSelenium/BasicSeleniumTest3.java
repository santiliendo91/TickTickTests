package basicSelenium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Date;

public class BasicSeleniumTest3 {

    WebDriver driver;

    @BeforeEach
    public void setup(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/driver/chromedriver");
        driver = new ChromeDriver();
        // implicit
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // page load wait
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://todoist.com/");
    }

    @AfterEach
    public void cleanup(){
        driver.quit();
    }

    @Test
    public void verifyCRUDProject() throws InterruptedException {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // login
        driver.findElement(By.xpath("//ul/li/a[contains(text(),'Log in')]")).click();

        driver.findElement(By.xpath("//input[contains(@placeholder, \"Enter your email\")]")).sendKeys("remihog425@pamaweb.com");
        driver.findElement(By.xpath("//input[contains(@placeholder, \"Enter your password...\")]")).sendKeys("pass123*");
        driver.findElement(By.xpath("//button[contains(@type,\"submit\")]")).click();

        explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[contains(text(),'Today')]")));

        //Create project
        driver.findElement(By.xpath("//button[@aria-label='Add project']")).click();
        driver.findElement(By.xpath("//input[contains(@id,\"edit_project_modal_field_name\")]")).sendKeys("Test");
        driver.findElement(By.xpath("//button[contains(@type,\"submit\")]")).click();
        driver.findElement(By.xpath("//header/div/span[@class='simple_content']")).getText();

        //EditProject
        driver.findElement(By.xpath("//button[contains(@aria-label,\"Project options menu\")]")).click();
        driver.findElement(By.xpath("//ul/li/div[contains(text(),'Edit project')]")).click();
        driver.findElement(By.xpath("//input[contains(@id,\"edit_project_modal_field_name\")]")).sendKeys("Test2");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        driver.findElement(By.xpath("//header/div/span[@class='simple_content']")).getText();

        //deleteProject
        driver.findElement(By.xpath("//button[contains(@aria-label,\"Project options menu\")]")).click();
        driver.findElement(By.xpath("//ul/li/div[contains(text(),'Delete project')]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();



        //check created project




        // Explicit Wait
        Thread.sleep(5000);

//        explicitWait.until(ExpectedConditions.elementToBeClickable(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")));
//
//        Assertions.assertTrue(driver.findElement(By.id("ctl00_HeaderTopControl1_LinkButtonLogout")).isDisplayed()
//                                    ,"ERROR login was incorrect");

//        // create
//        String nameProject="Mojix"+new Date().getTime();
//        driver.findElement(By.xpath("//td[text()='Add New Project']")).click();
//        driver.findElement(By.id("NewProjNameInput")).sendKeys(nameProject);
//        driver.findElement(By.id("NewProjNameButton")).click();
//        Thread.sleep(1000);
//        int actualResult=driver.findElements(By.xpath(" //td[text()='"+nameProject+"'] ")).size();
//        Assertions.assertTrue(actualResult >= 1
//                ,"ERROR The project was not created");
//        // create task
//        driver.findElement(By.id("NewItemContentInput")).sendKeys("Eynar");
//        driver.findElement(By.id("NewItemAddButton")).click();
//        // create update
//        driver.findElement(By.xpath("//div[@class=\"ItemContentDiv\" and text()='Eynar']")).click();
//        driver.findElement(By.id("ItemEditTextbox")).clear();
//        driver.findElement(By.id("ItemEditTextbox")).sendKeys("Update\n");
//        Thread.sleep(5000);

    }
}

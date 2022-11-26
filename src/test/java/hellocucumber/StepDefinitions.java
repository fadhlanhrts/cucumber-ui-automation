package hellocucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import static org.junit.jupiter.api.Assertions.*;

public class StepDefinitions {
    WebDriver driver;
    Select menuOption;
    WebElement element;
    String actual;
    JavascriptExecutor js;
    String[] colors = {"Black", "Blue", "Green", "Red"};

    WebElement webObject;

    StepDefinitions sd;

    public void setWebObject(WebElement webObject) {
        this.webObject = webObject;
    }

    public WebElement getWebObject(){
        return this.webObject;
    }

    /*
        Scenario 1
     */
    @Given("User go to {string}")
    public void userGoTo(String url) throws InterruptedException{
        // Get location of web driver
        final String dir = System.getProperty("user.dir");
        System.out.println("Current dir: " + dir);
        System.setProperty("webdriver.chrome.driver",dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        // Navigate to url
        url = "https://demoqa.com/select-menu";
        driver.get(url);
        Thread.sleep(100);
    }

    @When("User in {string} page")
    public void userInPage(String menuOption) {
        // Verify user is at url
        driver.findElement(By.xpath("//*[contains(text(), 'Select Menu')]")).isDisplayed();
    }

    @And("User choose select value “Another root option”")
    public void userChooseSelectValueAnotherRootOption() {
        // Click on select option dropdown
        element = driver.findElement(By.xpath("//*[contains(text(), 'Select Option')]"));
        element.click();

        // Search for another root option in dropdown
        element = driver.findElement(By.xpath("//div[contains(text(), 'Select Option')]//following::input"));
        element.sendKeys("Another");

        // Click on another root option
        element = driver.findElement(By.xpath("//*[contains(text(), 'Another root option')]"));
        element.click();
    }

    @And("User choose select one “Other”")
    public void userChooseSelectOneOther() {
        // Click on select option dropdown
        element = driver.findElement(By.xpath("//*[contains(text(), 'Select Title')]"));
        element.click();

        // Search for another root option in dropdown
        element = driver.findElement(By.xpath("//div[contains(text(), 'Select Title')]//following::input"));
        element.sendKeys("oth");

        // Click on another root option
        element = driver.findElement(By.xpath("//*[contains(text(), 'Other')]"));
        element.click();
    }

    @And("User choose old style select menu “Aqua”")
    public void userChooseOldStyleSelectMenuAqua() {
        menuOption = new Select(driver.findElement(By.id("oldSelectMenu")));
        menuOption.selectByVisibleText("Aqua");

    }

    @And("User choose multi select drop down “all color”")
    public void userChooseMultiSelectDropDownAllColor() {

        String[] colorKeyword = {"black", "blue", "green", "red"};


        for (int i = 0; i < colors.length; i++) {
            // Search for another root option in dropdown

            if(i>1){
                String el = "//div[contains(text(), '" + colors[i-1] +"')]//following::input";
                element = driver.findElement(By.xpath(el));
            } else {
                element = driver.findElement(By.xpath("//div[contains(text(), 'Select...')]//following::input"));

            }
              js.executeScript("arguments[0].scrollIntoView();", element);
            element.sendKeys(colorKeyword[i]);
             String xpath = "//div[contains(text(), '" + colors[i] + "')]";

            // Click on another root option
            element = driver.findElement(By.xpath(xpath));
            element.click();
        }
    }

    @Then("User success input all select menu")
    public void userSuccessInputAllSelectMenu() {
        sd = new StepDefinitions();
        sd.setWebObject(driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue' and contains(text(), 'Another root option')]")));
        sd.getWebObject().isDisplayed();

        driver.findElement(By.xpath("//div[@class=' css-1uccc91-singleValue' and contains(text(), 'Other')]"))
                .isDisplayed();
        
        menuOption = new Select(driver.findElement(By.id("oldSelectMenu")));
        actual = menuOption.getFirstSelectedOption().getText();
        assertEquals("Aqua", actual);


        for (int i = 0; i < colors.length; i++) {
            String xpath = "//div[contains(text(), '" + colors[i] + "')]";

            sd.setWebObject(driver.findElement(By.xpath(xpath)));
            sd.getWebObject().isDisplayed();
        }

        driver.close();
        driver.quit();
    }


    /*
     Scenario 2
     */
    @Given("User navigate to {string}")
    public void userNavigateTo(String url) throws InterruptedException{
        // Get location of web driver
        final String dir = System.getProperty("user.dir");
        System.out.println("Current dir: " + dir);
        System.setProperty("webdriver.chrome.driver",dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        // Navigate to url
        url = "https://demoqa.com/books";
        driver.get(url);
        Thread.sleep(100);
    }

    @When("User is in {string} page")
    public void userIsInPage(String urlPage) {
        // Verify user is at url
        driver.findElement(By.xpath("//*[contains(text(), 'Book Store')]")).isDisplayed();
    }

    @And("User search book {string}")
    public void userSearchBook(String bookName) {
        // Search for another root option in dropdown
        element = driver.findElement(By.id("searchBox"));
        element.sendKeys("qa engineer");
        element.sendKeys(Keys.ENTER);
    }

    @Then("User see {string}")
    public void userSee(String result) {
        sd = new StepDefinitions();
        sd.setWebObject(driver.findElement(By.className("rt-noData")));
        sd.getWebObject().isDisplayed();

        driver.close();
        driver.quit();
    }


    /*
     Scenario 3
     */
    @Given("User visit {string}")
    public void userVisit(String url) throws InterruptedException{
        // Get location of web driver
        final String dir = System.getProperty("user.dir");
        System.out.println("Current dir: " + dir);
        System.setProperty("webdriver.chrome.driver",dir+"/driver/chromedriver");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();

        // Navigate to url
        url = "https://demoqa.com/books";
        driver.get(url);
        Thread.sleep(100);
    }

    @When("User is located in {string} page")
    public void userIsLocatedInPage(String urlPage) {
        // Verify user is at url
        driver.findElement(By.xpath("//*[contains(text(), 'Book Store')]")).isDisplayed();
    }

    @And("User look up {string}")
    public void userLookUp(String keyword) {
        // Search for another root option in dropdown
        element = driver.findElement(By.id("searchBox"));
        element.sendKeys("Git Pocket Guide");
        element.sendKeys(Keys.ENTER);
    }

    @And("User click book {string}")
    public void userClickBook(String bookName) {
        element = driver.findElement(By.xpath("//a[@href='/books?book=9781449325862']"));
        element.click();
    }

    @Then("User can see {string}")
    public void userCanSee(String bookName) {
        sd = new StepDefinitions();
        sd.setWebObject(driver.findElement(By.id("title-wrapper")));
        sd.getWebObject().isDisplayed();

        driver.close();
        driver.quit();
    }
}

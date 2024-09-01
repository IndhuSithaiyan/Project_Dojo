package com.cts.dojomvp.banking.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class BankApplication_StepFile {

    private WebDriver driver;

    @Given("open the browser and launch the Bank Management home page")
    public void open_the_browser_and_launch_the_bank_management_home_page() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);

        driver.get("http://localhost:8080/login");
    }

    @When("user is able to login by using username as “{string}” and password as “{string}”")
    public void user_is_able_to_login_by_using_username_as_and_password_as(String username, String password) {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
    }

    @When("click on login button")
    public void click_on_login_button() throws InterruptedException {
        WebElement loginbtn = driver.findElement(By.xpath("//input[@type='submit']"));
        Thread.sleep(2000);
        loginbtn.click();
        Thread.sleep(4000);
    }

    @Then("user logged in successfully and navigated to page")
    public void user_logged_in_successfully_and_navigated_to_page() {
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "http://localhost:8080/loginProcess";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("Test Pass");

        driver.quit();
    }

    @Then("user is getting error {string}")
    public void userIsGettingErrorError(String errorMsg) {
        WebElement text = driver.findElement(By.xpath("/html/body/table/tbody/tr/td"));
        Assert.assertEquals(errorMsg,text.getText());
    }

    @Given("click on register button")
    public void click_on_register_button() throws InterruptedException {
        WebElement registerbtn = driver.findElement(By.xpath("//input[@type='button']"));
        registerbtn.click();
        Thread.sleep(2000);

    }

    @When("enter details to register {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void enter_details_to_register(String firstName, String lastName, String password, String accountType, String PAN, String mobNum, String email, String amount) {
        driver.findElement(By.id("firstName")).sendKeys(firstName);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("passWord")).sendKeys(password);
        WebElement dropdown = driver.findElement(By.id("accountType"));
        Select select = new Select(dropdown);

        //select by visible text
        select.selectByValue(accountType);
        driver.findElement(By.id("pan")).sendKeys(PAN);
        driver.findElement(By.id("mobileNumber")).sendKeys(mobNum);
        driver.findElement(By.id("emailId")).sendKeys(email);
        driver.findElement(By.id("amount")).sendKeys(amount);
    }

    @When("click on submit")
    public void click_on_submit() throws InterruptedException {
        WebElement registerSubmitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
        registerSubmitbtn.click();
        Thread.sleep(2000);
    }

    @Then("user should be reach on Account details page")
    public void user_should_be_reach_on_Account_details_page() {
        String expectedUrl = driver.getCurrentUrl();
        String actualUrl = "http://localhost:8080/user-regn/createAccount";
        Assert.assertEquals(expectedUrl,actualUrl);
        System.out.println("Test Pass");

        driver.quit();
    }

    @Then("user should be receive error warning while entering invalid values {string}")
    public void userShouldBeReceiveErrorWarningWhileEnteringInvalidValues(String expected) throws InterruptedException {
        WebElement firstName_field = driver.findElement(By.id("firstName"));
        String actual_firstName = firstName_field.getAttribute("title");

        WebElement lastName_field = driver.findElement(By.id("firstName"));
        String actual_lastName = lastName_field.getAttribute("title");

        WebElement pan_field = driver.findElement(By.id("firstName"));
        String actual_pan = pan_field.getAttribute("title");

        WebElement mobileNumber_field = driver.findElement(By.id("firstName"));
        String actual_mobileNumber = mobileNumber_field.getAttribute("title");

        isMatching(actual_firstName,expected);
        isMatching(actual_lastName,expected);
        isMatching(actual_pan,expected);
        isMatching(actual_mobileNumber,expected);

        Thread.sleep(4000);
        driver.quit();
    }

    private boolean isMatching(String actualErrorMsg, String expectedErrorMsg){
        if(actualErrorMsg.equalsIgnoreCase(expectedErrorMsg)){
            System.out.println("Test Case Passed");
            return true;
        }
        else {
            System.out.println("Test Case Failed");
            return false;
        }
    }

    @When("user is able to apply loan by selecting loan section {string} {string} {string}")
    public void user_is_able_to_apply_loan_by_selecting_loan_section(String loanRequestType, String interestType, String loanAmount) throws InterruptedException {
        WebElement dropdown1 = driver.findElement(By.id("loanRequestType"));
        Select select1 = new Select(dropdown1);
        select1.selectByValue(loanRequestType);

        WebElement dropdown2 = driver.findElement(By.id("interestType"));
        Select select2 = new Select(dropdown2);
        select2.selectByValue(interestType);

        driver.findElement(By.id("loanAmount")).sendKeys(loanAmount);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(3000);
    }

    @Then("user is able to see their applied loan details page")
    public void userIsAbleToSeeTheirAppliedLoanDetailsPage() {
        WebElement text = driver.findElement(By.xpath("//*[@id='command']/h1"));
        Assert.assertEquals(" Applied Loan Details ", text);
        driver.quit();
    }


}

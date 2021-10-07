package com.newexperiences;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    private WebDriver webDriver;
    private String baseUrl = "http://automationpractice.com";

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chrome-driver-81.0.4044.69.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @Given("Abre http://automationpractice.com/index.php?controller=authentication")
    public void open_google_com() {
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get(baseUrl+"/index.php?controller=authentication");
    }

    @When("Ingresa email {string} y {string}")
    public void entering_number_and(String email, String password) {
        WebElement textBoxEmail = webDriver.findElement(By.id("email"));
        WebElement textBoxPassword = webDriver.findElement(By.id("passwd"));

        textBoxEmail.sendKeys(email);
        textBoxPassword.sendKeys(password);

    }

    @When("Preciona SING IN")
    public void press_enter() {
        WebElement signInButton = webDriver.findElement(new By.ById("SubmitLogin"));
        signInButton.click();
    }

    @Then("Muestra mensaje {string}")
    public void result_should_be(String result) {
        WebElement mensaje = webDriver.findElement(By.xpath("div[@class='alert alert-danger']"));
        String getResult = mensaje.getText();
        Assert.assertTrue(getResult.contains(result));
        webDriver.close();
    }

    @After
    public void end() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}

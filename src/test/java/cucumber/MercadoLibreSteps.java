package cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class MercadoLibreSteps {

    private WebDriver driver;

    @Before
    public void before() {

        driver = new ChromeDriver();
        driver.get("https://www.mercadolibre.com.co/");
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.quit();
    }

    @Given("^Enter search term '(.*?)'$")
    public void searchFor(String searchTerm) {
        WebElement searchField = driver.findElement(By.className("nav-search-input"));
        searchField.sendKeys(searchTerm);
    }

    @When("^Do search$")
    public void clickSearchButton() {
        WebElement searchButton = driver.findElement(By.className("nav-search-btn"));
        searchButton.click();
    }

    @Then("^Multiple results shown for '(.*?)'$")
    public void assertSingleResult(String searchResult) {
        WebElement results = driver
                .findElement(By.className("ml-main"));
        assertFalse(results.getText().contains("No hay publicaciones que coincidan con tu búsqueda."));
        assertTrue(results.getText().startsWith(searchResult));
    }
}

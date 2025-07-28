package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
    WebDriver driver;

    @FindBy(id = "firstname") WebElement firstNameInput;
    @FindBy(id = "lastname") WebElement lastNameInput;
    @FindBy(id = "email_address") WebElement emailInput;
    @FindBy(id = "password") WebElement pwdInput;
    @FindBy(id = "password-confirmation") WebElement pwdConfirmInput;
    @FindBy(css = "button[title='Create an Account']") WebElement createAccountButton;

    @FindBy(css = ".message-success") WebElement successMessage;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
    }

    public void register(String fn, String ln, String email, String password) {
        firstNameInput.sendKeys(fn);
        lastNameInput.sendKeys(ln);
        emailInput.sendKeys(email);
        pwdInput.sendKeys(password);
        pwdConfirmInput.sendKeys(password);
        createAccountButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}

package authPage;

import core.BasePage;
import jdk.nashorn.internal.objects.Global;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import readProperties.ConfigProvider;


public class AuthPage extends BasePage {

    @FindBy(xpath = "//label[text()='Заказчик']")
    private WebElement customerRadioButton;

    @FindBy(xpath = "//label[text()='Уполномоченное учреждение']")
    private WebElement uoRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "//button[contains(text(),'Отмена')]")
    private WebElement cancelButton;

    public AuthPage(){
        driver.get(ConfigProvider.URL);
    }

}

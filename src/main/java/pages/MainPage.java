package pages;

import core.BasePage;
import core.ElementActions;
import core.Global;
import enums.OrgType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.procedure.ProceduresPage;


public class MainPage extends BasePage {

    @FindBy(xpath = "//label[text()='Заказчик']")
    private WebElement customerRadioButton;

    @FindBy(xpath = "//label[text()='Уполномоченное учреждение']")
    private WebElement uoRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Войти')]")
    private WebElement enterButton;

    @FindBy(xpath = "//p[text()='Вы успешно авторизовались в закрытой части Единой информационной системы в сфере закупок.']")
    private WebElement successAuthText;

    @FindBy(xpath = "//span[text()='Закупки']")
    private WebElement topMenuPurchaseLink;

    @FindBy(xpath = "//a[contains(text(),'Закупки 44-ФЗ')]")
    private WebElement purchase44FzLink;

    @FindBy(xpath = "//h1[text()='Реестр закупок закрытой части сайта (Закон №44-ФЗ)']")
    private WebElement procedurePagesTitle;

    public MainPage(){
        driver.get(Global.URL);
        PageFactory.initElements(driver,this);
    }

    /**
     * Авторизации на площадке
     * @param type - тип организации, размещающей закупку
     * @return
     */
    public MainPage auth(OrgType type){
        switch (type) {
            case CUSTOMER:
                ElementActions.isVisibilityIsClickableClick(customerRadioButton);
                break;
            case UO:
                ElementActions.isVisibilityIsClickableClick(uoRadioButton);
                break;
        }
        ElementActions.isVisibilityIsClickableClick(enterButton);
        return this;
    }

    public ProceduresPage openProceduresPage(){
        ElementActions.isVisibilityIsClickableClick(topMenuPurchaseLink);
        ElementActions.isVisibilityIsClickableClick(purchase44FzLink, procedurePagesTitle);
        return new ProceduresPage();
    }

}

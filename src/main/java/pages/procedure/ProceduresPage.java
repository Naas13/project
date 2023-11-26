package pages.procedure;

import core.BaseTest;
import core.ElementActions;
import enums.PlacingWay;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProceduresPage extends BaseTest {

    @FindBy(xpath = "//strong[text()='Создать']")
    private WebElement createButton;

    @FindBy(xpath = "//li[text()='Извещение об осуществлении закупки/ Приглашение к участию в закупке']")
    private WebElement purchaseLink;

    @FindBy(xpath = "//h1[text()='Выбор способа определения поставщика (подрядчика, исполнителя)']")
    private WebElement placingWayHeader;

    @FindBy(id = "popupPlacingWaySelect")
    private WebElement popupPlacingWaySelect;

    @FindBy(xpath = "//input[contains(@value,'Выбрать')]")
    private WebElement SelectButton;

    @FindBy(id = "confirm")
    private WebElement OkButton;

    @FindBy(xpath = "//input[contains(@value,'Да')]")
    private WebElement YesButton;

    @FindBy(xpath = "//div[contains(text(),'В соответствии с положениями Закона № 44-ФЗ')]")
    private WebElement warningText;

    @FindBy(xpath = "//span[contains(text(),'Вы можете сформировать извещение об осуществлении закупки" +
            " на основе структурированного плана-график')]")
    private WebElement modalText;

    @FindBy(xpath = "//th[contains(text(),'Формирование извещения (приглашения)')]")
    private WebElement procedureStatusText;

    public ProceduresPage() {
        PageFactory.initElements(driver,this);
    }

    public MainInfo createProcedureDraft(PlacingWay placingWay){
        ElementActions.isVisibilityIsClickableClick(createButton, purchaseLink);
        ElementActions.isVisibilityIsClickableClick(purchaseLink, placingWayHeader);
        Select placingWaySelect = new Select(popupPlacingWaySelect);
        placingWaySelect.selectByValue(String.valueOf(placingWay));
        ElementActions.isVisibilityIsClickableClick(SelectButton, warningText);
        ElementActions.isVisibilityIsClickableClick(OkButton, modalText);
        ElementActions.isVisibilityIsClickableClick(YesButton, procedureStatusText);
        return new MainInfo();
    }

}

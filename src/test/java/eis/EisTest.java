package eis;

import core.ElementActions;
import enums.OrgType;
import enums.PlacingWay;
import pages.MainPage;
import core.BaseTest;
import org.junit.jupiter.api.Test;

public class EisTest extends BaseTest {

    @Test
    public void test01(){
        MainPage mainPage = new MainPage();
        mainPage.auth(OrgType.CUSTOMER)
                .openProceduresPage()
                .createProcedureDraft(PlacingWay.ZK20);
    }


}

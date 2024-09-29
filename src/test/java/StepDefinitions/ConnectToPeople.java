package StepDefinitions;

import Pages.LocatorPage;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ConnectToPeople {

    LocatorPage lp = new LocatorPage();

    @When("Enter the datas and press KeysENTER")
    public void enterTheDatasAndPressKeysENTER(DataTable dataTable) {
        List<List<String>> strElementsList = dataTable.asLists(String.class);
        for (int i = 0; i < strElementsList.size(); i++) {
            WebElement e = lp.getWebElement(strElementsList.get(i).get(0));
            String strData = strElementsList.get(i).get(1);
            lp.mySendKeysENTER(e, strData);
        }
    }


    @And("Connect to people")
    public void connectToPeople(DataTable dataTable) {
        List<String> strElementsList = dataTable.asList(String.class);
        lp.wait.until(ExpectedConditions.visibilityOfAllElements(lp.status));
        List<WebElement> statusList = lp.status;
        int connect = 0;
        int noConnect = 0;

        for (int i = 0; i < statusList.size(); i++) {
            if (statusList.get(i).getText().toLowerCase().contains(strElementsList.get(4))) {
                lp.myJsClick(statusList.get(i));
                lp.wait.until(ExpectedConditions.elementToBeClickable(lp.getWebElement(strElementsList.get(2))));
                if (lp.getWebElement(strElementsList.get(1)).getText().toLowerCase().contains(strElementsList.get(4))) {
                    lp.myJsClick(lp.getWebElement(strElementsList.get(2)));
                    lp.myClick(lp.getWebElement(strElementsList.get(3)));
                    connect = connect + 1;
                } else {
                    lp.myJsClick(lp.getWebElement(strElementsList.get(5)));
                    lp.myJsClick(lp.getWebElement(strElementsList.get(6)));
                    lp.myClick(lp.getWebElement(strElementsList.get(3)));
                    connect = connect + 1;
                }
                GWD.getDriver().navigate().back();
            } else {
                noConnect = noConnect + 1;
            }
        }
        System.out.println(connect + " connect yapıldı\t" + noConnect + " connect yapılmadı");
    }


}

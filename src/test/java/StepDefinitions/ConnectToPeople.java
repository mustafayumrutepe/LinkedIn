package StepDefinitions;

import Pages.LocatorPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ConnectToPeople {

    LocatorPage lp = new LocatorPage();

    @When("Enter the datas and press KeysENTER")
    public void enterTheDatasAndPressKeysENTER(DataTable dataTable) {
        List<List<String>> strElementsList = dataTable.asLists(String.class);
        for (int i = 0; i < strElementsList.size(); i++) {
            WebElement e=lp.getWebElement(strElementsList.get(i).get(0));
            String strData = strElementsList.get(i).get(1);

            lp.mySendKeysENTER(e,strData);
        }
    }

    @And("Connect to people")
    public void connectToPeople(DataTable dataTable) {
        List<String> strElementsList = dataTable.asList(String.class);
        optionalWait(3);
        List<WebElement> statusList = lp.status;


            for (int i = 0; i < statusList.size(); i++) {
                optionalWait(3);
                WebElement element = statusList.get(i).findElement(By.xpath("./div/button/span"));
                if (element.getText().toLowerCase().contains(strElementsList.get(4))){
                lp.myJsClick(statusList.get(i));
                    optionalWait(3);
                    WebElement element2 = lp.getWebElement(strElementsList.get(1)).findElement(By.xpath("./div/button/span"));
                    if (element2.getText().toLowerCase().contains(strElementsList.get(4))) {
                        lp.myJsClick(element2);
                        lp.myClick(lp.getWebElement(strElementsList.get(3)));
                    }else {
                    System.out.println("buraya more butonuna tıklayarak devam etme kodları gelecek");
                }
                    GWD.getDriver().navigate().back();
                }else {
                    System.out.println("hiç connect yapılmadı");
                    continue;
                }
            }

    }




    public void optionalWait(int sec) {
        try {
            try {
                Thread.sleep(sec * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } finally {

        }
    }


}

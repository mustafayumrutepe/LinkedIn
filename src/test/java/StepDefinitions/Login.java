package StepDefinitions;

import Pages.LocatorPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login {
    LocatorPage lp = new LocatorPage();

    @Given("^Navigate to website$")
    public void navigateToWebsite() {
        GWD.getDriver().get("https://www.linkedin.com/login/tr?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");
    }


    @Then("Enter the data/datas$")
    public void enterTheDataDatas(DataTable dataTable) {
        List<List<String>> strElementsList = dataTable.asLists(String.class);
        for (int i = 0; i < strElementsList.size(); i++) {
            WebElement e=lp.getWebElement(strElementsList.get(i).get(0));
            String strData = strElementsList.get(i).get(1);

            lp.mySendKeys(e,strData);
        }
    }


    @When("Click on the element/elements$")
    public void clickOnTheElementElements(DataTable dataTable) {
        List<String> strElementsList = dataTable.asList(String.class);
        for (String strE : strElementsList){
            lp.myClick(lp.getWebElement(strE));
        }
    }




}










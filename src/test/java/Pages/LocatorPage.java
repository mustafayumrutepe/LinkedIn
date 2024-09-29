package Pages;

import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LocatorPage extends Parent{
    public LocatorPage() {PageFactory.initElements(GWD.getDriver(),this);}

    @FindBy(id = "username")                                                                                                private WebElement email;
    @FindBy(id = "password")                                                                                                private WebElement password;
    @FindBy(css = "[type='submit']")                                                                                        private WebElement loginButton;
    @FindBy(css = "[placeholder='Search']")                                                                                 private WebElement searchButton;
    @FindBy(xpath = "(//div[@id='search-reusables__filters-bar'])/ul/li/button[text()='People']")                           private WebElement people;
    @FindBy(xpath = "(//div[@class='top-card-background-hero-image']/following-sibling::div[1])/div[3]")                    private WebElement barInfo;
    @FindBy(xpath = "(//div[@class='top-card-background-hero-image']/following-sibling::div[1])/div[3]/div/button")         private WebElement connect1;
    @FindBy(xpath = "//button[@aria-label='Send without a note']")                                                          private WebElement sendWithoutANote;



    public WebElement getWebElement(String strElement){
        switch (strElement){
            case "email": return this.email;
            case "password": return this.password;
            case "loginButton": return this.loginButton;
            case "searchButton": return this.searchButton;
            case "people": return this.people;
            case "barInfo": return this.barInfo;
            case "connect1": return this.connect1;
            case "sendWithoutANote": return this.sendWithoutANote;
        }
        return null;
    }







    @FindBy(xpath = "(//ul[@role='list'])[1]//li/div/div/div/div[3]")           public List<WebElement> status;

//    public List<WebElement> getStatus(String strElements) {return this.status;}
//
//    public List<WebElement> getWebElements(String strElements){
//        switch (strElements){
//            case "status": return this.status;
//        }
//        return null;
//    }
}
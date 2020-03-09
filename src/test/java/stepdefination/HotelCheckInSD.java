package stepdefination;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HotelCheckInSD extends BasePageSD {
    BasePageSD basePageSD = new BasePageSD();

    @Given("^I am on the hotels page$")
    public void homePage() throws InterruptedException {
        Thread.sleep(2000);
        org.testng.Assert.assertEquals(SharedSD.getDriver().getTitle(), "Hotels.com - Deals & Discounts for Hotel Reservations from Luxury Hotels to Budget Accommodations", "Invalid Home Page");
    }


    @When("^I select (\\d+) in rooms$")
    public void selectNumberOfRooms(int selectNumberofRooms) throws InterruptedException {
        selectNumberofRooms = 1;
        WebElement room = SharedSD.getDriver().findElement(By.id("qf-0q-rooms"));
        Select roomDropdown = new Select(room);
        List<WebElement> roomsList = roomDropdown.getOptions();
        for (int i = 0; i < roomsList.size(); i++) {
            WebElement totalRooms = roomsList.get(i);
            // System.out.println("print total romms: "+totalRooms.getText());
            if (totalRooms.getText().equals(new Integer(selectNumberofRooms).toString())) {
                totalRooms.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @When("^I select (\\d+) in adults$")
    public void selectNumberOfAdults(int numberOfAdults) throws InterruptedException {
        numberOfAdults = 4;
        WebElement adults = SharedSD.getDriver().findElement(By.id("qf-0q-room-0-adults"));
        Select adultsDropDown = new Select(adults);
        List<WebElement> adultsList = adultsDropDown.getOptions();
        for (int i = 0; i < adultsList.size(); i++) {
            WebElement totalAdults = adultsList.get(i);
            if (totalAdults.getText().equals((new Integer(numberOfAdults).toString()))) {
                totalAdults.click();
                Thread.sleep(2000);
                break;
            }
        }
    }

    @When("^I select (\\d+) in children$")
    public void selectNumberOfKids(int numberOfKids) throws InterruptedException {
        numberOfKids = 2;
        WebElement kids = SharedSD.getDriver().findElement(By.id("qf-0q-room-0-children"));
        Select kidsDropDown = new Select(kids);
        List<WebElement> kidsList = kidsDropDown.getOptions();
        for (int i = 0; i < kidsList.size(); i++) {
            WebElement totalKids = kidsList.get(i);
            if (totalKids.getText().equals((new Integer(numberOfKids).toString()))) {
                totalKids.click();
                Thread.sleep(2000);
                break;
            }
        }
    }


    @Then("^I verify that i get 2 children dropdown$")
    public void verifyGetChildrenDropDrown() {
       Assert.assertEquals("Select your children’s age to see accurate prices and availability",basePageSD.getTextM());
    }

}








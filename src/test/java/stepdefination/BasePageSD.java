package stepdefination;

import org.openqa.selenium.By;

public class BasePageSD {
    private By rooms = By.id("qf-0q-rooms");
    private By adults=By.id("qf-0q-room-0-adults");
    private By children=By.id("qf-0q-room-0-children");
    private By ChildrenMESSage=By.xpath("//div[@class='widget-query-room-children-notice']");
    public void clickOn(){
        SharedSD.getDriver().findElement(rooms).click();
    }
    public void clickOnAdult(){ SharedSD.getDriver().findElement(adults).click();}
    public void clickOnChildren(){SharedSD.getDriver().findElement(children).click();}
    public String getTextM()
    {
        return SharedSD.getDriver().findElement(ChildrenMESSage).getText();}
}

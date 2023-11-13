package day11_actions_faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ActionsTest extends TestBase {
    @Test
    public void test01() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        frameIndex(0); // TestBase classinda olusturdugunuz reusable method sayesinde
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        actions.dragAndDrop(drag,drop).perform(); // drag webelementini alip drop webelementinin üzerine birakiriz
    }


    @Test
    public void test02() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        frameIndex(0); // TestBase classinda olusturdugunuz reusable method sayesinde
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.clickAndHold(drag). //drag webelementini tut ve bekle
                moveToElement(drop). //drag webelementini drop webelementinin üzerine götürür
                release(). //Basili tuttugumuz webelementi serbest birakir
                perform(); // Action i isleme aldik
    }

    @Test
    public void test03() {
        //https://jqueryui.com/droppable/ adresine gidelim
        driver.get("https://jqueryui.com/droppable/");

        //Drag me to my target webelementini Drop here webelementi üzerine bıkalım
        Actions actions = new Actions(driver);
        frameIndex(0); // TestBase classinda olusturdugunuz reusable method sayesinde
        WebElement drag = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));
        actions.clickAndHold(drag).moveByOffset(186, 48).release().perform();


        //Homework
        //Drag webelementinin drop webelementi üzerine birakildigini dogrulayin
    }

}


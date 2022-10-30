/*
Otomasyon projesinde kullanılan methodlar okunulabilirliğin arttırılması
ve  esneklik  sağlanabilmesi  için  bu  sınıf  içerisinde tanımlanmıştır.
*/

package Automation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods {

    WebDriver driver;
    private static WebDriverWait wait;

    //Constructor
    public Methods(WebDriver driver) {
        this.driver = Variables.driver;
        wait = new WebDriverWait(driver, 20);
    }

    // Yorum sayısını getir // Get the number of comments
    public static int GetCommentCount(String commentCountString)
    {
        String parts[] = commentCountString.split(" ");
        String str=parts[1].substring(1, parts[1].length() - 1);
        return Integer.parseInt(str);
    }

    // Tıklanabilir olmasını bekle // wait for it to be clickable
    public static void waitWhileTheElementIsClickable(By elementBy)
    {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    // Elemente tıkla // Click on the element
    public static void clickElement(WebDriver driver, By elementBy)
    {
        driver.findElement(elementBy).click();
    }

    // Aktif olduğunda elemente tıkla // Click on element when active
    public static void clickWhenTheElementIsActive(WebDriver driver,By elementBy)
    {
        waitWhileTheElementIsClickable(elementBy);
        clickElement(driver,elementBy);
    }

    // Elemente metin girişi yap // Input text to the element
    public static void writeText(WebDriver driver, By elementBy, String text) {
        waitWhileTheElementIsClickable(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    //Elementin text'ini al // Get the text of the element
    public static String readText(WebDriver driver, By elementBy) {
        waitWhileTheElementIsClickable(elementBy);
        return driver.findElement(elementBy).getText();
    }

    //Bir elementin içerisinde beklenilen text'in olup olmadığı doğrulanır
    //Verifies whether an element contains the expected text
    public static void checkResult(WebDriver driver, By elementBy, String expectedText) {
        waitWhileTheElementIsClickable(elementBy);
        //Assert.assertEquals(readText(driver, elementBy), expectedText);
        try
        {
            Assert.assertTrue("Text Verification", readText(driver, elementBy).contains(expectedText));
            System.out.println("Beğeni başarılı.");
        }
        catch (AssertionError e)
        {
            System.out.println("Beğeni başarısız");
            throw e;
        }

    }


}

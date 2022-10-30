package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

    public static void main(String[] args) {

        //Chrome webdriver projeye eklendi
        // Added Chrome webdriver to the project
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver");
        WebDriver driver = new ChromeDriver();
        Variables variables = new Variables();
        Methods methods = new Methods(driver);

        //baseURL: www.hepsiburada.com sayfası açıldı
        //baseURL: www.hepsiburada.com page opened
        driver.get(variables.baseURL);
        driver.manage().window().maximize();

        //Methodlarda kullanılan değişkenler By tipine çevrildi
        //Variables used in methods are converted to By type
        By cookiesPopUp = By.xpath(variables.cookiesPopUpxPath);
        By cookiesAcceptButton = By.id(variables.acceptCookiesButtonId);
        By searchTextBoxElement = By.className(variables.searchTextBoxClassName);
        By searchButtonElement = By.className(variables.searchButtonClassName);
        By firstProductElement = By.xpath(variables.firstProductxPath);
        By reviewsTabElement = By.xpath(variables.openReviewsTabxPath);
        By likeButtonElement = By.xpath(variables.likeButtonxPath);
        By likeActionResultElement = By.xpath(variables.likeActionResultxPath);

        //Otomatize edilecek tüm işlem adımlarında ilgili elementin hazır olması beklendi
        // Waited for the relevant element to be ready in all processing steps to be automated

        //Websitesi ilk açılışında çerezler pop-up'u beklenildi ve kabul edildi
        //Cookies pop-up waited and accepted when the website is first opened
        Methods.waitWhileTheElementIsClickable(cookiesPopUp);
        Methods.clickWhenTheElementIsActive(driver, cookiesAcceptButton);

        //Arama kutusunun aktif olması beklendi ve arama kelimesi yazıldı
        // Waited for the search box to be active and the search word was typed
        Methods.clickWhenTheElementIsActive(driver, searchTextBoxElement);
        Methods.writeText(driver, searchTextBoxElement, variables.searchText);

        //Arama butonunun aktif olması beklendi ve butona basıldı
        // Waited for the search button to be active and pressed the button
        Methods.clickWhenTheElementIsActive(driver, searchButtonElement);

        //Ürün listesinin gelmesi beklendi ve ilk ürün seçilerek detay sayfası açıldı
        //Waited for the product list to arrive and the first product was selected and the detail page was opened
        Methods.clickWhenTheElementIsActive(driver, firstProductElement);

        //Ürün detay sayfası yeni pencerede açıldığı için yeni pencereye gidildi
        // The new window was opened because the product detail page was opened in a new window
        String winHandleNew = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            winHandleNew = winHandle;
        }
        driver.switchTo().window(winHandleNew);

        //Ürün yorum sekmesinin aktif olması beklendi ve yorumlar sekmesine açıldı
        // Waited for the product comment tab to be active and opened to the comments tab
        Methods.clickWhenTheElementIsActive(driver, reviewsTabElement);

        //Ürün yorum adeti kontrol edildi
        // The number of product comments has been checked
        WebElement reviewCountElement = driver.findElement(By.xpath(variables.openReviewsTabxPath));
        int reviewCount=Methods.GetCommentCount(reviewCountElement.getText());

        //Ürüne daha önce yorum yapılmamış ise otomasyon süreci bitirildi
        // If the product has not been commented before, the automation process has been completed
        if(reviewCount==0)
        {
            System.out.println("Ürüne Hiç Yorum Yapılmamış.");
        }
        else //Ürüne daha önce yorum yapıldı ise // If the product has been commented before
        {
            //Beğeni butonunun aktif olması beklenildi ve beğeni butonuna basıldı
            // Waited for the like button to be active and the like button was pressed
            Methods.clickWhenTheElementIsActive(driver, likeButtonElement);

            //Beğeni işleminin ardından site cevabı beklendi ve beğeni sonucu “Teşekkür Ederiz” yazısı
            //Assert.assertTrue işevi ile teyit edildi

            //After the liking process, the site's response was waited and the "Teşekkür Ederiz" text
            //as a result of the appreciation confirmed with function Assert.assertTrue
            Methods.waitWhileTheElementIsClickable(likeActionResultElement);
            String expectedMessage = "Teşekkür Ederiz.";
            Methods.checkResult(driver, likeActionResultElement,expectedMessage);
        }
        //driver.quit();
    }
}

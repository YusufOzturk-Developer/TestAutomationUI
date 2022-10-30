/*
Otomasyon projesinde kullanılan değişkenler okunulabilirliğin arttırılması,
güncellemelerin  kolay olması  ve  esneklik  sağlanabilmesi  için bu sınıf
içerisinde tanımlanmıştır.
 */

package Automation;
import org.openqa.selenium.WebDriver;

public class Variables {
    public static WebDriver driver;
    public String baseURL="https://www.hepsiburada.com/";
    public String searchText ="iphone";
    public String cookiesPopUpxPath = "//*[@id=\"onetrust-accept-btn-handler\"]";
    public String searchTextBoxClassName="desktopOldAutosuggestTheme-UyU36RyhCTcuRs_sXL9b";
    public String searchButtonClassName="SearchBoxOld-cHxjyU99nxdIaAbGyX7F";
    public String firstProductxPath="//*[@id=\"i0\"]/div/a";
    public String acceptCookiesButtonId="onetrust-accept-btn-handler";
    public String openReviewsTabxPath="//*[@id=\"productReviewsTab\"]";
    public String likeButtonxPath="//*[@id=\"hermes-voltran-comments\"]/div[5]/div[3]/div/div[1]/div[2]/div[4]/div[1]/div/div[1]/div[1]/div";
    public String likeActionResultxPath="//*[@id=\"hermes-voltran-comments\"]/div[5]/div[3]/div/div[1]/div[2]/div[4]/div[2]/span";
}

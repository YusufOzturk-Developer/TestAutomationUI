# TestAutomationUI
www.hepsiburada.com /Hepsiburada Case Study_QA Çalışması / TestAutomationUI

Projede Java programlama dili kullanılarak IntejijIDEA aracı üzerinde geliştirilmiştir.

Projede Selenium, WebDriverElement, junit.Assert kütüphaneleri kullanılmıştır.

Otomasyon Chrome browser üzerinde çalışacak şekilde hazırlanmıştır.

Otomasyon projesinde kullanılan değişkenler okunulabilirliğin arttırılması, güncellemelerin  kolay olması  ve  esneklik  sağlanabilmesi  için 'Variables' sınıfı
içerisinde tanımlanmıştır.

Otomasyon projesinde kullanılan methodlar okunulabilirliğin arttırılması ve  esneklik  sağlanabilmesi  için  'Methods'  sınıfı  içerisinde tanımlanmıştır.

Otomasyon projesinde yapılan işlemler aşağıdaki gibidir;

* Chrome browserı ile www.hepsiburada.com sayfası yüklendi,
* Web sayfasının ilk açılışında çerezlerin kabulu pop-up'ı beklendi ve çerezlere izin verildi,
* Arama motorunda 'iphone' kelimesi ile arama yaptırıldı,
* 'iphone' kelimesi ile yapılan aramanın sonucunda listelenen ürünlerin ilk sırasındaki ürüne tıklandı ve ürün detay sayfası açıldı,
* Ürün detay sayfasında yorumlar tab'ı açıldı,
* Yorumlar tab'ında ürüne yapılan yorumların adeti kontrol edildi,
* Ürüne daha önce hiç yorum yapılmadı ise test senaryosu sonlandırıldı,
* Ürüne daha önce yorum yapılmış ise ilk yapılan yorumun beğeni(Evet) butonuna tıklandı,
* Beğeni butonuna tıklandıktan sonra gelmesi gereken 'Teşekkür ederiz' yazısı kontrol edildi, 

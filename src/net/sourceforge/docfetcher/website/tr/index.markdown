**Note**: You may be interested in [DocFetcher Pro](https://docfetcherpro.com/), the commercial big brother of DocFetcher with more features and fewer bugs.

Açıklama
===========
DocFetcher bir Açık Kaynak masaüstü arama uygulamasıdır: Bilgisayarınızdaki dosyaların içeriğini aramanıza izin verir. &mdash; Yerel dosyalarınız için Google olarak düşünebilirsiniz. Uygulama Windows, Linux ve OS&nbsp;X üzerinde çalışır ve [Eclipse Public License](https://en.wikipedia.org/wiki/Eclipse_Public_License) altında kullanıma sunulur.

Temel Kullanım
===========
Aşağıdaki ekran görüntüsü ana kullanıcı arayüzünü göstermektedir. Sorgular (1) 'deki metin alanına girilir. Arama sonuçları (2) 'deki sonuç bölmesinde görüntülenir. (3) 'deki önizleme bölmesi, sonuç bölmesinde o anda seçili olan dosyanın salt metin önizlemesini gösterir. Dosyadaki tüm eşleşmeler sarı ile vurgulanır.

Sonuçları minimum ve/veya maksimum dosya boyutuna (4), dosya türüne (5) ve konuma (6) göre filtreleyebilirsiniz. (7) 'deki düğmeler sırasıyla kılavuzu açmak, tercihleri açmak ve programı sistem tepsisine küçültmek için kullanılır.

<div id="img" style="text-align: center;"><a href="../all/intro-001-results-edited.png"><img style="width: 500px; height: 375px;" src="../all/intro-001-results-edited.png"></a></div>

DocFetcher, arama yapmak istediğiniz klasörler için sözde *dizinler* oluşturmanızı gerektirir. Dizin oluşturmanın ne olduğu ve nasıl çalıştığı aşağıda daha ayrıntılı olarak açıklanmıştır. Özetle, bir dizin DocFetcher'ın hangi dosyaların belirli bir kelime grubunu içerdiğini çok hızlı bir şekilde (milisaniye sırasına göre) bulmasını ve böylece aramaları büyük ölçüde hızlandırmasını sağlar. Aşağıdaki ekran görüntüsü DocFetcher'ın yeni dizinler oluşturmak için iletişim kutusunu göstermektedir:

<div id="img" style="text-align: center;"><a href="../all/intro-002-config.png"><img style="width: 500px; height: 375px;" src="../all/intro-002-config.png"></a></div>

Bu iletişim kutusunun sağ alt köşesindeki "Çalıştır" düğmesine tıklamak indekslemeyi başlatır. İndeksleme işlemi, indekslenecek dosyaların sayısına ve boyutlarına bağlı olarak biraz zaman alabilir. İyi bir pratik kural, dakikada 200 dosyadır.

Bir dizin oluşturmak zaman alırken, klasör başına yalnızca bir kez yapılmalıdır. Ayrıca, klasör içeriği değiştikten sonra bir dizini *güncellemek*, onu oluşturmaktan çok daha hızlıdır &mdash; genellikle sadece birkaç saniye sürer.

Önemli Özellikler
================
* **Taşınabilir bir sürüm**: DocFetcher'in Windows, Linux *ve* OS&nbsp;X üzerinde çalışan taşınabilir bir sürümü vardır. Bunun nasıl yararlı olduğu, bu sayfada daha ayrıntılı olarak açıklanmaktadır.
* **64 bit desteği**: Hem 32 bit hem de 64 bit işletim sistemleri desteklenir.
* **Unicode desteği**: DocFetcher, Microsoft Office, OpenOffice.org, PDF, HTML, RTF ve düz metin dosyaları dahil tüm ana formatlar için sağlam Unicode desteği ile birlikte gelir.
* **Arşiv desteği**: DocFetcher şu arşiv biçimlerini destekler: zip, 7z, rar ve tüm tar.* ailesi. Zip arşivleri için dosya uzantıları özelleştirilebilir ve gerektiğinde daha fazla zip tabanlı arşiv biçimi eklemenize olanak tanır. Ayrıca, DocFetcher sınırsız sayıda arşivleri yerleştirebilir (örneğin, bir rar arşivi içeren 7z arşivi içeren bir zip arşivi... vb.).
* **Kaynak kodu dosyalarında arama**: DocFetcher'ın düz metin dosyalarını tanıdığı dosya uzantıları özelleştirilebilir, böylece DocFetcher'ı her türlü kaynak kodu ve diğer metin tabanlı dosya formatlarında arama yapmak için kullanabilirsiniz. (Bu, özelleştirilebilir zip uzantılarıyla birlikte oldukça iyi çalışır, örneğin Jar dosyalarının içindeki Java kaynak kodunda arama yapmak için.)
* **Outlook PST dosyaları**: DocFetcher, Microsoft Outlook'un genellikle PST dosyalarında depoladığı Outlook e-postalarının aranmasına izin verir.
* **HTML çiftlerinin tespiti**: Varsayılan olarak DocFetcher, HTML dosyası çiftlerini (ör. "foo.html" adlı bir dosya ve "foo_files" adlı bir klasör) algılar ve çifti tek bir belge olarak ele alır. Bu özellik ilk bakışta oldukça yararsız görünebilir, ancak HTML klasörlerindeki tüm "karmaşa" sonuçlardan kaybolduğu için, HTML dosyalarıyla uğraşırken arama sonuçlarının kalitesini önemli ölçüde artırdığı ortaya çıktı.
* **Düzenli ifade tabanlı dosyaların indeksleme dışında bırakılması**: Belirli dosyaları indekslemeden çıkarmak için düzenli ifadeleri kullanabilirsiniz. Örneğin, Microsoft Excel dosyalarını tarama dışında bırakmak için şuna benzer bir düzenli ifade kullanabilirsiniz: `.*\.xls`
* **Mime türü algılama**: Belirli dosyalar için "mime türü algılamayı" açmak için normal ifadeleri kullanabilirsiniz; bu, DocFetcher'ın yalnızca dosya adına bakarak değil, aynı zamanda dosya içeriğine göz atarak da gerçek dosya türlerini algılamaya çalışacağı anlamına gelir. Bu, yanlış dosya uzantısına sahip dosyalar için kullanışlıdır.
* **Güçlü sorgu sözdizimi**: DocFetcher, "VEYA", "VE" ve "DEĞİL" gibi temel yapılara ek olarak, diğer şeylerin yanı sıra şunları da destekler: Joker karakterler, kelime öbeği araması, bulanık arama ("... ile benzer kelimeleri bul"), yakınlık araması (" Bu iki kelime birbirinden en fazla 10 kelime uzakta olmalıdır "), artırıcı (" ... içeren belgelerin puanını artırın ")

Desteklenen Belge Biçimleri
==========================
* Microsoft Office (doc, xls, ppt)
* Microsoft Office 2007 ve daha yenisi (docx, xlsx, pptx, docm, xlsm, pptm)
* Microsoft Outlook (pst)
* OpenOffice.org (odt, ods, odg, odp, ott, ots, otg, otp)
* Taşınabilir Belge Formatı (pdf)
* EPUB (epub)
* HTML (html, xhtml, ...)
* TXT ve diğer düz metin biçimleri (özelleştirilebilir)
* Zengin Metin Biçimi (rtf)
* AbiWord (abw, abw.gz, zabw)
* Microsoft Derlenmiş HTML Yardımı (chm)
* MP3 Meta Verileri (mp3)
* FLAC Meta Verileri (flac)
* JPEG Exif Meta Verileri (jpg, jpeg)
* Microsoft Visio (vsd)
* Ölçeklenebilir Vektör Grafikleri (svg)

Diğer Masaüstü Arama Uygulamalarıyla Karşılaştırma
===============================================
Diğer masaüstü arama uygulamaları ile karşılaştırıldığında, DocFetcher burada öne çıkıyor:

**Saçmalık içermez**: DocFetcher'in kullanıcı arayüzünü dağınıklıktan ve saçmalıklardan uzak tutmaya çalışıyoruz. Reklam yok veya "kayıt olmak ister misiniz ...?" açılır pencereler. Web tarayıcınıza, kayıt defterinize veya sisteminizin başka bir yerine hiçbir işe yaramaz şey yüklenmez.

**Gizlilik**: DocFetcher, özel verilerinizi toplamaz. Hiç. Bundan şüphe duyan herkes, herkesin erişebileceği [kaynak kodunu](https://docfetcher.sourceforge.net/wiki/doku.php?id=source_code) kontrol edebilir.

**Sonsuza kadar ücretsiz**: DocFetcher Açık Kaynak olduğundan, programın eskimesi ve desteklenmemesi konusunda endişelenmenize gerek yoktur, çünkü kaynak kodu her zaman almak için orada olacaktır. Destekten bahsetmişken, DocFetcher'ın en büyük ticari rakiplerinden biri olan Google Desktop’ın 2011’de kullanımdan kaldırıldığı haberini aldınız mı? İyi...

**Çapraz platform**: Rakiplerinin çoğunun aksine, DocFetcher yalnızca Windows üzerinde değil, aynı zamanda Linux ve OS&nbsp;X üzerinde de çalışmaktadır. Bu nedenle, Windows kutunuzdan Linux veya OS&nbsp;X'e geçmeyi düşünüyorsanız, DocFetcher sizi diğer tarafta bekliyor olacak.

**Taşınabilir**: DocFetcher'in en güçlü yanlarından biri taşınabilir olmasıdır. Temel olarak, DocFetcher ile eksiksiz, tamamen aranabilir bir belge deposu oluşturabilir ve bunu USB sürücünüzde taşıyabilirsiniz. Bundan sonraki bölümde daha fazlası.

**Yalnızca ihtiyacınız olanı indeksleme**: DocFetcher'in ticari rakipleri arasında, kullanıcıları tüm sabit diski indekslemeye itme eğilimi var gibi görünüyor &mdash; belki de sözde "aptal" kullanıcılardan olabildiğince çok karar alma çabasıyla veya daha kötüsü, daha fazla kullanıcı verisi toplama girişimiyle. Pratikte, çoğu insanın tüm sabit disklerinin indekslenmesini *istemediğini* varsaymak güvenli görünüyor: Bu sadece indeksleme zamanı ve disk alanı kaybı değil, aynı zamanda arama sonuçlarını istenmeyen dosyalarla karıştırıyor. Bu nedenle, DocFetcher yalnızca açıkça dizine eklenmesini istediğiniz klasörleri dizine ekler ve bunun da ötesinde çok sayıda filtreleme seçeneği sunulur.

Taşınabilir Belge Havuzları
==============================
DocFetcher'in olağanüstü özelliklerinden biri, *taşınabilir bir belge deposu* oluşturmanıza olanak tanıyan taşınabilir bir sürüm olarak mevcut olmasıdır &mdash; özgürce hareket ettirebileceğiniz tüm önemli belgelerinizin tamamen indekslenmiş ve tamamen aranabilir bir deposu.

**Kullanım örnekleri**: Böyle bir havuzla yapabileceğiniz her türlü şey vardır: Bir USB sürücüsünde yanınızda taşıyabilir, arşivleme amacıyla bir CD-ROM'a yazabilir, şifreli bir birime koyabilirsiniz (önerilen: [TrueCrypt](https://www.truecrypt.org/)), [DropBox](https://www.dropbox.com/) gibi bir bulut depolama hizmeti aracılığıyla birden çok bilgisayar arasında senkronize edin. Daha da iyisi, DocFetcher Açık Kaynak olduğundan, hatta deponuzu yeniden dağıtabilirsiniz: İsterseniz yükleyin ve dünyanın geri kalanıyla paylaşın.

**Java: Performans ve taşınabilirlik**: Bazı kişilerin sorun yaşayabileceği bir özellik, DocFetcher'in "yavaş" olmakla ünlü Java dilinde yazılmış olmasıdır. Bu on yıl önce gerçekten doğruydu, ancak o zamandan beri Java'nın performansı [Wikipedia'ya göre](https://en.wikipedia.org/wiki/Java_%28software_platform%29#Performance). çok gelişme gösterdi. Her neyse, Java ile yazılmanın en güzel yanı, aynı taşınabilir DocFetcher paketinin Windows, Linux *ve* OS&nbsp;X &mdash; diğer birçok program, her platform için ayrı paketler kullanmayı gerektirir. Sonuç olarak, örneğin, taşınabilir belge havuzunuzu bir USB sürücüsüne koyabilir ve ardından bir Java çalıştırma zamanının yüklenmiş olması koşuluyla, bu işletim sistemlerinden *herhangi birinden* buna erişebilirsiniz.

Dizin Oluşturma Nasıl Çalışır?
==================
Bu bölüm, indekslemenin ne olduğu ve nasıl çalıştığı konusunda temel bir anlayış vermeye çalışır.

**Dosya aramaya saf yaklaşım**: Dosya aramaya yönelik en temel yaklaşım, bir arama yapıldığında belirli bir konumdaki her dosyayı tek tek ziyaret etmektir. Bu, *yalnızca dosya adı* araması için yeterince iyi çalışır, çünkü dosya adlarını analiz etmek çok hızlıdır. Bununla birlikte, dosyaların *içeriğini* aramak isteseydiniz o kadar iyi sonuç vermezdi, çünkü tam metin çıkarma, dosya adı analizinden çok daha pahalı bir işlemdir.

**Dizine dayalı arama**: Bu nedenle, bir içerik araştırmacısı olan DocFetcher, *dizinleme* olarak bilinen bir yaklaşımı benimsiyor: Temel fikir, insanların arama yapması gereken dosyaların çoğunun (% 95'ten fazlası gibi) çok seyrek olarak veya hiç değiştirilmemesidir. Bu nedenle, her aramada her dosyada tam metin çıkarma yapmak yerine, tüm dosyalarda yalnızca *bir kez* metin çıkarma gerçekleştirmek ve çıkarılan tüm metinden sözde *dizin* oluşturmak çok daha etkilidir. Bu dizin, dosyaların içerdikleri kelimelere göre hızlı bir şekilde aranmasını sağlayan bir sözlüğe benzer.

**Telefon rehberi benzetimi**: Bir benzetme olarak, diğer taraftaki kişinin numarası olup olmadığını anlamak için *her* olası telefon numarasını aramak yerine bir telefon rehberinde ("dizin") bir kişinin telefon numarasına bakmanın ne kadar verimli olduğunu düşünün. &mdash; Birini telefonla aramak ve bir dosyadan metin çıkarmak "pahalı işlemler" olarak kabul edilebilir. Ayrıca, insanların telefon numaralarını çok sık değiştirmemeleri, bilgisayardaki çoğu dosyanın nadiren değiştirildiği gerçeğine benzer.

**Dizin güncellemeleri**: Elbette bir dizin, dosyaların en son durumunu değil, yalnızca oluşturulduğu andaki dizine alınan dosyaların durumunu yansıtır. Dolayısıyla, dizin güncel tutulmazsa, tıpkı bir telefon rehberinin güncelliğini yitirmesi gibi, güncel olmayan arama sonuçları alabilirsiniz. Ancak, dosyaların çoğunun nadiren değiştirildiğini varsayabilirsek, bu çok da sorun olmamalıdır. Ek olarak, DocFetcher dizinlerini *otomatik olarak* güncelleyebilir: (1) Çalışırken, değişen dosyaları tespit eder ve buna göre dizinlerini günceller. (2) Çalışmadığında, arka planda küçük bir arka plan programı değişiklikleri algılar ve güncellenecek dizinlerin bir listesini tutar; DocFetcher daha sonra bir sonraki başlatılışında bu dizinleri güncelleyecektir. Ve arka plan programı hakkında endişelenmeyin: Hangi klasörlerin değiştiğini belirtmekten başka hiçbir şey yapmadığı ve daha pahalı dizin güncellemelerini DocFetcher'a bıraktığı için gerçekten düşük CPU kullanımı ve bellek ayak izine sahiptir.

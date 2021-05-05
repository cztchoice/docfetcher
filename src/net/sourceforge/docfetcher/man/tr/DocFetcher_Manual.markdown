Giriş
============

DocFetcher bir Açık Kaynak masaüstü arama uygulamasıdır: Bilgisayarınızdaki dosyaların içeriğini aramanıza izin verir. - Yerel dosyalarınız için Google olarak düşünebilirsiniz.

**Dizine dayalı arama**: Doğrudan belgelerde arama yapmak, çok sayıda belge için pratik olmayan bir şekilde yavaş olacağından, DocFetcher, arama yapmak istediğiniz klasörler için *dizinler* oluşturmanızı gerektirir. Bu dizinler, bir kitabın arkasındaki dizini nasıl kullanacağınıza benzer şekilde, DocFetcher'ın dosyaları anahtar kelimeye göre hızlı bir şekilde aramasına olanak tanır. Bir dizin oluşturmak, dizinlenen dosyaların sayısına ve boyutlarına bağlı olarak biraz zaman alabilir. Ancak, bunun her klasör için yalnızca bir kez yapılması gerekir; daha sonra dizinli klasörlerde istediğiniz kadar arama yapabilirsiniz.

**Bir dizin oluşturma**: Bir dizin oluşturmak için, soldaki `Arama Kapsamı` alanına sağ tıklayın ve `Dizin Oluştur > Klasör` ü seçin. Şimdi dizine eklenecek bir klasör seçin. Yeni başlayanlar için, bu, içinde çok fazla dosya olmayan, 50 gibi küçük bir dosya olmalı mı? Klasörü seçtikten sonra bir yapılandırma penceresi açılır. Varsayılan yapılandırma yeterli olmalıdır, bu nedenle sadece `Çalıştır` düğmesine tıklayın ve DocFetcher belgeleri dizinlemeyi bitirene kadar bekleyin. (Bir dizin oluşturmanın alternatif bir yolu, panodan bir dizini `Arama Kapsamı` alanına yapıştırmaktır. Ancak bu, PST dosyaları için değil, yalnızca sıradan dizinler için işe yarar.)

**Arama**: Sonuç bölmesinin yukarısındaki metin alanına (sütun başlıklarının bulunduğu tablo) aranacak bir veya daha fazla sözcük girin ve `Enter` tuşuna basın. Arama sonuçları, azalan puana göre sıralanmış olarak sonuç bölmesinde görüntülenecektir.

*Bu kılavuzu DocFetcher içinde okuyorsanız, bir sonraki paragraftaki talimatları izleyerek kılavuzu ortadan kaldıracaktır. Geri yüklemek için sağ üstteki `'?'` düğmesine tıklayın. Kılavuzu, doğrudan bu bölmenin yukarısındaki `Harici tarayıcıda aç` düğmesine tıklayarak varsayılan web tarayıcınızda da açabilirsiniz.*

**Sonuç bölmesi ve önizleme bölmesi**: Sonuç bölmesinin altında (veya mevcut GUI düzenine bağlı olarak sağında) önizleme bölmesini bulabilirsiniz. Sonuç bölmesinde bir dosya seçerseniz, önizleme bölmesi dosya içeriğinin salt metin önizlemesini gösterecektir. Önemli özellikler:

* ***Vurgulama***: Varsayılan olarak, girdiğiniz arama terimleri vurgulanır ve yukarı ve aşağı düğmelerini kullanarak bir oluşumdan öncekine veya sonrakine atlayabilirsiniz.
* ***Yerleşik web tarayıcısı***: HTML dosyaları olması durumunda, salt metin görünümü ile basit bir yerleşik web tarayıcısı arasında geçiş yapabilirsiniz. (Not: İkincisi, bazı Linux varyantlarında mevcut değildir.)

Yararlı bulabileceğiniz bir kısayol: Odağı arama alanına geri taşımak için `Ctrl+F` veya `Alt+F` tuşlarına basın. Harici bir programda bir dosya açmak için sonuç bölmesinde dosyaya çift tıklayın.

**Sıralama**: Sonuç bölmesinin sütun başlıklarından herhangi birine tıklayarak sonuçların sıralamasını değiştirebilirsiniz. Örneğin, sonuçları dosya adına göre sıralamak için `Dosya adı` başlığına tıklayın. Aynı başlığın iki kez tıklanması, karşılık gelen kritere göre ters sırada sıralanacaktır. Sütunların sırasını sürükle ve bırak yöntemiyle de değiştirebilirsiniz: Örneğin, `Dosya adı` nın ilk sütun olmasını istiyorsanız, `Dosya adı` sütun başlığını sola sürüklemeniz yeterlidir.

**Filtreleme**: GUI'nin solunda, sonuçları filtrelemek için çeşitli kontroller görebilirsiniz: (1) `Minimum / Maksimum Dosya Boyutu` kontrolünde minimum ve/veya maksimum dosya boyutu belirtebilirsiniz. (2) `Belge Türleri` listesi, sonuçları türe göre filtrelemenize olanak tanır. (3) `Arama Kapsamı` alanındaki öğelerin işaretini kaldırarak sonuçları konuma göre filtreleyebilirsiniz.

**Dizin güncellemeleri**: Dizine alınmış klasörlerdeki dosyalar eklenir, kaldırılır veya değiştirilirse, ilgili dizinlerin güncellenmesi gerekir, aksi takdirde arama sonuçlarınız güncel olmayabilir. Neyse ki, bir dizini güncellemek, onu sıfırdan oluşturmaktan hemen hemen her zaman çok daha hızlıdır, çünkü yalnızca değişikliklerin işlenmesi gerekir. Ayrıca DocFetcher dizinlerini iki şekilde otomatik olarak güncelleyebilir:

1. ***DocFetcher'ın kendisi***: DocFetcher çalışıyorsa ve değiştirilen klasör için *klasör izleme* etkinleştirildiyse, DocFetcher değişiklikleri hemen algılar ve dizinlerini günceller.
2. ***DocFetcher artalan süreci***: DocFetcher çalışmıyorsa, değişiklikler arka planda çalışan küçük bir arka plan programı tarafından kaydedilir; etkilenen dizinler daha sonra DocFetcher'ın bir sonraki başlatılışında güncellenecektir. (Not: Arka plan programı maalesef şu anda Mac OS&nbsp;X'te kullanılamamaktadır.)

Bazı uyarılar: DocFetcher'in taşınabilir sürümünü kullanıyorsanız ve arka plan programının çalıştırılmasını istiyorsanız, işletim sisteminizin başlangıç programları listesine çalıştırılabilir arka plan programı ekleyerek onu manuel olarak yüklemelisiniz. Ayrıca, ne DocFetcher ne de arka plan programı ağ paylaşımlarındaki değişiklikleri algılayamaz.<!-- bu satır iki boşlukla bitmelidir -->  
Bu nedenle, dizinlerin otomatik olarak güncellenemediği durumlarda, bunu kendiniz yapmanız gerekir: `Arama Kapsamı` alanında, güncellenecek bir veya daha fazla dizin seçin, ardından ya da `Dizini Güncelle` ye tıklayın. `Arama Kapsamı` bağlam menüsüne veya `F5` tuşuna basın.

* * *

<a name="Advanced_Usage"></a> <!-- Bu satırı çevirmeyin, aynen kopyalayın. -->

Gelişmiş Kullanım
==============

**Sorgu sözdizimi**: DocFetcher ile basit kelime aramasından çok daha fazlasını yapabilirsiniz. Örneğin, ortak bir başlangıca sahip kelimeleri aramak için joker karakterleri kullanabilirsiniz, örneğin: `wiki*`. Belirli bir kelime öbeğini (yani belirli bir sıradaki bir dizi kelime) aramak için, kelime öbeğini tırnak işaretleri arasına alın: `"hızlı kahverengi tilki"`. Ama bu ancak başlangıç. Desteklenen tüm yapılara genel bir bakış için, [sorgu sözdizimi bölümüne](DocFetcher_Manual_files/Query_Syntax.html) bakın.

**Tercihler**: Kullanıcı arayüzünün sağ üst tarafında, iki dişli çarkı gösteren bir simge bulacaksınız. Tercihler iletişim kutusunu açmak için üzerine tıklayın. Daha gelişmiş kullanım için ek ayarlara Tercihler iletişim kutusunun sol alt kısmındaki "Gelişmiş Ayarlar" bağlantısından erişilebilir.

**Taşınabilir belge deposu**: DocFetcher'ın taşınabilir sürümü, DocFetcher'ı, belgelerinizi ve ilişkili dizinleri içeren bir paket oluşturmanıza ve ardından bu paketi serbestçe hareket ettirmenize olanak tanır &mdash; bir işletim sisteminden diğerine bile, ör. Windows'tan Linux'a ve tersi. Taşınabilir sürümü kullanırken akılda tutulması gereken önemli bir nokta, dizinlerin *göreceli yollarla* oluşturulması gerektiğidir. Taşınabilir belge havuzları hakkında daha fazla bilgi için [burayı](DocFetcher_Manual_files/Portable_Repositories.html) tıklayın. Bu arada, DocFetcher 1.0.3 ve önceki sürümlerini kullanıyorsanız, artık belgelerinizi DocFetcher klasörüne koymanız gerekmediğini unutmayın.

**Dizin oluşturma yapılandırma seçenekleri**: Dizin oluşturma yapılandırma penceresindeki tüm bu seçeneklerin ayrıntılı bir tartışması için, [buraya](DocFetcher_Manual_files/Indexing_Options.html) tıklayın. Bu kılavuz sayfasına, pencerenin altındaki `Yardım` düğmesine tıklayarak doğrudan yapılandırma penceresinden de ulaşabilirsiniz. Belki de en ilginç yapılandırma seçenekleri şunlardır:

* ***Özelleştirilebilir dosya uzantıları***: Düz metin dosyaları ve zip arşivleri için dosya uzantıları tamamen özelleştirilebilir. Bu, özellikle kaynak kod dosyalarını indekslemek için kullanışlıdır.
* ***Dosya dışlama***: Normal ifadelere dayalı olarak belirli dosyaları indekslemenin dışında bırakabilirsiniz.
* ***Mime türü algılama***: Mime türü algılaması olmadan DocFetcher, dosya türünü belirlemek için yalnızca bir dosyanın uzantısına (ör. `'.doc'`) bakacaktır. Mime türü algılama ile DocFetcher daha iyi bir tür bilgisi bulup bulamayacağını görmek için dosyanın içeriğine de göz atacaktır. Bu, dosya uzantısını kontrol etmekten daha yavaştır, ancak yanlış dosya uzantısına sahip dosyalar için kullanışlıdır.
* ***HTML eşleştirme***: Varsayılan olarak, DocFetcher bir HTML dosyasını ve ilişkili klasörünü (örneğin bir `foo.html` ve bir `foo_files` klasörü) tek bir belge olarak ele alır. Bunun temel amacı, HTML klasörleri içindeki tüm "karmaşayı" arama sonuçlarından kaldırmaktır.

**Düzenli ifadeler**: Hem dosya dışlama hem de mime türü algılama sözde *düzenli ifadelere* dayanır. Bunlar, DocFetcher'in dosya adları veya dosya yollarıyla eşleştireceği kullanıcı tanımlı kalıplardır. Örneğin, "journal" kelimesiyle başlayan tüm dosyaları tarama dışında bırakmak için şu düzenli ifadeyi kullanabilirsiniz: `journal.*` Bunun DocFetcher'ın sorgu sözdiziminden biraz farklı olduğuna dikkat edin, burada nokta: `journal*` atlanır. Düzenli ifadeler hakkında daha fazla bilgi edinmek istiyorsanız, bu [kısa girişi](DocFetcher_Manual_files/Regular_Expressions.html) okuyun.

**Yayın bildirimi**: DocFetcher, güncellemeleri otomatik olarak kontrol etmez (ve bunu yapmamalı mı?). Yeni sürümlerden haberdar edilmek *istiyorsanız*, bunu ayarlamanın [birkaç yolu](DocFetcher_Manual_files/Release_Notification.html) vardır.

* * *

<a name="Caveats"></a> <!-- Bu satırı çevirmeyin, aynen kopyalayın. -->

Uyarılar ve Yaygın Gotchalar
==========================

**Bellek sınırını yükseltme**: DocFetcher, tüm Java programları gibi, kullanmasına izin verilen bellek miktarı konusunda *Java yığın boyutu* olarak bilinen sabit bir sınıra sahiptir. Bu bellek sınırı başlangıçta ayarlanmalıdır ve DocFetcher şu anda 256&nbsp;MB varsayılan değer seçmektedir. Çok, çok fazla sayıda dosyayı dizinlemeye çalışırsanız ve/veya dizinlenen dosyalardan bazıları gerçekten çok büyükse (bu, PDF dosyalarında nadir değildir), DocFetcher'ın bu bellek sınırına ulaşma ihtimali vardır. Böyle bir durumda, [bellek sınırını yükseltmek](DocFetcher_Manual_files/Memory_Limit.html) isteyebilirsiniz.

**Sistem klasörlerini dizine eklemeyin**: Diğer masaüstü arama uygulamalarının aksine, DocFetcher `C:` veya `C:\Windows` gibi sistem klasörlerini dizinlemek için tasarlanmamıştır. Bunu yapmak, aşağıdaki nedenlerden ötürü önerilmez

1. ***Yavaşlama***: Sistem klasörlerindeki dosyalar çok sık değiştirilme eğilimindedir. Klasör izleme açıksa, bu DocFetcher'ın dizinlerini her zaman güncellemesine ve bilgisayarınızı yavaşlatmasına neden olur.
2. ***Bellek sorunları***: DocFetcher'ın dosyalarınızın küçük temsillerini bellekte tutması gerekir. Bu nedenle ve sistem klasörleri genellikle çok fazla sayıda dosya içerdiğinden, DocFetcher'in sistem klasörlerini dizinlerseniz belleğin bitmesi daha olasıdır.
3. ***Kaynak israfı, daha kötü arama sonuçları***: Bu teknik nedenlerin dışında, sistem klasörlerinin dizinlenmesi büyük olasılıkla dizinleme zamanı ve disk alanı israfıdır ve ayrıca arama sonuçlarınızı gereksiz sistem dosyalarıyla kirletecektir. Bu nedenle, en kısa sürede en iyi sonuçları elde etmek için ihtiyacınız olanı dizine eklemeniz yeterli.

**Unicode desteği**: DocFetcher, tüm belge formatları için tam Unicode desteğine sahiptir. Düz metin dosyaları söz konusu olduğunda, DocFetcher, düz metin dosyaları içermediğinden doğru kodlamayı tahmin etmek için [belirli buluşsal yöntemler](http://www-archive.mozilla.org/projects/intl/UniversalCharsetDetection.html) kullanmak zorundadır.

**Arşiv desteği**: DocFetcher şu anda aşağıdaki arşiv biçimlerini desteklemektedir: zip ve türetilmiş biçimler, 7z, rar ve tüm tar.* ailesi. Ek olarak, yürütülebilir zip ve 7z arşivleri de desteklenir, ancak yürütülebilir rar arşivleri desteklenmez. DocFetcher tüm arşivlere sıradan klasörlermiş gibi davranır ve arşivlerin keyfi olarak derinlemesine yerleştirilmesini de işleyebilir (örneğin, bir rar arşivi içeren 7z arşivi içeren bir zip arşivi...).<!-- bu satır iki boşlukla bitmelidir -->  
Bununla birlikte, zip ve 7z arşivleri için desteğin sağlamlık ve hız açısından en iyisi olduğuna dikkat edilmelidir. Öte yandan, tar.gz, tar.bz2 ve benzeri formatların indekslenmesi daha az verimli olma eğilimindedir. Bunun nedeni, bu formatların arşiv içeriğinin dahili bir "özetine" sahip olmamasıdır, bu da DocFetcher'ı yalnızca tek tek arşiv girişleri yerine tüm arşivi açmaya zorlar. Alt satır: Seçeneğiniz varsa, DocFetcher ile maksimum uyumluluk için dosyalarınızı zip veya 7z arşivleri olarak sıkıştırın.

**DocFetcher artalan süreci masumdur**: DocFetcher arka plan programının bilgisayarınızı yavaşlattığından veya çökmelere neden olduğundan şüpheleniyorsanız, muhtemelen yanılıyorsunuz. Nitekim, arka plan programı, düşük bellek ayak izi ve CPU kullanımı ile çok basit bir programdır ve klasörleri izlemekten başka pek bir şey yapmaz. Hala ikna olmadıysanız, arka plan programı yürütülebilir dosyalarını yeniden adlandırın, böylece otomatik olarak başlamazlar ya da arka plan programının varsayılan olarak devre dışı bırakıldığı DocFetcher taşınabilir sürümünü deneyin.

* * *

<a name="Subpages"></a> <!-- Bu satırı çevirmeyin, aynen kopyalayın. -->

Kılavuz Alt Sayfalar
===============
* [Sorgu sözdizimi](DocFetcher_Manual_files/Query_Syntax.html)
* [Taşınabilir belge havuzları](DocFetcher_Manual_files/Portable_Repositories.html)
* [İndeksleme seçenekleri](DocFetcher_Manual_files/Indexing_Options.html)
* [Düzenli ifadeler](DocFetcher_Manual_files/Regular_Expressions.html)
* [Yayın bildirimi](DocFetcher_Manual_files/Release_Notification.html)
* [Bellek sınırı nasıl yükseltilir](DocFetcher_Manual_files/Memory_Limit.html)
* [Klasör izleme sınırı nasıl yükseltilir (Linux)](DocFetcher_Manual_files/Watch_Limit.html)
* [Tercihler](DocFetcher_Manual_files/Preferences.html)

Daha Fazla Bilgi
===================
Daha fazla bilgi için, bu sayfamıza bakın [wiki](http://docfetcher.sourceforge.net/wiki/doku.php). Herhangi bir sorunuz varsa, [forumumuzu](http://sourceforge.net/projects/docfetcher/forums/forum/702424). ziyaret etmekten çekinmeyin. Hata raporları [hata izleyicimizden](http://sourceforge.net/tracker/?group_id=197779&atid=962834) gönderilebilir.
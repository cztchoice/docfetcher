Temel Fikir: Dizin Oluşturma Görevlerinin Sırası
=====================================
Dizin oluşturma yapılandırma penceresi, her biri oluşturulacak veya güncellenecek bir dizini temsil eden bir veya daha fazla sekmeden oluşur. Tüm sekmeler birlikte, öğeleri birer birer işlenen bir görev kuyruğu oluşturur. Sağ üstteki `'+'` düğmesiyle kuyruğa daha fazla görev ekleyebilirsiniz.

Her sekmenin sağ alt tarafında bir `Çalıştır` düğmesi vardır. Tıklayarak, görevin doğru şekilde yapılandırıldığını ve indekslemeye hazır olduğunu onaylarsınız. Kuyrukta bir hazır görev olduğu anda indeksleme başlar.

`'+'` Düğmesinin sağında başka bir düğme var. Buna tıklamak, tüm konfigürasyon penceresini DocFetcher'ın durum çubuğuna küçültecektir. Bu, arka planda yenilerini oluştururken mevcut dizinler üzerinde arama yapmanızı sağlar.

Herhangi bir görevi, sekmesinin kapat düğmesine (`'x'`) tıklayarak iptal edebilirsiniz. Bir görev iptal edildiğinde, kısmen oluşturulan dizini tutma veya atma seçeneği sunulur. Önemli olan, dizinlemeyi herhangi bir noktada durdurup daha sonra devam ettirebilmenizdir. Sürdürme, kısmi dizinde, `Arama Kapsamı` alanının içerik menüsünden `Dizini Güncelle` aracılığıyla bir dizin güncellemesi çalıştırılarak yapılır.

Yapılandırma penceresinin kendisinde de bir kapatma düğmesi vardır (Windows'ta bu, sağ üstteki `'x'` düğmesidir). Üzerine tıklarsanız, tüm indeksleme görevleri iptal edilecek ve kuyruktan kaldırılacaktır.

Dizin Oluşturma Seçenekleri
================
Not: Bu bölüm, klasör ve arşiv dizinleri için mevcut dizinleme seçeneklerine odaklanmaktadır. Outlook PST dizinlerinin seçenekleri için aşağıdaki 'Çeşitli' tablosundaki ilgili girişlere bakın.

Dosya Uzantıları
---------------
'Dosya uzantıları' denetimi, hangi dosyaların düz metin dosyaları veya zip arşivleri olarak ele alınacağını belirlemenize olanak tanır. Yaygın bir kullanım senaryosu, DocFetcher'ın belirli türdeki kaynak kodu dosyalarını dizinlemesidir. Sağdaki iki `'...'` düğmesine dikkat edin. Bunlara tıklarsanız, DocFetcher dizine eklenecek klasörde dolaşacak ve tüm dosya uzantılarını, aralarından seçim yapabileceğiniz bir listede toplayacaktır.

Dosyaları Hariç Tut / Mime Türünü Algıla
--------------------------------
Tabloya öğeler ekleyerek (1) belirli dosyaları indekslemenin dışında bırakabilir ve (2) belirli dosyalar için mime türü algılamayı etkinleştirebilirsiniz. Bunların tümü normal ifadelere (regexes) dayanmaktadır, bu nedenle bunları nasıl kullanacağınızı bilmiyorsanız, [normal ifadelere giriş](Regular_Expressions.html) bölümünü okuyun.

Şimdi, tablonun çalışma şekli şöyledir: Tablodaki her öğe, ilişkili bir eylemi olan bir düzenli ifadedir. Düzenli ifade, dosya adlarıyla veya dosya yollarıyla eşleştirilebilir ve eylem, "dosyayı dışla" veya "mime türünü algıla" dır. İndeksleme sırasında, bir dosya bir düzenli ifadeyle eşleştirildiğinde, düzenli ifadenin eylemi dosyaya uygulanır.

Sağ taraftaki `'+'` ve `'-'` butonları ile tabloya madde ekleyebilir ve tablodan madde çıkartabilirsiniz. Yukarı ve aşağı düğmeleri, seçili tablo öğesinin *önceliğini* artırmanıza veya azaltmanıza olanak tanır. Bir dosya tablodaki birden fazla düzenli ifadeyle eşleştirildiğinde öncelik önemli hale gelir; bu durumda en yüksek önceliğe sahip düzenli ifade kazanır ve diğerlerinin tümü yok sayılır.

Tablonun hemen altında, düzenli ifadeler yazmanıza yardımcı olacak küçük bir araç var: İndekslenecek klasörden belirli bir dosya seçmek için sağdaki `'...'` düğmesine tıklayın. Bu dosyanın dosya yolu metin alanında görünecektir. Ardından, metin alanının üstündeki metin satırı, tabloda o anda seçili olan düzenli ifadenin seçilen dosyayla eşleşip eşleşmediğini size söyleyecektir.

Çeşitli
-------------
Seçenek | Yorum
-------|--------
HTML eşleştirme  |  HTML dosyalarının ve ilişkili klasörlerinin (örneğin bir "foo.html" dosyası ve "foo_files" klasörü) tek bir belge olarak değerlendirilip değerlendirilmeyeceği.
Yürütülebilir zip ve 7z arşivlerini algılama (daha yavaş)  |  Etkinleştirilirse, DocFetcher, yürütülebilir bir zip veya 7z arşivi olup olmadığını `exe` uzantısına sahip *her* dosyayı kontrol edecektir.
Dosya içeriği ayıklanamasa bile dizin dosya adı  |  Etkinleştirilirse, DocFetcher herhangi bir dosya içeriğinin çıkarılıp çıkarılamayacağına bakılmaksızın *tüm* dosyaları dizinine dahil edecektir. Tam dosya adı araması için bunu etkinleştirin. Ancak DocFetcher'ın dizinlenen klasördeki dosya sayısına bağlı olarak çok daha fazla bellek kaplayabileceğini unutmayın. Belleğinizin bitmesi durumunda, [bellek sınırını artırabilirsiniz](Memory_Limit.html).
Mümkünse göreceli yolları saklayın (taşınabilirlik için)  |  DocFetcher'in taşınabilir sürümünü kullanıyorsanız bu ayar önemlidir. Bununla ilgili daha fazla bilgiyi [taşınabilir belge havuzları](Portable_Repositories.html) sayfasında okuyabilirsiniz.
Dosya değişiklikleri için klasörleri izleyin  |  DocFetcher'in indekslenmiş klasörlerdeki değişiklikleri tespit edip etmeyeceği ve buna göre indekslerini güncellemesinin gerekip gerekmediği. Bu ayar DocFetcher artalan sürecini etkilemez.
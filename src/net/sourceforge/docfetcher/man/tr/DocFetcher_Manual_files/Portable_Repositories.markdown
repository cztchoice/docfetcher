Taşınabilir Belge Havuzları
==============================

Temel kullanım
-----------
DocFetcher'ın taşınabilir sürümü, esasen tamamen indekslenmiş ve tamamen aranabilir bir belge havuzunu taşımanıza (ve hatta yeniden dağıtmanıza) izin verir. Henüz taşınabilir sürüme sahip değilseniz, [proje web sitesinden] (http://docfetcher.sourceforge.net) indirebilirsiniz.

Taşınabilir sürüm herhangi bir kurulum gerektirmez; arşivin içeriğini seçtiğiniz bir klasöre çıkarmanız yeterlidir. Daha sonra DocFetcher'ı işletim sisteminiz için uygun başlatıcı aracılığıyla başlatabilirsiniz: Windows'ta `DocFetcher.exe` Linux'ta `DocFetcher.sh` ve Mac OS&nbsp;X'te `DocFetcher` uygulama paketi. Tek gereksinim, makineye bir Java çalışma zamanının, sürüm 1.6 veya daha yeni bir sürümün yüklenmesi gerektiğidir.

<u>Göreceli yollar</u>: Dikkat edilmesi gereken önemli bir nokta, tüm dizinlerin *göreceli yollar* ayarı açık olarak oluşturulması gerektiğidir. Bu olmadan, DocFetcher dosyalarınıza *mutlak* referanslar kaydeder, böylece yalnızca DocFetcher'ı ve dizinlerini taşıyabilirsiniz, ancak dosyalarınızı taşıyamazsınız &mdash; en azından referansları bozmadan. İşte bunu açıklamak için bir örnek:

* Göreceli yol: `..\..\dosyalarım\bazı-belge.txt`
* Mutlak yol: `C:\dosyalarım\bazı-belge.txt`

Göreceli yol temelde DocFetcher'a şu anki konumundan iki seviye yukarı giderek `dosyalarım` klasörüne giderek `bazı-belge.txt` bulabileceğini söyler. Öte yandan, mutlak yol sabit bir referanstır ve DocFetcher'ın mevcut konumundan bağımsızdır, bu nedenle referansı bozmadan `bazı-belge.txt` i taşıyamazsınız (yani DocFetcher dosyayı bulamaz).

DocFetcher'ın yalnızca göreceli yolları depolamaya *çalışabileceğini* unutmayın: Açıkçası, DocFetcher'ı ve dosyalarınızı farklı birimlere koyarsanız, bunu yapamaz, örn. `D:\DocFetcher` içindeki DocFetcher ve `E:\dosyalarım` içindeki dosyalarınız.

Kullanılabilirlik ipuçları
--------------

* ***CD-ROM arşivleme***: Sağduyu, ama yine de: DocFetcher'ı bir CD-ROM'a koyarsanız, tercihlerdeki veya dizinlerdeki değişiklikleri kaydedemezsiniz, bu yüzden CD-ROM'a yazmadan önce her şeyi düzgün bir şekilde yapılandırmayı unutmayın. Ayrıca, bir Java çalışma zamanı yükleyicisi eklemek isteyebilirsiniz.
* ***Farklı program başlıkları***: Taşınabilir belge havuzunuzun yeniden dağıtılması veya birden çok DocFetcher örneğiyle çalışmayı daha az kafa karıştırıcı hale getirmek için, her DocFetcher örneğine farklı bir program penceresi başlığı verebilirsiniz. Bunu yapmak için, tercihler iletişim kutusundaki `Gelişmiş Ayarlar` ı açın ve `UygulamaAdı` ayarını değiştirin.

Uyarılar
--------

* ***`Dizinler` klasörüne dokunmayın***: Dosyalarınızı doğrudan DocFetcher klasörüne koyabilirsiniz, ancak gerekli değildir. Bunu yaparsanız, `dizinler` klasörünü rahat bırakın, çünkü içine koyduğunuz her şey silinebilir!
* ***Dosya adı uyumsuzlukları***: Farklı işletim sistemleri arasındaki dosya adı uyumsuzluklarına dikkat edin. Örneğin, Linux'ta dosya adları ":" veya "|", gibi karakterler içerebilir, ancak Windows'ta yapamazlar. Sonuç olarak, bir belge havuzunu yalnızca uyumsuz dosya adlarına sahip belgeler içermiyorsa Linux'tan Windows'a veya ters yönde taşıyabilirsiniz. Oh, ve Alman umlautları gibi özel karakterler tamamen farklı bir konu...
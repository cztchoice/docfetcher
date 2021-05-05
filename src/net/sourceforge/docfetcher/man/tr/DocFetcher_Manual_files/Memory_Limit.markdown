Bellek sınırı nasıl yükseltilir
=============================
DocFetcher, başlangıçta belirlenen 256&nbsp;MB'lık bir varsayılan bellek sınırına sahiptir. Platforma özel rampalarla oynayarak bu sınır yükseltilebilir:

Windows
-------
DocFetcher'in Windows sürümü, farklı yığın boyutları ayarlayan hazır alternatif başlatıcılarla birlikte gelir. Bunları kullanmak için şu adımları izleyin:

* DocFetcher klasörünü açın. DocFetcher'ın taşınabilir sürümünü kullanıyorsanız, bu yalnızca indirdiğiniz ve paketini açtığınız klasördür. Taşınabilir olmayan sürümü kullanıyorsanız, DocFetcher klasörü `C:\Program Files`, veya `C:\Program Files (x86)`, veya benzer bir konumda olacaktır.
* Alternatif başlatıcılar, `DocFetcher\misc` klasörünün içindedir. Bunlar, `DocFetcher-XXX.exe`, olarak adlandırılır ve burada `XXX`, ilgili başlatıcı tarafından ayarlanan yığın boyutudur. Örneğin, `DocFetcher-512.exe` başlatıcısı 512&nbsp;MB'lık bir yığın boyutu ayarlayacaktır.
* Bu başlatıcılardan herhangi birini kullanmadan önce, **onu DocFetcher klasörüne taşımanız veya kopyalamanız gerekir**. Varsayılan başlatıcıyı silmek veya alternatif başlatıcıyı yeniden adlandırmak gerekmez.

Bellek sınırını değiştirmenin başka bir yolu, `misc\DocFetcher.bat` dosyasını DocFetcher klasörüne kopyalamak ve dosyanın son satırındaki `-Xmx256m` ifadesini, örneğin `-Xmx512m` olarak değiştirmektir.

Linux
-----
Bir metin düzenleyiciyle `DocFetcher/DocFetcher.sh` başlatıcı komut dosyasını açın ve son satırda, gerektiği gibi `-Xmx256m` ifadesini, örneğin `-Xmx512m` olarak değiştirin.

Mac OS&nbsp;X
-------------
Hem taşınabilir olmayan hem de taşınabilir sürümde, DocFetcher bir uygulama paketi aracılığıyla başlatılır. Taşınabilir olmayan sürümde, uygulama paketi, indirilen disk görüntüsünden aldığınız şeydir. Taşınabilir sürümde, uygulama paketi DocFetcher klasöründe bulunabilir.

Her iki durumda da, uygulama paketi aslında `.app`. uzantısına sahip bir klasördür. Bu klasörü açmak için Finder'da bir bağlam menüsü girişi olmalıdır. Mac OS&nbsp;X diliniz İngilizce ise, bu menü girişi `Show Package Contents` olarak adlandırılacaktır.

Klasörün içinde şu başlatıcı komut dosyasını bulacaksınız: `Contents/MacOS/DocFetcher`. Bir metin düzenleyiciyle açın ve son satırda, `-Xmx256m` ifadesini gerektiği gibi değiştirin, örneğin `-Xmx512m` olarak değiştirin.
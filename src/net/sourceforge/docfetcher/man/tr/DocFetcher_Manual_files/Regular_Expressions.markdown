Düzenli İfadeler
===================
Bu sayfa, düzenli ifadelere çok kısa bir giriş niteliğindedir. Düzenli ifadeler temelde bütün bir kalıp eşleştirme dilini temsil ettiğinden, hiçbir şekilde kapsamlı değildir. Daha derine inmek isterseniz, internette bununla ilgili bir ton bilgi bulabilirsiniz; sadece 'düzenli ifade eğitimi' veya 'düzenli ifade girişi' veya bunun gibi bir şey arayın.

Tüm Microsoft Excel dosyalarıyla eşleşiyor: `.*\.xlsx?`
-----------------------------------------------
Düzenli ifadelerde (genellikle "regex" olarak kısaltılır), belirli karakterlerin özel bir anlamı vardır. Örneğin, ***nokta*** (`'.'`) Tam olarak bir bilinmeyen karakter anlamına gelir. Dolayısıyla, örneğin, `hallo` veya `hello` gibi dizelerle eşleştirmek için `h.llo` düzenli ifadesini, aynı zamanda `hzllo` veya `h8llo` ifadesini kullanabilirsiniz.

Diğer bir özel karakter, "sıfır veya daha fazla kez tekrarlanan önceki karakter" anlamına gelen ***yıldız işaretidir*** (`'*'`). Dolayısıyla, `hello*` düzenli ifadesini girerseniz, şu dizeler eşleşir: `hell`, `hello`, `helloo`, `hellooo`, vb.

Bu kuralların bir sonucu olarak, nokta ve yıldız işareti bir araya getirilirse, rastgele bir karakter dizisiyle eşleşeceklerdir. Örneğin, `gen.*ion` düzenli ifadeyle eşleşir: `genion`, `generalization`, `generation`, `gentrification`, vb.

Yıldız işaretine benzer özel bir karakter, "önceki karakter, sıfır kez veya tam olarak bir kez" anlamına gelen ***soru işaretidir*** (`'?'`). Ayrıca, "önceki karakter orada olabilir veya olmayabilir" şeklinde yeniden ifade edebilirsiniz. Yıldız işareti gibi, bir nokta ile birleştirilebilir. Bu nedenle, `hell.?` düzenli ifadesi şu şekilde eşleşir: `hell`, `hello`, `hells`, `hell4`, vb.

Nokta ve yıldız işareti gibi karakterlerin özel bir anlamı olduğundan, onları *tam anlamıyla* eşleştirmek istiyorsanız, onlardan *kaçmanız* gerekir. Bu, onlardan önce başka bir özel karakter olan ***ters eğik çizgi*** (`'\'`) ile yapılır. Ters eğik çizginin gerekli olduğu tipik bir durum, bir dosya adındaki noktayla eşleştirmektir. Örneğin, tüm dosyaları `license.txt` dosya adıyla eşleştirmek için, yalnızca `license\.txt` yerine `license.txt` &mdash; düzenli ifadesini kullanmanız gerekir, ikincisi, örneğin, `license-txt` ile de eşleşir.

Tüm bunları bir araya getirirsek, tüm Microsoft Excel dosyalarıyla eşleşen bir düzenli ifade yazabiliriz, örneğin: `.*\.xlsx?`. Bu düzenli ifade temelde şunu söyler: Keyfi bir karakter dizisi, ardından bir gerçek nokta, ardından "xls", ve sonunda isteğe bağlı bir "x" vardır.

Bir basamak dizisiyle eşleştirme: `journal\d+\.doc`
------------------------------------------------
"journal" ile başlayan ve bir zaman damgasıyla biten tüm Microsoft Word dosyalarını şu şekilde eşleştirmek istediğinizi varsayalım: "journal2007.doc". Dahası, *istemediğiniz şey* "journalism.doc" gibi dosyalarla eşleşmektir.

`journal.*\.doc` gibi bir düzenli ifade burada çalışmaz çünkü "journalism.doc" ile de eşleşir. Çözüme giden ilk adım, noktayı `[0-9]` veya `\d` ile değiştirmektir, her ikisi de tam olarak ***bir rakamla***eşleşir. `[0-9]` ifadesi aslında `\d` den daha genel bir gösterimdir, çünkü örneğin `4`, `5` ve `6` rakamlarını eşleştirmek için `[4-6]` yazabilirsiniz. Harfler için bile işe yarar: `[m-p]`, m'den p'ye kadar tüm küçük harflerle eşleşir.

Bu nedenle, `\d` yi bir yıldız işaretiyle birleştirirsek, "journal2007.doc" ile eşleşecek ancak "journalism.doc" ile eşleşmeyen `journal\d*\.doc` düzenli ifadesini yazabiliriz. Ancak bekleyin, bu tam olarak doğru değil: Yıldız işaretinin "önceki karakter, *sıfır* veya daha fazla kez tekrarlanan" anlamına geldiğini hatırlayın. Bu durumda, "journal" den sonra *sıfır* basamak istemiyoruz, *en az bir* &mdash; istiyoruz, aksi takdirde düzenli ifade "journal.doc" dosyasıyla da eşleşecektir.

İşte sizin için başka bir özel karakter: ***artı*** sembolü (`'+'`) "bir veya daha fazla kez tekrarlanan önceki karakter" anlamına gelir. Bu nedenle düzenli ifademizin son sürümü: `journal\d+\.doc`
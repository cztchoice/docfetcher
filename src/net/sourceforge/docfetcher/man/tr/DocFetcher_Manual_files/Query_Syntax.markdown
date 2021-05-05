Sorgu Sözdizimi
============
Bu sayfa, "temel" den "gelişmiş" e giden mevcut sorgu söz dizimine genel bir bakış sunar. Sorgu sözdizimi, DocFetcher'ın temelindeki arama motoru olan Apache Lucene tarafından sağlanır ve Lucene'nin [sorgu sözdizimi sayfasında](http://lucene.apache.org/java/3_4_0/queryparsersyntax.html) daha teknik bir şekilde açıklanır.

Boole Operatörleri
-----------------
DocFetcher, `OR`, `AND` ve `NOT` boole operatörlerini destekler. Kelimeler boole operatörleri *olmadan* birleştirilirse, DocFetcher varsayılan olarak onları `OR` ile bitiştirilmiş gibi ele alır. Bundan hoşlanmıyorsanız, [tercihler](Preferences.html) adresine gidebilir ve `AND` yi varsayılan olarak ayarlayabilirsiniz.

`OR`, `AND` ve `NOT` yerine sırasıyla `||`, `&&` ve `'-'` (eksi simgesi) de kullanabilirsiniz. Belirli ifadeleri gruplamak için *parantez* kullanabilirsiniz. İşte bazı örnekler:

Sorgu                    | Ortaya çıkan belgeler şunları içerir...
-------------------------|---------------------------------------------
`köpek OR kedi`             | ya da `köpek`, veya `kedi`, veya her ikisi
`köpek AND kedi`            | hem `köpek` hem de `kedi`
`köpek kedi`                | (varsayılan olarak `köpek OR kedi` sorgusuna eşdeğerdir)
`köpek NOT kedi`            | `köpek`, ancak `kedi` değil
`-köpek kedi`               | `kedi`, ancak `köpek` değil
`(köpek OR kedi) AND fare` | `fare`, ve `köpek` veya `kedi`, veya her ikisi


Arama büyük/küçük harfe duyarlı değildir
-----------------------------
DocFetcher küçük harfli ve büyük harfli karakterler arasında ayrım yapmaz, bu nedenle girdiğiniz kelimelerin tamamen küçük veya tamamen büyük olması veya her ikisinin karışımı olması önemli değildir. Tek istisna, her zaman büyük harfle girilmesi gereken `OR`, `AND`, `NOT` ve `TO`, anahtar kelimeleridir. (`TO` anahtar kelimesi için aşağıdaki 'aralık aramaları' bölümüne bakın.)


Cümle Aramaları ve Gerekli Terimler
----------------------------------
Bir kelime öbeğini (yani bir dizi kelime) aramak için, kelime öbeğini çift tırnak içine alın. Aranacak belgelerin belirli bir kelimeyi içermesi gerektiğini belirtmek için kelimenin önüne bir `'+'` koyun. Elbette bu yapıları boole operatörleri ve parantezlerle birleştirebilirsiniz. Yine bazı örnekler:

Sorgu                 | Ortaya çıkan belgeler şunları içerir...
----------------------|-------------------------------------
`"köpek kedi fare"`     | belirli bir sırayla `köpek`, `kedi` ve `fare` kelimeleri
`+köpek kedi`            | kesinlikle `köpek` ve belki de `kedi`
`"köpek kedi" AND fare` | `köpek kedi` ifadesi ve `fare` kelimesi
`+köpek +kedi`           | (`köpek AND kedi` sorgusuna eşdeğerdir)


Joker karakterler
---------
Soru işaretleri (`'?'`) ve yıldız işaretleri (`'*'`) bazı karakterlerin bilinmediğini belirtmek için kullanılabilir. Soru işareti tam olarak bir bilinmeyen karakter anlamına gelirken, yıldız işareti sıfır veya daha fazla bilinmeyen karakter anlamına gelir. Örnekler:

Sorgu        | Ortaya çıkan belgeler şunları içerir...
-------------|-------------------------------------
`luc?`       | `lucy`, `luca`, ...
`luc*`       | `luc`, `lucy`, `luck`, `lucene`, ...
`*ene*`      | `lucene`, `energy`, `generator`, ...

Not: Bir kelimenin ilk karakteri olarak joker karakterler kullanılırsa, arama ortalama olarak daha yavaş olma eğilimindedir. Bu, dizinin nasıl yapılandırıldığına bağlıdır: Sanki birinin telefon numarasını aramaya çalışmışsınızdır ve yalnızca o kişinin adını biliyorsunuzdur. Dolayısıyla, yukarıdaki örnekte, `*ene*` araması muhtemelen diğer aramalardan daha yavaş olacaktır çünkü `*ene*` bir joker karakterle başlar.


Bulanık Aramalar
--------------
Bulanık aramalar, belirli bir kelimeye *benzer* kelimeleri aramanıza olanak tanır. Örneğin, `roam~` ararsanız, DocFetcher  `foam` ve `roams` gibi kelimeleri içeren dokümanları bulacaktır.

Ek olarak, 0 ile 1 arasında bir benzerlik eşiği ekleyebilirsiniz, şöyle ki: `roam~0.8`. Eşik ne kadar yüksekse, dönen eşleşmelerin benzerliği o kadar yüksek olur. Eşiği dışarıda bırakmak, varsayılan değer olan 0,5'i kullanmakla aynıdır.


Yakınlık Aramaları
------------------
Yakınlık aramaları, birbirinden belirli bir mesafede bulunan kelimeleri bulmanızı sağlar. Yakınlık araması yapmak için, bir cümlenin sonuna bir tilde (`'~'`) ve ardından bir mesafe değeri koyun. &mdash; Bunun sözdizimsel olarak bulanık aramalara benzer olduğunu unutmayın. Örneğin, 10 kelime içinde `wikipedia` ve `lucene` içeren dokümanları aramak için şunu yazın: `"wikipedia lucene"~10`


Artan Koşullar
--------------
Sözcüklere özel ağırlıklar atayarak sonuçların alaka düzeyini etkileyebilirsiniz. Örnek: Yalnızca `köpek kedi` yerine `köpek^4 kedi` girerseniz, `köpek` içeren belgeler daha yüksek bir puan alır ve bu nedenle sonuçların en üstüne yaklaşır.

Arttırma faktörünün pozitif olması gerekmesine rağmen, 1'den az olabilir (ör. 0,2). Yükseltme faktörü belirtilmezse, varsayılan değer 1 kullanılır.


Alan Aramaları
--------------
Varsayılan olarak DocFetcher, ayıklayabildiği tüm metin verilerini, yani belgelerin içeriğini, dosya adlarını ve meta verilerini arayacaktır. Bununla birlikte, aramalarınızı dosya adı ve/veya belirli meta veri alanlarıyla da sınırlayabilirsiniz. Örneğin, başlıkları `wikipedia` içeren dokümanları aramak için şunu girin: `title:wikipedia`. Bu, kelime öbeği aramasıyla birleştirilebilir, ör. `title:"köpek kedi"` veya parantez içinde, ör. `title:(köpek kedi)`. Aslında, tırnak işaretlerini ve parantezleri atlarsanız, başlıkla `kedi` değil, yalnızca `köpek` eşleşir.

Hangi alanların kullanılabilir olduğu genellikle belge biçimine bağlıdır, ancak bunu pratik bir kural olarak kullanabilirsiniz:

<!-- Aşağıdaki alan adlarını (dosya adı, başlık vb.) çevirmeyin -->
* *Dosyalar*: filename, title, author
* *E-postalar*: subject, sender, recipients


Aralık Aramaları
--------------
DocFetcher, sözlükbilimsel olarak iki kelime *arasında* olan kelimelerin aranmasına izin verir. Örneğin, `beta` kelimesi `alpha` ve `gamma` arasında yer alır. Bu nedenle, `alpha` ve `gamma` arasındaki kelimeleri içeren tüm belgeleri listelemek istiyorsanız, şunu yazın: `[alpha TO gamma]`.

Köşeli parantez kullanıldığında, aralık sorgusu *kapsayıcıdır*, yani sonuçlara `alpha` ve `gamma` dahildir. *Özel* aralık araması yapmak için, bunun yerine süslü parantez kullanın: `{alpha TO gamma}`

Aralık aramalarını ve alan aramalarını şu şekilde birleştirebilirsiniz: `title:{alpha TO gamma}`.Bu, aralık aramasını başlık alanıyla sınırlayacaktır.
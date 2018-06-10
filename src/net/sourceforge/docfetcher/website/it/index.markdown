Descrizione
===========
DocFetcher è un programma Open Source per effettuare ricerche sul desktop consentendo la ricerca del contenuto dei file presenti sul proprio computer &mdash; È possibile pensare a DocFetcher come al motore di ricerca Google applicato al proprio computer. L'applicazione gira su Windows, Linux e Mac OS&nbsp;X ed è reso disponibile sotto la [Eclipse Public License](http://en.wikipedia.org/wiki/Eclipse_Public_License).

Utilizzo di base
===========
L'immagine sottostante mostra l'interfaccia-utente principale. Le stringhe da ricercare debbono essere inserite nel campo di testo contrassegnato con (1). I risultati della ricerca compaiono nel pannello dei risultati (2). Il pannello di anteprima in (3) mostra invece l'anteprima in formato solo testo del file correntemente selezionato nel pannello dei risultati. Tutte le corrispondenze nel contenuto vengono evidenziate in giallo.

È possibile filtrare i risultati per dimensione (minima e massima) dei file (4), per tipo di file (5) e per posizione (6). I pulsanti in (7) sono usati rispettivamente per aprire la Guida, aprire la finestra delle Preferenze e per minimizzare il programma nell'area di notifica.

<div id="img" style="text-align: center;"><a href="../all/intro-001-results-edited.png"><img style="width: 500px; height: 375px;" src="../all/intro-001-results-edited.png"></a></div>

DocFetcher richiede la creazione dei cosiddetti *Indici* delle cartelle in cui si vogliono effettuare ricerche. Che cos'è un indice e come funziona è spiegato in maniera più dettagliata più oltre. In breve, un indice consente a DocFetcher di trovare assai rapidamente (nell'ordine di millisecondi) quali file contengono un particolare gruppo di parole consentendo una enome velocizzazione delle ricerche. L'immagine seguente mostra la finestra di dialogo di DocFetcher per creare nuovi indici:

<div id="img" style="text-align: center;"><a href="../all/intro-002-config.png"><img style="width: 500px; height: 375px;" src="../all/intro-002-config.png"></a></div>

Facendo clic sul pulsante *Esegui* posto in basso sulla destra della finestra di dialogo, inizia l'indicizzazione. Il processo richiede un po' di tempo, in funzione del numero e delle dimensioni dei file che si vogliono indicizzare. Indicativamente si può assumere che vengano indicizzati circa 200 file al minuto.

La creazione di un indice, come detto, richiede del tempo, ma va eseguita una sola volta per ciascuna cartella. Viceversa l'*aggiornamento* di un indice a seguito della modifica del contenuto di una carella è molto più veloce &mdash; generalmente impiega solo un paio di secondi.

Caratteristiche degne di nota
================
* **Versione portatile**: esiste una versione portatile di DocFetcher che gira su Windows, Linux *e* Mac OS&nbsp;X. Perché tale versione possa essere utile è spiegato in dettaglio più oltre in questa pagina.
* **Supporto 64-bit**:  sono supportati sia i sistemi operativi a 32-bit, sia quelli a 64-bit.
* **Supporto di Unicode**: DocFetcher dispone di un robusto sistema di supporto di Unicode che riguarda tutti i principali formati, compresi Microsoft Office, LibreOffice/OpenOffice.org, PDF, HTML, RTF e file di testo semplice. L'unica eccezione è rappresentata dai file CHM, per i quali non vi è tuttora supporto Unicode.
* **Supporto degli Archivi**: DocFetcher supporta i seguenti formati di archivio: zip, 7z, rar e l'intera famiglia tar.*. Le estensioni degli archivi zip possono essere personalizzate, consentendo di aggiungere altri archivi basati su tale formato, a seconda delle necessità. Inoltre, DocFetcher può gestire una nidificazione iillimitata degli archivi (per esempio un archivio zip che contiene un archivio 7z che contiene un archivio rar archive ecc…).
* **Ricerca nei file di codice sorgente**: le estensioni dei file che DocFetcher riconosce come file di testo semplice possono essere personalizzate, per cui si può usare  DocFetcher per ricercare all'interno di qualsiasi file di codice sorgente e di altri formati di testo semplice. (Questa possibilità si sposa bene anche con la personalizzazione delle estensioni zip, per esempio per cercare del codice sorgente Java all'interno dei file "jar").
* **File PST di Outlook**: DocFetcher consente di effettuare ricerche all'interno dei messaggi di posta elettronica di Microsoft Outlook che tipicamente vengono memorizzati in file aventi estensione PST.
* **Riconoscimento delle coppie  HTML**: DocFetcher riconosce le coppie HTML (per esempio un file denominato "foo.html" e la corrispondente cartella denominata "foo_files") in maniera predefinita e considera tale coppia come documento singolo. Questa caratteristica di primo acchitto potrebbe sembrare non molto utile , ma si rivela in realtà molto impotante per incrementare la qualità dei risultati di una ricerca che abbia a che fare con file HTML, in quanto  scompare dai risultati tutta la "confusione" presente all'interno delle cartelle HTML.
* **Esclusione di file dall'indicizzazione basata sulle espressioni regolari (RegEx)**: è possibile usare le espressioni regolari per escludere certi file dall'indicizzazione. Per esempio, per escludere dall'indicizzazione tutti i file Microsoft Excel, è possibile usare un'espressione regolare come questa : `.*\.xls`
* **Riconoscimento tipo di MIME**: le espressioni regolari possono essere usate anche per attivare il "riconoscimento del tipo di MIME" per certi file. In tal modo DocFetcher cercherà di riconoscere gli effettivi tipi di file non semplicemente guardando al nome del file e alla sua estensione, ma anche sbirciandone il contenuto. Questa caratteristica è utile nel caso di file che abbiano una estensione "sbagliata".
* **Potente sintassi di interrogazione**: oltre a costrutti semplici quali `OR`, `AND` e `NOT`, fra le altre cose DocFetcher supporta anche i caratteri jolly, la ricerca di frasi, le ricerche per analogia (fuzzy search) in cui vengono "cercate parole simili a…"), le ricerche per prossimità ("queste due parole debbono essere al massimo a 10 parole di distanza l'una dall'altra"), il fattore di rafforzamento ("aumento del punteggio di congruità di quei documenti che contengono…")

Tipi di documento supportati
==========================
* Microsoft Office (doc, xls, ppt)
* Microsoft Office 2007 e superiori (docx, xlsx, pptx, docm, xlsm, pptm)
* Microsoft Outlook (pst)
* Libre Office/OpenOffice.org (odt, ods, odg, odp, ott, ots, otg, otp)
* Portable Document Format (pdf)
* HTML (html, xhtml, …)
* Testo semplice (personalizzabile)
* Rich Text Format (rtf)
* AbiWord (abw, abw.gz, zabw)
* Microsoft Compiled HTML Help (chm)
* Microsoft Visio (vsd)
* Scalable Vector Graphics (svg)

Ecco l'opinione della gente a proposito di questo programma…
=========================================
${awards_table}

DocFetcher ha  ricevuto buone valutazioni anche da parte degli utenti come appare nella [nostra pagina](http://sourceforge.net/projects/docfetcher/) su SourceForge.net.

Confronto con altre applicazioni di ricerca desktop
===============================================
Paragonando DocFetcher con altre applicazioni di ricerca desktop, questi sono i punti nei quali DocFetcher spicca:

**Privo di schifezze**: ci siamo sforzati di mantenere l'interfaccia-utente di DocFetcher pulita e priva di schifezze. Nessuna pubblicità o finestre a comparsa con scritte quali: "Volete registrarvi…?". Niente aggiunte inutili al vostro web browser, o al file di registro o in qualunque altro posto del vostro sistema.

**Privacy**: DocFetcher non raccoglie i vostri dati privati. Mai. Chiunque abbia dubbi a questo riguardo può controllare il [codice sorgente](http://docfetcher.sourceforge.net/wiki/doku.php?id=source_code), accessibile pubblicamente.

**Gratuito per sempre**: poiché DocFetcher è Open Source, non c'è da preoccuparsi per la sua obsolescenza o per il timore che non venga più supportato, in quanto il codice sorgente rimarrà sempre a disposizione per essere riutilizzato. Per quanto riguarda il supporto: paragonate DoCFetcher con uno dei suoi principali competitori a livello commerciale, cioè **Google Desktop Search**: bene, sapete che è stato discontinuato nel 2011?

**Utilizzabile su più sistemi (cross-platform)**: a differenza della maggior parte dei suoi competitori, DocFetcher non solo gira su Windows, ma anche su Linux e su Mac OS&nbsp;X. Pertanto, se per caso si sente il desiderio di spostarsi dal proprio sistema Windows a Linux o a Mac OS&nbsp;X (o viceversa), DocFetcher sarà sempre pronto ad aspettarvi lì, sull'altro versante.

**Portatile**: una dei maggiori punti di forza di DocFetcher è la sua portatilità. Sostanzialmente con DocFetcher è possibile costruirsi una raccolta di documenti completa, pienamente ricercabile e portarsela con sé in una chiavetta o in un hard disk USB. A questo proposito si veda la sezione successiva.

**Indicizza solo quanto è necessario**: fra i competitori commerciali di DocFetcher, sembra esserci la tendenza a spingere gli utenti verso l'indicizzazione del contenuto dell'intero hard disk &mdash; forse avendo in mente l'idea di togliere più scelte/decisioni possibili agli utenti che si pensa siano "stupidi" o, peggio, nel tentativo di raccogliere quanti più dati possibili dagli utenti. In realtà si può assumere con ragionevole certezza che la maggior parte delle persone *non* vuole chevenga indicizzato interamente il proprio hard disk. Non solo ciò rappresenta una perdita di tempo e di spazio-disco, ma comporta anche un "inquinamento" dei risultati della ricerca presentando anche dei file indesiderati. DocFetcher invece indicizza solo le cartelle che gli si dice esplicitamente di voler indicizzare e, inoltre, consente una ulteriore personalizzazione dell'indicizzazione mettendo a disposizione tutta una serie di filtri.

Raccolte di documenti portatili
==============================
Una delle caratteristiche più rilevanti di DocFetcher è quella di essere disponibile anche in una versione portatile che consente di creare una *raccolta di documenti portatili* &mdash; cioè una raccolta di tutti i propri documenti importanti, indicizzata e totalmente ricercabile che può essere liberamente spostata ove si vuole.

**Esempi d'uso**: queste raccolte portatili di documenti indicizzazti possono essere portare con sé su una chiavetta o su un hard disk USB oppure possono essere masterizzate su un CD-ROM o su un DVD a scopo di archiviazione. Ancora: si possono mettere in un volume crittografato (in particolare si raccomanda [TrueCrypt](http://www.truecrypt.org/) oppure si possono sincronizzare fra differenti computer tramite memorizzazione su servizi cloud quali [DropBox](http://www.dropbox.com/) ecc… Inoltre, poiché DocFetcher è Open Source, è anche possibile distribuire le proprie raccolte! Se lo si vuole, si carichino da qualche parte le proprie raccolte e le si condivida con il resto del mondo!

**Java &mdash; prestazioni e portatilità**: un aspetto che potrebbe far storcere il naso a taluni è il fatto che DocFetcher sia scritto in Java, che ha la reputazione di essere un linguaggio "lento". Ciò era vero dieci anni fa, ma da allora le prestazioni di Java's secondo [Wikipedia](http://en.wikipedia.org/wiki/Java_%28software_platform%29#Performance) sono di gran lunga migliorate. In ogni caso, il grande vantaggio di DocFetcher è che essendo scritto in Java  può girare su Windows, Linux *e* su Mac OS&nbsp;X &mdash; molti altri programm richiedono invece l'uso di pacchetti separati per ciascuna piattaforma. Ida questo fatto ne consegue che, per esempio, si può mettere la propria raccolta di documenti su una chiavetta o su un hard disk USB e vi si può accedere da uno *qualsiasi* di questi sistemi operativi, con l'unica limitazione che sia installata la versione *runtime* di Java.

Come funziona l'indicizzazione
==================
Questa sezione cerca di fornire gli elementi di base per comprendere che cos'è e come funziona il processo di indicizzazione.

**L'approccio semplicistico alla ricerca dei file**: l'approccio più semplice nella ricerca dei file è quello di controllare, ogni qualvolta viene eseguita una ricerca, il nome dei singoli file presenti in un certo luogo del proprio hard disk. Questo tipo di ricerca funziona bene qualora si cerchino solo i *nomi dei file* perché l'analisi del solo nome dei file è molto veloce. Tale tipo di ricerca però non è né molto pratico né molto veloce se la ricerca invece si riferisce al *contenuto* dei file, poiché l'estrazione del testo è molto più dispendiosa della semplice analisi del nome dei file.

**Ricerca basata sugli indici**: quanto detto sopra spiga perché DocFetcher, essendo una applicazione che si occupa di ricercare i contenuti, utilizzi un approccio noto come *indicizzazione*. L'idea di fondo che vi sta dietro è che la maggior parte dei file di cui le persone ricercano il contenuto (circa il 95% e oltre) vengono modificati solo di rado o addirittura mai. Pertanto, piuttosto di estrarre completamente il testo di ciascun file in ciascuna ricerca, risulta di gran lunga più efficiente effettuare l'estrazione del testo di tutti i file *una volta* solamente, creando il cosiddetto *Indice* a partire da tutto il testo estratto. Questo indice risulta simile ad un dizionario consentendo una rapida ricerca all'interno dei file attraverso la ricerca delle parole in esso contenute.

**Analogia con l'elenco telefonico**: si consideri quanto più efficace è cercare il numero telefonico di qualcuno/a in un elenco telefonico (l'"Indice") invece di chiamare *ogni* numero telefonico possibile solo per verificare se la persona all'altro capo del filo è quella con cui si vuole effettivamente parlare. &mdash; In tal senso fare ogni volta n-mila chiamate al telefono per trovare il numero giusto o estrarre ogni volta il testo da tutti i file alla ricerca di quello che ci interessa può  esser considerato come una "operazione costosa". E un'altra analogia con il telefono e è che la gente non cambia  il proprio numero telefonico di frequente, allo stesso modo con cui la maggior parte dei file presenti in un computer viene modificata solo di rado se non addirittura mai.

**Aggiornamento degli Indici**: naturalmente un indice riflette lo stato dei file solo quando viene creato. Esso quindi non esprime necessariamente l'ultimo stato (il più recente) dei file. Pertanto, se l'indice non viene antenuto aggiornato, si incorre nella possibilità di ottenere dei risultati di ricerca non corretti perché obsoleti, così come un elenco telefonico nel tempo diventa anch'esso obsoleto. Questo però non è un grosso problema se si assume che la maggior parte dei file vengono modificati solo raramente. Inoltre, DocFetcher è in grado di aggiornare *automaticamente* i propri indici: (1) mentre sta girando in quanto riconosce le eventuali modifiche dei file così da aggiornare i propri indici di conseguenza. (2) se non sta girando, un piccolo demone (servizio) in background ha il compito di riconoscere le modifiche dei file che sono intervenute e tiene un elenco degli indici che debbono essere aggiornati non appena possibile. Non appena DocFetcher verrà eseguito, si occuperà di aggiornare quegli indici che il demone ha identificato. Non c'è da preoccuparsi del demone: ha un basso impatto sull'uso della CPU e uno scarso consumo di memoria, perché non fa nient'altro che prendere nota delle cartelle che sono cambiate lasciando a DocFetcher il compito dell'aggiornamento vero e proprio degli indici.
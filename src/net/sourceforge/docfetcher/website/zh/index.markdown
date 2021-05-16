**Note**: You may be interested in [DocFetcher Pro](https://docfetcherpro.com/), the commercial big brother of DocFetcher with more features and fewer bugs.

描述
===========
DocFetcher是一个开源桌面搜索应用程序：它允许您搜索计算机上的文件内容。&mdash; 您可以将其视为Google的本地文件。该应用程序在Windows，Linux和OS&nbsp;X上运行，并在[Eclipse Public License](https://en.wikipedia.org/wiki/Eclipse_Public_License)下提供。

基本用法
===========
下面的屏幕截图显示了主用户界面。查询在(1)的文本字段中输入。搜索结果显示在结果窗格中的(2)处。(3)中的预览窗格显示了结果窗格中当前所选文件的纯文本预览。文件中的所有匹配项都以黄色突出显示。

您可以按最小和/或最大文件大小(4)，按文件类型(5)和按位置(6)过滤结果。(7)处的按钮分别用于打开手册，打开首选项和最小化程序到系统托盘中。

<div id="img" style="text-align: center;"><a href="../all/intro-001-results-edited.png"><img style="width: 500px; height: 375px;" src="../all/intro-001-results-edited.png"></a></div>

DocFetcher要求您为要搜索的文件夹创建所谓的*索引*。下面将详细介绍索引及其工作原理。简而言之，索引允许DocFetcher非常快速地（以毫秒为单位）找出哪些文件包含特定的单词集，从而大大加快了搜索速度。以下屏幕截图显示了DocFetcher用于创建新索引的对话框：

<div id="img" style="text-align: center;"><a href="../all/intro-002-config.png"><img style="width: 500px; height: 375px;" src="../all/intro-002-config.png"></a></div>

单击此对话框右下角的“运行”按钮可启动索引编制。索引过程可能需要一段时间，具体取决于要编制索引的文件的数量和大小。一个好的经验法则是每分钟200个文件。

虽然创建索引需要时间，但每个文件夹只需执行一次。此外，*在文件夹内容发生变化后更新*索引比创建它快得多 &mdash; 它通常只需要几秒钟。

主要特点
================
* **便携版**：DocFetcher的可移植版本可在Windows，Linux *和* OS&nbsp;X上运行。这个有用的内容在本页后面有更详细的描述。
* **64位支持**：支持32位和64位操作系统。
* **Unicode支持**：DocFetcher为所有主要格式提供坚如磐石的Unicode支持，包括Microsoft Office，OpenOffice.org，PDF，HTML，RTF和纯文本文件。
* **存档支持**：DocFetcher支持以下存档格式：zip，7z，rar和整个tar。*系列。可以自定义zip存档的文件扩展名，允许您根据需要添加更多基于zip的存档格式。此外，DocFetcher可以处理无限制的存档嵌套（例如，包含带有rar存档的7z存档的zip存档......等等）。
* **在源代码文件中搜索**：可以自定义DocFetcher识别纯文本文件的文件扩展名，因此您可以使用DocFetcher搜索任何类型的源代码和其他基于文本的文件格式。（这与可自定义的zip扩展相结合非常有效，例如，用于在Jar文件中搜索Java源代码。）
* **Outlook PST文件**：DocFetcher允许搜索Outlook电子邮件，Microsoft Outlook通常存储在PST文件中。
* **HTML对的检测**：默认情况下，DocFetcher会检测HTML文件对（例如名为“foo.html”的文件和名为“foo_files”的文件夹），并将该对视为单个文档。这个功能一开始看起来似乎没用，但事实证明，当你处理HTML文件时，这会大大提高搜索结果的质量，因为HTML文件夹中的所有“混乱”都会从结果中消失。
* **基于正则表达式的文件从索引中排除**：您可以使用正则表达式从索引中排除某些文件。例如，要排除Microsoft Excel文件，可以使用如下的正则表达式：`.*\.xls`
* **Mime类型检测**：您可以使用正则表达式为某些文件启用“mime-type detection”，这意味着DocFetcher将尝试检测其实际文件类型，而不仅仅是通过查看文件名，还可以通过偷看文件内容。这对于文件扩展名错误的文件很方便。
* **强大的查询语法**：除了“OR”，“AND”和“NOT”之类的基本结构之外，DocFetcher还支持以下内容：通配符，短语搜索，模糊搜索（“查找类似单词“），邻近搜索（”这两个单词应该相距最多10个单词“），提升（”增加文档的权重“）

支持的文档格式
==========================
* Microsoft Office (doc, xls, ppt)
* Microsoft Office 2007 及更新版本 (docx, xlsx, pptx, docm, xlsm, pptm)
* Microsoft Outlook (pst)
* OpenOffice.org (odt, ods, odg, odp, ott, ots, otg, otp)
* Portable Document Format (pdf)
* EPUB (epub)
* HTML (html, xhtml, ...)
* TXT and other plain text formats (customizable)
* 富文本文件 (rtf)
* AbiWord (abw, abw.gz, zabw)
* Microsoft Compiled HTML Help (chm)
* MP3 Metadata (mp3)
* FLAC Metadata (flac)
* JPEG Exif Metadata (jpg, jpeg)
* Microsoft Visio (vsd)
* Scalable Vector Graphics (svg)

Comparison To Other Desktop Search Applications
===============================================
与其他桌面搜索应用程序相比，DocFetcher在这里脱颖而出：

**无废话**：我们努力保持DocFetcher的用户界面整洁，无垃圾。没有广告或“你想注册......？” 弹出窗口。您的Web浏览器，注册表或系统中的任何其他位置都没有安装任何无用的东西。

**隐私**：DocFetcher不会收集您的私人数据。永远。任何对此有疑问的人都可以查看可公开访问的[源代码](https://docfetcher.sourceforge.net/wiki/doku.php?id=source_code)

**永远免费**：由于DocFetcher是开源的，你不必担心程序会变得过时和不受支持，因为源代码将始终存在。说到支持，你得到的消息是，DocFetcher的主要商业竞争对手之一Google桌面在2011年停产吗？好...

**跨平台**：与许多竞争对手不同，DocFetcher不仅可以在Windows上运行，还可以在Linux和OS&nbsp;X上运行。因此，如果您想要从Windows框移动到Linux或OS&nbsp;X，DocFetcher将在另一边等待您。

**便携式**：DocFetcher的最大优势之一是其便携性。基本上，使用DocFetcher，您可以构建一个完整的，完全可搜索的文档存储库，并将其随身携带在USB驱动器上。更多内容将在下一节中介绍。

**仅对您需要的内容进行索引**：在DocFetcher的商业竞争对手中，似乎倾向于推动用户索引整个硬盘驱动器 &mdash; 也许是为了试图从所谓的“愚蠢”用户那里拿走尽可能多的决定，或者更糟糕的是，试图收获更多的用户数据。但实际上，假设大多数人*不希望将整个硬盘驱动器编入索引似乎是安全的：这不仅浪费了索引时间和磁盘空间，而且还会使搜索结果与不需要的文件混乱。因此，DocFetcher仅对您明确要编制索引的文件夹编制索引，并在此基础上为您提供了大量过滤选项。

便携式文档存储库
==============================
DocFetcher的一个突出特点是它可以作为便携式版本使用，它允许您创建*便携式文档存储库* &mdash; 一个完全索引和完全可搜索的所有重要文档的存储库，您可以自由移动。

**使用示例**：您可以使用此类存储库执行各种操作：您可以随身携带USB驱动器，将其刻录到CD-ROM上进行存档，将其放入加密卷(建议：[TrueCrypt](https://www.truecrypt.org/))，通过云端存储服务（如[DropBox](https://www.dropbox.com/)等）在多台计算机之间进行同步。由于DocFetcher是开源的，您甚至可以重新分发您的存储库：如果您愿意，可以上传它并与世界其他地方共享。

**Java：性能和可移植性**：一些人可能会遇到的一个问题是DocFetcher是用Java编写的，它有着“慢”的美誉。十年前确实如此，但从那以后Java的表现已经有了很大改善，[根据维基百科](https://en.wikipedia.org/wiki/Java_%28software_platform%29#Performance)。无论如何，用Java编写的好处是可以在Windows，Linux *和* OS&nbsp;X上运行相同的可移植DocFetcher包X &mdash; 许多其他程序需要为每个平台使用单独的捆绑包。因此，您可以将便携式文档存储库放在USB驱动器上，然后从* any *这些操作系统访问它，前提是安装了Java运行时。

索引如何工作
==================
本节试图基本了解索引是什么以及它是如何工作的。

**文件搜索的天真方法**：文件搜索的最基本方法是在执行搜索时逐个访问特定位置的每个文件。这适用于*filename-only*搜索，因为分析文件名非常快。但是，如果要搜索文件的*contents*，它将无法正常工作，因为全文提取是比文件名分析更昂贵的操作。

**基于索引的搜索**：这就是为什么作为内容搜索者的DocFetcher采用一种称为*索引*的方法：基本思想是人们需要搜索的大多数文件（例如，超过95％）都是很少修改或根本不修改。因此，不是在每次搜索的每个文件上进行全文提取，而是对所有文件执行文本提取只需，并从所有提取的文本创建所谓的*index*。这个索引有点像字典，它允许通过它们包含的单词快速查找文件。

**电话簿类比**：作为类比，考虑在电话簿中查找某人的电话号码（“索引”），而不是拨打*每个*可能的电话号码，以查明是否有效在另一端的人是你正在寻找的人。&mdash; 通过电话呼叫某人并从文件中提取文本都可以被视为“昂贵的操作”。此外，人们不经常更改电话号码的事实类似于计算机上的大多数文件很少被修改的事实。

**索引更新**：当然，索引仅反映索引文件创建时的状态，而不一定是文件的最新状态。因此，如果索引没有保持最新，您可能会得到过时的搜索结果，就像电话簿过时一样。但是，如果我们可以假设大多数文件很少被修改，那么这应该不是什么大问题。此外，DocFetcher能够*自动*更新其索引：(1)当它运行时，它会检测更改的文件并相应地更新其索引。(2)当它没有运行时，后台的一个小守护进程将检测到变化并保留一个要更新的索引列表; 然后，DocFetcher将在下次启动时更新这些索引。你不担心守护进程：

查询语法
============
此页面概述了可用的查询语法，从“基本”到“高级”。查询语法由DocFetcher底层搜索引擎Apache Lucene提供，并在Lucene的[查询语法页面](http://lucene.apache.org/java/3_4_0/queryparsersyntax.html)上以更技术的方式进行描述。

布尔运算符
-----------------
DocFetcher支持布尔运算符`OR`，`AND`和`NOT`。如果单词连接*没有*布尔运算符，DocFetcher默认将它们视为与`OR`连接。如果您不喜欢，可以转到[preferences](Preferences.html)并将“AND”设置为默认值。

而不是“OR”，“AND”和“NOT”，你也可以分别使用`||`，`&&`和`'-'`（减号）。您可以使用*括号*对某些表达式进行分组。这里有些例子：

查询| 结果文件包含......
-------------------------|---------------------------------------------
`dog OR cat` | either `dog`, or `cat`, or both
`dog AND cat` | both `dog` and `cat`
`dog cat` | (by default equivalent to the query `dog OR cat`)
`dog NOT cat` | `dog`, but not `cat`
`-dog cat` | `cat`, but not `dog`
`(dog OR cat) AND mouse` | `mouse`, and either `dog` or `cat`, or both


搜索不区分大小写
-----------------------------
DocFetcher不区分小写和大写字符，因此，如果输入的单词完全小写，或完全大写，或两者兼而有之，则无关紧要。唯一的例外是关键字“OR”，“AND”，“NOT”和“TO”，它们必须始终以大写形式输入。（对于`TO`关键字，请参阅下面的'范围搜索'部分。）


短语搜索和必需条款
----------------------------------
要搜索短语（即单词序列），请将短语放在双引号中。要指示要搜索的文档必须包含特定单词，请在单词前面加上“+”。当然，您可以将这些结构与布尔运算符和括号组合在一起。再举一些例子：

查询| 结果文件包含......
----------------------|-------------------------------------
`"dog cat mouse"` | the words `dog`, `cat` and `mouse`, in that particular order
`+dog cat` | definitely `dog`, and maybe also `cat`
`"dog cat" AND mouse` | the phrase `dog cat`, and the word `mouse`
`+dog +cat` | (equivalent to the query `dog AND cat`)


通配符
---------
问号(`'?'`)和星号(`'*'`)可用于表示某些字符未知。问号代表一个未知字符，而星号代表零个或多个未知字符。例子：

查询|结果文件包含......
-------------|-------------------------------------
`luc?` | `lucy`, `luca`, ...
`luc*` | `luc`, `lucy`, `luck`, `lucene`, ...
`*ene*` | `lucene`, `energy`, `generator`, ...

注意：如果将通配符用作单词的第一个字符，则搜索的平均速度往往较慢。这是由于索引的结构如何：就好像你试图查找某人的电话号码，而你只知道该人的名字。因此，在上面的例子中，搜索`*ene*`可能比其他搜索慢，因为`*ene*`以通配符开头。


模糊搜索
--------------
模糊搜索允许您搜索与给定单词*相似*的单词。例如，如果你搜索`roam~`，DocFetcher会找到包含`foam`和`roams`等单词的文档。

此外，您可以在0和1之间附加相似性阈值，如下所示：`roam~0.8`。阈值越高，返回的匹配的相似性越高。省略阈值与使用默认值0.5相同。


邻近搜索
------------------
通过邻近搜索，您可以找到彼此相距特定距离的单词。要进行邻近搜索，请在短语的末尾加上波浪号（`'〜'`），后跟距离值。&mdash; 请注意，这在语法上与模糊搜索类似。例如，要搜索包含“维基百科”和“lucene”的文档，请在10个单词内输入，输入：`"wikipedia lucene"~10`


提升条款
--------------
您可以通过为单词指定自定义权重来影响结果的相关性排序。示例：如果输入`dog^4 cat`而不是`dog cat`，则包含`dog`的文档将获得更高的分数，因此更接近结果的顶部。

虽然提升因子必须为正，但它可以小于1（例如0.2）。如果未指定增强因子，则使用默认值1。


现场搜索
--------------
默认情况下，DocFetcher将搜索它能够提取的所有文本数据，即文档的内容，文件名和元数据。但是，您也可以将搜索限制为文件名和/或某些元数据字段。例如，要搜索标题包含“wikipedia”的文档，请输入：`title:wikipedia`。这可以与短语搜索相结合，例如`title:"dog cat"`，或括号，例如`title:(dog cat)`。事实上，如果你省略引号和括号，只有`dog`将匹配标题，而不是`cat`。

哪些字段可用通常取决于文档格式，但您可以将其用作经验法则​​：

<!-- 不要翻译以下字段名称（文件名，标题等）-->
* *Files*: filename, title, author
* *Emails*: subject, sender, recipients


范围搜索
--------------
DocFetcher允许在*两个其他单词之间搜索按字典顺序排列的单词。例如，“beta”这个词位于“alpha”和“gamma”之间。因此，如果要列出包含`alpha`和`gamma`之间单词的所有文档，请输入：`[alpha TO gamma]`。

使用方括号时，范围查询为*包含*，即结果中包含“alpha”和“gamma”。要进行*exclusive* range搜索，请使用大括号：`{alpha TO gamma}`

您可以按如下方式组合范围搜索和字段搜索：`title:{alpha TO gamma}`。这会将范围搜索限制为标题字段。

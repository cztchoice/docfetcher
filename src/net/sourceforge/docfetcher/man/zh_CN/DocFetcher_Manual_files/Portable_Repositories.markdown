便携式文档存储库
==============================

基本用法
-----------
DocFetcher的可移植版本基本上允许您随身携带（甚至重新分发）完全索引且完全可搜索的文档存储库。如果您还没有便携版，可以从[项目网站](http://docfetcher.sourceforge.net)下载。

便携式版本不需要任何安装; 只需将存档的内容提取到您选择的文件夹中即可。然后，您可以通过适用于您的操作系统的启动器启动DocFetcher：Windows上的“DocFetcher.exe”，Linux上的“DocFetcher.sh”和Mac OS上的“DocFetcher”应用程序包。唯一的要求是必须在计算机上安装Java运行时版本1.6或更高版本。

<u>相对路径</u>：需要注意的一件重要事情是必须在启用*relative paths*设置的情况下创建所有索引。如果没有这个，DocFetcher会将*absolute*引用存储到您的文件中，因此您只能移动DocFetcher及其索引，而不能移动文件＆mdash; 至少没有打破引用。这是一个例子来说明这一点：

*相对路径: `..\..\my-files\some-document.txt`
* 绝对路径: `C:\my-files\some-document.txt`

相对路径基本上告诉DocFetcher它可以通过从当前位置上升两个级别然后下到`my-files`文件夹中找到`some-document.txt`。另一方面，绝对路径是一个固定的引用，独立于DocFetcher的当前位置，因此您不能在不破坏引用的情况下移动`some-document.txt`（意味着DocFetcher将无法找到该文件）。

请注意，DocFetcher只能*尝试*存储相对路径：显然，如果你将DocFetcher和你的文件放在不同的卷上，它就不能这样做，例如DocFetcher在`D:\DocFetcher`和你的文件在`E:\my-files`.

可用性提示
--------------

* *** CD-ROM存档***：只是常识，但仍然：如果您将DocFetcher放在CD-ROM上，您将无法保存对首选项或索引的更改，因此请记住正确配置将所有内容刻录到CD-ROM上之前的所有内容 此外，您可能希望包含Java运行时安装程序。
* ***不同的程序标题***：对于可移植文档存储库的重新分发，或者为了减少混淆多个DocFetcher实例，您可以为每个DocFetcher实例提供不同的程序窗口标题。为此，请在首选项对话框中打开“高级设置”并修改“AppName”设置。

警告
--------

* ***不要触摸`indices`文件夹***：您可以，但不要求将文件直接放入DocFetcher文件夹。如果这样做，请单独留下`indexes`文件夹，因为您放入的任何内容都可能被删除！
* ***文件名不兼容***：注意不同操作系统之间的文件名不兼容性。例如，在Linux上，文件名可以包含诸如“：”或“|”之类的字符，但在Windows上则不能。因此，如果文档存储库不包含具有不兼容文件名的文档，则只能将文档存储库从Linux移动到Windows或相反方向。哦，像德国变形金刚这样的特殊人物是完全不同的事情......
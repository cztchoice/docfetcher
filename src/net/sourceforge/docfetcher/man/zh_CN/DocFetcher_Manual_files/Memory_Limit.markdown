如何提高内存限制
=============================
DocFetcher的默认内存限制为256MB，在启动时设置。通过摆弄平台特定的发射器可以提高限制：

Windows
-------
Windows版本的DocFetcher附带现成的备用启动器，可设置不同的堆大小。请按照以下步骤使用它们：

* 打开DocFetcher文件夹。如果您使用的是DocFetcher的便携版本，那么这只是您下载和解压缩的文件夹。如果您使用的是非便携版本，则DocFetcher文件夹将位于`C:\Program Files`或`C:\Program Files (x86)`或类似位置。
* 替代发射器位于`DocFetcher\misc`文件夹中。它们被命名为`DocFetcher-XXX.exe`，其中`XXX`是相应启动器设置的堆大小。例如，启动程序`DocFetcher-512.exe`将设置堆大小为512 MB。
* 在使用任何这些发射器之前，**必须先将其移动或复制到DocFetcher文件夹中**。没有必要删除默认启动器或重命名备用启动器。

更改内存限制的另一种方法是将文件`misc\DocFetcher.bat`复制到DocFetcher文件夹中，并在文件的最后一行中更改表达式`-Xmx256m`，例如更改为`-Xmx512m`。

Linux
-----
使用文本编辑器打开启动程序脚本`DocFetcher/DocFetcher.sh`，在最后一行中，根据需要更改表达式`-Xmx256m`，例如更改为`-Xmx512m`。

Mac OS&nbsp;X
-------------
在非便携版和便携版中，DocFetcher都是通过应用程序包启动的。在非便携版本中，应用程序包就是您从下载的磁盘映像中获取的内容。在便携版本中，可以在DocFetcher文件夹中找到应用程序包。

在这两种情况下，应用程序包实际上都是一个扩展名为`.app`的文件夹。Finder中应该有一个上下文菜单条目来打开此文件夹。如果您的Mac OS&nbsp;X语言是英语，则此菜单项将命名为“显示包内容”。

在该文件夹中，您将找到此启动器脚本：`Contents/MacOS/DocFetcher`。用文本编辑器打开它，在最后一行，根据需要改变表达式`-Xmx256m`，例如改为`-Xmx512m`。
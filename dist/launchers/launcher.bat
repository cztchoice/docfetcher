@echo off

rem  This file is an alternative launcher for the program, provided for easy
rem  customization. How to use it:
rem  1) Move this file one level up into the DocFetcher folder.
rem  2) Modify this file as needed.
rem  3) Double-click on this file to launch DocFetcher.
rem  
rem  Common modifications of this file:
rem  
rem  1) You can adjust the maximum amount of memory available to the program
rem     with the setting -Xmx... in the last line. For example, -Xmx512m will
rem     give the program up to 512 MB of memory, whereas -Xmx8g will give it up
rem     to 8 GB of memory. The latter only works if your machine has at least 8
rem     GB of RAM. Also note that using more memory than about 1 GB requires a
rem     64-bit Java runtime.
rem  
rem  2) You can replace the "java" keyword in the last line with an absolute or
rem     relative path to the Java executable. If the path contains spaces, put
rem     the entire path in quotes, e.g.:
rem     "C:\Program Files\Java\jre1.8.0_181\bin\java.exe"
rem     Here's an example of a relative path to a Java runtime that resides in
rem     the same parent folder as the DocFetcher folder:
rem     ..\Java\bin\java.exe
rem     Another relative path example where the Java folder resides directly
rem     inside the DocFetcher folder:
rem     .\Java\bin\java.exe
rem     Setting an alternative Java path is useful for using a different
rem     installed Java runtime, or for using a portable Java runtime such as the
rem     jPortable runtime provided by the PortableApps project:
rem     https://portableapps.com/apps/utilities/java_portable
rem  
rem  3) To hide the black command prompt window after launching, replace the
rem     "java" keyword in the last line with: "start /b javaw". Notice the use
rem     of "javaw" instead of "java". This also works with full paths to the
rem     Java runtime, but in that case requires some extra batch file weirdness:
rem     start /b "" "C:\Program Files\Java\jre1.8.0_181\bin\javaw.exe"

cd %~dp0

set libclasspath=

for %%f in (.\lib\*.jar) do (call :append_classpath %%f)
goto :proceed

:append_classpath
set libclasspath=%libclasspath%;%1
goto :eof

:proceed
java -enableassertions -Xmx1g -Xss2m -cp %libclasspath% -Djava.library.path=lib ${main_class} %1 %2 %3 %4 %5 %6 %7 %8 %9

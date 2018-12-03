#!/bin/sh

scriptdir=$(cd "$(dirname "$0")"; pwd)
cd "$scriptdir"
cd ../../..

CLASSPATH=
for FILE in `ls ./lib/*.jar`
do
   CLASSPATH=${CLASSPATH}:${FILE}
done

# Prefer legacy Java 6 runtime from Apple if present
java_exec=/Library/Internet\ Plug-Ins/JavaAppletPlugin.plugin/Contents/Home/bin/java
if [ ! -f "$java_exec" ]; then
	java_exec=java
fi

# Note: The java call must not end with '&', otherwise the -Xdock:name property will have no effect.

"$java_exec" -XstartOnFirstThread -Xdock:name="${app_name}" -enableassertions -Xmx512m -Xss2m -cp ".:${CLASSPATH}" -Djava.library.path="lib" ${main_class} "$@"

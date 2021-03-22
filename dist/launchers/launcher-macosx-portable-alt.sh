#!/bin/sh

scriptdir=$(cd "$(dirname "$0")"; pwd)
cd "$scriptdir"

./DocFetcher.app/Contents/MacOS/DocFetcher

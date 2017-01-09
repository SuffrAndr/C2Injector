#!/bin/bash
ps -ef | grep FTPDownload | grep -v grep | awk '{print $2}'| xargs -I {} kill -9 {}

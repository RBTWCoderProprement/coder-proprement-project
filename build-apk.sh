#!/bin/sh

#DEBUG MODE
set -x

#VARIABLES
apk_name=sample
apk_extension=.apk
apk_folder=build/apk/

###LET'S SCRIPT###

#GET FINAL APK_PATH
date=$(date '+%d%m%Y%H%M%S');
apk_final_path=$apk_folder$apk_name-$date$apk_extension

#BUILD APK
chmod +x gradlew
./gradlew clean
./gradlew assembleDebug

#FIND APK
apk_origin_path=`find . -type f -name "*.apk" | head -n 1`

#COPY FILE TO RIGHT FOLDER
mkdir -p $apk_folder
cp $apk_origin_path $apk_final_path
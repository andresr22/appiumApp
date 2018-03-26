#!/bin/bash

## Execute this shell as root

npm install -g appium -unsafed-perm=true -allow-root		# Install appium
path=$($HOME)	# Home variable
echo $path
cd $path		# Change to home directory
mkdir -p appiumAndroidSetup/android 	# Create a directory for Android SDK
cd appiumAndroidSetup/android
echo "Downloading Android SDK ...."
curl -O 'https://dl.google.com/android/repository/sdk-tools-darwin-3859397.zip' # Download sdk tools
unzip sdk-tools-darwin-*.zip	# Unzip the SDK file
echo "Accepting Android SDK licenses"
yes Yes | tools/bin/sdkmanager --licenses # Accept all the licenses
echo "updating the Android sdk manager"
yes Yes | tools/bin/sdkmanager --update		# Update the sdkmanager, sometimes this action take a several minutes
echo "Downloading other tools ..."
tools/bin/sdkmanager "platforms;android-25" "build-tools;25.0.2" "extras;google;m2repository" "extras;android;m2repository"	# Dowloading extra tools
rm sdk-tools-darwin-*.zip	# Remove the zip file
echo "Set below path as ANDROID_HOME"
pwd
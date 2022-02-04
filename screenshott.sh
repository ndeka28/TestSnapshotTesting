#!/bin/bash

# Install an AOSP image that would later be used as the AVD's OS
$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --install "system-images;android-30;default;x86_64"


# Create an AVD with the image we've previously installed
$ANDROID_HOME/cmdline-tools/latest/bin/avdmanager --verbose create avd --force --name Pixel_4_API_30 --abi x86_64 --device "pixel" --package "system-images;android-30;default;x86_64"

#Start the emulator
$ANDROID_HOME/emulator/emulator -avd  Pixel_4_API_30 -wipe-data &
EMULATOR_PID=$!

# Wait for the emulator to boot up completely.
# This script is actually a bit naive. There are various suggestions out there
# as to make this more robust. One alternative is to utilize the "adb wait-for-device" command.
booted=0
while [ "$booted" != "1" ]
do
  echo "Waiting for emulator..."
  booted=`$ANDROID_HOME/platform-tools/adb shell getprop dev.bootcomplete`
  sleep 1
done

./gradlew clean devDebugExecuteScreenshotTests


kill $EMULATOR_PID


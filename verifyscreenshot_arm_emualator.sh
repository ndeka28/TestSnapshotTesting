#!/bin/bash

# Install an AOSP image that would later be used as the AVD's OS
$ANDROID_HOME/cmdline-tools/latest/bin/sdkmanager --install "system-images;android-30;default;arm64-v8a"


# Create an AVD with the image we've previously installed
$ANDROID_HOME/cmdline-tools/latest/bin/avdmanager --verbose create avd --force --name Pixel_4_API_30 --abi arm64-v8a --device "pixel" --package "system-images;android-30;default;arm64-v8a"

#Start the emulator
$ANDROID_HOME/emulator/emulator -avd  Pixel_4_API_30 -wipe-data &
EMULATOR_PID=$!

# Wait for the emulator to boot up completely.
# as to make this more robust. One alternative is to utilize the "adb wait-for-device" command.
booted=0
while [ "$booted" != "1" ]
do
  echo "Waiting for emulator..."
  booted=$($ANDROID_HOME/platform-tools/adb shell getprop dev.bootcomplete)
  sleep 1
done

./gradlew clean devDebugExecuteScreenshotTests


kill -9 $EMULATOR_PID


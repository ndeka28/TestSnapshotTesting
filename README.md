# TestScreenShotTest

## About the project
#### This project demonstrates very basic usage of executing Screenshot tests for Android app

## Project Location
#### Please create/put project in any of the location - /Users/$user$ or /Users/$user$/Documents or /Users/$user$/Downloads or /Users/$user$/Desktop. The screenshots will not be genrated in any other locations.

## Generate or Record Screenshots
#### First step is to record all the screenshots of the application. These screenshots will be later used for comparisons. From terminal window, go to your project path and run the recording script by executing `./generatescreen.sh` This step will create snapshot images in location  `/Users/$user$/TestScreenShotTest-main/app/screenshots/$flavour$/$build type$`. These files are required to be pushed to repository for future verification. The script will first create an emulator, start it and run the recording tasks.


## Run the Screenshot tests
#### The screenshot tests are basically some Android Instrumentation tests. To run it, From terminal window, go to your project path and run the recording script by executing `./screenshott.sh`.The script will first create an emulator (same configuration as generation step), start it and run the verification tasks. This step will generate screenshots and will compare with previously recorded screenshots from `/Users/$user/TestScreenShotTest-main/app/screenshots/$flavour$/$build type$`. Build will success if the screenshots are similar. The result of the task will be availabe in /Users/$user/TestScreenShotTest-main/app/build/reports/shot/$flavour$/$build type$/verification 

## Pros
#### Easy to use
#### Quick to find design changes without regression, specially scenarios where we update the library (e.g., material design)
#### Good start for learning Android instrumentation testing

## Cons
#### For Android, not many library options
#### All devs, CI should use same device /emulator for generating the screenshots and verifying. It might be a problem if we start using M1 mac book, we might be completely different set up than CI
#### Every test will generate a screenshot, which will effect build time, and also might be a storage issue if tests are increased

## NEED TO DISCUSS
#### How far should we use this for testing? Is it just a page, or more detailed like error scenario?
#### Should we do it in the CI?

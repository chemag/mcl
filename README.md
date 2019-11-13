# mcl: a simple Android MediaCodecList

# 1. Introduction

mcl is an app that lists the codecs in the android MediaCodecList.


# 2. Example

Run the app. You will see something like this:

![Example Image](https://github.com/chemag/mcl/raw/master/doc/pixel1.png "MCL running on a Pixel 1")

You can scroll the text to get the full codec list.

# 3. Build Instructions

Optionally, you can build the apk yourself.
```
$ ./gradlew build
$ ls -s ./app/build/outputs/apk/debug/com.example.mediacodeclist-v1.0-debug.apk
1580K ./app/build/outputs/apk/debug/com.example.mediacodeclist-v1.0-debug.apk
```

Optionally, you can run the local unit-tests.
```
$ ./gradlew test
...
BUILD SUCCESSFUL in 0s
36 actionable tasks: 36 up-to-date
```

Optionally, you can run the instrumented unit-tests.
```
$ ./gradlew connectedAndroidTest
...
Starting 1 tests on Pixel - 10

BUILD SUCCESSFUL in 22s
51 actionable tasks: 1 executed, 50 up-to-date
```

You can also run the instrumented unit-tests using adb.
```
$ ./gradlew installDebug
...
Installing APK 'com.example.mediacodeclist-v1.0-debug.apk' on 'device-name' for app:debug
...
$ ./gradlew installDebugAndroidTest
...
Installing APK 'com.example.mediacodeclist-v1.0-debug-androidTest.apk' on 'device-name' for app:debugAndroidTest
...

$ adb shell am instrument -w com.example.mediacodeclist.test/android.support.test.runner.AndroidJUnitRunner
$ adb shell am instrument -w -e class com.example.mediacodeclist.ExampleInstrumentedTest#useAppContext com.example.mediacodeclist.test/android.support.test.runner.AndroidJUnitRunner
```


# 4. Install Instructions

Download the apk from [here](https://github.com/chemag/mcl/blob/master/app/release/com.example.mediacodeclist-v1.0-debug.apk).

Install the app:

```
$ adb install com.example.mediacodeclist-v1.0-debug.apk
Success
$ adb shell cmd package list package |grep mediacodeclist
package:com.example.mediacodeclist
```

You may need to install any old copies.

```
$ adb shell pm uninstall com.example.mediacodeclist
Success
```

Run it from the app list, or using the shell.

```
$ adb shell monkey -p com.example.mediacodeclist -c android.intent.category.LAUNCHER 1
```

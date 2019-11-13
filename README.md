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

# mcl: a simple Android MediaCodecList

# 1. Introduction

mcl is an app that lists the codecs in the android MediaCodecList.


# 2. Example

Run the app. You will see something like this:

![Example Image](https://github.com/chemag/mcl/raw/master/doc/pixel1.png "MCL running on a Pixel 1")

You can scroll the text to get the full codec list.


# 3. Install Instructions

Download the apk from [here](https://github.com/chemag/mcl/blob/master/app/release/app-release.apk).

Install the app:

```
$ adb install app-release.apk
Success
```

You may need to install any old copies.

```
$ adb shell pm uninstall com.example.mediacodeclist
Success
```

Run it.


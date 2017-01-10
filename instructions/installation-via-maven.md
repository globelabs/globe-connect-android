# Installing via Maven Central.

Below are the step by step procedure on how to install the sdk via Maven Central and add it as a dependency to your new / existing android project, below also shows the list of the requirements for the sdk to work properly.

## Requirements

- Java >= 7
- Android SDK (minimum version 14, target version 25)
- Android API 16 to 24 is the current support.
- Android Studio (or other IDE with the same functionality, we will use Android Studio for most of the examples).

### Step 1. Configuring Gradle.

The other way and the most easiest way to add the sdk as a dependency of your project is to put it into your gradle script, first we have to add the sdk into the dependency list by adding this little snippet of code to your app's build.gradle script:

Under the "dependencies" section...
```java
dependencies {
    ...
    compile 'ph.com.globe.connect:globe-connect-android:0.0.7'
}
```

We also need to put some compilation options on our app's build.gradle.

Under the "defaultConfig" section...
```java
defaultConfig {
    ...
    jackOptions {
        enabled true
    }
}
```

We also need to specify the compileOptions...
```java
compileOptions {
    sourceCompatibility JavaVersion.VERSION_1_7
    targetCompatibility JavaVersion.VERSION_1_7
}
```

And lastly under your app's AndroidManifest.xml

```xml
<uses-permission android:name="android.permission.INTERNET" />
```

Now you should be able to see the autocompletion for the globe connect module, you can test it out by trying to import the module using the namespace ph.com.globe.connect, the autocomplete result should look like this:
![Auto Complete](manual/step-3-d.png)

When you start working with the sdk a few import directive is required for you to be able to work with the sdk, you are required to import:
- ```org.json.JSONObject``` (for handling the response results)
- ```org.json.JSONException``` (for handling json parsing errors)

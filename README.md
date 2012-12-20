CordovaPlugin_AndroidSmsRead
============================

Plugin for Cordova, giving access to SMS message boxes on Android.

MainActivity.java - Adroid PhoneGap/Cordova application example program.
(c) 2012 David C. Walley. davidwalley.ca
This work is licensed under the Creative Commons Attribution 3.0 Unported License. To
view a copy of this license, visit http://creativecommons.org/licenses/by/3.0/.

This is a full example of a Cordova (PhoneGap) plug-in to read text message boxes.
Warning: it uses undocumented features of Android 4.2 and Cordova 2.2

This is also an example of coding in DAVES style. More about DAVES at: davidwalley.ca.

Uses the following Android native-side of the Cordova (formerly 'PhoneGap') plug-in
(with directories as in a project created with eclipse Android Developer Tools v21.0.0)
    src/CordovaPlugin_SmsRead.java                                                      // The Android Java native-side of plug-in for Cordova.
Copy the following file into your project's libs directory:
    cordova-2.2.0.jar
Ensure the following is in res/xml/config.xml, <plugins> section:
    <plugin name="CordovaPlugin_SmsRead"                                                // Give the name
        value="ca.davidwalley.cordovaplugin_androidsmsexample.CordovaPlugin_SmsRead"/>  // and world-wide unique full package name of the plug-in.
and JavaScript (for a Cordova(PhoneGap) application), and GUI stuff:                    // The following are the website-like definition of the Cordova app:
    assets/www/library/plugin_SmsRead.js                                                // Provide this file, the JavaScript connection to the plug-in.
    assets/www/index.html                                                               // Provide a starting point GUI for our simple example, coded in HTML.
    assets/www/SmsReaderExample.js                                                      // Provide JavaScript defining the logic of this Cordova example application.
You will want to add:                                                                   // This is a Cordova app, so you will need
    assets/www/library/cordova-2.2.0.js                                                 // some JavaScript implementation of Cordova.
For this example, you will probably want to add:                                        // This example app happens to use jQuery mobile, so
    assets/www/library/jquery.mobile-1.2.0.min.css                                      // include jQuery mobile styles
    assets/www/library/jquery.mobile-1.2.0.min.js                                       // and some jQuery mobile JavaScript library,
    assets/www/library/jquery-1.8.3.min.js                                              // and some jQuery version.
You must modify AndroidManifest.xml to include (in manifest section):                   // Need to specify some options for our Android app:
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />          // ??? Not sure of exact reason this permission is needed, but it appears to be.
    <uses-permission android:name="android.permission.READ_SMS"/>                       // This is permission to access text messages, which is the subject matter of this example.
Ensure that you also have (as part of setting up Android Cordova/PhoneGap):
    <activity android:name="org.apache.cordova.DroidGap" ... >                          // This refers to Cordova (formerly PhoneGap) for Android, which is what this plug-in example plugs in to.
as well as another, existing activity??? somthing like the following:
            <activity                                                                   // ??? Is this as simple as it can be? I guess not.
    android:name="ca.davidwalley.cordovaplugin_androidsmsexample.MainActivity"          // Edit this for your app.
    android:configChanges="orientation|keyboardHidden"
                android:label="@string/app_name" >
                <intent-filter>
                    <action android:name="android.intent.action.MAIN" />
                    <category android:name="android.intent.category.LAUNCHER" />
                </intent-filter>
            </activity>

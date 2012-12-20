/// MainActivity.java - Adroid PhoneGap/Cordova application example program.                //                          [2012-12-17 davidwalley.ca D4F7]
// (c) 2012 David C. Walley. davidwalley.ca                                                 //                          [2012-12-14 davidwalley.ca F59E 2012-12-18 davidwalley.ca]
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To    //                          [2012-12-17 davidwalley.ca AC60]
// view a copy of this license, visit http://creativecommons.org/licenses/by/3.0/.          //                          [2012-12-17 davidwalley.ca 1FA2]
// This is also an example of coding in DAVES style. More about DAVES at: davidwalley.ca.   //                          [2012-12-17 davidwalley.ca 1E2B]

package ca.davidwalley.cordovaplugin_androidsmsread;                                     // This is the package name David C. Walley chose for this example.   [2012-12-17 davidwalley.ca 7C29]
                                                                                            //
                                                                                            //
//////////////////////////////////////////////////////////////////////////////////////////////                          [2012-12-17 davidwalley.ca 202F]
public class ///////////////////////////////////////////////////////////////////////////////// Define a set of related procedure for the following:   [2012-12-14 davidwalley.ca 1EB1]
                                MainActivity ///////////////////////////////////////////////// This application is defined in the standard way   [2012-12-14 davidwalley.ca 68B7]
extends                         org.apache.cordova.DroidGap ////////////////////////////////// using the Cordova (previously known as PhoneGap) cross-system framework   [2012-12-14 davidwalley.ca CDFD]
{///////////////////////////////////////////////////////////////////////////////////////////// .                        [2012-12-14 davidwalley.ca 207B]
                                                                                            //
 @Override public void          ////////////////////////////////////////////////////////////// Over-ride the parent class's procedure to:   [2012-12-14 davidwalley.ca ABB5]
                                onCreate(//                                                 // Handle the initialization of this application.   [2012-12-14 davidwalley.ca EED8]
 android.os.Bundle               a_bundleSavedInstanceState                                 // Given information to be passed along to the parent object,   [2012-12-14 davidwalley.ca D4F9]
 ){                             ////////////////////////////////////////////////////////////// Report nothing.          [2012-12-14 davidwalley.ca 0D19]
  super.onCreate(a_bundleSavedInstanceState);                                               // We must run the DroidGap parent's equivalent of this procedure.   [2012-12-14 davidwalley.ca C043]
  super.loadUrl("file:///android_asset/www/index.html");                                    // Define a file in this project as the GUI page (there is only one, which gets modified by JavaScript code).   [2012-12-14 davidwalley.ca E172]
 }///onCreate///////////////////////////////////////////////////////////////////////////////// End of this procedure.   [2012-12-14 davidwalley.ca 77A7]
                                                                                            //
}///class MainActivity//////////////////////////////////////////////////////////////////////// End of the set of application related procedures.   [2012-12-14 davidwalley.ca 071C]
//////////////////////////////////////////////////////////////////////////////////////////////                          [2012-12-17 davidwalley.ca 202F]
                                                                                            //
//End of File
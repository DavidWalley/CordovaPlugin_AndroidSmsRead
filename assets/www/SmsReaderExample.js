// SmsReaderExample.js - JavaScript code for example Cordova app, using an Android SMS reader plug-in. //               [2012-12-11 davidwalley.ca 1E19 2012-12-18 davidwalley.ca]
// (c) 2012 David C. Walley. davidwalley.ca                                                 //                          [2012-12-14 davidwalley.ca F59E 2012-12-18 davidwalley.ca]
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To    //                          [2012-12-17 davidwalley.ca AC60]
// view a copy of this license, visit http://creativecommons.org/licenses/by/3.0/.          //                          [2012-12-17 davidwalley.ca 1FA2]
// This is also an example of coding in DAVES style. More about DAVES at: davidwalley.ca.   //                          [2012-12-17 davidwalley.ca 1E2B]

// This code is the main part of a Cordova (was PhoneGap) application to grab info out of   //                          [2012-12-14 davidwalley.ca 0E17 2012-12-17 davidwalley.ca]
// the SMS text message records in Android 4.2.  Unfortunately, it uses an undocumented     //                          [2012-12-17 davidwalley.ca C28F]
// database/file format which may change with future versions of Android and/or Cordova.    //                          [2012-12-17 davidwalley.ca E834]
                                                                                            //
                                                                                            //
function                        ////////////////////////////////////////////////////////////// Define a procedure to:   [2012-12-11 davidwalley.ca ED11]
                                SmsReaderExampleGo(//                                       // Run the example code to read the text-messaging inbox, displaying results to the user.   [2012-12-17 davidwalley.ca 2FCE]
                                 a_sInboxOrSent                                             // given "inbox" or "sent" to specify which message box to use.   [2012-12-18 davidwalley.ca B40C]
){                              ////////////////////////////////////////////////////////////// Report nothing           [2012-12-11 davidwalley.ca 0D19]
 window.plugin_smsread.Get(                                                                 // Call the main method of the plug-in, to get SMS records:   [2012-12-15 davidwalley.ca 8031 2012-12-16 davidwalley.ca]
  a_sInboxOrSent                                                                            // passing along "inbox" or "sent",   [2012-12-16 davidwalley.ca B40C 2012-12-18 davidwalley.ca]
 ,[0 ,10]                                                                                   // and start index, together with maximum number of results to return.   [2012-12-15 davidwalley.ca 565B 2012-12-17 davidwalley.ca]
                                                                                            //
 ,function(a_a2sResult){                                                                    // On success of the above, run the following:   [2012-12-15 davidwalley.ca 1A7B 2012-12-17 davidwalley.ca]
   var                          sResults                  = "";                             // Start building a results string for display, from scratch.   [2012-12-15 davidwalley.ca A122 2012-12-17 davidwalley.ca]
   for( var i = 0; i < a_a2sResult.length; i++ ){                                           // Scroll through the returned data, and   [2012-12-15 davidwalley.ca E0C2 2012-12-17 davidwalley.ca]
    sResults += "'"+ a_a2sResult[i].address +"','"+ a_a2sResult[i].body +"'<br />";         // add the contents of the phone number and message contents fields to the results text string.   [2012-12-15 davidwalley.ca D7DA 2012-12-17 davidwalley.ca]
   }//for i                                                                                 // Repeat.                  [2012-12-15 davidwalley.ca A7A7]
   sResults += "--- End of results ---";                                                    // Inform user of end of list.   [2012-12-17 davidwalley.ca E765]
   jQuery("#divResults").html(sResults);                                                    // Display the results text string in the web-page division.   [2012-12-15 davidwalley.ca 7BBC 2012-12-17 davidwalley.ca]
  }//function                                                                               // End of success procedure.   [2012-12-15 davidwalley.ca 09B7]
                                                                                            //
 ,function(){ alert("Error getting "+ a_sInboxOrSent +"."); }                               // But, on error, inform the user and quit.   [2012-12-15 davidwalley.ca 00F0 2012-12-18 davidwalley.ca]
 );///window.plugin_smsread.Get                                                             // End of the call to the plug-in.   [2012-12-15 davidwalley.ca 1E4A 2012-12-17 davidwalley.ca]
}///SmsReaderExampleGo//////////////////////////////////////////////////////////////////////// End of this procedure.   [2012-12-11 davidwalley.ca 72F1 2012-12-17 davidwalley.ca]
                                                                                            //
                                                                                            //
function                        ////////////////////////////////////////////////////////////// Define a procedure to:   [2012-12-11 davidwalley.ca ED11]
                                onDeviceReady(//                                            // Do setup stuff when everything (with the browser's DOM) is ready.   [2012-12-11 davidwalley.ca 7C14]
){                              ////////////////////////////////////////////////////////////// Report nothing           [2012-12-11 davidwalley.ca 0D19]
 /// Nothing to initialize so far.                                                          //                          [2012-12-18 davidwalley.ca BAD7]
}//onDeviceReady////////////////////////////////////////////////////////////////////////////// End of this procedure.   [2012-12-11 davidwalley.ca FCA2]
                                                                                            //
                                                                                            //
document.addEventListener("deviceready", onDeviceReady, false);                             // When everything (in the DOM) is ready, run the designated routine.   [2012-12-11 davidwalley.ca A6DA]
                                                                                            //
// End of File
/// plugin_SmsRead.js - Cordova plugin for reading SMS text messages from inbox or sent.    //                          [2012-12-15 davidwalley.ca 18DB 2012-12-18 davidwalley.ca]
// (c) 2012 David C. Walley. davidwalley.ca                                                 //                          [2012-12-14 davidwalley.ca F59E 2012-12-18 davidwalley.ca]
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To    //                          [2012-12-17 davidwalley.ca AC60]
// view a copy of this license, visit http://creativecommons.org/licenses/by/3.0/.          //                          [2012-12-17 davidwalley.ca 1FA2]
// This is also an example of coding in DAVES style. More about DAVES at: davidwalley.ca.   //                          [2012-12-17 davidwalley.ca 1E2B]
                                                                                            //
// The JavaScript portion of a plugin always uses the cordova.exec method as follows:       //                          [2012-12-16 davidwalley.ca 587E]
//  exec(<successFunction>, <failFunction>, <service>, <action>, [<args>]);                 //                          [2012-12-16 davidwalley.ca 710E]
// The plugin must be added to the config.xml file in your Cordova-Android application's    //                          [2012-12-16 davidwalley.ca 7EC9]
// res/xml/ folder.                                                                         //                          [2012-12-16 davidwalley.ca CF44]
//  <plugin name="<service_name>" value="<full_name_including_namespace>"/>                 //                          [2012-12-16 davidwalley.ca 14ED]
// The service name should match what you use in the JavaScript exec call, and the value    //                          [2012-12-16 davidwalley.ca 8FB2]
// will be the full name of the Java class including the namespace. Without this added, the //                          [2012-12-16 davidwalley.ca E1F6]
// plugin may compile but will not be reachable by Cordova.                                 //                          [2012-12-16 davidwalley.ca 8B3C]
                                                                                            //
                                                                                            //
var                             oPlugin_SmsRead         = function(){};                     // Create an empty object ready to have some procedures associated with it.   [2012-12-15 davidwalley.ca 39BE 2012-12-17 davidwalley.ca]
                                                                                            //
                                                                                            //
                                oPlugin_SmsRead.////////////////////////////////////////////// Associate with objects of this class:   [2012-12-15 davidwalley.ca F60D 2012-12-17 davidwalley.ca]
prototype.                      Get  =function(//                                           // a main procedure, which reads records of received SMS text messages.   [2012-12-15 davidwalley.ca 36B2]
                                 a_sAction                                                  // Given "inbox" or "sent,   [2012-12-15 davidwalley.ca BABF]
,                                a_aStartAndNumber                                          // an array with the start index and maximum number of results to return (this JavaScript array is translated into a JSON formatted array on the Java side)   [2012-12-17 davidwalley.ca 64A9]
,                                a_OnSuccess                                                // a method to run on success, and   [2012-12-15 davidwalley.ca 51E2]
,                                a_OnError                                                  // a method to run on failure.   [2012-12-15 davidwalley.ca C8BD]
){                              ////////////////////////////////////////////////////////////// Report nothing.          [2012-12-15 davidwalley.ca 0D19]
 cordova.exec(                                                                              // This runs the plug-in native-side code. We pass along   [2012-12-15 davidwalley.ca 736D 2012-12-16 davidwalley.ca]
  function(a){ a_OnSuccess(a); }                                                            // the method to run on success, and   [2012-12-15 davidwalley.ca 840E]
 ,function(a){ a_OnError(  a); }                                                            // the method to run on failure,   [2012-12-15 davidwalley.ca CE4E]
 ,'CordovaPlugin_SmsRead'                                                                   // Name of java class (and file), for handling the native Android side.   [2012-12-17 davidwalley.ca 037B]
 ,a_sAction                                                                                 // name of action, nominally a subroutine, in the class file.   [2012-12-15 davidwalley.ca 0CF4 2012-12-17 davidwalley.ca]
 ,a_aStartAndNumber                                                                         // an array with the start index and maximum number of results to return (this JavaScript array is translated into a JSON formatted array on the Java side)   [2012-12-17 davidwalley.ca C4B9]
 );                                                                                         // .                        [2012-12-15 davidwalley.ca 0D59 2012-12-16 davidwalley.ca]
};///Get////////////////////////////////////////////////////////////////////////////////////// End of this procedure.   [2012-12-15 davidwalley.ca 87E0]
                                                                                            //
                                                                                            //
window.plugin_smsread = new oPlugin_SmsRead();                                              // Create an instance of the above object prototype (class), and remember it as an application global object.   [2012-12-14 davidwalley.ca CB21 2012-12-17 davidwalley.ca]
                                                                                            //
//End of File
/// CordovaPlugin_SmsRead.java - A Cordova (PhoneGap) plug-in for Android, to get info from text messaging inbox and sent box. //   [2012-12-16 davidwalley.ca 5BEF 2012-12-17 davidwalley.ca]
// (c) 2012 David C. Walley. davidwalley.ca                                                 //                          [2012-12-14 davidwalley.ca F59E 2012-12-18 davidwalley.ca]
// This work is licensed under the Creative Commons Attribution 3.0 Unported License. To    //                          [2012-12-17 davidwalley.ca AC60]
// view a copy of this license, visit http://creativecommons.org/licenses/by/3.0/.          //                          [2012-12-17 davidwalley.ca 1FA2]
// This is also an example of coding in DAVES style. More about DAVES at: davidwalley.ca.   //                          [2012-12-17 davidwalley.ca 1E2B]
                                                                                            //
// The is the native-side Android Java code for a Cordova (formerly PhoneGap) plug-in, to   //                          [2012-12-18 davidwalley.ca 0626]
// get info out of the records for the device's text message boxes. It uses undocumented    //                          [2012-12-18 davidwalley.ca 0914]
// procedures that may fail to work in future versions.  It has worked in Cordova 2.2.0 and //                          [2012-12-18 davidwalley.ca 47A1]
// Android 4.2,                                                                             //                          [2012-12-18 davidwalley.ca 5619]
                                                                                            //
package ca.davidwalley.cordovaplugin_androidsmsread;                                     // This is the package name David C. Walley chose for this example.   [2012-12-17 davidwalley.ca 7C29]
                                                                                            //
import org.apache.cordova.api.*;                                                            // Uses the Cordova Plug-in API to abbreviate   [2012-12-14 davidwalley.ca 28A0 2012-12-15 davidwalley.ca]
                                                                                            //
public class /////////////////////////////////////////////////////////////////////////////////                          [2012-12-15 davidwalley.ca 1EB1]
                                CordovaPlugin_SmsRead ////////////////////////////////////////                          [2012-12-15 davidwalley.ca 961A 2012-12-16 davidwalley.ca]
extends                         CordovaPlugin ////////////////////////////////////////////////                          [2012-12-15 davidwalley.ca 4F43 2012-12-16 davidwalley.ca]
{/////////////////////////////////////////////////////////////////////////////////////////////                          [2012-12-15 davidwalley.ca 207B]
                                                                                            //
 @Override public boolean       //////////////////////////////////////////////////////////////                          [2012-12-16 davidwalley.ca 47AD]
                                execute(//                                                  // Override the execute() method in order to recieve messages from exec().   [2012-12-16 davidwalley.ca 1A43]
  String                         a_sAction                                                  // Either "inbox" or "sent",   [2012-12-15 davidwalley.ca 0EBE]
 ,org.json.JSONArray             a_jsonaFirstAndNumber                                      // arguments passed in from JavaScript,   [2012-12-15 davidwalley.ca 3F29 2012-12-16 davidwalley.ca]
 ,CallbackContext                a_callbackcontext                                          //                          [2012-12-16 davidwalley.ca 2A9D]
 ){                             ////////////////////////////////////////////////////////////// Report true if action found, false if not.   [2012-12-15 davidwalley.ca 0D19]
  if( ! "inbox".equals(a_sAction)   &&   ! "sent".equals(a_sAction) ){                      // Compare the action parameter against recognized actions, and   [2012-12-15 davidwalley.ca 76C2 2012-12-16 davidwalley.ca]
 return false;                                                                              // any other action will return false, which results in an error of type INVALID_ACTION - this will translate into an error callback invocation on the JavaScript side. Returning false results in a "MethodNotFound" error   [2012-12-16 davidwalley.ca B775]
  }//if                                                                                     // .                        [2012-12-15 davidwalley.ca 0724]
                                                                                            //
  try{                                                                                      // Watch for exceptional errors in the following block of code:   [2012-12-15 davidwalley.ca 65F5]
   int                          iFirst    = (int)a_jsonaFirstAndNumber.getLong(0);          // From the given array of parameters, get the first index to return   [2012-12-16 davidwalley.ca E176]
   int                          iEnd      = (int)a_jsonaFirstAndNumber.getLong(1) + iFirst; // and calculate the last from the number to return.   [2012-12-16 davidwalley.ca 53BC]
                                                                                            // Content Providers - you address them by Url, query them with SQL, and iterate them with a Cursor:   [2012-12-17 davidwalley.ca 0000]
   android.net.Uri              uriSmsAction            =                                   // Create and remember a Uri   [2012-12-15 davidwalley.ca 8B94]
       android.net.Uri.parse("content://sms/"+ a_sAction);                                  // by parsing the given encoded URI string conforming to RFC 2396. The Android team isn�t promising that it�ll be the same in the next release or even that it�ll be there in the next release.   [2012-12-15 davidwalley.ca 7BAE]
/// Available Uri strings:                                                                  //                          [2012-12-16 davidwalley.ca 5C83]
///   String strUriInbox         = "content://sms/inbox";                                   // SMS_INBOX:       1       [2012-12-16 davidwalley.ca 90DE]
///   String strUriFailed        = "content://sms/failed";                                  // SMS_FAILED:      2       [2012-12-16 davidwalley.ca 7EAF]
///   String strUriQueued        = "content://sms/queued";                                  // SMS_QUEUED:      3       [2012-12-16 davidwalley.ca 4FE9]
///   String strUriSent          = "content://sms/sent";                                    // SMS_SENT:        4       [2012-12-16 davidwalley.ca 2A8C]
///   String strUriDraft         = "content://sms/draft";                                   // SMS_DRAFT:       5       [2012-12-16 davidwalley.ca 2538]
///   String strUriOutbox        = "content://sms/outbox";                                  // SMS_OUTBOX:      6       [2012-12-16 davidwalley.ca A76E]
///   String strUriUndelivered   = "content://sms/undelivered";                             // SMS_UNDELIVERED          [2012-12-16 davidwalley.ca 610D]
///   String strUriAll           = "content://sms/all";                                     // SMS_ALL                  [2012-12-16 davidwalley.ca 5A9C]
///   String strUriConversations = "content://sms/conversations";                           // you can delete one conversation by thread_id   [2012-12-16 davidwalley.ca 9699]
///   String strUriAll           = "content://sms";                                         // you can delete one message by _id   [2012-12-16 davidwalley.ca 2ACD]
                                                                                            //
   android.database.Cursor      cursorSmsAction         =                                   //                          [2012-12-15 davidwalley.ca 62BC]
       cordova.getActivity().getContentResolver().query(uriSmsAction,null,null,null,null);  //                          [2012-12-16 davidwalley.ca 6648]
                                                                                            //
   org.json.JSONArray           r_jsona                 = new org.json.JSONArray();         // Start a list of results.   [2012-12-15 davidwalley.ca C5DB 2012-12-17 davidwalley.ca]
   for( int i = 0; i < iEnd   &&   cursorSmsAction.moveToNext(); i++ ){                     //                          [2012-12-15 davidwalley.ca D535 2012-12-16 davidwalley.ca]
    if( iFirst <= i ){                                                                      //                          [2012-12-16 davidwalley.ca C88D]
     org.json.JSONObject        jsonoRow                = new org.json.JSONObject();        //                          [2012-12-15 davidwalley.ca 0410]
     jsonoRow.put("_id"                ,cursorSmsAction.getString( 0));                     //                          [2012-12-17 davidwalley.ca A7ED]
     jsonoRow.put("thread_id"          ,cursorSmsAction.getString( 1));                     //                          [2012-12-17 davidwalley.ca CEB8]
     jsonoRow.put("address"            ,cursorSmsAction.getString( 2));                     // The phone number.        [2012-12-17 davidwalley.ca F40D]
     jsonoRow.put("person"             ,cursorSmsAction.getString( 3));                     //                          [2012-12-17 davidwalley.ca 5A62]
     jsonoRow.put("date"               ,cursorSmsAction.getString( 4));                     //                          [2012-12-17 davidwalley.ca B517]
     jsonoRow.put("protocol"           ,cursorSmsAction.getString( 5));                     //                          [2012-12-17 davidwalley.ca C7A6]
     jsonoRow.put("read"               ,cursorSmsAction.getString( 6));                     //                          [2012-12-17 davidwalley.ca 0E02]
     jsonoRow.put("status"             ,cursorSmsAction.getString( 7));                     //                          [2012-12-17 davidwalley.ca 32F9]
     jsonoRow.put("type"               ,cursorSmsAction.getString( 8));                     //                          [2012-12-17 davidwalley.ca 0EA3]
     jsonoRow.put("reply_path_present" ,cursorSmsAction.getString( 9));                     //                          [2012-12-17 davidwalley.ca 9294]
     jsonoRow.put("subject"            ,cursorSmsAction.getString(10));                     //                          [2012-12-17 davidwalley.ca 98E2]
     jsonoRow.put("body"               ,cursorSmsAction.getString(11));                     // the text that was sent   [2012-12-17 davidwalley.ca B484]
     jsonoRow.put("service_center"     ,cursorSmsAction.getString(12));                     //                          [2012-12-17 davidwalley.ca E2D1]
     jsonoRow.put("locked"             ,cursorSmsAction.getString(13));                     //                          [2012-12-17 davidwalley.ca 7103]
     jsonoRow.put("error_code"         ,cursorSmsAction.getString(14));                     //                          [2012-12-17 davidwalley.ca D705]
     jsonoRow.put("seen"               ,cursorSmsAction.getString(15));                     // .                        [2012-12-17 davidwalley.ca 7368]
     r_jsona.put(jsonoRow);                                                                 //                          [2012-12-15 davidwalley.ca 0F43 2012-12-17 davidwalley.ca]
   }}//if//for i                                                                            //                          [2012-12-15 davidwalley.ca BCAB 2012-12-16 davidwalley.ca]
                                                                                            //
   a_callbackcontext.success(r_jsona);                                                      // call success() to invoke the success callback on the JavaScript side, passing the results into the JavaScript success callback function   [2012-12-16 davidwalley.ca 3B25 2012-12-17 davidwalley.ca]
                                                                                            //
  }catch( org.json.JSONException e ){                                                       // If there was an exceptional error then   [2012-12-15 davidwalley.ca 0853 2012-12-16 davidwalley.ca]
   a_callbackcontext.error("Plug-in error: "+ e);                                           // If it is, we call error() to invoke the error callback on the JavaXcript side.   [2012-12-16 davidwalley.ca FA54]
  }//try                                                                                    // .                        [2012-12-15 davidwalley.ca 8302]
                                                                                            //
 return true;                                                                               //                          [2012-12-16 davidwalley.ca 6823]
 }///execute////////////////////////////////////////////////////////////////////////////////// End of this procedure.   [2012-12-15 davidwalley.ca F3D3]
                                                                                            //
}///class CordovaPlugin_SmsRead///////////////////////////////////////////////////////////////                          [2012-12-15 davidwalley.ca A62D 2012-12-16 davidwalley.ca]
//////////////////////////////////////////////////////////////////////////////////////////////                          [2012-12-15 davidwalley.ca 202F]
                                                                                            //
//End of File
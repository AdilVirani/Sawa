package io.sawa.android.sawa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle =intent.getExtras();
        SmsMessage[] messages = null;
        String str = "";
        if(bundle!=null){

            Object[] pdus = (Object[])bundle.get("pdus");
            messages = new SmsMessage[pdus.length];
            int l = 0;
            for (int i=0; i<messages.length; i++)
            {

                messages[i]=SmsMessage.createFromPdu((byte[])pdus[i]);
                String balance = messages[i].getMessageBody().toString();
                String checkPhrase = "New M";

                for(int z=0; z<messages[i].getMessageBody().toString().length()-4; z++)
                {

                    if(checkPhrase.equals(messages[i].getMessageBody().toString().substring(z, z+4))){
                           l = z;}

                }

                balance = messages[i].getMessageBody().toString().substring(l,messages[i].getMessageBody().toString().length());
                str+= "Message from " + messages[i].getOriginatingAddress() + " :"
                        + balance + "\n";

            }
            Toast.makeText(context, str, Toast.LENGTH_SHORT).show();

        }

    }
}
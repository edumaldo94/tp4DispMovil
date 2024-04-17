package com.softulp.simulacro.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class Llamada extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        boolean modoWifi= intent.getBooleanExtra("connected", false);
        if(modoWifi){
            Intent intent1 = new Intent(Intent.ACTION_CALL);
            intent1.setData(Uri.parse("tel:"+"2222333445"));
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent1);
            //context.getApplicationContext().startActivity(intent1);
        }else{
            Toast.makeText(context, "Wifi Desactivado, No se puede llamar",Toast.LENGTH_LONG).show();
        }


    }
}

package com.sruthy.call;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends BroadcastReceiver {

SharedPreferences sharedPreferences;
    @Override
    public void onReceive(Context context, Intent intent) {
sharedPreferences=context.getSharedPreferences("number",Context.MODE_PRIVATE);

        Bundle extras = intent.getExtras();
        if (extras != null) {
            String state = extras.getString(TelephonyManager.EXTRA_STATE);
            Log.w("MY_DEBUG_TAG", state);
            if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
                String phoneNumber = extras
                        .getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.w("MY_DEBUG_TAG", phoneNumber);

                if (Objects.equals(phoneNumber,sharedPreferences.getString("num",null))) {
                    AudioManager audioManager=(AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
Toast.makeText(context,sharedPreferences.getString("num",null),Toast.LENGTH_LONG).show();

                        audioManager.adjustVolume(AudioManager.ADJUST_RAISE,AudioManager.FLAG_PLAY_SOUND);
                   MediaPlayer m=MediaPlayer.create(context,R.raw.erty);
                   m.start();
                    AudioManager am =
                            (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

                    assert am != null;
                    am.setStreamVolume(
                            AudioManager.STREAM_MUSIC,
                            am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),
                            0);
                        Toast.makeText(context,phoneNumber,Toast.LENGTH_LONG).show();
                    // Toast.makeText(context,phoneNumber+"ok",Toast.LENGTH_LONG).show();

                }


            }

        }

    }

}
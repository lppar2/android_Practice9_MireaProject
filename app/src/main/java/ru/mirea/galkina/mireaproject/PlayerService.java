package ru.mirea.galkina.mireaproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class PlayerService extends Service {
    private MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        mediaPlayer=MediaPlayer.create(this, R.raw.music);
        mediaPlayer.setLooping(true);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        mediaPlayer.start();
        Log.d("Music", "Music started");
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}

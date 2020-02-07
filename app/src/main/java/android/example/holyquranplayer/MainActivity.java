package android.example.holyquranplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button play,stop,pause;
    int pasuePosition;
    MediaPlayer mediaPlayer;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        pause = (Button) findViewById(R.id.pause);
        stop = (Button) findViewById(R.id.stop);
        imageView = (ImageView) findViewById(R.id.imageView);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.play:
            if(mediaPlayer == null){
              mediaPlayer = MediaPlayer.create(getApplicationContext() , R.raw.mohamedseddik);
              mediaPlayer.start();
              imageView.setVisibility(View.VISIBLE);
            } else if (!mediaPlayer.isPlaying()){
                mediaPlayer.seekTo(pasuePosition);
                mediaPlayer.start();
                imageView.setVisibility(View.VISIBLE);
            }
           break;

            case R.id.pause:
                if(mediaPlayer != null) {
                    mediaPlayer.pause();
                    pasuePosition = mediaPlayer.getCurrentPosition();
                    imageView.setVisibility(View.GONE);
                }

                break;


            case R.id.stop:

                if(mediaPlayer != null){
                    mediaPlayer.stop();
                   mediaPlayer=null;
                    imageView.setVisibility(View.GONE);

                }
        }

    }
}

package soundoftheanimals.cursoandroid.com.soundoftheanimals;

import android.app.Activity;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    private ImageView imageDog;
    private ImageView imageCat;
    private ImageView imageLion;
    private ImageView imageMonkey;
    private ImageView imageSheep;
    private ImageView imageCaw;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageDog = findViewById(R.id.imageDogID);
        imageCat = findViewById(R.id.imageCatID);
        imageLion = findViewById(R.id.imageLionID);
        imageMonkey = findViewById(R.id.imageMonkeyID);
        imageSheep = findViewById(R.id.imageSheepID);
        imageCaw = findViewById(R.id.imageCawID);

        imageDog.setOnClickListener(this);
        imageCat.setOnClickListener(this);
        imageLion.setOnClickListener(this);
        imageMonkey.setOnClickListener(this);
        imageSheep.setOnClickListener(this);
        imageCaw.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageDogID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.cao);
                playSound(mediaPlayer);
                break;
            case R.id.imageCatID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.gato);
                playSound(mediaPlayer);
                break;
            case R.id.imageLionID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.leao);
                playSound(mediaPlayer);
                break;
            case R.id.imageMonkeyID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.macaco);
                playSound(mediaPlayer);
                break;
            case R.id.imageSheepID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ovelha);
                playSound(mediaPlayer);
                break;
            case R.id.imageCawID:
                mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.vaca);
                playSound(mediaPlayer);
                break;
        }
    }

    public void playSound(MediaPlayer mediaPlayer){
        if(mediaPlayer != null){
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }
}

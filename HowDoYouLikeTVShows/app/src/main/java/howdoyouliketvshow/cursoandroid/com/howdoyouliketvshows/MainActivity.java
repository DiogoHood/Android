package howdoyouliketvshow.cursoandroid.com.howdoyouliketvshows;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBar;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBarID);
        imageView = findViewById(R.id.ImageViewID);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(progress >= 0 && progress < 4){
                    imageView.setImageResource(R.drawable.pouco);
                }else if(progress >= 4 && progress < 8){
                    imageView.setImageResource(R.drawable.medio);
                }else if(progress >= 8 && progress < 10){
                    imageView.setImageResource(R.drawable.muito);
                }else if(progress == 10){
                    imageView.setImageResource(R.drawable.susto);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}

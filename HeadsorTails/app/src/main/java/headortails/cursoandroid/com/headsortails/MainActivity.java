package headortails.cursoandroid.com.headsortails;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView buttonPlay;
    private String[] option = {"head", "tails"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonPlay  = findViewById(R.id.buttonPlayID);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Gerar números aleatórios
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(2);

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("option", option[randomNumber]);

                startActivity(intent);
            }
        });
    }


}

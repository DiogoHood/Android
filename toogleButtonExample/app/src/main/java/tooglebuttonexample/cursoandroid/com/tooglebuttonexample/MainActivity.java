package tooglebuttonexample.cursoandroid.com.tooglebuttonexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButtonID);
        textView = findViewById(R.id.textViewID);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked == true){
                    Toast.makeText(getApplicationContext(),"true",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"false",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

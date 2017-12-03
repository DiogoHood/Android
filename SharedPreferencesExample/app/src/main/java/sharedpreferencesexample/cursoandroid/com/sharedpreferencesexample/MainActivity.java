package sharedpreferencesexample.cursoandroid.com.sharedpreferencesexample;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView textView;

    private static final String PREFERENCE_FILE = "PreferenceFile";

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextID);
        button = findViewById(R.id.buttonID);
        textView = (TextView) findViewById(R.id.textViewID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if(editText.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Please, enter a name!",Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("name",editText.getText().toString());
                    editor.commit();
                    textView.setText("Hello, " + editText.getText().toString());
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE,0);
        if(sharedPreferences.contains("name")){
            String userName = sharedPreferences.getString("name","User undefined");
            textView.setText("Hello, " + userName);
        }else{
            textView.setText("Hello, user undefined!");
        }
    }
}

package radiobuttonexample.cursoandroid.com.radiobuttonexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroupID);
        button = findViewById(R.id.buttonID);
        textView = findViewById(R.id.textViewID);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int idRadioButton = radioGroup.getCheckedRadioButtonId();
                if(idRadioButton > 0){
                    radioButton = findViewById(idRadioButton);
                    textView.setText(radioButton.getText());
                }

            }
        });
    }
}

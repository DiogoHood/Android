package colorpreference.cursoandroid.com.colorpreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private Button buttonSave;
    private ConstraintLayout layout;
    private static final String PREFERENCE_FILE = "PreferenceFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupID);
        buttonSave = (Button) findViewById(R.id.buttonSaveID);
        layout = (ConstraintLayout) findViewById(R.id.layoutID);

        buttonSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int idRadioButtonChecked = radioGroup.getCheckedRadioButtonId();

                if(idRadioButtonChecked > 0){
                    radioButton = findViewById(idRadioButtonChecked);
                    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE,0);
                    SharedPreferences.Editor  editor = sharedPreferences.edit();

                    String selectedColor = radioButton.getText().toString();
                    editor.putString("SelectedColor",selectedColor);
                    editor.commit();

                    setBackground(selectedColor);
                }
            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_FILE,0);
        if(sharedPreferences.contains("SelectedColor")){
            String selectedColor = sharedPreferences.getString("SelectedColor","Blue");
            setBackground(selectedColor);
        }
    }

    private void setBackground(String selectedColor){

        if(selectedColor.equals("Red")){
            layout.setBackgroundColor(Color.parseColor("#FF0000"));
        }else if(selectedColor.equals("Green")){
            layout.setBackgroundColor(Color.parseColor("#00FF00"));
        }else if(selectedColor.equals("Blue")){
            layout.setBackgroundColor(Color.parseColor("#0000FF"));
        }
    }
}

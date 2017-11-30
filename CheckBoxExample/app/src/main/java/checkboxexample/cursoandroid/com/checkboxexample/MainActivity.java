package checkboxexample.cursoandroid.com.checkboxexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button buttonShow;
    private CheckBox checkBoxDog;
    private CheckBox checkBoxCat;
    private CheckBox checkBoxPig;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonShow = findViewById(R.id.buttonShowID);
        checkBoxDog = findViewById(R.id.checkBoxDogID);
        checkBoxCat = findViewById(R.id.checkBoxCatID);
        checkBoxPig = findViewById(R.id.checkBoxPigID);
        textView = findViewById(R.id.textViewID);

        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selecteditems = "";

                selecteditems += "Item: " + checkBoxDog.getText() + " Status: " + checkBoxDog.isChecked() + "\n";
                selecteditems += "Item: " + checkBoxCat.getText() + " Status: " + checkBoxCat.isChecked() + "\n";
                selecteditems += "Item: " + checkBoxPig.getText() + " Status: " + checkBoxPig.isChecked() + "\n";

                textView.setText(selecteditems);
            }
        });
    }
}

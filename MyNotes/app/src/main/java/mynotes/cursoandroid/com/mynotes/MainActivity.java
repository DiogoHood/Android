package mynotes.cursoandroid.com.mynotes;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends Activity {

    private EditText text;
    private ImageView buttonSave;
    private static final String fileName = "fileAnnotation.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (EditText) findViewById(R.id.editTextID);
        buttonSave = (ImageView) findViewById(R.id.buttonSaveID);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String typedtext = text.getText().toString();
                try {
                    recordFile(typedtext);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            if(readFile() != null ){
                text.setText(readFile());
            }
        } catch (IOException e) {
            Log.v("MainActivity@onCreate", e.toString());
        }
    }

    @SuppressWarnings("deprecation")
    private void recordFile(String typedtext) throws IOException {

        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(typedtext);
            outputStreamWriter.close();
            Toast.makeText(getApplicationContext(), "Text saved with success!", Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            Log.v("MainActivity@recordFile", e.toString());
        }
    }

    private String readFile() throws IOException {

        InputStream inputStream = null;
        String text = "";

        try{
            //Open file
            inputStream = openFileInput(fileName);
            if(inputStream != null){

                //Read file
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                //Create a buffer of the read file
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                //Recover text of the read file
                String fileLine = "";
                while((fileLine = bufferedReader.readLine()) != null) {
                    text = text + fileLine;
                }

                inputStream.close();
            }

        }catch (FileNotFoundException e){
            Log.v("MainActivity@readFile", e.toString());
        }

        return text;
    }
}

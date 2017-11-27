package headortails.cursoandroid.com.headsortails;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity {

    private ImageView buttonGoBack;
    private ImageView imageResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        buttonGoBack = findViewById(R.id.buttonGoBackID);
        imageResult = findViewById(R.id.imageResultID);

        //Recuperar informação que foi passada da Activity anterior
        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String result = extra.getString("option");

            //Verificar qual foi o resultado e mostrar a imagem referente
            if(result.equals("head")){
                imageResult.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.moeda_cara));
            }else if(result.equals("tails")){
                imageResult.setImageDrawable(ContextCompat.getDrawable(this,R.drawable.moeda_coroa));
            }
        }

        //Caso o botão voltar seja acionado, voltar para a activity principal
        buttonGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResultActivity.this, MainActivity.class));
            }
        });
    }
}

package listviewexample.cursoandroid.com.listviewexample;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ListView list;
    private String[] itens = {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará",
            "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso",
            "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco",
            "Piauí","Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul","Rondônia",
            "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listViewID);

        ArrayAdapter adapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.activity_list_item,
                android.R.id.text1,
                itens
                );

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String state = list.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),state,Toast.LENGTH_SHORT).show();
            }
        });
    }
}

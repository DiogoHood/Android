package signs.cursoandroid.com.signs;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView listSigns;
    String[] signs = {
            "Signo de Aquário (21/1 - 19/2)",
            "Signo de Peixes (20/2 - 20/3)",
            "Signo de Áries (21/3 - 20/4)",
            "Signo de Touro (21/4 - 21/5)",
            "Signo de Gêmeos (22/5 - 21/6)",
            "Signo de Câncer (21/6 - 23/7)",
            "Signo de Leão (24/7 - 23/8)",
            "Signo de Virgem (24/8 - 23/9)",
            "Signo de Libra (24/9 - 23/10)",
            "Signo de Escorpião (24/10 - 22/11)",
            "Signo de Sagitário (23/11 - 21/12)",
            "Signo de Capricórnio (22/12 - 20/1)"
    };
    int[] signsImgs = {
            R.drawable.aquarius,
            R.drawable.pisces,
            R.drawable.aries,
            R.drawable.taurus,
            R.drawable.gemini,
            R.drawable.cancer,
            R.drawable.leo,
            R.drawable.virgo,
            R.drawable.libra,
            R.drawable.scorpio,
            R.drawable.sagittarius,
            R.drawable.capricorn
    };
    private String[] aboutSigns = {"...","...","...","...","","","","","","","",""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listSigns = (ListView) findViewById(R.id.listViewID);
        CustomAdapter adapter = new CustomAdapter(MainActivity.this, signsImgs, signs);

        listSigns.setAdapter(adapter);

//        listSigns.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }
}

package tomi.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    public class Kuuntelija extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent){


            String actioni = "";
            if(intent.getAction() == Intent.ACTION_SCREEN_OFF){
                Log.d("omaOff",intent.getAction());
                actioni = "Näyttö pois päältä: ";
            }else if(intent.getAction() == Intent.ACTION_SCREEN_ON){
                Log.d("omaOn",intent.getAction());
                actioni = "Näyttö päälle: ";
            }

            Date date = new Date();
            Intent intent2 = new Intent(context, IntentPalvelu.class);

            Calendar cal = Calendar.getInstance();
            String aika = formatter.format(cal.getTime());

            ScreeActivity act = new ScreeActivity(actioni+" "+aika);
            intent2.putExtra("date",act);
            context.startService(intent2);
        }



    }

    Kuuntelija kuuntelija;
    SimpleDateFormat formatter;
    Context _context;

    OmaAdapteri entityAdapter;
    ListView listView;

    @Override
    protected void onResume() {
        super.onResume();

        DB db = DB.getInstance(_context);
        List<ScreeActivity> lista = db.getSCDao().lista();
        ArrayList<ScreeActivity> arLista = new ArrayList<ScreeActivity>(lista);

        entityAdapter = new OmaAdapteri(getApplicationContext(),R.layout.omaleiska,arLista);

        listView = (ListView)findViewById(R.id.listaView);
        listView.setAdapter(entityAdapter);
        listView.setVisibility(View.VISIBLE);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _context = getApplicationContext();

        formatter = new SimpleDateFormat("dd.mm.yyyy HH:mm:ss");

        IntentFilter intentFilter = new IntentFilter();
        kuuntelija = new Kuuntelija();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(kuuntelija,intentFilter);
    }
}

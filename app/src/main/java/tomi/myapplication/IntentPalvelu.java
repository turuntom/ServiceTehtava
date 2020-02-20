package tomi.myapplication;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;

public class IntentPalvelu extends IntentService {

    private static final String TAG = "IntentPalvelu";

    public IntentPalvelu(){
        super("palveluNimi");
        //setIntentRedelivery(true);
    }

    public IntentPalvelu(String name) {
        super(name);
        //setIntentRedelivery(true);
    }

    Context context;
    SimpleDateFormat formatter;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d(TAG, "OnHandleIntent");

        ScreeActivity screeActivity = (ScreeActivity)intent.getSerializableExtra("date");
        Log.d(TAG, "TAGISSA OLEVA AIKA KUNDEILLE ESITELTÄVÄKSI TÄNÄÄN DISKOSSA JOO TÄSSÄ TULEE A_I_K_A"+screeActivity.aika);

        DB db = DB.getInstance(getApplicationContext());
        db.getSCDao().InsertScreeAction(new ScreeActivity(screeActivity.aika));
    }
}

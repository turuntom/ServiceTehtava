package tomi.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class OmaAdapteri extends ArrayAdapter<ScreeActivity> {

    private Context context;
    private LayoutInflater layoutInflater;

    private TextView tekstiView;

    private ArrayList<ScreeActivity> entities;

    public OmaAdapteri(@NonNull Context context, int resource, @Nullable ArrayList<ScreeActivity> entities) {
        super(context, resource, entities);
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.entities = entities;

    }



    @Override
    public void add(@Nullable ScreeActivity object) {
        super.add(object);
        entities.add(object);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        View view = layoutInflater.inflate(R.layout.omaleiska, parent, false);

        tekstiView = (TextView)view.findViewById(R.id.tekstiView);



        tekstiView.setText(entities.get(position).aika);




        return view;

    }

}
package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Titio on 03/09/2017.
 */

public class EventosAdapter extends ArrayAdapter<Eventos> {

    private final Context context;
    private final ArrayList<Eventos> elementos;

    public EventosAdapter(Context context, ArrayList<Eventos> elementos) {
        super(context, R.layout.listadeeventos, elementos);
        this.context= context;
        this.elementos= elementos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.listadeeventos, parent , false);

        TextView nomeDoEvento = (TextView) rowView.findViewById(R.id.nomeDoEvento);
        TextView nomeDoOrga = (TextView) rowView.findViewById(R.id.nomeDoOrga);
        TextView dataInicio = (TextView) rowView.findViewById(R.id.dataDeInicio);
        ImageButton imageButton = (ImageButton) rowView.findViewById(R.id.testeImage);
        imageButton.setFocusable(false);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Teste" , Toast.LENGTH_LONG).show();
            }
        });
        nomeDoEvento.setText(elementos.get(position).getNomeDoEvento());
        nomeDoOrga.setText(elementos.get(position).getNomeDoOrga());
        dataInicio.setText(elementos.get(position).getDataDeInicio());

        return rowView;
    }
}

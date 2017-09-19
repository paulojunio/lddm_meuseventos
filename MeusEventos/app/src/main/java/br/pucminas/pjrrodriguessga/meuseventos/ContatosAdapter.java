package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Titio on 14/09/2017.
 */

public class ContatosAdapter extends ArrayAdapter<Contatos> {

        private final Context context;
        private final ArrayList<Contatos> elementos;

        public ContatosAdapter(Context context, ArrayList<Contatos> elementos) {
            super(context, R.layout.listadecontatos, elementos);
            this.context = context;
            this.elementos = elementos;
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.listadecontatos, parent , false);

            TextView nomeDoContato = (TextView) rowView.findViewById(R.id.nomeDoCont);
            TextView telefoneDoContato = (TextView) rowView.findViewById(R.id.teleDoContato);
            TextView emailDoContato = (TextView) rowView.findViewById(R.id.emailDoContato);
            ImageButton imageButton = (ImageButton) rowView.findViewById(R.id.sendZap);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri mUri = Uri.parse("smsto:+556181172357");
                    Intent mIntent = new Intent(Intent.ACTION_SENDTO, mUri);
                    mIntent.setPackage("com.whatsapp");
                    mIntent.putExtra("chat",true);
                    context.startActivity(mIntent);

                }
            });
            nomeDoContato.setText(elementos.get(position).getNomeDoContato());
            telefoneDoContato.setText(elementos.get(position).getTeleDoContato());
            emailDoContato.setText(elementos.get(position).getEmailDoContato());

            return rowView;
        }
}

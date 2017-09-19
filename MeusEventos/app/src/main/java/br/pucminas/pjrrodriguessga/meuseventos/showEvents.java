package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class showEvents extends AppCompatActivity {

    private ArrayList<Eventos> eventos = new ArrayList<Eventos>();
    private int posicao;
    private int posicaoDado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_events);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Mostrar o botão
        getSupportActionBar().setHomeButtonEnabled(true);      //Ativar o botão

        //Toast.makeText(getBaseContext(), posicao + " " + posicaoDado,Toast.LENGTH_LONG).show();
        if(getIntent().getSerializableExtra("evento") != null) {

            eventos = (ArrayList<Eventos>) getIntent().getSerializableExtra("evento");
            posicao = (int) getIntent().getIntExtra("posicao",0);
        }

        if(getIntent().getSerializableExtra("dadosContato") != null) {

            eventos = (ArrayList<Eventos>) getIntent().getSerializableExtra("dadosContato");
            posicao = (int) getIntent().getIntExtra("posicao",0);
            posicaoDado = (int) getIntent().getIntExtra("posicaoDados",0);
            //adicionarContato(eventos.get(posicao).getContatos().get(posicaoDado));
        }
        setTitle(eventos.get(posicao).getNomeDoEvento());
        TextView nomeDoOrga = (TextView) findViewById(R.id.nomeDoOrga);
        TextView telefoneDoOrga = (TextView) findViewById(R.id.teleDoOrga);
        TextView dataDeInicio = (TextView) findViewById(R.id.dataDeInicio);
        TextView horarioDeInicio = (TextView) findViewById(R.id.horarioDeInicio);

        nomeDoOrga.setText(eventos.get(posicao).getNomeDoOrga());
        telefoneDoOrga.setText(eventos.get(posicao).getTelefoneDoOrga());
        dataDeInicio.setText(eventos.get(posicao).getDataDeInicio());
        horarioDeInicio.setText(eventos.get(posicao).getHorarioInicio());

        ListView lista = (ListView) findViewById(R.id.listaDeContatos);
        ArrayAdapter adapter = new ContatosAdapter(this,eventos.get(posicao).getContatos());
        lista.setAdapter(adapter);
    }

    public void adicionarContato(Contatos contatos){

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        //Toast.makeText(getBaseContext(), "Teste" , Toast.LENGTH_LONG).show();
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, contatos.getEmailDoContato());
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL_TYPE, ContactsContract.CommonDataKinds.Email.TYPE_WORK);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, contatos.getTeleDoContato());
        intent.putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, contatos.getNomeDoContato());

        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.adicionarContato:
                Intent intent = new Intent(this,registerCont.class);
                intent.putExtra("addContato",eventos);
                intent.putExtra("addContatoP",posicao);
                startActivity(intent);
                finish();
                return true;
            case android.R.id.home:
                intent = new Intent(this,MainActivity.class);
                intent.putExtra("refresh" , eventos);
                startActivity(intent);
                finish();
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }

}


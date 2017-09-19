package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Eventos> eventos = new ArrayList<Eventos>();
    private int posicaoEvento
;    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metodoTest();
        if(getIntent().getSerializableExtra("refresh")!= null){

            eventos = (ArrayList<Eventos>) getIntent().getSerializableExtra("refresh");

        }
        if(getIntent().getSerializableExtra("dadosSend") != null) {

            eventos = (ArrayList<Eventos>) getIntent().getSerializableExtra("dadosSend");
            posicaoEvento = (int) getIntent().getIntExtra("posicaoEvento",0);
            addEvento();
        }
        ListView lista = (ListView) findViewById(R.id.listaDeEventos);
        ArrayAdapter adapter = new EventosAdapter(this, eventos);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,showEvents.class);
                intent.putExtra("evento",eventos);
                intent.putExtra("posicao",i);
                startActivity(intent);
            }
        });

    }

    private void addEvento() {


        String startDate = eventos.get(posicaoEvento).getDataDeInicio();
        String startHour = eventos.get(posicaoEvento).getHorarioInicio();
        Date fullDateStart = null;

        String endDate = eventos.get(posicaoEvento).getDataDeTermino();
        String endHour = eventos.get(posicaoEvento).getHorarioFinal();
        Date fullDateEnd = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        formato.setLenient(false);
        try {

            fullDateStart = formato.parse(startDate + " " + startHour);
            fullDateEnd = formato.parse(endDate + " " + endHour);


        } catch (ParseException e) {
            e.printStackTrace();
        }


        Intent intent = new Intent(Intent.ACTION_EDIT);
        String descricao = "Nome do Evento: " + eventos.get(posicaoEvento).getNomeDoEvento() + "\n" +
                            "Nome do Organizador: " + eventos.get(posicaoEvento).getNomeDoOrga() + "\n" +
                             "Email do Organizador: " + eventos.get(posicaoEvento).getEmailDoOrga() + "\n" +
                                "Telefone do Organizador: " + eventos.get(posicaoEvento).getTelefoneDoOrga() + "\n" ;

        long startMillis = System.currentTimeMillis();
        //Toast.makeText(getBaseContext(),"TESTE: O CERTO: " + startMillis + " OS ERRADOS :" +  eventos.get(posicaoEvento).getDataDeTermino() + " " + eventos.get(posicaoEvento).getHorarioFinal(),Toast.LENGTH_LONG).show();
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("title", eventos.get(posicaoEvento).getNomeDoEvento());
        intent.putExtra("description", descricao);
        intent.putExtra("beginTime",  fullDateStart.getTime());
        intent.putExtra("endTime", fullDateEnd.getTime());


        startActivity(intent);


    }

    private void metodoTest() {

        ArrayList<Contatos> contatos = new ArrayList<Contatos>();
        Contatos contatosAux = new Contatos("Paulinho","1234554321","email@gmail.com");
        contatos.add(contatosAux);
        Eventos tmp = new Eventos("Nome do Evento","01/09/1997","Nome do Organizador","17:30","031-12345678",contatos);
        eventos.add(tmp);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.criar_evento:
                Intent intent = new Intent(this,registerEvent.class);
                intent.putExtra("dados" , eventos);
                startActivity(intent);
                finish();
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }

}

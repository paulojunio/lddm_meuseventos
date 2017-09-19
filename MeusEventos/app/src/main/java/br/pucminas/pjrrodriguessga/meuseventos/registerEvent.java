package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

public class registerEvent extends AppCompatActivity {

    private ArrayList<Eventos> eventosSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.criarEvento);
        setContentView(R.layout.activity_register_event);
        eventosSend = (ArrayList<Eventos>) getIntent().getSerializableExtra("dados");

    }

    public void adicionarEvento (View view) {

        Intent intent = new Intent(this , MainActivity.class);
        EditText editTextNomeEvento = (EditText) findViewById(R.id.nomeDoEvento);
        EditText editTextDataInicio = (EditText) findViewById(R.id.dataDeInicio);
        EditText editTextHorarioInicio = (EditText) findViewById(R.id.horarioDeInicio);
        EditText editTextDataTermino = (EditText) findViewById(R.id.dataDeTermino);
        EditText editTextHorarioTermino = (EditText) findViewById(R.id.horarioDeTermino);
        EditText editTextNomeOrga = (EditText) findViewById(R.id.nomeDoOrga);
        EditText editTextEmailOrga = (EditText) findViewById(R.id.emailDoOrga);
        EditText editTextTelefoneOrga = (EditText) findViewById(R.id.teleDoOrga);

        Eventos evento = new Eventos(editTextNomeEvento.getText().toString(),
                                    editTextDataInicio.getText().toString(),
                                    editTextHorarioInicio.getText().toString(),
                                    editTextDataTermino.getText().toString(),
                                    editTextHorarioTermino.getText().toString(),
                                    editTextNomeOrga.getText().toString(),
                                    editTextTelefoneOrga.getText().toString(),
                                    editTextEmailOrga.getText().toString() );

        eventosSend.add(evento);
        intent.putExtra("dadosSend",eventosSend);
        intent.putExtra("posicaoEvento", eventosSend.size()-1);
        startActivity(intent);
        finish();
    }

}

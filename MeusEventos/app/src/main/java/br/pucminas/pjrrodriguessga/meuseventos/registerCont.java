package br.pucminas.pjrrodriguessga.meuseventos;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class registerCont extends AppCompatActivity {

    private ArrayList<Eventos> eventoSend = new ArrayList<Eventos>();
    private int posicao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.adicionarContato);
        setContentView(R.layout.activity_register_cont);
        eventoSend = (ArrayList<Eventos>) getIntent().getSerializableExtra("addContato");
        posicao = (int) getIntent().getIntExtra("addContatoP",0);
    }

    public void adicionarPessoa (View view) {

    	Intent intent = new Intent(this , showEvents.class);
        ArrayList<Contatos> contatosArrayList = eventoSend.get(posicao).getContatos();
        EditText editTextNomeContato = (EditText) findViewById(R.id.nomeDoCont);
        EditText editTextTelefoneContato = (EditText) findViewById(R.id.teleDoContato);
        EditText editTextEmailContato = (EditText) findViewById(R.id.emailDoContato);
        

        Contatos contatos = new Contatos(editTextNomeContato.getText().toString(),
                                    editTextTelefoneContato.getText().toString(),
                                    editTextEmailContato.getText().toString());
        contatosArrayList.add(contatos);
        eventoSend.get(posicao).setContatos(contatosArrayList);
        intent.putExtra("posicaoDados",contatosArrayList.size() - 1);
        intent.putExtra("dadosContato",eventoSend);
        intent.putExtra("posicao",posicao);
        startActivity(intent);
        finish();
    }



}

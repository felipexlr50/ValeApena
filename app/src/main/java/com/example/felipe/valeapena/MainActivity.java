package com.example.felipe.valeapena;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.felipe.valeapena.adapter.ListAdapter;
import com.example.felipe.valeapena.model.Produto;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Produto> produtos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputObservacao(MainActivity.this);
            }
        });

        produtos = new ArrayList<>();
        listView = (ListView) findViewById(R.id.listView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setDataToList(Produto produto){
        produtos.add(produto);
        Collections.sort(produtos,Produto.ProdutoRatioComparator);
        ListAdapter adapter = new ListAdapter(this,produtos);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void inputObservacao(final Context context){

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Insira um novo Produto!");
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);
        final EditText unidade = new EditText(context);
        final EditText valor = new EditText(context);
        final EditText nome = new EditText(context);

        unidade.setHint("Coloque o valor da unidade");
        valor.setHint("Coloque o preço do produto");
        nome.setHint("Coloqueo nome do Produto!");

        nome.setPadding(0,20,0,20);
        valor.setPadding(0,20,0,20);
        unidade.setPadding(0,20,0,20);

        unidade.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        valor.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
        nome.setInputType(InputType.TYPE_CLASS_TEXT);
        layout.addView(nome);
        layout.addView(unidade);
        layout.addView(valor);
        builder.setView(layout);


        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(nome.getText().toString().equals("")|| unidade.getText().toString().equals("") || valor.getText().toString().equals("")){
                    Toast.makeText(context, "Algum campo ficou vazio!", Toast.LENGTH_SHORT).show();
                }else {
                    String nomeP = nome.getText().toString();
                    double unidadeP = Double.parseDouble(unidade.getText().toString());
                    double valorP = Double.parseDouble(valor.getText().toString());
                    Produto produto = new Produto(unidadeP,valorP,nomeP);
                    setDataToList(produto);
                }
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();

    }
}

package com.example.felipe.valeapena.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.felipe.valeapena.R;
import com.example.felipe.valeapena.model.Produto;

import java.text.NumberFormat;
import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private ArrayList<Produto> produtos;


    public ListAdapter(Context context, ArrayList<Produto> produtos) {
       this.produtos = produtos;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ItemSuporte itemHolder;
        if (view == null) {
            view = mInflater.inflate(R.layout.list_view_item_cell,null);
            itemHolder = new ItemSuporte();
            itemHolder.txtUnidade = ((TextView) view.findViewById(R.id.txtCellUnidade));
            itemHolder.txtValor = (TextView) view.findViewById(R.id.txtCellValor);
            itemHolder.txtNome = (TextView) view.findViewById(R.id.txtCellNome);
            itemHolder.txtRatio = (TextView) view.findViewById(R.id.txtCellRatio);


            Produto produto = produtos.get(position);
            itemHolder.txtNome.setText(produto.getNome());
            itemHolder.txtUnidade.setText(produto.getUnidade()+"");
            itemHolder.txtValor.setText(NumberFormat.getCurrencyInstance().format(produto.getValor()));
            itemHolder.txtRatio.setText(NumberFormat.getInstance().format(produto.getRatio())+" R$/U");


            view.setTag(itemHolder);
        } else {
            itemHolder = (ItemSuporte) view.getTag();
        }

        return view;
    }

    private class ItemSuporte {

        TextView txtUnidade;
        TextView txtValor;
        TextView txtNome;
        TextView txtRatio;
    }

    private class ItemSuporte2{
        TextView txtUnidade;
        TextView txtValor;
        TextView txtNome;
        TextView txtRatio;
    }
}

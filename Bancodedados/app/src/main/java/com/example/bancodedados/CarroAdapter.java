package com.example.bancodedados;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CarroAdapter  extends ArrayAdapter<Carro> {

    private Context mContext;
    private List<Carro> carroList;

    public CarroAdapter(Context context, ArrayList<Carro> list){
        super(context, 0, list);

        mContext = context;
        carroList =  list;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;

        if(listItem == null)
            listItem = LayoutInflater.from(mContext).inflate(R.layout.carro_list,parent,false);
        Carro currentCarro = carroList.get(position);


        TextView Codigo = listItem.findViewById(R.id.textViewCodigo);
        Codigo.setText(currentCarro.getCod());

        TextView Marca = listItem.findViewById(R.id.textViewMarca);
        Marca.setText(currentCarro.getModelo());


        TextView Modelo = listItem.findViewById(R.id.textViewModelo);
        Modelo.setText(currentCarro.getMarca());


        TextView Ano = listItem.findViewById(R.id.textViewAno);
        Ano.setText(currentCarro.getAno());



        return listItem;
    }


}

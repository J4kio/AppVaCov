package com.example.appvacov;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter4 extends RecyclerView.Adapter<ListAdapter4.ViewHolder>  {
    private List<ListElement4> mData;
    private LayoutInflater mInflater;
    private Context context;




    public ListAdapter4(List<ListElement4> itemList, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList;


    }


    @Override
    public int getItemCount(){ return mData.size();}



    @Override
    public ListAdapter4.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = mInflater.inflate(R.layout.list_element4,null);
        return new ListAdapter4.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter4.ViewHolder holder, final int position){

        holder.bindData(mData.get(position));



    }
    public void setItems (List<ListElement4> items){mData=items;}


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id_lote, fecha_vencimiento,marca,fecha_recepcion,cantidad;

        ViewHolder(View itemView){
            super(itemView);
            id_lote = itemView.findViewById(R.id.itextview1);
            fecha_vencimiento = itemView.findViewById(R.id.itextview2);
            marca = itemView.findViewById(R.id.itextview3);
            fecha_recepcion = itemView.findViewById(R.id.itextview4);
            cantidad = itemView.findViewById(R.id.itextview5);



        }
        void bindData(final ListElement4 item){

            id_lote.setText(item.getId_lote());
            fecha_vencimiento.setText(item.getFecha_vencimiento());
            marca.setText(item.getMarca());
            fecha_recepcion.setText(item.getFecha_recepcion());
            cantidad.setText(item.getCantidad());


        }
    }
}
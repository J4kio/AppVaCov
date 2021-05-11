package com.example.appvacov;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter2 extends RecyclerView.Adapter<ListAdapter2.ViewHolder> {
    private List<ListElement2> mData;
    private LayoutInflater mInflater;
    private Context context;



    public ListAdapter2(List<ListElement2> itemList2, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList2;


    }


    @Override
    public int getItemCount(){ return mData.size();}



    @Override
    public ListAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = mInflater.inflate(R.layout.list_element2,null);
        return new ListAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter2.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));

    }
    public void setItems (List<ListElement2> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre, apellido,cedula,fecha,dosis,fase,edad;
        ViewHolder(View itemView){
            super(itemView);
            nombre = itemView.findViewById(R.id.textview1);
            apellido = itemView.findViewById(R.id.textview2);
            cedula = itemView.findViewById(R.id.textview3);
            fecha = itemView.findViewById(R.id.textview4);
            dosis = itemView.findViewById(R.id.textview5);
            fase = itemView.findViewById(R.id.textview6);
            edad = itemView.findViewById(R.id.textview7);


        }
        void bindData(final ListElement2 item){
            nombre.setText(item.getNombre());
            apellido.setText(item.getApellido());
            cedula.setText(item.getCedula());
            fecha.setText(item.getFecha());
            dosis.setText(item.getDosis());
            fase.setText(item.getFase());
            edad.setText(item.getEdad());


        }
    }
}

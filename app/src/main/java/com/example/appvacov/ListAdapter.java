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

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>  {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;
    public String cedulap;



    public ListAdapter(List<ListElement> itemList, Context context){
    this.mInflater=LayoutInflater.from(context);
    this.context=context;
    this.mData=itemList;


    }


    @Override
    public int getItemCount(){ return mData.size();}



    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = mInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){

            holder.bindData(mData.get(position));



    }
    public void setItems (List<ListElement> items){mData=items;}


    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id, hora,fecha,sede,usuario;
        Button btn;
        ViewHolder(View itemView){
            super(itemView);
            btn = itemView.findViewById(R.id.cbutton1);
            id = itemView.findViewById(R.id.ctextview1);
            hora = itemView.findViewById(R.id.ctextview2);
            fecha = itemView.findViewById(R.id.ctextview3);
            sede = itemView.findViewById(R.id.ctextview4);
            usuario = itemView.findViewById(R.id.ctextview5);



        }
        void bindData(final ListElement item){
            btn.setOnClickListener(v -> {
                Intent intent = new Intent(context, ReporteVacunacion.class);
                intent.putExtra("sede", sede.getText());
                intent.putExtra("fecha", fecha.getText());
                intent.putExtra("usuario", usuario.getText());
                intent.putExtra("cedulap",cedulap);

                context.startActivity(intent);

            });
            id.setText(item.getId());
            hora.setText(item.getHora());
            fecha.setText(item.getFecha());
            sede.setText(item.getSede());
            usuario.setText(item.getUsuario());
            cedulap = item.getCedulap();

        }
    }
}

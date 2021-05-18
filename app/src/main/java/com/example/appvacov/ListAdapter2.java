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

        TextView id_reporte, cedulapa,cedulap,fecha,sede,dosis,id_lote,marca;
        ViewHolder(View itemView){
            super(itemView);
            id_reporte = itemView.findViewById(R.id.textview1);
            cedulapa = itemView.findViewById(R.id.textview2);
            cedulap = itemView.findViewById(R.id.textview3);
            fecha = itemView.findViewById(R.id.textview4);
            sede = itemView.findViewById(R.id.textview5);
            dosis = itemView.findViewById(R.id.textview6);
            id_lote = itemView.findViewById(R.id.textview7);
            marca = itemView.findViewById(R.id.textview8);

        }
        void bindData(final ListElement2 item){


            id_reporte.setText(item.getId_reporte());
            cedulapa.setText(item.getCedulapa());
            cedulap.setText(item.getCedulap());
            fecha.setText(item.getFecha());
            sede.setText(item.getSede());
            dosis.setText(item.getDosis());
            id_lote.setText(item.getId_lote());
            marca.setText(item.getMarca());


        }
    }
}

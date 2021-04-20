package com.example.appvacov;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;



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
        ViewHolder(View itemView){
            super(itemView);
            id = itemView.findViewById(R.id.textview1);
            hora = itemView.findViewById(R.id.textview2);
            fecha = itemView.findViewById(R.id.textview3);
            sede = itemView.findViewById(R.id.textview4);
            usuario = itemView.findViewById(R.id.textview5);


        }
        void bindData(final ListElement item){
            id.setText(item.getId());
            hora.setText(item.getHora());
            fecha.setText(item.getFecha());
            sede.setText(item.getSede());
            usuario.setText(item.getUsuario());


        }
    }
}

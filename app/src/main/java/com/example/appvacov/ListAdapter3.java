package com.example.appvacov;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter3 extends RecyclerView.Adapter<ListAdapter3.ViewHolder> {
    private List<ListElement3> mData;
    private LayoutInflater mInflater;
    private Context context;



    public ListAdapter3(List<ListElement3> itemList3, Context context){
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.mData=itemList3;


    }


    @Override
    public int getItemCount(){ return mData.size();}



    @Override
    public ListAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent , int viewType){
        View view = mInflater.inflate(R.layout.list_element3,null);
        return new ListAdapter3.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter3.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));

    }
    public void setItems (List<ListElement3> items){mData=items;}

    public class ViewHolder extends RecyclerView.ViewHolder{



        TextView cedula, correo,nombres,apellidos,edad,genero,fase,ocupacion,comorbilidades,direccion;
        ViewHolder(View itemView){
            super(itemView);
            cedula = itemView.findViewById(R.id.textview1);
            correo = itemView.findViewById(R.id.textview2);
            nombres = itemView.findViewById(R.id.textview3);
            apellidos = itemView.findViewById(R.id.textview4);
            edad = itemView.findViewById(R.id.textview5);
            genero = itemView.findViewById(R.id.textview6);
            fase = itemView.findViewById(R.id.textview7);
            ocupacion = itemView.findViewById(R.id.textview8);
            comorbilidades = itemView.findViewById(R.id.textview9);
            direccion = itemView.findViewById(R.id.textview10);

        }
        void bindData(final ListElement3 item){


            cedula.setText(item.getCedula());
            correo.setText(item.getCorreo());
            nombres.setText(item.getNombres());
            apellidos.setText(item.getApellidos());
            edad.setText(item.getEdad());
            genero.setText(item.getGenero());
            fase.setText(item.getFase());
            ocupacion.setText(item.getOcupacion());
            if (item.getComorbilidades().equals("0")){
                comorbilidades.setText("No Presenta");
            }
            else{
                comorbilidades.setText("Presenta");
            }

            direccion.setText(item.getDireccion());


        }
    }
}

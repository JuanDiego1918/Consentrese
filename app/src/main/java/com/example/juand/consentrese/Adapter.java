package com.example.juand.consentrese;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.AdaptersViewHolder> implements View.OnClickListener {
    ArrayList<UserVo> list;
    View.OnClickListener listener;

    public Adapter(ArrayList<UserVo> list) {
        this.list = list;
    }

    @Override
    public AdaptersViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_adapter, null, false);
        view.setOnClickListener(this);
        return new AdaptersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdaptersViewHolder holder, int position) {
        holder.nombre.setText(list.get(position).getNombre());
        holder.puntos.setText(list.get(position).getPuntaje());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }

    public class AdaptersViewHolder extends RecyclerView.ViewHolder {
        TextView nombre,puntos;
        public AdaptersViewHolder(View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombreUser);
            puntos=itemView.findViewById(R.id.puntosUser);
        }
    }
}

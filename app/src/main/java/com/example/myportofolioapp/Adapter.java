package com.example.myportofolioapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.example.myportofolioapp.Model.ItemVidio;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    // Buat Global variable untuk manampung context

    MediaController mediaController;
    Context context;
    List<ItemVidio> itemVidio;


    public Adapter(Context context, List<ItemVidio> itemVidio) {
        this.context = context;
        this.itemVidio = itemVidio;
    }


    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.content_view, parent, false);
        // Hubungkan dengan MyViewHolder
        myViewHolder holder = new myViewHolder(view);
        mediaController = new MediaController(context);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, final int i) {
        holder.tv_judul.setText(itemVidio.get(i).getJudul());
        holder.vv_tampilan_video.setVideoPath("http://192.168.43.81/motion_graphic/public/motion_graphic_storage/"+itemVidio.get(i).getFile());
        holder.vv_tampilan_video.setMediaController(mediaController);
        mediaController.setAnchorView(holder.vv_tampilan_video);

    }
    

    // Menentukan Jumlah item yang tampil
    @Override
    public int getItemCount () {
        return itemVidio.size();
    }


    public class myViewHolder extends RecyclerView.ViewHolder {

        VideoView vv_tampilan_video;
        TextView tv_judul;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            vv_tampilan_video = itemView.findViewById(R.id.vv_tampilan_video);
            tv_judul = itemView.findViewById(R.id.tv_judul);

        }

    }



}

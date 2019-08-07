package com.example.myportofolioapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.myportofolioapp.Api.Client;
import com.example.myportofolioapp.Api.InterfaceVideo;
import com.example.myportofolioapp.Model.ItemVidio;
import com.google.gson.Gson;
//import com.example.myportofolioapp.FullScreen.FullScreenMediaControler;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 VideoView videoView;
 RecyclerView recyclerView;
 Adapter adapter;
 InterfaceVideo interfaceVideo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        interfaceVideo = (InterfaceVideo) Client.getClient().create(InterfaceVideo.class);
        recyclerView = (RecyclerView) findViewById(R.id.rv_main);

    /*    String fullSrceen = getIntent().getStringExtra("fullScreen");

//        if ("y".equals(fullSrceen)){
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        }*/
//        String videopath = "android.resource://"+ getPackageName() + "/" + R.raw.video;
//         Uri uri = Uri.parse(videopath);
//         videoView.setVideoURI(uri);

      /*  Uri videoUri = Uri.parse("android.resource://"+ getPackageName() + "/" + R.raw.video);
//         videoView.setVideoURI(videoUri);*/
//         mediaController = new MediaController(this);
//         mediaController.setAnchorView(videoView);
//
//         videoView.setMediaController(mediaController);


        tampilkanvideo();


    }

    private void tampilkanvideo() {
        this.interfaceVideo.request_video().enqueue(new Callback<List<ItemVidio>>() {
            @Override
            public void onResponse(Call<List<ItemVidio>> call, Response<List<ItemVidio>> response) {
                if(response.isSuccessful()){
                    List<ItemVidio> itemVidio = response.body();
//                    Toast.makeText(MainActivity.this, new Gson().toJson(response.body()), Toast.LENGTH_LONG).show(); List<ItemVidio> videoItems = response.body();
                    adapter = new Adapter(MainActivity.this, itemVidio);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView.setLayoutManager(layoutManager);
                    recyclerView.setAdapter(adapter);
                }else{
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ItemVidio>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}

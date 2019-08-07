/*
package com.example.myportofolioapp.FullScreen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.MediaController;

import com.example.myportofolioapp.MainActivity;
import com.example.myportofolioapp.R;

public class FullScreenMediaControler extends MediaController {
    ImageButton fullSreen;
    String isFullSreen;

    public FullScreenMediaControler(Context context){
        super(context);
    }

    @Override
    public void setAnchorView(View view) {
        super.setAnchorView(view);

        fullSreen = new ImageButton(super.getContext());

        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        params.gravity = Gravity.RIGHT;
        params.rightMargin = 80;
        addView(fullSreen, params);

        isFullSreen = ((Activity)getContext()).getIntent().getStringExtra("fullScreen");

        if ("y".equals(isFullSreen)){
            fullSreen.setImageResource(R.drawable.ic_fullscreen_exit);
        }else {
            fullSreen.setImageResource(R.drawable.ic_fullscreen);

        }

        fullSreen.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MainActivity.class);

                if ("y".equals(isFullSreen)){
                    intent.putExtra("fullScreen", "");
                }else {
                    intent.putExtra("fullScreen", "y");
                }
                ((Activity)getContext()).startActivity(intent);
            }
        });

    }
}
*/

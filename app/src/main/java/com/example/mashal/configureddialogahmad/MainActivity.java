package com.example.mashal.configureddialogahmad;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3;
    AlertDialog.Builder adb;
    AlertDialog ad;
    LinearLayout ll2;
    String[] colors = {"red","green","blue"};
    int [] color = new int[] {0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
    }

    public void firstBTN(View view) {
        adb = new AlertDialog.Builder(this);
        adb.setTitle("new background color");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[0] = 0;
                color[1] = 0;
                color[2] = 0;
                color[which] = 255;
                ll2.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });

        adb.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad=adb.create();
        ad.show();
    }

    public void secondBTN(View view) {
        color[0]=0; color[1]=0; color[2]=0;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("new background color");
        adb.setMultiChoiceItems(colors,null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if ( color[which]==255 ) color[which]=0;
                Toast.makeText(MainActivity.this, ""+color[0]+color[1]+color[2], Toast.LENGTH_SHORT).show();
            }
        });

        adb.setNegativeButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        adb.setPositiveButton("change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ll2.setBackgroundColor(Color.rgb(color[0],color[1],color[2])); }
        });

        ad=adb.create();
        ad.show();

    }



    public void thirdBTN(View view) {
        ll2.setBackgroundColor(Color.WHITE);
    }
}
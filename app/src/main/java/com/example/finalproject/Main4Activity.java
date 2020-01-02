package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main4Activity extends AppCompatActivity {
    private Button btn_query;
    public static TextView time1,temp1,time2,temp2,time3,temp3,time4,temp4,time5,temp5;
    public static ImageView image1,image2,image3,image4,image5;
    public int a =0;
    public String CITY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        findViewById(R.id.backk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.backk2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main4Activity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
//        btn_query = findViewById(R.id.btn_query);
        time1 = findViewById(R.id.timeone);
        temp1 = findViewById(R.id.tempone);
        time2 = findViewById(R.id.timetwo);
        temp2 = findViewById(R.id.temptwo);
        time3 = findViewById(R.id.timethree);
        temp3 = findViewById(R.id.tempthree);
        time4 = findViewById(R.id.timefour);
        temp4 = findViewById(R.id.tempfour);
        time5 = findViewById(R.id.timefive);
        temp5 = findViewById(R.id.tempfive);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
        image4 = findViewById(R.id.image4);
        image5 = findViewById(R.id.image5);
        CITY = getIntent().getExtras().getString("City");
        registerReceiver(receiver,new IntentFilter("Mymessage"));
//        btn_query.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
        Request req = new Request.Builder()
                .url("https://api.openweathermap.org/data/2.5/forecast?q="+ CITY +"&units=metric&appid=665a5166b72c53a06628e31dca210add").build();

        new OkHttpClient().newCall(req).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e("查詢失敗",e.toString());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                sendBroadcast(new Intent("Mymessage").putExtra("json",response.body().string()));
            }
        });
//            }
//        });
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Data data = new Gson().fromJson(intent.getExtras().getString("json"), Data.class);
            final String[] items = new String[data.list.length];
            Queue<String> queuet = new LinkedList<String>();
            Queue<String> queued = new LinkedList<String>();
            Queue<Integer> queueh = new LinkedList<Integer>();
//            for (int i = 0; i < items.length; i++) {
//                items[i] = "\n溫度:" +
//                        data.list[i].main.feels_like +
//                        "\n時間" +
//                        data.list[i].dt_txt;
//            }
            for (int i = 0; i < items.length; i++) {
                String test = data.list[i].dt_txt;
                String test2 = test.substring(8,10);
                String test4 = "2020-01-"+test2+" 12:00:00";
                if(test.equals(test4)) {
                    queuet.add(data.list[i].main.temp);
                    queued.add(test2);
                    queueh.add(data.list[i].main.humidity);
                }
            }
//            MainActivity.this.runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    new AlertDialog.Builder(MainActivity.this)
//                            .setTitle("台北捷運列車到站站名")
//                            .setItems(items, null)
//                            .show();
//                }
//            });
//            for(int a=0; a<items.length; a++) {
//                String test = data.list[a].dt_txt;
//                String test2 = test.substring(8,10);
//                String test4 = "2020-01-"+test2+" 12:00:00";
//        }
            try {
                /*for(String q : queue){
                    MainActivity.textView.setText(q);
                }*/
//                String tmp = "";
//                for (int i = 0; i < queue.size(); i++) {
//                    tmp+=queue.remove()+"\n";
//                }
                Main4Activity.temp1.setText(queuet.poll());
                Main4Activity.temp2.setText(queuet.poll());
                Main4Activity.temp3.setText(queuet.poll());
                Main4Activity.temp4.setText(queuet.poll());
                Main4Activity.temp5.setText(queuet.poll());
                Main4Activity.time1.setText(queued.poll());
                Main4Activity.time2.setText(queued.poll());
                Main4Activity.time3.setText(queued.poll());
                Main4Activity.time4.setText(queued.poll());
                Main4Activity.time5.setText(queued.poll());
                a=queueh.poll();

                if(a>=90){
                    image1.setImageResource(R.drawable.rain);
                }
                else if(a>=80 && a<90){
                    image1.setImageResource(R.drawable.cloud);
                }
                else{
                    image1.setImageResource(R.drawable.sun);
                }
                a=0;
                a=queueh.poll();

                if(a>=90){
                    image2.setImageResource(R.drawable.rain);
                }
                else if(a>=80 && a<90){
                    image2.setImageResource(R.drawable.cloud);
                }
                else{
                    image2.setImageResource(R.drawable.sun);
                }
                a=0;
                a=queueh.poll();

                if(a>=90){
                    image3.setImageResource(R.drawable.rain);
                }
                else if(a>=80 && a<90){
                    image3.setImageResource(R.drawable.cloud);
                }
                else{
                    image3.setImageResource(R.drawable.sun);
                }
                a=0;
                a=queueh.poll();

                if(a>=90){
                    image4.setImageResource(R.drawable.rain);
                }
                else if(a>=80 && a<90){
                    image4.setImageResource(R.drawable.cloud);
                }
                else{
                    image4.setImageResource(R.drawable.sun);
                }
                a=0;
                a=queueh.poll();

                if(a>=90){
                    image5.setImageResource(R.drawable.rain);
                }
                else if(a>=80 && a<90){
                    image5.setImageResource(R.drawable.cloud);
                }
                else{
                    image5.setImageResource(R.drawable.sun);
                }




            }
            catch (Exception e){
                Main4Activity.time1.setText(e.toString());
            }
        }
    };


}


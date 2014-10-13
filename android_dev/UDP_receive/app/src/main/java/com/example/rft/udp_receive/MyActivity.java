package com.example.rft.udp_receive;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.net.Inet4Address.*;


public class MyActivity extends Activity {

    public static DatagramPacket pack = null;
    public static DatagramSocket socket1 = null;
    public InetAddress serverAddress = null;
    public static byte receiver[] = new byte[1280];
    public static byte datapack[] = new byte[12582912];
    public static int count = 0;
    public static boolean lock = true;
    public connect3322 listening;
    public static int pos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);



        Button button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
           //         new Thread(){
            //            public void run(){
                            try {
                                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());

                                socket1 = new DatagramSocket(3322);

                                socket1.setReuseAddress(true);
                                socket1.setReceiveBufferSize(1024*64);

                                serverAddress = InetAddress.getByName("192.168.0.1");

                                socket1.connect(serverAddress, 3322);
                                AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                        .setMessage("连接成功")
                                        .show();
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                                AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                        .setMessage(e.getMessage())
                                        .show();
                            }
                 //       }
                //    }.start();
                }
        });


        button.setOnClickListener(new View.OnClickListener() {
            //ToDo
            @Override
            public void onClick(View v) {
                try {
                    listening = new connect3322();
                    listening.start();

                }
                catch (Exception e){
                    AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                            .setMessage(e.getMessage())
                            .show();
                }
            }
       });


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new Thread() {
                //    public void run() {
                        try
                        {
                            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());

                            byte[] data = {0x02, 0x01, 0x00, 0x03};//, 0x00, 0x01, 0x00, 0x00, 0x00, (byte) 0xff};
                            DatagramPacket packet = new DatagramPacket(data, data.length);
                            socket1.send(packet);
                            AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                    .setMessage("发送成功")
                                    .show();


                        } catch (Exception e)

                        {
                            e.printStackTrace();
                            AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                    .setMessage(e.getMessage())
                                    .show();
             //           }
                    }
            //    }.start();


            }

        });

        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            //    new Thread() {
            //        public void run() {

                    try {
                        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
                        lock = false;
                        listening.interrupt();


                        //socket1.disconnect();
                        //socket1.close();
                        AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                .setTitle("数据统计")
                                .setMessage("共接收"+String.valueOf(count)+"字节\n共储存"+String.valueOf(pos)+"字节")
                                .show();
                    }
                    catch (Exception e){
                        e.printStackTrace();
                        AlertDialog show = new AlertDialog.Builder(MyActivity.this)
                                .setMessage(e.getMessage())
                                .show();
                    }
            //        }
            //    }.start();

            }
        });
    }
}

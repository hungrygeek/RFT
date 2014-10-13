package com.example.rft.udp_receive;

import android.app.AlertDialog;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import static com.example.rft.udp_receive.MyActivity.lock;
import static com.example.rft.udp_receive.MyActivity.pack;
import static com.example.rft.udp_receive.MyActivity.receiver;
import static com.example.rft.udp_receive.MyActivity.socket1;
import static com.example.rft.udp_receive.MyActivity.count;
import static com.example.rft.udp_receive.MyActivity.datapack;
import static com.example.rft.udp_receive.MyActivity.pos;

/**
 * Created by shishu on 23/09/2014.
 */
public class connect3322 extends Thread {
    //public boolean lock = true;
    //public DatagramPacket pack;
    //public byte receiver[] = new byte[2048];
    //public DatagramSocket socket1 = null;
    //public int count = 0;
    private int i = 0;
    //private int pos =0;


    public void run() {
        try {
                        while (lock) {
                            pack = new DatagramPacket(receiver, receiver.length);
                            socket1.receive(pack);
                            int numBytesReceived = pack.getLength();
                            count = count + numBytesReceived;
                            for (i=0;i<numBytesReceived;i++) {
                                //if (pack.getData()[i*10+1] == 0x02){
                                datapack[pos%12582912] = pack.getData()[i];
                                    pos = pos + 1;
                            }
                        }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

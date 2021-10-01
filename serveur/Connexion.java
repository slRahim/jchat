package projet_coda.serveur;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

public class Connexion extends Thread {

    BufferedReader entrer ;


    public Connexion(BufferedReader entrer) {
        this.entrer = entrer;
    }

    @Override
    public void run() {
        String msg ;
        while (true) {
            try {
                msg = entrer.readLine();
                if (msg.subSequence(0,10).equals("<<byebye>>")){
                    //pour deconnecter un client du serveur
                    Serveur.deconnecter(msg.substring(10));
                }
                else
                {
                    //messagrie priver ou public
                    String recepteur = msg.split("@#31#")[1];
                    msg = msg.split("@#31#")[0];
                    if (recepteur.equals("public")) {
                        Serveur.diffuser_msg(msg);
                    } else {
                        Serveur.diffuser_priver(recepteur, msg);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }




    }


}

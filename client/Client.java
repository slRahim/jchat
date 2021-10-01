package projet_coda.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {

    String ip;
    String port;
    String user;
    OutputStreamWriter sortie;
    BufferedReader entrer ;

    public Client(String ip, String port, String user) {
        this.ip = ip;
        this.port = port;
        this.user = user;
    }

    public void run(){
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));

            OutputStreamWriter sortie=new OutputStreamWriter(socket.getOutputStream());
            BufferedReader entrer = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //envoyer le nom du clinet pour quand ajoute à la liste et au tableau
            sortie.write(user+"\n");
            sortie.flush();

            Fclient fenetre=new Fclient();
            fenetre.setVisible(true);


            fenetre.setSortie(sortie);
            //pour affichage seulement
            fenetre.getTxt_adresse().setText(ip);
            fenetre.getTxt_port().setText(port);
            fenetre.getTxt_user().setText(user);

            //thread d'ecoute pour recuperer tout ce qui est envoyer par le serveur
            EcouteurClient ecouteurClient=new EcouteurClient(entrer,fenetre);
            ecouteurClient.start();

            //deconnecter du serveur
            fenetre.getBtn_deconnecter().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        sortie.write("<<byebye>>"+user+"\n");
                        sortie.flush();
                        sortie.close();
                        System.exit(0);

                    } catch (IOException e1) {
                        //e1.printStackTrace();
                    }
                }
            });


        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}

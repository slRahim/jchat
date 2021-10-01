package projet_coda.serveur;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.Iterator;
import java.util.Vector;

public class Serveur extends Thread{

    Socket socket ;
    ServerSocket serveur ;
    OutputStreamWriter sortie ;
    BufferedReader entrer;
    static Vector<ClientInfo> clients=new Vector<>();
    ClientInfo client;
    static JTable tab_connecter ;
    static JTextArea txt_chat ;
    DefaultTableModel model;
    static String etat_seveur ;

    public Serveur(JTable tab_connecter, JTextArea txt_chat) {
        this.tab_connecter = tab_connecter;
        this.txt_chat = txt_chat;

    }

    @Override
    public void run() {
        try {
            serveur=new ServerSocket(1998);
            while (true){
                socket=serveur.accept();

                sortie= new OutputStreamWriter(socket.getOutputStream());
                entrer=new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // ajouter le nouveaux client à la liste
                client=new ClientInfo(socket.getLocalAddress().getHostAddress(),entrer.readLine(),"connecter","non",sortie);
                clients.add(client);

                //pour regrouper les infos du client et facilite l'ajout à la table
                String [] tab=new String[4];
                tab[0]=clients.lastElement().ip_adresse;
                tab[1]=clients.lastElement().nom;
                tab[2]=clients.lastElement().etat;
                tab[3]=clients.lastElement().bloquer;

                //un nouveux membre est arriver
                diffuser_connexion(clients.lastElement().nom+" est connecter ....");
                diffuser_liste_user();


                Connexion connexion=new Connexion(entrer);
                connexion.start();

                //ajouter le client à la table du serveur
                model= (DefaultTableModel) tab_connecter.getModel();
                model.addRow(tab);
                tab_connecter.setModel(model);



            }
        } catch (IOException e) {
           // e.printStackTrace();
        }


    }

    //informer tout les clients sur des nouvelles
    public static void  diffuser_connexion(String msg){
        ClientInfo client ;
        if (etat_seveur.equals("on")) {
            for (int i = 0; i < clients.size(); i++) {
                client = clients.elementAt(i);
                try {
                    if (client.etat == "connecter" && client.bloquer == "non") {
                        txt_chat.append("Envoi du message: " + msg + "\n");
                        client.sortie.write(msg + "\n");
                        client.sortie.flush();
                    }
                } catch (IOException e) {
                    txt_chat.append("Erreur de diffusion du message !");
                }

            }
        }

    }

    //envoyer des messages aux clients  connecter
    public static void  diffuser_msg(String msg){
        ClientInfo client ;
        boolean b=verfie_blocage(msg.split(" : ")[0]) ;
        if (etat_seveur.equals("on") && b==false) {
            for (int i = 0; i < clients.size(); i++) {
                client = clients.elementAt(i);
                try {
                    if (client.etat == "connecter" && client.bloquer == "non") {
                        txt_chat.append("Envoi du message: " + msg + "\n");
                        client.sortie.write(msg + "\n");
                        client.sortie.flush();
                    }
                } catch (IOException e) {
                    txt_chat.append("Erreur de diffusion du message !");
                }

            }
        }

    }

    //envoyer des messages priver à un client
    public static void diffuser_priver(String rec,String msg){
        boolean b=verfie_blocage(msg.split(" : ")[0]) ;
        if (etat_seveur.equals("on") && b==false) {
            for (int i = 0; i < clients.size(); i++) {
                if (clients.elementAt(i).nom.equals(rec) || clients.elementAt(i).nom.equals(msg.split(" : ")[0])) {
                    try {
                        if (clients.elementAt(i).etat=="connecter" && clients.elementAt(i).bloquer=="non") {
                            txt_chat.append("Envoi du message: " + msg + "\n");
                            clients.elementAt(i).getSortie().write(msg + "\n");
                            clients.elementAt(i).getSortie().flush();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    //envoyer la liste des client connecter au serveur à chaque client msg priver
    public static void diffuser_liste_user() {
        ClientInfo client;
        if (etat_seveur.equals("on")) {
            for (int i = 0; i < clients.size(); i++) {
                client = clients.elementAt(i);
                if (client.getSortie() != clients.lastElement().getSortie()) {
                    try {
                        client.getSortie().write("*#31#" + clients.lastElement().nom + "\n");
                        client.getSortie().flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    for (int j = 0; j < clients.size() - 1; j++) {
                        try {
                            client.getSortie().write("*#31#" + clients.elementAt(j).nom + "\n");
                            client.getSortie().flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }
    }

    //supprimer un client depuis la liste et le tableau
    public static void deconnecter(String user){

        for (int i = 0; i <clients.size() ; i++) {
            if (clients.elementAt(i).nom.equals(user)){
                clients.removeElementAt(i);
                DefaultTableModel model= (DefaultTableModel) tab_connecter.getModel();
                model.removeRow(i);
                tab_connecter.setModel(model);
                break;
            }

        }


    }

    //verefie si un client est bloquer ou nn
    public static boolean verfie_blocage(String user){
        int pos=-1 ;
        for (int i = 0; i <clients.size() ; i++) {
            if (clients.elementAt(i).nom.equals(user)){
               pos=i ;
               break;
            }

        }
        if (clients.elementAt(pos).bloquer=="oui"){
            return true ;
        }
        else {
            return  false ;
        }

    }

}

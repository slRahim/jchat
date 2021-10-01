package projet_coda.client;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;

public class EcouteurClient extends Thread {

    BufferedReader entrer ;
    Fclient fenetre ;
    DefaultComboBoxModel model ;

    public EcouteurClient(BufferedReader entrer, Fclient fenetre) {
        this.entrer = entrer;
        this.fenetre = fenetre;
    }

    // recuperation des données envoyer par le serveur
    @Override
    public void run() {
        while (true){
            try {
                String msg=entrer.readLine();
                //pour tester si un message simple ou b1 c'est la liste des clients connecter
                if (msg.subSequence(0,5).equals("*#31#")){
                    model= (DefaultComboBoxModel) fenetre.getjComboBox1().getModel();
                    model.addElement(msg.substring(5));
                    fenetre.getjComboBox1().setModel(model);
                }
                else{
                  fenetre.getTxt_chat().append("\n"+msg);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

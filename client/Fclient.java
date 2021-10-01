
package projet_coda.client;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Fclient extends javax.swing.JFrame {

    OutputStreamWriter sortie ;
    String destination_msg="public";

    
    public Fclient() {
        initComponents();
    }



    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_chat = new javax.swing.JTextArea();
        txt_message = new javax.swing.JTextField();
        btn_envoyer = new javax.swing.JButton();
        txt_adresse = new javax.swing.JTextField();
        txt_port = new javax.swing.JTextField();
        btn_deconnecter = new javax.swing.JButton();
        txt_user = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Messenger");

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaptionBorder);

        txt_chat.setColumns(20);
        txt_chat.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_chat.setRows(5);
        jScrollPane1.setViewportView(txt_chat);

        txt_message.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_messageActionPerformed(evt);
            }
        });

        btn_envoyer.setBackground(new java.awt.Color(0, 102, 255));
        btn_envoyer.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_envoyer.setForeground(new java.awt.Color(255, 255, 255));
        btn_envoyer.setText("envoyer");
        btn_envoyer.addActionListener(new ActionListener() {
            //envoyer des message
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    sortie.write(txt_user.getText()+" : "+txt_message.getText()+"@#31#"+destination_msg+"\n");
                    sortie.flush();
                    txt_message.setText("");
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        txt_adresse.setEditable(false);
        txt_adresse.setBackground(new java.awt.Color(255, 255, 255));
        txt_adresse.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        txt_port.setEditable(false);
        txt_port.setBackground(new java.awt.Color(255, 255, 255));
        txt_port.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txt_port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_portActionPerformed(evt);
            }
        });

        btn_deconnecter.setBackground(new java.awt.Color(255, 0, 0));
        btn_deconnecter.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_deconnecter.setForeground(new java.awt.Color(255, 255, 255));
        btn_deconnecter.setText("deconnexion");

        txt_user.setEditable(false);
        txt_user.setBackground(new java.awt.Color(255, 255, 255));

        jComboBox1.setEditable(false);
        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "public" }));
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                destination_msg= (String) jComboBox1.getSelectedItem();

            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(txt_message, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btn_envoyer))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGap(22, 22, 22)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(txt_adresse, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(btn_deconnecter)
                                                                .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(21, 21, 21))
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_adresse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_deconnecter)
                                        .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txt_message, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_envoyer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void txt_messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_messageActionPerformed

    private void txt_portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_portActionPerformed


    public JButton getBtn_deconnecter() {
        return btn_deconnecter;
    }

    public JButton getBtn_envoyer() {
        return btn_envoyer;
    }

    public JTextArea getTxt_chat() {
        return txt_chat;
    }

    public JTextField getTxt_message() {
        return txt_message;
    }

    public void setSortie(OutputStreamWriter sortie) {
        this.sortie = sortie;
    }


    public JTextField getTxt_adresse() {
        return txt_adresse;
    }


    public JTextField getTxt_port() {
        return txt_port;
    }

    public JTextField getTxt_user() {
        return txt_user;
    }

    public JComboBox<String> getjComboBox1() {
        return jComboBox1;
    }

    public void setjComboBox1(JComboBox<String> jComboBox1) {
        this.jComboBox1 = jComboBox1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_deconnecter;
    private javax.swing.JButton btn_envoyer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JTextField txt_adresse;
    private javax.swing.JTextArea txt_chat;
    private javax.swing.JTextField txt_message;
    private javax.swing.JTextField txt_port;
    private javax.swing.JTextField txt_user;


    // End of variables declaration//GEN-END:variables



}

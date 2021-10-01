
package projet_coda.serveur;



import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Fserveur extends javax.swing.JFrame  {


    public Fserveur() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_chat = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab_connect = new javax.swing.JTable();
        btn_bloque = new javax.swing.JButton();
        btn_on = new javax.swing.JButton();
        btn_off = new javax.swing.JButton();
        btn_dbloc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Serveur Chate");
        setResizable(false);

        jPanel1.setBackground(java.awt.SystemColor.inactiveCaption);

        txt_chat.setColumns(20);
        txt_chat.setRows(5);
        jScrollPane2.setViewportView(txt_chat);

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        tab_connect.setAutoCreateRowSorter(true);
        tab_connect.setBackground(java.awt.SystemColor.inactiveCaptionBorder);
        tab_connect.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        tab_connect.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "Ip_adresse", "Id_utilisateur", "Etat actuel", "Bloquer"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tab_connect);

        btn_bloque.setBackground(new java.awt.Color(0, 102, 204));
        btn_bloque.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_bloque.setForeground(new java.awt.Color(255, 255, 255));
        btn_bloque.setText("Bloquer");
        btn_bloque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bloqueActionPerformed(evt);
            }
        });

        btn_on.setBackground(new java.awt.Color(51, 204, 0));
        btn_on.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_on.setForeground(new java.awt.Color(255, 255, 255));
        btn_on.setText("Serveur On");
        btn_on.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_onActionPerformed(evt);
            }
        });

        btn_off.setBackground(new java.awt.Color(255, 0, 0));
        btn_off.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        btn_off.setForeground(new java.awt.Color(255, 255, 255));
        btn_off.setText("Serveur Off");
        btn_off.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt) { btn_offActionPerformed(evt); }
        });

        btn_dbloc.setBackground(new java.awt.Color(0, 153, 204));
        btn_dbloc.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        btn_dbloc.setForeground(new java.awt.Color(255, 255, 255));
        btn_dbloc.setText("Debloquer");
        btn_dbloc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dblocActionPerformed(evt);
            }

        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_dbloc, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_bloque, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                                        .addComponent(jSeparator1)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_on, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_off, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_on, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btn_off, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btn_bloque)
                                        .addComponent(btn_dbloc))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void btn_bloqueActionPerformed(java.awt.event.ActionEvent evt) {
        DefaultTableModel model = (DefaultTableModel) tab_connect.getModel();

        int i=tab_connect.getSelectedRow();
        model.setValueAt("oui",i,3);
        tab_connect.setModel(model);

        Serveur.clients.elementAt(i).setBloquer("oui");



    }

    private void btn_dblocActionPerformed(ActionEvent evt) {

        DefaultTableModel model = (DefaultTableModel) tab_connect.getModel();
        int i=tab_connect.getSelectedRow();
        model.setValueAt("non",i,3);
        tab_connect.setModel(model);

        Serveur.clients.elementAt(i).setBloquer("non");


    }

    private void btn_onActionPerformed(java.awt.event.ActionEvent evt) {
        Serveur serveur=new Serveur(tab_connect,txt_chat);
        serveur.start();
        Serveur.etat_seveur="on";
        txt_chat.append("Serveur demarer avec succer ....");
        System.out.println(Serveur.etat_seveur);
    }

    private void btn_offActionPerformed(java.awt.event.ActionEvent evt) {

        Serveur.diffuser_connexion("le serveur est arreter et tous messages ne seront pas transmit ");
        txt_chat.append("\n Serveur deconnecter...");
        txt_chat.setText("");
        Serveur.etat_seveur="off";

    }



    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fserveur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bloque;
    private javax.swing.JButton btn_dbloc;
    private javax.swing.JButton btn_off;
    private javax.swing.JButton btn_on;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tab_connect;
    private javax.swing.JTextArea txt_chat;


    // End of variables declaration//GEN-END:variables
}

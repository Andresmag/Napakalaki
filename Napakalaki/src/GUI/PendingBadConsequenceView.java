/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;

/**
 *
 * @author Lenovo
 */
public class PendingBadConsequenceView extends javax.swing.JPanel {
    //Atributo
    private BadConsequence pendingBadConsequenceModel;
    
    //Setter
    public void setPendingBadConsequence(BadConsequence aBadConsequence){
        pendingBadConsequenceModel = aBadConsequence;
        if(pendingBadConsequenceModel != null)
            this.pendingText.setText(pendingBadConsequenceModel.toString());
        repaint();
    }
    /**
     * Creates new form PendingBadConsequenceView
     */
    public PendingBadConsequenceView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pendingText = new javax.swing.JTextArea();

        pendingText.setEditable(false);
        pendingText.setBackground(new java.awt.Color(153, 153, 153));
        pendingText.setColumns(20);
        pendingText.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        pendingText.setForeground(new java.awt.Color(0, 0, 0));
        pendingText.setRows(5);
        jScrollPane1.setViewportView(pendingText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea pendingText;
    // End of variables declaration//GEN-END:variables
}
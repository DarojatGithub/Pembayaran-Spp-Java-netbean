/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pembayaranspp;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TOSHIBA DC
 */
public class kelas extends javax.swing.JInternalFrame {

    /**
     * Creates new form datamurid
     */
    public kelas() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        initComponents();
         getConnection();     
           siapIsi(false);
        tombolNormal();
    
    }
    public Connection getConnection()
    {
    Connection con=null;
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost/pembayaranspp","root","");
            
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(datamurid.class.getName()).log(Level.SEVERE, null, ex);
            
            return con;
        }    
}
       public boolean checkInputs()
{
    if(
            
      
         noTF.getText()== null
              
             ||kelasTF.getText()== null
            
            ){
       return false;
    }
else{
    try{
     
     return true;
    }catch(Exception ex)
    {
        return false;
    }
    }
}
        
       
    
    
    private void bersih(){
        noTF.setText("");
      kelasTF.setText("");
      
        
    }
      private void siapIsi(boolean a){
        noTF.setEnabled(a);
        kelasTF.setEnabled(a);

    }
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        hapusBT.setEnabled(false);
        editBT.setEnabled(false);
        cariBT.setEnabled(false);
    }

private void simpan()
{  
    if(checkInputs())
        {
            try{
                Connection con=getConnection();
                PreparedStatement ps=con.prepareStatement("INSERT INTO tambahdatakelas(kelas)"
                    + "values(?)");
                ps.setString(1, kelasTF.getText());
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan","SEKOLAH CITA-CITA", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());

         
        }
          } else{
JOptionPane.showMessageDialog(null, "Lengkapi inputan data","SEKOLAH CITA-CITA",JOptionPane.INFORMATION_MESSAGE);
            
        }
            
}
private void perbarui()
        
{
    
             if(checkInputs() && noTF.getText() !=null)
     {
            String UpdateQuery= null;
            PreparedStatement ps =null;
            Connection con=getConnection();
           
                try {
                  
                    UpdateQuery="UPDATE tambahdatakelas SET kelas=?" +" WHERE no=?";
                    ps=con.prepareStatement(UpdateQuery);
                    ps.setString(1,kelasTF.getText());
                          ps.setInt(2, Integer.parseInt(noTF.getText()));
                            
                            
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Data Berhasil Diedit","SEKOLAH CITA-CITA", JOptionPane.INFORMATION_MESSAGE);
                    bersih();
                    
                } catch (Exception ex) {
                    Logger.getLogger(datawalimurid.class.getName()).log(Level.SEVERE, null, ex);
                }
                
           
                    
         
             }else{
                  JOptionPane.showMessageDialog(null,"Id Tidak Tersedia","SEKOLAH CITA-CITA", JOptionPane.INFORMATION_MESSAGE);   
             
     }
       
}


private void hapus()
{
      
            try {
                Connection con =getConnection();
                PreparedStatement ps = con.prepareStatement("DELETE FROM tambahdatakelas WHERE no =?");
                  ps.setString(1, (String) noTF.getText());
                ps.executeUpdate();
             
                bersih();
                JOptionPane.showMessageDialog(null,"Data Berhasil Dihapus","SEOLAH CITA-CITA", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
           
            
        }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        kelasTF = new javax.swing.JTextField();
        noTF = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        editBT = new javax.swing.JButton();
        simpanBT = new javax.swing.JButton();
        hapusBT = new javax.swing.JButton();
        tambahBT = new javax.swing.JButton();
        cariBT = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA MURID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 210, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TAMBAH DATA KELAS");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 1100, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.gray), "Masukan Inputan Data", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Kelas  :");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("No      :");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 50, -1));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 560, 10));

        kelasTF.setBorder(null);
        jPanel3.add(kelasTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 510, 40));

        noTF.setBorder(null);
        jPanel3.add(noTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 460, 40));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 560, 10));

        editBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        editBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Edit.png"))); // NOI18N
        editBT.setText("EDIT");
        editBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editBTMouseEntered(evt);
            }
        });
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });
        jPanel3.add(editBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, 130, 50));

        simpanBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpanBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Simpan.png"))); // NOI18N
        simpanBT.setText("SIMPAN");
        simpanBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                simpanBTMouseEntered(evt);
            }
        });
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });
        jPanel3.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 130, 50));

        hapusBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hapusBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/trash.png"))); // NOI18N
        hapusBT.setText("HAPUS");
        hapusBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                hapusBTMouseEntered(evt);
            }
        });
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });
        jPanel3.add(hapusBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 130, 50));

        tambahBT.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tambahBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Tambah.png"))); // NOI18N
        tambahBT.setText("TAMBAH");
        tambahBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tambahBTMouseEntered(evt);
            }
        });
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });
        jPanel3.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, 50));

        cariBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Cari2.png"))); // NOI18N
        cariBT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cariBTMouseEntered(evt);
            }
        });
        cariBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBTActionPerformed(evt);
            }
        });
        jPanel3.add(cariBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 110, 600, 210));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBTActionPerformed
        // TODO add your handling code here:
        
          String cari = JOptionPane.showInputDialog(null, "Cari berdasarkan Masukan No Kelas", "Input", JOptionPane.QUESTION_MESSAGE);
      
        String sql="select * from tambahdatakelas where no='"+ cari +"'";
        try {
            Connection con = getConnection();
             Statement st;
           ResultSet rs;
           st = con.createStatement();
            rs=st.executeQuery(sql);
            if (rs.next())
            {
                noTF.setText(rs.getString(1));
                kelasTF.setText(rs.getString(2));
                
                //button
                hapusBT.setEnabled(true);
                editBT.setEnabled(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"Data tidak ditemukan");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cariBTActionPerformed

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
          if(tambahBT.getText().equalsIgnoreCase("tambah")){
            tambahBT.setText("Batal");
            //bersih();
            siapIsi(true);
            kelasTF.requestFocus();
            noTF.setEnabled(false);
            tambahBT.setEnabled(true);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(false);
           
           cariBT.setEnabled(true);
        } else{
            tambahBT.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
        
    }    
    }//GEN-LAST:event_tambahBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        if(tambahBT.getText().equalsIgnoreCase("batal")){
                if(tambahBT.getText().equalsIgnoreCase("batal")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "Simpan data gagal, periksa kembali","SEKOLAH CITA-CITA",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(editBT.getText().equalsIgnoreCase("batal")){
                if(editBT.getText().equalsIgnoreCase("batal")){
                    perbarui();
                } else{
                    JOptionPane.showMessageDialog(null, "Edit data gagal, periksa kembali","SEKOLAH CITA-CITA",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            editBT.setText("Edit");
            tombolNormal();
    }//GEN-LAST:event_simpanBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        // TODO add your handling code here:
         if(editBT.getText().equalsIgnoreCase("edit")){
            editBT.setText("Batal");
            siapIsi(true);
          noTF.setEnabled(false);
          
           kelasTF.requestFocus();
            tambahBT.setEnabled(false);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(true);
           
            cariBT.setEnabled(true);
        } else{
            editBT.setText("Edit");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_editBTActionPerformed

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        // TODO add your handling code here:
        int pesan=JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                siapIsi(false);
                tombolNormal();
            } else{
                JOptionPane.showMessageDialog(null, "Hapus data gagal");
            }
        
        }
       
    }//GEN-LAST:event_hapusBTActionPerformed

    private void tambahBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tambahBTMouseEntered
        // TODO add your handling code here:
        tambahBT.setBackground(new Color(0,153,153));
      tambahBT.setForeground(Color.red);
    }//GEN-LAST:event_tambahBTMouseEntered

    private void simpanBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simpanBTMouseEntered
        // TODO add your handling code here:
          simpanBT.setBackground(new Color(0,153,153));
      simpanBT.setForeground(Color.red);
    }//GEN-LAST:event_simpanBTMouseEntered

    private void editBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBTMouseEntered
        // TODO add your handling code here:
           editBT.setBackground(new Color(0,153,153));
       editBT.setForeground(Color.red);
    }//GEN-LAST:event_editBTMouseEntered

    private void hapusBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hapusBTMouseEntered
        // TODO add your handling code here:
          hapusBT.setBackground(new Color(0,153,153));
      hapusBT.setForeground(Color.red);
    }//GEN-LAST:event_hapusBTMouseEntered

    private void cariBTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cariBTMouseEntered
        // TODO add your handling code here:
        cariBT.setBackground(new Color(0,153,153));
      cariBT.setForeground(Color.red);
    }//GEN-LAST:event_cariBTMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBT;
    private javax.swing.JButton editBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField kelasTF;
    private javax.swing.JTextField noTF;
    private javax.swing.JButton simpanBT;
    private javax.swing.JButton tambahBT;
    // End of variables declaration//GEN-END:variables
}

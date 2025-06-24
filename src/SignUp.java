

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import database.Koneksi;
import org.mindrot.jbcrypt.BCrypt;


public class SignUp extends javax.swing.JFrame {

   
    public SignUp() {
        initComponents();
            ImageSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/SignUp.jpg")));

    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jButtonSignUp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jUsername = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jFullName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ImageSignUp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPhoneNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jConfirmPasswordField = new javax.swing.JPasswordField();
        jCheckBoxAdmin = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setBackground(new java.awt.Color(0, 87, 166));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN UP");
        jLabel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(70, 16));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setText("Email: ");

        jEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEmailActionPerformed(evt);
            }
        });

        jButtonSignUp.setBackground(new java.awt.Color(0, 87, 166));
        jButtonSignUp.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonSignUp.setForeground(new java.awt.Color(51, 51, 51));
        jButtonSignUp.setText("Sign Up");
        jButtonSignUp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUpActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel3.setText("Username:");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel4.setText("Full Name:");

        jFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFullNameActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("Password:");

        ImageSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/SignUp.jpg"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel6.setText("Phone Number:");

        jPhoneNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPhoneNumberActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 23)); // NOI18N
        jLabel7.setText("Confirm Password:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Already have an account?");

        jButtonLogin.setBackground(new java.awt.Color(0, 87, 166));
        jButtonLogin.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(51, 51, 51));
        jButtonLogin.setText("Log In");
        jButtonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });

        jCheckBoxAdmin.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jCheckBoxAdmin.setText("Sign Up as Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSignUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jConfirmPasswordField)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jCheckBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 192, Short.MAX_VALUE))
                                    .addComponent(jEmail)
                                    .addComponent(jUsername)
                                    .addComponent(jFullName)
                                    .addComponent(jPhoneNumber)
                                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(ImageSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jConfirmPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jCheckBoxAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImageSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEmailActionPerformed
    }//GEN-LAST:event_jEmailActionPerformed

    private void jFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFullNameActionPerformed
    }//GEN-LAST:event_jFullNameActionPerformed

    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSignUpActionPerformed
        String email = jEmail.getText();
        String username = jUsername.getText();
        String fullName = jFullName.getText();
        String phoneNumber = jPhoneNumber.getText();
        String password = new String(jPasswordField1.getPassword());
        String confirmPassword = new String(jConfirmPasswordField.getPassword());
        boolean isAdmin = jCheckBoxAdmin.isSelected();
        
        if (email.isEmpty() || username.isEmpty() || fullName.isEmpty() || phoneNumber.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!email.contains("@") || !email.contains(".")) {
            JOptionPane.showMessageDialog(this, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

            insertUserIntoDatabase(email, username, fullName, phoneNumber, password, isAdmin);

    }//GEN-LAST:event_jButtonSignUpActionPerformed
 private void insertUserIntoDatabase(String email, String username, String fullName, String phoneNumber, String password, boolean isAdmin) {
    Connection conn = Koneksi.getKoneksi();
    try {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        String sql = "INSERT INTO USER_TABLE (email, username, full_name, phone_number, password, is_admin) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setString(2, username);
        stmt.setString(3, fullName);
        stmt.setString(4, phoneNumber);
        stmt.setString(5, hashedPassword);
        stmt.setBoolean(6, isAdmin);

        int rowsInserted = stmt.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Sign Up Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.dispose(); 
            new Login().setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(this, "Error while signing up, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        stmt.close();
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while connecting to the database.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}



    private void jPhoneNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPhoneNumberActionPerformed
     
    }//GEN-LAST:event_jPhoneNumberActionPerformed

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
 
        new Login().setVisible(true); 
        this.dispose(); 
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
      
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageSignUp;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JCheckBox jCheckBoxAdmin;
    private javax.swing.JPasswordField jConfirmPasswordField;
    private javax.swing.JTextField jEmail;
    private javax.swing.JTextField jFullName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jPhoneNumber;
    private javax.swing.JTextField jUsername;
    // End of variables declaration//GEN-END:variables
}

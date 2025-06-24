
import database.Koneksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.sql.*;
import database.Koneksi;
import org.mindrot.jbcrypt.BCrypt;


public class Login extends javax.swing.JFrame {

   
    public Login() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jEmail = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ImageSignUp = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonSignUp = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 245, 245));

        jLabel1.setBackground(new java.awt.Color(0, 87, 166));
        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOGIN");
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

        jButtonLogin.setBackground(new java.awt.Color(0, 87, 166));
        jButtonLogin.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(51, 51, 51));
        jButtonLogin.setText("Login");
        jButtonLogin.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel5.setText("Password:");

        ImageSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/res/SignUp.jpg"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Don't have an account?");

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(92, 92, 92)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jEmail)
                                    .addComponent(jPasswordField1)))
                            .addComponent(jButtonLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 226, Short.MAX_VALUE)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(304, 304, 304)
                        .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ImageSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
    // DEBUG hash
    String hashed = BCrypt.hashpw("123", BCrypt.gensalt());
    System.out.println("Hash dari '123' adalah: " + hashed);

    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new Login().setVisible(true);
        }
    });
}

    
  private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                              
    String email = jEmail.getText();
    String password = new String(jPasswordField1.getPassword());

    if (email.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter both email and password", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (validateCredentials(email, password)) {
        JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
        this.dispose(); 


    } else {
        JOptionPane.showMessageDialog(this, "Invalid email or password", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

private void jEmailActionPerformed(java.awt.event.ActionEvent evt) {                                       
    jPasswordField1.requestFocus();
}

private boolean validateCredentials(String email, String password) {
    boolean isValid = false;
    boolean isAdmin = false;
    Connection conn = Koneksi.getKoneksi();

    try {
        String sql = "SELECT * FROM USER_TABLE WHERE email = ?";  
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);  

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            String storedPassword = rs.getString("password");  
            isAdmin = rs.getBoolean("is_admin");

            System.out.println("Entered Password: " + password);
            System.out.println("Stored Hashed Password: " + storedPassword);

            if (BCrypt.checkpw(password, storedPassword)) {
                isValid = true;  
                System.out.println("Password match successful.");
            } else {
                System.out.println("Password does not match.");
            }
        } else {
            System.out.println("Email not found.");
        }

        rs.close();
        stmt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    if (isValid) {
        HomePage homePage = new HomePage(email, isAdmin);  // Pass username and isAdmin flag
        homePage.setVisible(true);  
        this.dispose();  
    }

    return isValid;
}






    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {                                              
        new SignUp().setVisible(true); 
        this.dispose(); 
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageSignUp;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JTextField jEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    // End of variables declaration//GEN-END:variables


}
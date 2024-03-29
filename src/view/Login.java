/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import chat.ChatInterface;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author shenugayana
 */
public class Login extends javax.swing.JFrame implements KeyListener {

    String username;
    ChatInterface chat;
    List<String> users = new ArrayList<>();

    /**
     * Creates new form WelcomeView
     */
    public Login(ChatInterface chat) {    // to hold passing "chat" parameter
        initComponents();               // initializing JFrame's components
        this.chat = chat;
        userNameInputText.addKeyListener(this);
        setVisible(true);
        setLocationRelativeTo(null);    // to visible the GUI in the middle of the screen
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginButton = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userNameInputText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ArulWing");
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        setResizable(false);
        getContentPane().setLayout(null);

        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BtnLogin.png"))); // NOI18N
        loginButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Login(evt);
            }
        });
        getContentPane().add(loginButton);
        loginButton.setBounds(800, 410, 145, 40);

        jLabel2.setFont(new java.awt.Font("DejaVu Sans", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 75, 91));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Enter Your Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(740, 300, 250, 26);

        userNameInputText.setFont(new java.awt.Font("Leelawadee UI Semilight", 0, 24)); // NOI18N
        userNameInputText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userNameInputText.setBorder(null);
        getContentPane().add(userNameInputText);
        userNameInputText.setBounds(760, 348, 220, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/BgLogin.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1280, 720);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Login(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Login
        userLogin();
    }//GEN-LAST:event_Login


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel loginButton;
    private javax.swing.JTextField userNameInputText;
    // End of variables declaration//GEN-END:variables

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {  // key event to the text field
            userLogin();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void userLogin() {
        username = userNameInputText.getText();
        try {
            users = chat.getAllUsers();
        } catch (RemoteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (users.contains(username)) {
            JOptionPane.showMessageDialog(null, "This user is already exists");
            System.exit(0);
        } else {
            try {
                new Home(chat, username);   // pass the reference "chat" and the logged user's name
            } catch (RemoteException ex) {      // and create new ChatView
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.setVisible(false);
        }
    }

}

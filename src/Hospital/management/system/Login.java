package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static java.awt.Font.BOLD;



public class Login extends JFrame implements ActionListener {

    JTextField jtextfield;
    JPasswordField jpasswordfield;
    JButton Login, Cancel;


    Login() {
        //FRAME LAYOUT
        setSize(600, 250);
        setLocationRelativeTo(null);
        setLayout(null);

        //USERNAME LAYOUT
        JLabel namelabel = new JLabel("username:");
        namelabel.setForeground(Color.black);
        namelabel.setBounds(30, 30, 100, 30);
        namelabel.setFont(new Font("Thoma", BOLD, 16));
        add(namelabel);

        //DECLARATION OF USERNAME
        jtextfield = new JTextField();
        jtextfield.setBounds(150, 32, 200, 25);
        jtextfield.setFont(new Font("Thoma", BOLD, 15));
        add(jtextfield);



        //PASSWORD LAYOUT
        JLabel password = new JLabel("password:");
        password.setForeground(Color.black);
        password.setBounds(30, 80, 100, 30);
        password.setFont(new Font("Thoma", BOLD, 16));
        add(password);




        // DECLARATION OF PASSWORD
        jpasswordfield = new JPasswordField();
        jpasswordfield.setBounds(150, 82, 200, 25);
        jpasswordfield.setFont(new Font("Thoma", BOLD, 15));
        add(jpasswordfield);


        //BUTTON FOR LOGIN
        Login = new JButton("Login");
        Login.setBounds(30, 145, 80, 25);
        Login.setFont(new Font("serif", BOLD, 15));
        Login.setBackground(Color.BLACK);
        Login.setForeground(Color.WHITE);
        Login.addActionListener(this);
        add(Login);

        //BUTTON FOR CANCEL
        Cancel = new JButton("Cancel");
        Cancel.setBounds(160, 145, 80, 25);
        Cancel.setFont(new Font("serif", BOLD, 15));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.addActionListener(this);
        add(Cancel);



        // ADDING IMAGE
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/stethoscope.jpg"));
        Image i1 = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        JLabel label = new JLabel(new ImageIcon(i1));
        label.setBounds(350, 20, 200, 200);
        add(label);


         //setUndecorated(true);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() ==Login) {

            try {
                Connect c = new Connect();
                String user = jtextfield.getText();
                String pass = new String(jpasswordfield.getPassword());

                String q = "SELECT * FROM LOGIN WHERE USERNAME=? AND PASSWORD =?";
                        PreparedStatement ps=c.connection.prepareStatement(q);
                        ps.setString(1,user);
                        ps.setString(2,pass);
                        ResultSet resultSet=ps.executeQuery();
                if (resultSet.next()) {
                  //  JOptionPane.showMessageDialog(null,"Login successful");
                    new Reception();
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid password or username");
                }


            } catch (Exception ex) {
                System.out.println("Cannot connect to DB"+ex.getMessage());
            }
        }
             else{
                System.exit(10);
            }



        }

        public static void main(String[]args){
            new Login();

        }

    }

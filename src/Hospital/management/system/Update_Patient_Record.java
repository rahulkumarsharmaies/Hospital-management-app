package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update_Patient_Record extends JFrame {
      Update_Patient_Record(){
          JPanel panel=new JPanel();
          panel.setBounds(1,1,499,499);
          panel.setLayout(null);
          add(panel);

          JLabel UPR=new JLabel("UPDATE PATIENT RECORD");
          UPR.setBounds(100,10,300,20);
          UPR.setFont(new Font("ITALIC",Font.BOLD,16));
          UPR.setForeground(Color.RED);
          panel.add(UPR);


          JLabel Name =new JLabel("NAME:");
          Name.setBounds(10,50,100,20);
          Name.setFont(new Font("ITALIC",Font.BOLD,14));
          Name.setForeground(Color.BLACK);
          panel.add(Name);

          Choice choice=new Choice();
          choice.setBounds(150,50,150,20);
          choice.setForeground(Color.BLACK);
          panel.add(choice);
            try{
                Connect c=new Connect();
                ResultSet resultSet = c.statement.executeQuery("SELECT * FROM NEW_PATIENT");
                while(resultSet.next()){
                    choice.add(resultSet.getString("Name"));

                }
            }catch(SQLException ex){
                System.out.println("problem in DB connection"+ex.getMessage());
            }

          JLabel Room=new JLabel("ROOM NO:");
          Room.setBounds(10,100,100,20);
          Room.setFont(new Font("ITALIC",Font.BOLD,14));
          Room.setForeground(Color.BLACK);
          panel.add(Room);

          JTextField textFieldR=new JTextField();
          textFieldR.setBounds(150,100,150,20);
          textFieldR.setFont(new Font("ITALIC",Font.BOLD,14));
          textFieldR.setForeground(Color.BLACK);
          panel.add(textFieldR);


          JLabel CheckIn=new JLabel("CHECK IN:");
          CheckIn.setBounds(10,140,100,20);
          CheckIn.setFont(new Font("ITALIC",Font.BOLD,14));
          CheckIn.setForeground(Color.BLACK);
          panel.add(CheckIn);

          JTextField CItextField=new JTextField();
          CItextField.setBounds(150,140,150,20);
          CItextField.setFont(new Font("ITALIC",Font.BOLD,14));
          CItextField.setForeground(Color.BLACK);
          panel.add(CItextField);

          JLabel AmountPaid=new JLabel("AMOUNT PAID:");
          AmountPaid.setBounds(10,190,120,20);
          AmountPaid.setFont(new Font("ITALIC",Font.BOLD,14));
          AmountPaid.setForeground(Color.BLACK);
          panel.add(AmountPaid);


          JTextField AmountPaidTF=new JTextField();
          AmountPaidTF.setBounds(150,190,150,20);
          AmountPaidTF.setFont(new Font("ITALIC",Font.BOLD,14));
          AmountPaidTF.setForeground(Color.BLACK);
          panel.add(AmountPaidTF);

          JLabel DueAmountTF=new JLabel("DUE AMOUNT:");
          DueAmountTF.setBounds(10,230,120,20);
          DueAmountTF.setFont(new Font("ITALIC",Font.BOLD,14));
          DueAmountTF.setForeground(Color.BLACK);
          panel.add(DueAmountTF);

          JTextField DueAmount=new JTextField();
          DueAmount.setBounds(150,230,150,20);
          DueAmount.setFont(new Font("ITALIC",Font.BOLD,14));
          DueAmount.setForeground(Color.BLACK);
          panel.add(DueAmount);

            JButton Check=new JButton("CHECK");
            Check.setBounds(100,400,100,20);
            Check.setBackground(Color.BLACK);
            Check.setForeground(Color.WHITE);
            Check.setFont(new Font("ITALIC",Font.BOLD,14));
            panel.add(Check);
            Check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String id=choice.getSelectedItem();
                    String q="SELECT *FROM NEW_PATIENT WHERE NAME='"+id+"'";
                           try{
                               Connect c=new Connect();
                               ResultSet resultSet=c.statement.executeQuery(q);
                               while(resultSet.next()){
                                   textFieldR.setText(resultSet.getString("Room"));
                                   CItextField.setText(resultSet.getString("admission_date"));
                                   AmountPaidTF.setText(resultSet.getString("amount paid"));
                               }
                               ResultSet resultSet1=c.statement.executeQuery("SELECT *FROM ROOM WHERE ROOM_NO='"+textFieldR.getText()+"'");
                               while(resultSet1.next()){
                                   String price=resultSet1.getString("price");
                                   int amountPaid=Integer.parseInt(price)-Integer.parseInt(AmountPaidTF.getText());
                                   DueAmountTF.setText(""+amountPaid);
                               }

                           }catch(SQLException ex){
                               System.out.println("Cannot connect to DB"+ex.getMessage());
                           }
                }
            });

          Button button=new Button("Back");
          button.setBounds(300,400,100,20);
          button.setFont(new Font("Thoma",Font.BOLD,14));
          button.setBackground(Color.BLACK);
          button.setForeground(Color.WHITE);
          panel.add(button);
          button.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  setVisible(false);
              }
          });



          setUndecorated(true);
          setSize(500,500);
          setLocation(450,210);
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          setVisible(true);

      }
    public static void main(String[] args) {
        new Update_Patient_Record();
    }
}

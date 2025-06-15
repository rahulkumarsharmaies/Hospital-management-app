package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import static java.awt.Font.BOLD;

public class Patient_Discharge extends JFrame {
      Patient_Discharge(){

          setSize(700,500);

          setLocation(450,210);
          setDefaultCloseOperation(EXIT_ON_CLOSE);



          JPanel panel=new JPanel();
          panel.setLayout(null);
          panel.setBounds(5,5,690,490);
          panel.setBackground(Color.PINK);
          add(panel);

          JLabel id=new JLabel("PATIENT   DISCHARGE ");
          id.setBounds(250,20,200,25);
          id.setFont(new Font("Thoma",BOLD,15));
          panel.add(id);

          JLabel id_number=new JLabel("ID NUMBER :");
          id_number.setBounds(25,80,100,20);
          id_number.setFont(new Font("Thoma",BOLD,13));
          panel.add(id_number);

          Choice choice=new Choice();
          choice.setBounds(200,80,150,20);
          panel.add(choice);

          try {
              Connect c=new Connect();
              ResultSet resultset=c.statement.executeQuery("select *from new_patient");
              while(resultset.next()){
                  choice.add(resultset.getString("id_number"));
              }

          }catch(SQLException ex){
              System.out.println(ex.getMessage());
          }

          JLabel RoomNo=new JLabel("ROOM NO:");
          RoomNo.setBounds(25,120,200,20);
          RoomNo.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(RoomNo);

          JLabel PRoomNo=new JLabel();
          PRoomNo.setBounds(200,120,200,20);
          PRoomNo.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(PRoomNo);


          JLabel Name=new JLabel("PATIENT NAME:");
          Name.setBounds(25,160,200,20);
          Name.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(Name);

          JLabel PName=new JLabel();
          PName.setBounds(200,160,200,20);
          PName.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(PName);

          JLabel Admit=new JLabel("PATIENT ADMIT DATE :");
          Admit.setBounds(25,200,200,20);
          Admit.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(Admit);

          JLabel PAdmit=new JLabel();
          PAdmit.setBounds(200,200,200,20);
          PAdmit.setFont(new Font("Thoma",Font.BOLD,13));
          panel.add(PAdmit);


          JLabel Discharge=new JLabel("PATIENT DISCHARGE DATE:");
          Discharge.setBounds(25,240,200,20);
          Discharge.setFont(new Font("Thoma",Font.BOLD,12));
          panel.add(Discharge);



          Date date=new Date();
          JLabel DischargeTime=new JLabel(""+date);
          DischargeTime.setBounds(200,240,200,20);
          DischargeTime.setFont(new Font("Thoma",Font.BOLD,12));
          panel.add(DischargeTime);


          Button Check=new Button("CHECK");
          Check.setBounds(25,400,100,20);
          Check.setBackground(Color.BLACK);
          Check.setForeground(Color.white);
          Check.setFont(new Font("Thoma", BOLD,14));
          panel.add(Check);
          Check.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Connect c=new Connect();
                  try{
                      ResultSet resultSet=c.statement.executeQuery("select*from new_patient where id_number='"+choice.getSelectedItem()+"'");
                      while(resultSet.next()){
                          PName.setText(resultSet.getString("name"));
                          PRoomNo.setText(resultSet.getString("room"));
                          PAdmit.setText(resultSet.getString("admission_date"));
                      }

                  }catch(SQLException ex){
                      System.out.println(ex.getMessage());
                  }
              }
          });




          Button Discharge2=new Button("Discharge");
          Discharge2.setBounds(160,400,100,20);
          Discharge2.setBackground(Color.BLACK);
          Discharge2.setForeground(Color.white);
          Discharge2.setFont(new Font("Thoma", BOLD,14));
          panel.add(Discharge2);
          Discharge2.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  Connect c=new Connect();
                  try{
                      c.statement.executeUpdate("delete from new_patient  where id_number='"+choice.getSelectedItem()+"'");
                      c.statement.executeUpdate("update room Availability='Available' where room_no=RoomNo");
                      JOptionPane.showMessageDialog(null,"Patient Discharged ");
                      setVisible(false);
                  }catch(SQLException ex){
                      System.out.println(ex.getMessage());
                  }
              }
          });


          Button Back=new Button("BACK");
          Back.setBounds(300,400,60,20);
          Back.setBackground(Color.BLACK);
          Back.setForeground(Color.white);
          Back.setFont(new Font("Thoma", BOLD,14));
          panel.add(Back);
          Back.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  setVisible(false);
              }
          });
          setUndecorated(true);
          setVisible(true);


      }
    public static void main(String[] args) {
        new Patient_Discharge();
    }
}

package Hospital.management.system;


import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient_info extends JFrame {

         Patient_info(){

             setSize(1000,400);
             setLayout(null);
             setLocationRelativeTo(null);
             setDefaultCloseOperation(EXIT_ON_CLOSE);


             JPanel panel=new JPanel();
             panel.setLayout(null);
             panel.setBounds(5,5,990,590);
             panel.setBackground(Color.pink);
             add(panel);

             JLabel Name=new JLabel("NAME");
             Name.setBounds(5,10,50,20);
             Name.setForeground(Color.BLACK);
             Name.setFont(new Font("ITALIC",Font.BOLD,13));
             Name.setOpaque(false);
             panel.add(Name);


             JLabel Age=new JLabel("AGE");
             Age.setBounds(90,10,50,20);
             Age.setForeground(Color.BLACK);
             Age.setFont(new Font("ITALIC",Font.BOLD,13));
             Age.setOpaque(false);
             panel.add(Age);


             JLabel Gender=new JLabel("GENDER");
             Gender.setBounds(180,10,70,20);
             Gender.setForeground(Color.BLACK);
             Gender.setFont(new Font("ITALIC",Font.BOLD,13));
             Gender.setOpaque(false);
             panel.add(Gender);

             JLabel Id=new JLabel("ID TYPE");
             Id.setBounds(265,10,50,20);
             Id.setForeground(Color.BLACK);
             Id.setFont(new Font("ITALIC",Font.BOLD,13));
             Id.setOpaque(false);
             panel.add(Id);

             JLabel Mobile=new JLabel("MOBILE NO");
             Mobile.setBounds(350,10,100,20);
             Mobile.setForeground(Color.BLACK);
             Mobile.setFont(new Font("ITALIC",Font.BOLD,13));
             Mobile.setOpaque(false);
             panel.add(Mobile);


             JLabel State=new JLabel("STATE");
             State.setBounds(435,10,50,20);
             State.setForeground(Color.BLACK);
             State.setFont(new Font("ITALIC",Font.BOLD,13));
             State.setOpaque(false);
             panel.add(State);


             JLabel Symptom=new JLabel("SYMPTOM");
             Symptom.setBounds(525,10,100,20);
             Symptom.setForeground(Color.BLACK);
             Symptom.setFont(new Font("ITALIC",Font.BOLD,13));
             Symptom.setOpaque(false);
             panel.add(Symptom);

             JLabel Fee=new JLabel("FEE");
             Fee.setBounds(610,10,50,20);
             Fee.setForeground(Color.BLACK);
             Fee.setFont(new Font("ITALIC",Font.BOLD,13));
             Fee.setOpaque(false);
             panel.add(Fee);

             JLabel Date=new JLabel("DATE");
             Date.setBounds(700,10,50,20);
             Date.setForeground(Color.BLACK);
             Date.setFont(new Font("ITALIC",Font.BOLD,13));
             Date.setOpaque(false);
             panel.add(Date);

             JLabel Room=new JLabel("ROOM NO");
             Room.setBounds(780,10,50,20);
             Room.setForeground(Color.BLACK);
             Room.setFont(new Font("ITALIC",Font.BOLD,13));
             Room.setOpaque(false);
             panel.add(Room);

             JLabel IdNumber=new JLabel("ID NUMBER");
             IdNumber.setBounds(870,10,100,20);
             IdNumber.setForeground(Color.BLACK);
             IdNumber.setFont(new Font("ITALIC",Font.BOLD,13));
             IdNumber.setOpaque(false);
             panel.add(IdNumber);


             JTable table=new JTable();
             table.setBounds(5,50,950,150);
             table.setFont(new Font("thoma",Font.BOLD,12));
             table.setBackground(Color.white);
             panel.add(table);
             try{
                 Connect c=new Connect();
                 String q="select *from new_patient";
                 ResultSet resultSet=c.statement.executeQuery(q);
                 table.setModel(DbUtils.resultSetToTableModel(resultSet));

             }catch(SQLException ex){
                 System.out.println(ex.getMessage());
             }

             Button button=new Button("BACK");
             button.setBounds(400,360,100,20);
             button.setBackground(Color.BLACK);
             button.setForeground(Color.white);
             panel.add(button);
             button.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent e) {
                     setVisible(false);
                 }
             });
            setUndecorated(true);
           setVisible(true);
        }
    public static void main(String[] args) {
        new Patient_info();
    }
}

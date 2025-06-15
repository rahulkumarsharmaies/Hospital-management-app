package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class HospitalAmbulance extends JFrame {
    HospitalAmbulance(){
        JPanel panel=new JPanel();
        panel.setBounds(1,1,699,499);
        panel.setBackground(Color.pink);
        panel.setLayout(null);
        add(panel);

        JLabel label=new JLabel("AMBULANCE RECORD");
        label.setBounds(250,10,300,20);
        label.setFont(new Font("ITALIC",Font.BOLD,15));
        label.setForeground(Color.RED);
        panel.add(label);

        JLabel Name=new JLabel("NAME");
        Name.setBounds(10,40,50,20);
        Name.setFont(new Font("ITALIC",Font.BOLD,13));
        Name.setForeground(Color.black);
        panel.add(Name);


        JLabel Age=new JLabel("AGE");
        Age.setBounds(150,40,50,20);
        Age.setFont(new Font("ITALIC",Font.BOLD,13));
        Age.setForeground(Color.black);
        panel.add(Age);



        JLabel License=new JLabel("LICENSE NO");
        License.setBounds(280,40,120,20);
        License.setFont(new Font("ITALIC",Font.BOLD,13));
        License.setForeground(Color.black);
        panel.add(License);


        JLabel vehicleNo=new JLabel("VEHICLE NO");
        vehicleNo.setBounds(420,40,120,20);
        vehicleNo.setFont(new Font("ITALIC",Font.BOLD,13));
        vehicleNo.setForeground(Color.black);
        panel.add(vehicleNo);


        JLabel vehicleType=new JLabel("VEHICLE TYPE");
        vehicleType.setBounds(560,40,120,20);
        vehicleType.setFont(new Font("ITALIC",Font.BOLD,13));
        vehicleType.setForeground(Color.black);
        panel.add(vehicleType);

        JTable ambulance_record_table=new JTable();
        ambulance_record_table .setBounds(5,60,690,300);
        ambulance_record_table.setFont(new Font("thoma ",Font.PLAIN,12));
        ambulance_record_table.setOpaque(false);
        panel.add(ambulance_record_table);
        try{
            Connect c=new Connect();
            ResultSet resultSet=c.statement.executeQuery("select *from ambulance_record");
            ambulance_record_table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (SQLException ex){
            System.out.println("do not connect to db"+ex.getMessage());
        }

        JButton Back=new JButton("BACK");
        Back.setBounds(290,380,100,20);
        Back.setFont(new Font("ITALIC",Font.BOLD,15));
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(700,500);
        setBackground(Color.GRAY);
        setLocation(450,210);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HospitalAmbulance();
    }
}

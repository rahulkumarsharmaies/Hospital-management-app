package Hospital.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.BOLD;


public class Reception extends JFrame {

    Reception() {


        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,1525,200);
        panel.setBackground(Color.WHITE);
        add(panel);


        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5,170,1525,210);
        add(panel1);

        //ADD NEW PATIENT
        JButton button1=new JButton("Add new Patient");
        button1.setBounds(3,2,180,35);
        button1.setFont(new Font("serif",BOLD,20));
        button1.setBorder(null);
        panel.add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new new_patient();
            }
        });

        //ROOMS
        JButton button2=new JButton("Rooms");
        button2.setBounds(3,40,180,35);
        button2.setFont(new Font("serif",BOLD,20));
        button2.setBorder(null);
        panel.add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        //DEPARTMENT
        JButton button3=new JButton("Department");
        button3.setBounds(3,80,180,35);
        button3.setFont(new Font("serif",BOLD,20));
        button3.setBorder(null);
        panel.add(button3);
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });


        //ALL EMPLOYEE INFO
        JButton button4=new JButton("All emp info");
        button4.setBounds(200,2,180,35);
        button4.setFont(new Font("serif",BOLD,20));
        button4.setBorder(null);
        panel.add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Employee_info();
            }
        });

        //PATIENT INFORMATION
        JButton button5=new JButton(" Patient info ");
        button5.setBounds(200,40,180,35);
        button5.setFont(new Font("serif",BOLD,20));
        button5.setBorder(null);
        panel.add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });

        //PATIENT DISCHARGE
        JButton button6=new JButton("patient discharge");
        button6.setBounds(200,79,180,35);
        button6.setFont(new Font("serif",BOLD,20));
        button6.setBorder(null);
        panel.add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Patient_Discharge();
            }
        });


        //UPDATE PATIENT RECORD
        JButton button7=new JButton("update patient rec");
        button7.setBounds(390,2,180,35);
        button7.setFont(new Font("serif",BOLD,20));
        //button7.setBackground(Color.WHITE);
        button7.setBorder(null);
        panel.add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new Update_Patient_Record();
            }
        });

        //HOSPITAL AMBULANCE
        JButton button8=new JButton("hospital Ambulance");
        button8.setBounds(390,40,180,35);
        button8.setFont(new Font("serif",BOLD,20));
        //button8.setBackground(Color.WHITE);
        button8.setBorder(null);
        panel.add(button8);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HospitalAmbulance();
            }
        });


        //SEARCH ROOMS
        JButton button9=new JButton("Search rooms");
        button9.setBounds(390,78,180,35);
        button9.setFont(new Font("serif",BOLD,20));
        //button9.setBackground(Color.WHITE);
        button9.setBorder(null);
        panel.add(button9);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new SearchRoom();
            }
        });

        //LOGOUT
        JButton button10=new JButton("LogOut");
        button10.setBounds(580,2,180,35);
        button10.setFont(new Font("serif",BOLD,20));
       // button10.setBackground(Color.WHITE);
        button10.setBorder(null);
        panel.add(button10);
        button10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    setVisible(false);
                    JOptionPane.showMessageDialog(null,"LogOut Successfully");
            }
        });

        //PANEL IMAGE
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Icon/Reception.jpg"));
       Image image=i1.getImage().getScaledInstance(500,200,Image.SCALE_DEFAULT);
       ImageIcon i2=new ImageIcon(image);
       JLabel label=new JLabel(i2);
       label.setBounds(1000,2,500,200);
       panel.add(label);


        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("Icon/FrontImage.jpeg"));
        Image image1=i3.getImage().getScaledInstance(1525,600,Image.SCALE_DEFAULT);
        ImageIcon i4=new ImageIcon(image1);
        JLabel label1=new JLabel(i4);
        label1.setBounds(1,202,1525,600);
        panel1.add(label1);


        setUndecorated(true);
        setSize(1920,1080);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Reception();

    }
}

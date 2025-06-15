package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee_info extends JFrame {
    Employee_info(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,990,590);
        panel.setBackground(Color.WHITE);
        add(panel);

        JLabel Name=new JLabel("NAME");
        Name.setBounds(5,20,50,20);
        Name.setForeground(Color.BLACK);
        Name.setOpaque(false);
        panel.add(Name);

        JLabel Age=new JLabel("AGE");
        Age.setBounds(150,20,50,20);
        Age.setForeground(Color.BLACK);
        Age.setOpaque(false);
        panel.add(Age);

        JLabel Gender=new JLabel("GENDER");
        Gender.setBounds(285,20,100,20);
        Gender.setForeground(Color.BLACK);
        Gender.setOpaque(false);
        panel.add(Gender);

        JLabel Id=new JLabel("ID NUMBER");
        Id.setBounds(425,20,100,20);
         Id.setForeground(Color.BLACK);
         Id.setOpaque(false);
        panel.add (Id);

        JLabel Aadharno=new JLabel("AADHAR NO");
        Aadharno.setBounds(570,20,100,20);
        Aadharno.setForeground(Color.BLACK);
        Aadharno.setOpaque(false);
        panel.add(Aadharno);


        JLabel Department=new JLabel("DEPARTMENT");
        Department.setBounds(710,20,100,20);
        Department.setForeground(Color.BLACK);
        Department.setOpaque(false);
        panel.add(Department);



        JLabel Mobile=new JLabel("MOBILE NO");
        Mobile.setBounds(850,20,100,20);
        Mobile.setForeground(Color.BLACK);
        Mobile.setOpaque(false);
        panel.add(Mobile);

        JTable table=new JTable();
        table.setBounds(5,60,980,300);
        table.setBackground(Color.white);
        table.setOpaque(false);
        panel.add(table);

        try{
            Connect c=new Connect();
            String q="select *from Employee_info";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }


        Button button=new Button("Back");
        button.setBounds(450,500,50,20);
        button.setFont(new Font("Thoma",Font.BOLD,12));
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
        setSize(1000,600);
        setLocation(300,210);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}

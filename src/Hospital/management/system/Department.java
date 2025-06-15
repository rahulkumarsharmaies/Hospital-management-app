package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Department extends JFrame {

    Department(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,590,490);
        panel.setBackground(Color.gray);
        add(panel);

        ImageIcon RoomImage=new ImageIcon(ClassLoader.getSystemResource("Icon/Hospitalcoridoor.jpg"));
        Image image =RoomImage.getImage().getScaledInstance(590,490,Image.SCALE_DEFAULT);
        ImageIcon room= new ImageIcon(image);
        JLabel label=new JLabel(room);
        label.setBounds(5,5,590,490);
        panel.add(label);


        JLabel Department=new JLabel("DEPARTMENT");
        Department.setBounds(15,10,100,20);
        Department.setForeground(Color.BLACK);
        Department.setOpaque(false);
        label.add(Department);

        JLabel MobileNo=new JLabel("MOBILE NO");
        MobileNo.setBounds(300,10,100,20);
        MobileNo.setForeground(Color.BLACK);
        MobileNo.setOpaque(false);
        label.add(MobileNo);

       JTable table=new JTable();
       table.setBounds(5,40,590,200);
       table.setBorder(null);
       table.setOpaque(false);
       label.add(table);


        try{
            Connect c=new Connect();
            String q="select * from department";
            ResultSet resultSet=c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));


        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }

        Button Back=new Button("Back");
        Back.setBounds(230,400,100,30);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        label.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });


        setUndecorated(true);
        setSize(600,500);
        setLocation(500,210);
        setVisible(true);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new Department();
    }
}

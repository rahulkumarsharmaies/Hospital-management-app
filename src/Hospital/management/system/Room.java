package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Room extends JFrame  {
    JTable table;
    Button Back;
    Room(){
        setSize(600,600);
        setLayout(null);
        setLocation(500,210);

        JPanel panel=new JPanel();
        panel.setBounds(0,0,600,600);
        panel.setBackground(Color.gray);
        panel.setLayout(null);
        add(panel);




        ImageIcon RoomImage=new ImageIcon(ClassLoader.getSystemResource("Icon/RoomImage.jpg"));
        Image image =RoomImage.getImage().getScaledInstance(590,490,Image.SCALE_DEFAULT);
        ImageIcon room= new ImageIcon(image);
        JLabel label=new JLabel(room);
        label.setBounds(5,5,590,490);
        panel.add(label);

        table=new JTable();
        table.setBounds(5,60,580,200);
        table.setForeground(Color.BLACK);
        table.setOpaque(false);
        table.setFont(new Font("Thoma", Font.ITALIC,12));
        label.add(table);


        JLabel RoomNo=new JLabel("ROOM");
        RoomNo.setBounds(5,25,50,20);
        RoomNo.setForeground(Color.BLACK);
        RoomNo.setOpaque(false);
        RoomNo.setFont(new Font("Thoma",Font.BOLD,13));
        label.add(RoomNo);


        JLabel Available=new JLabel("AVAILABILITY");
        Available.setBounds(150,25,100,20);
        Available.setForeground(Color.BLACK);
        Available.setOpaque(false);
        Available.setFont(new Font("Thoma",Font.BOLD,13));
        label.add(Available);

        JLabel Price=new JLabel("PRICE");
        Price.setBounds(295,25,50,20);
        Price.setForeground(Color.BLACK);
        Price.setOpaque(false);
        Price.setFont(new Font("Thoma",Font.BOLD,13));
        label.add(Price);

        JLabel Bed=new JLabel("BED_TYPE");
        Bed.setBounds(440,25,100,20);
        Bed.setForeground(Color.BLACK);
        Bed.setOpaque(false);
        Bed.setFont(new Font("Thoma",Font.BOLD,13));
        label.add( Bed);


        try{
             Connect c=new Connect();
            String q="select * from room";
            ResultSet resultSet =c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

             }catch(SQLException ex){
                          System.out.println(ex.getMessage());
             }







        Back=new Button("Back");
        Back.setBounds(250,500,50,20);
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setFont(new Font("Thoma",Font.BOLD,15));
        panel.add(Back);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }

    public static void main(String[] args) {
        new Room();
    }
}

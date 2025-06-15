package Hospital.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchRoom extends JFrame {
     Choice choice;

    SearchRoom(){
        JPanel panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(1,1,499,499);
        panel.setBackground(Color.pink);

        add(panel);

        JLabel label=new JLabel("Select:");
        label.setBounds(50,40,100,20);
        label.setForeground(Color.BLACK);
        panel.add(label);

        JLabel RoomNo=new JLabel("Room No:");
        RoomNo.setBounds(5,68,80,20);
        RoomNo.setForeground(Color.BLACK);
        panel.add(RoomNo);


        JLabel Availability=new JLabel("Availability:");
        Availability.setBounds(120,68,100,20);
        Availability.setForeground(Color.BLACK);
        panel.add(Availability);


        JLabel Price=new JLabel("price:");
        Price.setBounds(250,68,100,20);
        Price.setForeground(Color.BLACK);
        panel.add(Price);


        JLabel Bed_Type=new JLabel("Bed type:");
        Bed_Type.setBounds(370,68,100,20);
        Bed_Type.setForeground(Color.BLACK);
        panel.add(Bed_Type);

        JTable table=new JTable();
        table.setBounds(2,100,490,200);
        table.setOpaque(false);
        panel.add(table);
        try{
            Connect c=new Connect();
            ResultSet resultSet=c.statement.executeQuery("select *from room");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch(SQLException ex){
            System.out.println("did no connect to DB"+ex.getMessage());
        }

        choice=new Choice();
        choice.setBounds(200,40,150,20);
        choice.add("available");
        choice.add("occupied");
        panel.add(choice);


        Button Search=new Button("SEARCH");
        Search.setBounds(60,400,100,20);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        Search.setFont(new Font("Thoma",Font.BOLD,12));
        panel.add(Search);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String q="select *from room where availability='"+choice.getSelectedItem()+"'";
                try{
                    Connect c=new Connect();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(SQLException ex){
                    System.out.println("did not connect to DB"+ex.getMessage());

                }
            }
        });


        Button back=new Button("BACK");
        back.setBounds(200,400,80,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Thoma",Font.BOLD,12));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);

        setSize(500,500);
        setLayout(null);
        setLocation(550,210);
        setBackground(Color.GRAY);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}

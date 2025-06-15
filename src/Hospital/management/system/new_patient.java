package Hospital.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;


import static java.awt.Font.BOLD;



public class new_patient  extends JFrame{

    JComboBox idCombo, roomComboBox;
    JTextField ageTF, nameTF, depositTF, idNumberTF, contactNoTF, addressTF, symptomTF;
    JRadioButton male, female;
    Choice c1;
    JLabel date;
    JButton submit, cancel;

    new_patient() {


        setSize(800, 550);
        setLayout(null);
        setLocation(400,210);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //LAYOUT OF PANEL
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 795, 495);
        panel.setLayout(null);
        add(panel);


        JLabel labelName = new JLabel("PATIENT  FORM");
        labelName.setBounds(300, 10, 200, 25);
        labelName.setFont(new Font("Thoma", BOLD, 17));
        labelName.setForeground(Color.red);
        panel.add(labelName);


//        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("Icon/stethoscope.png"));
//        Image image = imageIcon.getImage().getScaledInstance(180, 150, Image.SCALE_DEFAULT);
//        ImageIcon imageIcon1 = new ImageIcon(image);
//        JLabel label = new JLabel(imageIcon1);
//        label.setBounds(300, 50, 180,150);
//        panel.add(label);


        //1.NAME LAYOUT
        JLabel labelName1 = new JLabel(" PATIENT NAME:");
        labelName1.setBounds(30, 70, 100, 20);
        labelName1.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelName1);

        nameTF = new JTextField();
        nameTF.setBounds(160, 70, 200, 23);
        nameTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(nameTF);



        //2.AGE LAYOUT
        JLabel labelNumber = new JLabel("AGE:");
        labelNumber.setBounds(30, 100, 100, 23);
        labelNumber.setForeground(new Color(0, 0, 0));
        labelNumber.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelNumber);

        ageTF = new JTextField();
        ageTF.setBounds(160, 100, 200, 20);
        ageTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(ageTF);

        //3.GENDER
        JLabel labelGender = new JLabel("GENDER:");
        labelGender.setBounds(30, 132, 200, 20);
        labelGender.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelGender);

        male = new JRadioButton("male");
        male.setBounds(160, 135, 80, 15);
        male.setFont(new Font("Thoma", BOLD, 12));
        panel.add(male);

        female = new JRadioButton("female");
        female.setBounds(240, 135, 80, 15);
        female.setFont(new Font("Thoma", BOLD, 12));
        panel.add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);


        //4.IDs
        JLabel labelID = new JLabel("ID:");
        labelID.setBounds(30, 165, 50, 20);
        labelID.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelID);

        idCombo = new JComboBox<>(new String[]{"select", "Aadhar_card", "Voter id card", "Pan card", "Passport"});
        idCombo.setBounds(160, 165, 200, 20);
        idCombo.setFont(new Font("Thoma", BOLD, 12));
        panel.add(idCombo);


        //ID NUMBER
        JLabel labelIdNumber = new JLabel("ID NUMBER:");
        labelIdNumber.setBounds(30, 205, 150, 20);
        labelIdNumber.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelIdNumber);

        idNumberTF = new JTextField();
        idNumberTF.setBounds(160, 205, 200, 20);
        idNumberTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(idNumberTF);

        //5.CONTACT NO
        JLabel labelContact = new JLabel("CONTACT NO:");
        labelContact.setBounds(30, 235, 150, 20);
        labelContact.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelContact);

        contactNoTF = new JTextField();
        contactNoTF.setBounds(160, 235, 200, 20);
        contactNoTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(contactNoTF);

        //6.ADDRESS
        JLabel labelAddress = new JLabel("ADDRESS:");
        labelAddress.setBounds(30, 265, 150, 20);
        labelAddress.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelAddress);

        addressTF = new JTextField();
        addressTF.setBounds(160, 265, 200, 20);
        addressTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(addressTF);

        //7.SYMPTOM
        JLabel labelSymptom = new JLabel("SYMPTOM :");
        labelSymptom.setBounds(30, 300, 150, 20);
        labelSymptom.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelSymptom);

        symptomTF = new JTextField();
        symptomTF.setBounds(160, 300, 200, 40);
        symptomTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(symptomTF);


        //8.DATE
        JLabel labelDate = new JLabel("DATE &TIME:");
        labelDate.setBounds(30, 350, 90, 20);
        labelDate.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelDate);

        Date date1 = new Date();
        date = new JLabel("" + date1);
        date.setBounds(160, 350, 200, 20);
        date.setFont(new Font("Thoma", BOLD, 12));
        panel.add(date);

        //9.DEPOSIT BUTTON
        JLabel labelDeposit= new JLabel("DEPOSIT:");
        labelDeposit.setBounds(30, 415, 90, 20);
        labelDeposit.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelDeposit);

        depositTF = new JTextField();
        depositTF.setBounds(160, 415, 200, 20);
        depositTF.setFont(new Font("Thoma", BOLD, 12));
        panel.add(depositTF);

        //10.ROOMS
        JLabel labelRoom = new JLabel("ROOMS :");
        labelRoom.setBounds(30, 380, 90, 20);
        labelRoom.setFont(new Font("Thoma", BOLD, 12));
        panel.add(labelRoom);

        roomComboBox = new JComboBox<>(new String[]{"101", "102", "201", "202", "301", "302"});
        roomComboBox.setBounds(160, 380, 200, 20);
        roomComboBox.setFont(new Font("Thoma", BOLD, 12));
        panel.add(roomComboBox);


        //ADD SUBMIT BUTTON
        submit = new JButton("SUBMIT");
        submit.setBounds(50, 460, 90, 20);
        submit.setFont(new Font("Thoma", BOLD, 12));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.CYAN);
        panel.add(submit);


        //ADD CANCEL BUTTON
        cancel = new JButton("CANCEL");
        cancel.setBounds(180, 460, 90, 20);
        cancel.setFont(new Font("Thoma", BOLD, 12));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.CYAN);
        panel.add(cancel);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        setUndecorated(true);
        setVisible(true);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name = nameTF.getText();{
                    if (name.isEmpty()) {
                        JOptionPane.showMessageDialog(panel,"Patient Name required");
                        nameTF.requestFocus();
                        return;
                    }
                }

                String age = ageTF.getText();{
                    if(age.isEmpty()){
                        JOptionPane.showMessageDialog(panel,"Age required");
                        ageTF.requestFocus();
                        return;
                    }
                }
                String gender = male.isSelected() ? "Male" : (female.isSelected() ? "Female" : "");
                String idNumber = idNumberTF.getText();{
                    if(idNumber.isEmpty()){
                        JOptionPane.showMessageDialog(panel,"ID required ");
                        idNumberTF.requestFocus();
                        return;
                    }
                }

                String idType = idCombo.getSelectedItem().toString();{
                    if(idType.isEmpty()){
                        JOptionPane.showMessageDialog(panel,"Select ID first");
                        idCombo.requestFocus();
                        return;
                    }
                }

                String contactNo = contactNoTF.getText().trim();{
                    if(contactNo.isEmpty()) {
                        JOptionPane.showMessageDialog(panel, "Contact number required ");
                        contactNoTF.requestFocus();

                        return;
                    }
                        else if(contactNo.length()!=10){
                            JOptionPane.showMessageDialog(null,"Invalid Contact number");
                        }

                    }

                String address = addressTF.getText();{
                    if(address.isEmpty()){
                        JOptionPane.showMessageDialog(panel,"Address required");
                        addressTF.requestFocus();
                        return;
                    }
                }
                String symptom = symptomTF.getText();
                String deposit = depositTF.getText();
                String dateStr = date.getText();
                String room = roomComboBox.getSelectedItem().toString();



                    try {
                        Connect c = new Connect();
                        String q = "INSERT INTO NEW_PATIENT (name, age, gender,id_type, id_number, contact_no, address, symptom, deposit, admission_date, room) " +
                                "VALUES ('" + name + "','" + age + "','" + gender + "','" + idNumber + "','" + idType + "','" + contactNo + "','" + address + "','" + symptom + "','" + deposit + "','" + dateStr + "','" + room + "')";

                        String q1 = "UPDATE room SET Availability='occupied' WHERE room_no= " + room;
                        c.statement.executeUpdate(q);
                        c.statement.executeUpdate(q1);
                        JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                        setVisible(false);
                    } catch (SQLException ex) {
                         System.out.println("error in db " + ex.getMessage());

                    }

                    }
        });

    }

    public static void main(String[] args) {
        new new_patient();
    }
}
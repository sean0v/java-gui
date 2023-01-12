import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.*;

public class Launch extends JFrame{

    JTextField tfusername, tfpassword;
    JButton buttonreg, buttonlog;
    JLabel gui, invalid;

    Launch(){
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(new Color(249, 249, 249));
    /**************************TextField*****************************/
    tfusername = new JTextField(60);
    tfpassword = new JPasswordField(60);

    tfusername.setBounds(100, 60, 120, 30);
    tfusername.setText("username");
    tfpassword.setBounds(100, 100, 120, 30);
    tfpassword.setText("password");
    /***********************BUTTONS**********************************/
    buttonreg = new JButton("Register");
    buttonreg.setBounds(70,140, 85, 30);

    buttonlog = new JButton("Login");
    buttonlog.setBounds(170,140, 85, 30);
    /***********************LABEL**********************************/
    gui = new JLabel("gui");
    gui.setFont(new Font("Times New Roman", Font.BOLD,30));
    gui.setForeground(new Color(0xCD853F));
    gui.setBounds(130,10,300,30);

    invalid = new JLabel("");
    invalid.setForeground(new Color(0xB22222));
    invalid.setBounds(75,170,300,30);
    /**********************************************************/
    add(tfusername);
    add(tfpassword);
    add(buttonlog);
    add(buttonreg);
    add(gui);
    add(invalid);

    /************************EVENT*****************************/
    buttonlog.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            boolean matched = false;
            String username = tfusername.getText().toString();
            String password = tfpassword.getText().toString();

            try{
                FileReader fr = new FileReader("login.txt");
                BufferedReader br = new BufferedReader(fr);
                String line;
                while((line=br.readLine())!=null){
                    if(line.equals(username+"\t"+password)){
                        matched = true;
                        break;
                    }
                }
                fr.close();
            }catch(Exception a){
 
            }   
            if (matched){
                dispose();
                Window window = new Window();

            }else{
                JFrame f = new JFrame();
                JOptionPane.showMessageDialog(f, "Invalid username or password :(");
                dispose();
            }
        }
        
    });
    buttonreg.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            WindowReg windowreg = new WindowReg();
            windowreg.setVisible(true);
            windowreg.setTitle("Register");
            windowreg.setBounds(200,200,300,200);
        }
    
    });
    }
}
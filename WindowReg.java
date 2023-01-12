import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class WindowReg extends JFrame{

    JTextField username, password;
    JButton ok;
    WindowReg(){

        setLayout(null);

        username = new JTextField(60);
        password = new JTextField(60);
        ok = new JButton("Create");

        username.setBounds(100,20,80,30);
        password.setBounds(100,60,80,30);
        ok.setBounds(100,100,80,30);

        add(username);
        add(password);
        add(ok);

        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try{
                    FileWriter fw = new FileWriter("login.txt", true);
                    fw.write(username.getText() + "\t" + password.getText()+ "\n");
                    fw.close();
                    JFrame f = new JFrame();
                    JOptionPane.showMessageDialog(f, "account created");
                    dispose();

                }catch(Exception a){}
                
            }

        });
    }
}

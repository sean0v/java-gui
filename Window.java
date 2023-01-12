import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.TitledBorder;
 
public class Window extends JFrame{
 
 int figure=1, color=1, fill=1;
 int[] arrayX1 = {50,250,270,70,50};
 int[] arrayY1 = {100,100,250,250,100};
 int[] arrayX2 = {50,200,200,270,200,200,50,50};
 int[] arrayY2 = {100,100,50,150,250,200,200,100};
 
    public Window() {
        super("Figure");
        setSize(300, 300);
        JFrame myWindow = new JFrame("Settings");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Box mainBox = Box.createVerticalBox();
        Box box1 = Box.createVerticalBox();
        ButtonGroup bg = new ButtonGroup();
        /**********************************************************/
        JRadioButton r1 = new JRadioButton("Parallelogram");
        r1.addActionListener((ActionEvent e) -> {
            figure=1;
         });
        JRadioButton r2 = new JRadioButton("Arrow east");
        r2.addActionListener((ActionEvent e) -> {
            figure=2;
         });
        /**********************************************************/
        r1.setSelected(true);
        bg.add(r1); bg.add(r2);
        box1.add(r1);box1.add(r2);
        box1.setBorder(new TitledBorder("Figure"));
        bg = new ButtonGroup();
        Box box2 = Box.createVerticalBox();
        /**********************************************************/
        JRadioButton r3 = new JRadioButton("Red");
        r3.addActionListener((ActionEvent e) -> {
            color=1;
         });
        JRadioButton r4 = new JRadioButton("Blue");
        r4.addActionListener((ActionEvent e) -> {
            color=2;
         });
        /**********************************************************/
        r3.setSelected(true);
        bg.add(r3); bg.add(r4);
        box2.add(r3);box2.add(r4);
        box2.setBorder(new TitledBorder("Color"));
        bg = new ButtonGroup();
        Box box3 = Box.createVerticalBox();
        JRadioButton r5 = new JRadioButton("Fill");
        /**********************************************************/
        r5.addActionListener((ActionEvent e) -> {
            fill=1;
         });
        JRadioButton r6 = new JRadioButton("Dont Fill");
        r6.addActionListener((ActionEvent e) -> {
            fill=2;
         });
        /**********************************************************/
        r5.setSelected(true);
        bg.add(r5); bg.add(r6);
        box3.add(r5);box3.add(r6);
        box3.setBorder(new TitledBorder("Option"));
        mainBox.add(box1);
        mainBox.add(box2);
        mainBox.add(box3);
        myWindow.setContentPane(mainBox);
        JButton button = new JButton("Draw");
        button.addActionListener((ActionEvent e) -> {
            repaint();
            setVisible(true);
         });
        myWindow.add(button);
        myWindow.pack();
        myWindow.setVisible(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    
 @Override
 public void paint ( Graphics g ) {
        Graphics2D graph = (Graphics2D) g;
        graph.setPaint(new Color(240,240,240));
        graph.fillRect(0, 0, 300, 300);
        if (color==1){
                Color Color = new Color(139, 0, 0);
                g.setColor(Color);
            }else {
                Color Color = new Color(0, 0, 128);
                g.setColor(Color);
            }
         if(figure==1){
             Polygon poly = new Polygon(arrayX1, arrayY1, 5);
             graph.drawPolygon(poly); 
             if(fill==1){
             graph.fillPolygon(poly);}
         }else{
             Polygon poly = new Polygon(arrayX2, arrayY2, 8);
             graph.drawPolygon(poly); 
             if(fill==1){
             graph.fillPolygon(poly);}
         }
    }
}    
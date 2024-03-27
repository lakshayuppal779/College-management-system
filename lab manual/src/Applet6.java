
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Applet6 extends Applet implements ActionListener
{
    Label label1, label2, label3;
    TextField tf1, tf2, tf3;
    Button b1, b2, b3, b4;
    String whichButtonClk;
    public void init()
    {
        System.out.println("Initializing an applet");
        label1 = new Label("Number1");
        tf1= new TextField(10);
        label2 = new Label("Number2");
        tf2= new TextField(10);
        b1 = new Button("Add");
        b2= new Button("Subtract");
        b3 = new Button("Multiply");
        b4= new Button("Divide");
        add(label1);
        add(tf1);
        add(label2);
        add(tf2);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        tf1.addActionListener(this);
        tf2.addActionListener(this);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getActionCommand().equals("Add") || ae.getActionCommand().equals("Subtract")||ae.getActionCommand().equals("Multiply")||ae.getActionCommand().equals("Divide"))
        {
            whichButtonClk=ae.getActionCommand();
            repaint();
        }
    }
    public void paint(Graphics g)
    {
        g.drawString(" enter two numbers", 10,130);
        if(tf1.getText().equals("") && tf2.getText().equals(""))
        {
        }
        else
        {
            Integer i1= new Integer(tf1.getText());
            Integer i2= new Integer(tf2.getText());
            int sum = i1+i2;
            int subtract=i1-i2;
            int multiply=i1*i2;
            float divide=(float)i1/(float)i2;
            if(whichButtonClk.equals("Add"))
                g.drawString(" sum is "+ sum, 10,190);
            if(whichButtonClk.equals("Subtract"))
                g.drawString(" subtract is "+ subtract, 10,190);
            if(whichButtonClk.equals("Multiply"))
                g.drawString(" multiply is "+ multiply, 10,190);
            if(whichButtonClk.equals("Divide"))
                g.drawString(" divide is "+ divide, 10,190);
        }
    }
}

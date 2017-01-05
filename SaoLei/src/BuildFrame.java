import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.HashMap;

/**
 * Created by Anakinliu.
 * On 2016/11/2.
 */
class Square {
    private JButton littleSquare;
    private int data;

    public JButton getLittleSquare() {
        return littleSquare;
    }

    public void setLittleSquare(JButton littleSquare) {
        this.littleSquare = littleSquare;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
public class BuildFrame extends JFrame implements ActionListener {
    private JFrame base = new JFrame("É¨À×");
    private JPanel basePanel = new JPanel();
    private int i;
    private Square littleSquare[];
    private ImageIcon a = new ImageIcon("/images/a.png");

    public void actionPerformed(ActionEvent e) {
        for (int i=0; i<littleSquare.length; i++) {
            if (littleSquare[i].getLittleSquare().equals(((JButton)e.getSource()))) {
                System.out.println("µÚ" + (i+1) + "¿é" + "!!!!");
                JFrame temp = new JFrame("......");
                temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                temp.setSize(200,200);
                temp.setVisible(true);
                temp.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JButton c = new JButton(a);
                JPanel jp = new JPanel();
                jp.add(c);
                temp.add(jp);
            }
        }

    }
    public void setLine (int n) {
        GridLayout layout = new GridLayout(n,n,1,1);
        basePanel.setLayout(layout);
        littleSquare = new Square[n*n];

        for (int i=0; i<n*n; i++) {
            littleSquare[i] = new Square();
            littleSquare[i].setLittleSquare(new JButton(a));
            littleSquare[i].setData(i);
            littleSquare[i].getLittleSquare().setBackground(Color.cyan);
            if (i!=0) {
                if (i % 7 == 0) {
                    littleSquare[i].getLittleSquare().setBackground(Color.yellow);
                    littleSquare[i].getLittleSquare().addActionListener(this);
                    //System.out.println(littleSquare[i].getLittleSquare().getBackground());
                }
                if (i % 15 == 0) {
                    littleSquare[i].getLittleSquare().setBackground(Color.black);
                    littleSquare[i].getLittleSquare().addActionListener(this);
                }
                if (i % 16 == 0) {
                    littleSquare[i].getLittleSquare().setBackground(Color.red);
                    littleSquare[i].getLittleSquare().addActionListener(this);
                }
            }
            basePanel.add(littleSquare[i].getLittleSquare());
        }
        base.add(basePanel);
        base.setSize(600,600);
        base.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        base.setVisible(true);
//        basePanel.remove(0);
//        basePanel.remove(5);

    }

    public static void main(String[] args) {
        BuildFrame test = new BuildFrame();
        test.setLine(10);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Anakinliu.
 * On 2016/12/10.
 */
public class GameButton extends JButton implements MouseListener {
    boolean clicked;

   public GameButton (ImageIcon icon) {
        setSize(icon.getIconWidth(),icon.getIconHeight());
        setIcon(icon);
        setMargin(new Insets(0,0,0,0));
        setIconTextGap(0);
        setBorderPainted(false);
        setBorder(null);
        setFocusPainted(false);
        setContentAreaFilled(false);
   }


    @Override
    public void mouseClicked(MouseEvent e) {
        //System.out.println("clicked");
        clicked = true;

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

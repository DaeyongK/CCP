import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CircularButton extends EstablisherButton {
    CircularButton(QPanel Panel, int width, int height, Color color, String text, int buttonID, BufferedImage img) {
        super(Panel, width, height, color, text, buttonID);
        setBorder(new RoundedBorder(10)); //how big to make it?
        setIcon(new ImageIcon(img));
    }

    private static class RoundedBorder implements Border {
        private int radius;

        RoundedBorder(int radius) {
            this.radius = radius;
        }

        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }

        public boolean isBorderOpaque() {
            return true;
        }

        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }
    public void mouseOver(CircularButton b) {
        addMouseMotionListener(new MouseInputAdapter() {
            public void MouseEnter(MouseEvent e) {
            	b.setBackground(TITLE_COLOR);
            }
            public void mouseExited(MouseEvent evt){
               b.setBackground(null);
            }
        });
    }
}

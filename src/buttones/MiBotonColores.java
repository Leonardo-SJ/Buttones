package buttones;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *
 * @author Angel
 */
public class MiBotonColores extends JButton implements MouseListener{
 public MiBotonColores(){
this.setBackground(Color.RED);
this.setForeground(Color.WHITE);
this.setFont(new Font("Taoma",Font.BOLD,16));
this.setPreferredSize(new Dimension(400,50));
addMouseListener(this);
}   

    @Override
    public void mouseClicked(MouseEvent e) {
       elegirYAplicarColor();
    }
    private void elegirYAplicarColor() {
        Color colorSeleccionado = JColorChooser.showDialog(this, "Selecciona un color", getBackground());
        if (colorSeleccionado != null) {
            Color colorComplementario = calcularComplementario(colorSeleccionado);
            setBackground(colorSeleccionado);
            setForeground(colorComplementario);
            cambiarColorComponentes((Container) SwingUtilities.getRoot(this), colorSeleccionado, colorComplementario);
        }
    }
    private Color calcularComplementario(Color color) {
        int red = 255 - color.getRed();
        int green = 255 - color.getGreen();
        int blue = 255 - color.getBlue();
        return new Color(red, green, blue);
    }

    public void setCustomBackground(Color color) {
        setBackground(color);
        setForeground(calcularComplementario(color));
    }

    public void aplicarColorComplementario() {
        setForeground(calcularComplementario(getBackground()));
    }

private void cambiarColorComponentes(Container container, Color backgroundColor, Color textColor) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JPanel || comp instanceof JFrame) {
                comp.setBackground(backgroundColor);
            } else if (comp instanceof JButton) {
                comp.setBackground(textColor);
                comp.setForeground(backgroundColor);
            } else if (comp instanceof JLabel) {
                comp.setForeground(textColor);
            } else if (comp instanceof JTextField) {
                comp.setBackground(backgroundColor);
                comp.setForeground(textColor);
            }

            if (comp instanceof Container) {
                cambiarColorComponentes((Container) comp, backgroundColor, textColor);
            }
        }
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
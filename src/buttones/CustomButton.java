package buttones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CustomButton extends JButton implements MouseListener {

    public CustomButton(String text) {
        super(text);
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
        setFocusPainted(false);
        addMouseListener(this);  // Agregar el listener para los eventos del ratón
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
                comp.setBackground(backgroundColor);
                comp.setForeground(textColor);
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

    // Métodos vacíos para MouseListener
    @Override
    public void mousePressed(MouseEvent e) { }
    @Override
    public void mouseReleased(MouseEvent e) { }
    @Override
    public void mouseEntered(MouseEvent e) { }
    @Override
    public void mouseExited(MouseEvent e) { }

    
}

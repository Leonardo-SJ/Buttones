package buttones;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ChangeColorButton extends JButton {
    private Container container; // Contenedor cuyo color se cambiará

    public ChangeColorButton(Container container) {
        super("Cambiar Color");
        this.container = container; // Inicializar el contenedor
 setPreferredSize(new Dimension(150, 50));
 setMinimumSize(new Dimension(100, 30));
        // Agregar ActionListener para manejar el clic en el botón
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Abrir un selector de color
                Color newColor = JColorChooser.showDialog(ChangeColorButton.this, "Elige un color", container.getBackground());
                if (newColor != null) {
                    container.setBackground(newColor); // Cambiar el color de fondo del contenedor
                    updateComponentColors(container, newColor); // Cambiar el color de todos los componentes
                }
            }
        });
    }

    // Método para cambiar el color de todos los componentes del contenedor
    private void updateComponentColors(Container container, Color newColor) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JPanel || comp instanceof JFrame) {
                comp.setBackground(newColor);
            } else if (comp instanceof JButton) {
                comp.setBackground(newColor);
                comp.setForeground(Color.WHITE); // Cambiar texto a blanco para mejor visibilidad
            } else if (comp instanceof JLabel) {
                comp.setForeground(Color.WHITE); // Cambiar texto a blanco para mejor visibilidad
            } else if (comp instanceof JTextField) {
                comp.setBackground(newColor);
                comp.setForeground(Color.BLACK); // Cambiar texto a negro
            }

            // Aplicar el cambio recursivamente si el componente es un contenedor
            if (comp instanceof Container) {
                updateComponentColors((Container) comp, newColor);
            }
        }
    }
}

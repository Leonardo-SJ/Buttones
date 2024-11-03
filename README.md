Importaciones
import java.awt.Color;//Se ocupa para elegir el color para el fondo del panel
import java.awt.Component;// Lo ocupamos para un método
import java.awt.Container;// Se ocupa para contener componentes
import java.awt.Dimension;// Se ocupará darle tamaño al JButton
import java.awt.Font;//La ocupamos para darle diseño a las letras del botón personalizado
import java.awt.event.MouseEvent;//Se utiliza para el evento generado por el mouseCliked
import java.awt.event.MouseListener;//Lo ocuparemos para ocupar el método mousecliked
import javax.swing.JButton;//La clase que vamos a ocupar para generar nuestro botón personalizado
import javax.swing.JColorChooser;//Lo ocuparemos para crear el color complementario
import javax.swing.JFrame;//Se ocupara en el método color componentes
import javax.swing.JLabel;//Se ocupara en el método color componentes
import javax.swing.JPanel;//Se ocupara en el método color componentes
import javax.swing.JTextField;//Se ocupara en el método color componentes
import javax.swing.SwingUtilities;

Métodos
mouseClicked(MouseEvent e)
Este método se llama cuando se hace clic en el botón. Llama a elegirYAplicarColor() para mostrar un diálogo de selección de color y aplicar el color seleccionado al botón.

elegirYAplicarColor()
Muestra un diálogo de selección de color (JColorChooser) y aplica el color seleccionado como fondo del botón y su color complementario como el color del texto. También cambia los colores de los componentes contenidos en el contenedor raíz.

calcularComplementario(Color color)
Calcula y devuelve el color complementario del color proporcionado.

setCustomBackground(Color color)
Establece el color de fondo del botón y ajusta el color del texto al color complementario del fondo.

aplicarColorComplementario()
Aplica el color complementario al texto del botón en función del color de fondo actual.

cambiarColorComponentes(Container container, Color backgroundColor, Color textColor)
Recorre los componentes del contenedor proporcionado y cambia sus colores de fondo y texto al color de fondo y color de texto proporcionados.

Métodos vacíos para MouseListener
Estos métodos están presentes para cumplir con la interfaz MouseListener pero no tienen implementación, pero se pueden poner más funciones para crear un botón más interesante:

mousePressed(MouseEvent e)

mouseReleased(MouseEvent e)

mouseEntered(MouseEvent e)

mouseExited(MouseEvent e)

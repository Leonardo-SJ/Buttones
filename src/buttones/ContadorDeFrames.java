package buttones;
import javax.swing.JFrame;

public class ContadorDeFrames extends JFrame {
    private static int contadorFrames = 0;

    public ContadorDeFrames() {
        super("Nuevo Frame");
        contadorFrames++; // Incrementar el contador al crear un nuevo JFrame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static int getContadorFrames() {
        return contadorFrames;
    }

    // Método main para probar la creación de JFrames
    public static void main(String[] args) {
        ContadorDeFrames frame1 = new ContadorDeFrames();
        frame1.setVisible(true);

        ContadorDeFrames frame2 = new ContadorDeFrames();
        frame2.setVisible(true);

        System.out.println("Número de JFrames creados: " + ContadorDeFrames.getContadorFrames());
    }
}
package UncheckedException;

import javax.swing.JOptionPane;

public class UncheckedException {

	public static void main(String[] args) {

		boolean continueLooping = true;
		
		do {
			
			String a = JOptionPane.showInputDialog("Numerador: ");
			String b = JOptionPane.showInputDialog("Denominador: ");
			
			try {
				int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
				System.out.println("Resultado: " + resultado);
				continueLooping = false;
			} catch (NumberFormatException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Entrada inv�lida, informe um n�mero inteiro!");
			} catch (ArithmeticException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Imposs�vel dividir um n�mero por 0.");
			} finally {
				System.out.println("Chegou no Finally!");
			}
		} while(continueLooping);
		
		System.out.println("O c�digo continua...");
	}

	public static int dividir(int a, int b) {
		return a / b;
	}
}

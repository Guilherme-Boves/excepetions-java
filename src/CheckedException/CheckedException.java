package CheckedException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JOptionPane;

public class CheckedException {

	public static void main(String[] args) /* throws IOException */ {
		
		String nomeDoArquivo = "teste.txt";
		
		try {
			imprimirArquivoNoConsole(nomeDoArquivo);
		} catch (FileNotFoundException e) {
		//	e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Revise o nome do arquivo que deseja imprimir!");
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado! Entre em contato com o suporte!" + e.getCause());
			e.printStackTrace();
			
		} finally {
			System.out.println("Chegou no Finally");
		}

		System.out.println("Apesar da exception ou não, o programa contínua...");
	}
	
	public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException {
		File file = new File(nomeDoArquivo);
		
		
		BufferedReader br = new BufferedReader(new FileReader(file.getName()));
		String line = br.readLine();
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		do {
			bw.write(line);
			bw.newLine();
			line=br.readLine();					
		} while(line != null);
		bw.flush();
		br.close();
	}

}

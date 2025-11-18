package atividade01;
/*
 Nome: Luiz Felipe Gon�alves da Silva
 Prontuário: CB3030539
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora implements ActionListener {
    private JTextField resultado = new JTextField("0");
    private double valor1 = 0, valor2 = 0;
	private String operador = "";
	boolean novaOperacao = true;
    public static void main(String[] args) {
        new Calculadora().criarForm();
    }
    public void criarForm(){
        JFrame form = new JFrame("Calculadora");
        form.setSize(200,200);
        form.setLocationRelativeTo(null);
        form.setLayout(new BorderLayout());
        
		resultado.setHorizontalAlignment(SwingConstants.RIGHT);
		resultado.setEditable(false);
        resultado.setFont(new Font("Arial", Font.BOLD, 20));
		form.addWindowListener(new FechaJanela());
        
        JPanel painelSuperior = new JPanel(new GridLayout(1,1));
        painelSuperior.add(resultado);

        JPanel painelInferior = new JPanel(new GridLayout(5,4));
        
		String[] botoes = {
			"7","8","9","/",
			"4","5","6","*",
			"1","2","3","-",
			"0",".","=","+",
			"C"
		};
		for (String texto : botoes) {
			JButton botao = new JButton(texto);
			botao.addActionListener(this);
			painelInferior.add(botao);
		}

        form.add(painelSuperior, BorderLayout.CENTER);
        form.add(painelInferior, BorderLayout.SOUTH);
        form.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
    	String comando = e.getActionCommand();
		try {
	        if ("0123456789.".contains(comando)) {
                if (novaOperacao) {
                    resultado.setText(comando);
                    novaOperacao = false;
                } else {
                    resultado.setText(resultado.getText() + comando);
                }
            } else if ("+-*/".contains(comando)) {
				valor1 = Double.parseDouble(resultado.getText());
				operador = comando;
				novaOperacao = true;
			} else if ("=".equals(comando)) {
				valor2 = Double.parseDouble(resultado.getText());
				double resultadoFinal = 0;
				switch (operador) {
					case "+":
						resultadoFinal = valor1 + valor2;
						break;
					case "-":
						resultadoFinal = valor1 - valor2;
						break;
					case "*":
						resultadoFinal = valor1 * valor2;
						break;
					case "/":
						if (valor2 == 0) throw new IllegalArgumentException("Divisão por zero não é permitida.");
						resultadoFinal = valor1 / valor2;
						break;
					default: return;
				}
				resultado.setText(String.valueOf(resultadoFinal));
				novaOperacao = true;
			} else if ("C".equals(comando)) {
				resultado.setText("0");
				valor1 = 0;
				valor2 = 0;
				operador = "";
				novaOperacao = true;
			}
		}  
	    catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Entrada inválida. Use apenas números.", "Erro", JOptionPane.ERROR_MESSAGE);
        } 
        catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            resultado.setText("0");
        } 
        finally {
			// Qualquer limpeza necessária pode ser feita aqui
		}
    }
}
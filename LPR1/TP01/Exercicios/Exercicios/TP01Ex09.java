package Exercicios;

import java.util.Scanner;

public class TP01Ex09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a resistência (em ohms): ");
        double resistencia = scanner.nextDouble();

        System.out.print("Digite a corrente elétrica (em amperes): ");
        double corrente = scanner.nextDouble();

        double tensao = resistencia * corrente;

        System.out.printf("A tensão do circuito é: %.2f volts\n", tensao);

        scanner.close();
    }
}


//Dupla: Andre Luiz e Luiz Felipe  Ex: Calcular e exibir a tensão de um determinado circuito eletrônico a partir dos
//valores da resistência e corrente elétrica que serão digitados. Utilize a lei de Ohm.
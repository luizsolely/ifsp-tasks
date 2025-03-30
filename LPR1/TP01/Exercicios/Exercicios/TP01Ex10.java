package Exercicios;
import java.util.Scanner;

public class TP01Ex10 {
    
    public static double converterFahrenheit(int celsius){
        return celsius*1.8 + 32;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a temperatura em celsius: ");
        int celsius = scanner.nextInt();
        System.out.printf("O valor da temperatura em Fahrenheit e: " + converterFahrenheit(celsius));
        scanner.close();
    }
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Entrar via teclado com o valor de uma temperatura em graus Celsius, calcular e exibir sua temperatura equivalente em Fahrenheit.


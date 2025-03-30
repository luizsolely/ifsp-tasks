package Exercicios;

import java.util.Scanner;

public class TP01Ex15 {
  public static double converterParaReais(double cotacaoDolar, double dolar){
        return cotacaoDolar*dolar;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite a cotacao do dolar: ");
        double cotacaoDolar= scanner.nextDouble();
        System.out.println("Digite a quantidade de dolar: ");
        double dolar = scanner.nextDouble();
    
        System.out.printf("Em reais esse valor sera de: %.2f\n", converterParaReais(cotacaoDolar, dolar));
        scanner.close();
    }  
}
//Dupla: Andre Luiz e Luiz Felipe  Ex: Entrar via teclado com o valor da cotação do dólar e uma certa quantidade de dólares. Calcular e exibir o valor correspondente em Reais (R$).

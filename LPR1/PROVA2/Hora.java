import java.util.Scanner;

public class Hora {
    private int hora;
    private int minuto;
    private int segundo;

    public Hora() {
        Scanner scanner = new Scanner(System.in);
        boolean dadosValidos = false;

        while (!dadosValidos) {
            try {
                System.out.print("Digite a hora (0-23): ");
                int h = scanner.nextInt();
                System.out.print("Digite o minuto (0-59): ");
                int m = scanner.nextInt();
                System.out.print("Digite o segundo (0-59): ");
                int s = scanner.nextInt();

                if (validarHora(h, m, s)) {
                    this.hora = h;
                    this.minuto = m;
                    this.segundo = s;
                    dadosValidos = true;
                } else {
                    System.out.println("Hora inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! Digite apenas números.");
                scanner.nextLine(); // Limpa o buffer
            }
        }
    }

    public Hora(int h, int m, int s) {
        if (validarHora(h, m, s)) {
            this.hora = h;
            this.minuto = m;
            this.segundo = s;
        } else {
            throw new IllegalArgumentException("Hora inválida!");
        }
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if (hora >= 0 && hora <= 23) {
            this.hora = hora;
        } else {
            throw new IllegalArgumentException("Hora inválida!");
        }
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = minuto;
        } else {
            throw new IllegalArgumentException("Minuto inválido!");
        }
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = segundo;
        } else {
            throw new IllegalArgumentException("Segundo inválido!");
        }
    }

    public String mostraHora() {
        return String.format("%02d:%02d:%02d", hora, minuto, segundo);
    }

    private boolean validarHora(int h, int m, int s) {
        return (h >= 0 && h <= 23) && (m >= 0 && m <= 59) && (s >= 0 && s <= 59);
    }
}
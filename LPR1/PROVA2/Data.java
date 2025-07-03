import java.util.Scanner;
import java.text.DateFormat;
import java.util.Date;

public class Data {
    private int dia;
    private int mes;
    private int ano;

    public Data() {
        Scanner scanner = new Scanner(System.in);
        boolean dadosValidos = false;

        while (!dadosValidos) {
            try {
                System.out.print("Digite o dia: ");
                int d = scanner.nextInt();
                System.out.print("Digite o mês: ");
                int m = scanner.nextInt();
                System.out.print("Digite o ano: ");
                int a = scanner.nextInt();

                if (validarData(d, m, a)) {
                    this.dia = d;
                    this.mes = m;
                    this.ano = a;
                    dadosValidos = true;
                } else {
                    System.out.println("Data inválida! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public Data(int d, int m, int a) {
        if (validarData(d, m, a)) {
            this.dia = d;
            this.mes = m;
            this.ano = a;
        } else {
            throw new IllegalArgumentException("Data inválida!");
        }
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        if (validarDia(dia, this.mes, this.ano)) {
            this.dia = dia;
        } else {
            throw new IllegalArgumentException("Dia inválido!");
        }
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        if (validarMes(mes)) {
            this.mes = mes;
        } else {
            throw new IllegalArgumentException("Mês inválido!");
        }
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        if (validarAno(ano)) {
            this.ano = ano;
        } else {
            throw new IllegalArgumentException("Ano inválido!");
        }
    }

    public void entraDia(int d) {
        setDia(d);
    }

    public void entraMes(int m) {
        setMes(m);
    }

    public void entraAno(int a) {
        setAno(a);
    }

    public void entraDia() {
        Scanner scanner = new Scanner(System.in);
        boolean dadoValido = false;

        while (!dadoValido) {
            try {
                System.out.print("Digite o dia: ");
                int d = scanner.nextInt();
                if (validarDia(d, this.mes, this.ano)) {
                    this.dia = d;
                    dadoValido = true;
                } else {
                    System.out.println("Dia inválido! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public void entraMes() {
        Scanner scanner = new Scanner(System.in);
        boolean dadoValido = false;

        while (!dadoValido) {
            try {
                System.out.print("Digite o mês: ");
                int m = scanner.nextInt();
                if (validarMes(m)) {
                    this.mes = m;
                    dadoValido = true;
                } else {
                    System.out.println("Mês inválido! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public void entraAno() {
        Scanner scanner = new Scanner(System.in);
        boolean dadoValido = false;

        while (!dadoValido) {
            try {
                System.out.print("Digite o ano: ");
                int a = scanner.nextInt();
                if (validarAno(a)) {
                    this.ano = a;
                    dadoValido = true;
                } else {
                    System.out.println("Ano inválido! Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Erro na entrada de dados! Digite apenas números.");
                scanner.nextLine();
            }
        }
    }

    public int retDia() {
        return getDia();
    }

    public int retMes() {
        return getMes();
    }

    public int retAno() {
        return getAno();
    }

    public String mostra1() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }

    public String mostra2() {
        String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        return String.format("%02d/%s/%04d", dia, meses[mes - 1], ano);
    }

    public boolean bissexto() {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    public int diasTranscorridos() {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (bissexto()) {
            diasPorMes[1] = 29; // Fevereiro em ano bissexto
        }

        int diasTranscorridos = 0;

        for (int i = 0; i < mes - 1; i++) {
            diasTranscorridos += diasPorMes[i];
        }

        diasTranscorridos += dia;

        return diasTranscorridos;
    }

    public void apresentaDataAtual() {
        Date dataAtual = new Date();
        DateFormat formatador = DateFormat.getDateInstance(DateFormat.FULL);
        System.out.println("Data atual: " + formatador.format(dataAtual));
    }

    private boolean validarData(int d, int m, int a) {
        return validarAno(a) && validarMes(m) && validarDia(d, m, a);
    }

    private boolean validarAno(int a) {
        return a > 0;
    }

    private boolean validarMes(int m) {
        return m >= 1 && m <= 12;
    }

    private boolean validarDia(int d, int m, int a) {
        if (d < 1) return false;

        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (m == 2 && ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0))) {
            diasPorMes[1] = 29;
        }

        return d <= diasPorMes[m - 1];
    }
}
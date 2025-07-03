import java.util.Scanner;

public class ConsultaAgendada {
    private Data data;
    private Hora hora;
    private String nomePaciente;
    private String nomeMedico;
    private static int quantidade = 0;

    public ConsultaAgendada() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Cadastro de Consulta Agendada ===");

        System.out.println("Digite os dados da data:");
        this.data = new Data();

        System.out.println("Digite os dados da hora:");
        this.hora = new Hora();

        System.out.print("Digite o nome do paciente: ");
        this.nomePaciente = scanner.nextLine();

        System.out.print("Digite o nome do médico: ");
        this.nomeMedico = scanner.nextLine();

        quantidade++;
    }

    public ConsultaAgendada(int h, int mi, int s, int d, int m, int a, String p, String med) {
        this.data = new Data(d, m, a);
        this.hora = new Hora(h, mi, s);
        this.nomePaciente = p;
        this.nomeMedico = med;
        quantidade++;
    }

    public ConsultaAgendada(Data d, Hora h, String p, String m) {
        this.data = d;
        this.hora = h;
        this.nomePaciente = p;
        this.nomeMedico = m;
        quantidade++;
    }

    public void setData(int a, int b, int c) {
        this.data = new Data(a, b, c);
    }

    public void setData() {
        System.out.println("Digite os novos dados da data:");
        this.data = new Data();
    }

    public void setHora(int a, int b, int c) {
        this.hora = new Hora(a, b, c);
    }

    public void setHora() {
        System.out.println("Digite os novos dados da hora:");
        this.hora = new Hora();
    }

    public void setNomePaciente(String p) {
        this.nomePaciente = p;
    }

    public void setNomePaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o novo nome do paciente: ");
        this.nomePaciente = scanner.nextLine();
    }

    public void setNomeMedico(String m) {
        this.nomeMedico = m;
    }

    public void setNomeMedico() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o novo nome do médico: ");
        this.nomeMedico = scanner.nextLine();
    }

    public static int getQuantidade() {
        return quantidade;
    }

    public String getData() {
        return String.format("%02d/%02d/%02d",
                data.getDia(),
                data.getMes(),
                data.getAno() % 100);
    }

    public String getHora() {
        return hora.mostraHora();
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void exibirConsulta() {
        System.out.println("=== Consulta Agendada ===");
        System.out.println("Data: " + getData());
        System.out.println("Hora: " + getHora());
        System.out.println("Paciente: " + getNomePaciente());
        System.out.println("Médico: " + getNomeMedico());
        System.out.println("Total de consultas agendadas: " + getQuantidade());
    }

    @Override
    public String toString() {
        return String.format("Consulta - Data: %s, Hora: %s, Paciente: %s, Médico: %s",
                getData(), getHora(), getNomePaciente(), getNomeMedico());
    }
}
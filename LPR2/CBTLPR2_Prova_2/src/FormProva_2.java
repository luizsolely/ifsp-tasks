/*
 Nome: Luiz Gustavo Verissimo Monteiro
 Prontuário: CB3030326

 Nome: Luiz Felipe Gonçalves da Silva
 Prontario: CB3030539
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class FormProva_2 implements ActionListener 
{
    private int indiceAtual = 0;
    private static List<Paciente> listaPessoa = new ArrayList<>();
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtPeso;
    private JTextField txtAltura;;
    private JTextField txtPesquisa;;
    private JTextArea txtResultado;;
    private JButton btnIncluir, btnLimpar, btnApDados, btnPesquisar, btnCredito, btnSair;

    public static void main(String[] args)
    {
        new FormProva_2().criarForm();
    }

    public void criarForm()
    {
        JFrame form = new JFrame("PROVA 02 - LPR2");
        form.setSize(500,550);
        form.setLocationRelativeTo(null);
        form.setLayout(new BorderLayout());
        form.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelsuperior = new JPanel(new GridLayout(6,2));
        painelsuperior.setBackground(Color.LIGHT_GRAY);
        painelsuperior.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelsuperior.add(txtNome);
        painelsuperior.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelsuperior.add(txtIdade);
        painelsuperior.add(new JLabel("Peso:"));
        txtPeso = new JTextField();
        painelsuperior.add(txtPeso);
        painelsuperior.add(new JLabel("Altura:"));
        txtAltura = new JTextField();
        painelsuperior.add(txtAltura);
        btnIncluir = new JButton("Incluir");
        btnIncluir.addActionListener(this);
        painelsuperior.add(btnIncluir);
        btnSair = new JButton("Sair");
        btnSair.addActionListener(this);
        painelsuperior.add(btnSair);
        btnApDados = new JButton("Apresentar dados");
        btnApDados.addActionListener(this);
        painelsuperior.add(btnApDados);
        btnCredito = new JButton("Creditos");
        btnCredito.addActionListener(this);
        painelsuperior.add(btnCredito);

        JPanel painelCentral = new JPanel(new FlowLayout());
        painelCentral.setBackground(Color.LIGHT_GRAY);

        txtPesquisa = new JTextField();
        txtPesquisa.setPreferredSize(new Dimension(100, 30));
        painelCentral.add(txtPesquisa);
        btnPesquisar = new JButton("Pesquisar");
        btnPesquisar.addActionListener(this);
        painelCentral.add(btnPesquisar);
        btnLimpar = new JButton("Limpar");
        btnLimpar.addActionListener(this);
        painelCentral.add(btnLimpar);
        
        JPanel painelInferior = new JPanel();
        painelInferior.setLayout(new BoxLayout(painelInferior, BoxLayout.Y_AXIS));
        txtResultado = new JTextArea();
        painelInferior.add(txtResultado);
        painelInferior.setPreferredSize(new Dimension(500, 300));  


        form.add(painelsuperior, BorderLayout.NORTH);
        form.add(painelCentral, BorderLayout.CENTER);
        form.add(painelInferior, BorderLayout.SOUTH);

        form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == btnIncluir)
        {
            try {
                String nome = txtNome.getText();
                int idade = Integer.parseInt(txtIdade.getText());
                float peso = Float.parseFloat(txtPeso.getText());
                float altura = Float.parseFloat(txtAltura.getText());

                Paciente p = new Paciente(0, idade, nome, peso, altura);
                ConexaoPostgres.inserirPaciente(p);

                txtResultado.setText("Paciente inserido com sucesso!");

            } catch (Exception ex) {
                txtResultado.setText("Erro: " + ex.getMessage());
            }
        }

        if (e.getSource()==btnApDados)
        {
            List<Paciente> lista = ConexaoPostgres.listarPacientes();
            StringBuilder sb = new StringBuilder();

            for (Paciente p : lista) {
                sb.append("ID: ").append(p.getCod_func())
                        .append(" | Nome: ").append(p.getNome_paciente())
                        .append(" | Idade: ").append(p.getIdade_paciente())
                        .append(" | Peso: ").append(p.getPeso_paciente())
                        .append(" | Altura: ").append(p.getAltura_paciente())
                        .append("\n");
            }
            txtResultado.setText(sb.toString());
        }

        if (e.getSource() == btnPesquisar)
        {
            String nome = txtPesquisa.getText();
            List<Paciente> lista = ConexaoPostgres.pesquisarPacientes(nome);

            StringBuilder sb = new StringBuilder();
            for (Paciente p : lista) {
                sb.append("ID: ").append(p.getCod_func())
                        .append(" | Nome: ").append(p.getNome_paciente())
                        .append(" | Idade: ").append(p.getIdade_paciente())
                        .append(" | Peso: ").append(p.getPeso_paciente())
                        .append(" | Altura: ").append(p.getAltura_paciente())
                        .append("\n");
            }

            txtResultado.setText(sb.toString());
        }

        if (e.getSource() == btnLimpar)
        {
            txtNome.setText("");
            txtIdade.setText("");
            txtPeso.setText("");
            txtAltura.setText("");
            txtPesquisa.setText("");
            txtResultado.setText("");
        }

        if (e.getSource() == btnCredito)
        {
            JOptionPane.showMessageDialog(
              null,
              "Sistema desenvolvido por:\nLuiz Gustavo Verissimo Monteiro\nLuiz Felipe Gonçalves da Silva",
              "Créditos",
              JOptionPane.INFORMATION_MESSAGE
            );
        }

        if (e.getSource() == btnSair)
        {
            System.exit(0);
        }
    }


}

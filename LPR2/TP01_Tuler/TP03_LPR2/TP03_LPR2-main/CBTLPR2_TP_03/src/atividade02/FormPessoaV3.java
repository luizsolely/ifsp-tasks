package atividade02;

/*
Nome: Luiz Felipe Gonçalves da Silva
ProntuÃ¡rio: CB3030539
*/

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import java.awt.event.*;

public class FormPessoaV3 implements ActionListener 
{
    private static List<Pessoa> listaPessoa = new ArrayList<>();
    private JTextField txtNumero;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JRadioButton rbMasculino, rbFeminino;
    private ButtonGroup grupoSexo;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;

    public static void main(String[] args)
    {
        new FormPessoaV3().criarForm();
    }

    public void criarForm()
    {
        JFrame form = new JFrame("TP03 - LPR2");
        form.setSize(400,220);
        form.setLocation(50,50);
        form.setLayout(new BorderLayout());
        form.addWindowListener(new FechaJanela());

        JPanel painelsuperior = new JPanel(new GridLayout(4,2,10,10));
        painelsuperior.setBackground(Color.LIGHT_GRAY);

        painelsuperior.add(new JLabel("Numero:"));
        txtNumero = new JTextField();
        txtNumero.setEditable(false);
        txtNumero.setText("1");
        painelsuperior.add(txtNumero);
        painelsuperior.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelsuperior.add(txtNome);

        painelsuperior.add(new JLabel("Sexo:"));
        rbMasculino = new JRadioButton("Masculino");
        rbFeminino = new JRadioButton("Feminino");
        grupoSexo = new ButtonGroup();
        grupoSexo.add(rbMasculino);
        grupoSexo.add(rbFeminino);
        rbMasculino.setSelected(true);
        JPanel painelSexo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelSexo.add(rbMasculino);
        painelSexo.add(rbFeminino);
        painelsuperior.add(painelSexo);
        painelsuperior.add(new JLabel("Idade:"));
        txtIdade = new JTextField();
        painelsuperior.add(txtIdade);

        JPanel painelInferior = new JPanel(new GridLayout(1,4));
        painelInferior.setBackground(Color.LIGHT_GRAY);
        
        btnOk = new JButton("OK");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        btnOk.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnMostrar.addActionListener(this);
        btnSair.addActionListener(this);
        
        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        form.add(painelsuperior, BorderLayout.CENTER);
        form.add(painelInferior, BorderLayout.SOUTH);

        form.setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==btnOk)
        {
            try {
                String nome = txtNome.getText().trim();
                String idadeTexto = txtIdade.getText().trim();

                if (nome.isEmpty()) 
                    throw new IllegalArgumentException("Nome deve ser preenchido");
                if (idadeTexto.isEmpty()) 
                    throw new IllegalArgumentException("Idade deve ser informada.");
                
                int idade = Integer.parseInt(idadeTexto);

                char sexo;
                if (rbMasculino.isSelected()) {
                    sexo = 'M';
                } else if (rbFeminino.isSelected()) {
                    sexo = 'F';
                } else {
                    throw new IllegalArgumentException("Selecione o sexo (M ou F).");
                }

                Pessoa umaPessoa = new Pessoa(nome, sexo, idade);
                listaPessoa.add(umaPessoa);

                JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");

                txtNumero.setText(String.valueOf(umaPessoa.getKp() +1));

                txtNome.setText("");
                grupoSexo.clearSelection();
                txtIdade.setText("");
                txtNome.requestFocus();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Idade deve ser um numero inteiro.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource()==btnLimpar)
        {
            txtNome.setText("");
            txtIdade.setText("");
            grupoSexo.clearSelection();
            txtNome.requestFocus();
        }
        else if (e.getSource()==btnMostrar)
        {
            if(listaPessoa.isEmpty()){
                JOptionPane.showMessageDialog(null, "Nenhuma pessoa cadastrada.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            StringBuilder dadosPessoa = new StringBuilder();
            for (Pessoa p : listaPessoa) {
                dadosPessoa.append(p.toString()).append("\n");
            }
            dadosPessoa.append("Total de pessoas cadastradas: ").append(listaPessoa.get(listaPessoa.size() - 1).getKp());

            JOptionPane.showMessageDialog(null, dadosPessoa.toString(), "Pessoas Cadastradas", JOptionPane.INFORMATION_MESSAGE);
        }
        else if (e.getSource()==btnSair)
        {
            System.exit(0);
        }
    }
}
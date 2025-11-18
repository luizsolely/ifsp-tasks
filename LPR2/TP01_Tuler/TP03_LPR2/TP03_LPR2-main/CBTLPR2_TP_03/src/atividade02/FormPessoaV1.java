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

public class FormPessoaV1 implements ActionListener 
{
    private static List<Pessoa> listaPessoa = new ArrayList<>();
    private JTextField txtNumero;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSexo;
    private JButton btnOk, btnLimpar, btnMostrar, btnSair;

    public static void main(String[] args)
    {
        new FormPessoaV1().criarForm();
    }

    public void criarForm()
    {
        JFrame form = new JFrame("TP03 - LPR2");
        form.setSize(400,180);
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
        txtSexo = new JTextField();
        painelsuperior.add(txtSexo);
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
                String sexoTexto = txtSexo.getText().trim();
                String idadeTexto = txtIdade.getText().trim();

                if (sexoTexto.isEmpty()) 
                    throw new IllegalArgumentException("Sexo deve ser preenchido (M ou F).");
                
                if (idadeTexto.isEmpty()) 
                    throw new IllegalArgumentException("Idade deve ser informada.");
                
                int idade = Integer.parseInt(idadeTexto);
                char sexo = sexoTexto.charAt(0);

                Pessoa umaPessoa = new Pessoa(nome, sexo, idade);
                listaPessoa.add(umaPessoa);

                JOptionPane.showMessageDialog(null, "Pessoa cadastrada com sucesso!");

                txtNumero.setText(String.valueOf(umaPessoa.getKp() +1));

                txtNome.setText("");
                txtSexo.setText("");
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
            txtSexo.setText("");
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
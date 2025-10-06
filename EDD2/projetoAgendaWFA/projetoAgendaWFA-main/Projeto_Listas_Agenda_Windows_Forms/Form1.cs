using Projeto_Listas_Agenda;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace Projeto_Listas_Agenda_Windows_Forms
{
    public partial class Form1 : Form
    {
        Contatos contatos = new Contatos();
        public Form1()
        {
            InitializeComponent();            
        }

        private void btnAdicionarContato_Click(object sender, EventArgs e)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(txtNome.Text) ||
                    string.IsNullOrWhiteSpace(txtEmail.Text) ||
                    string.IsNullOrWhiteSpace(txtNumeroTelefone.Text) ||
                    cbTipoCelular.SelectedIndex < 0)
                {
                    MessageBox.Show("Preencha todos os campos antes de adicionar o contato.");
                    return;
                }

                string nome = txtNome.Text;
                string email = txtEmail.Text;
                int dia = dtpDataNascimento.Value.Day;
                int mes = dtpDataNascimento.Value.Month;
                int ano = dtpDataNascimento.Value.Year;
                string tipoTelefone = cbTipoCelular.Text;
                string numeroTelefone = txtNumeroTelefone.Text;

                Data data = new Data();
                data.setData(dia, mes, ano);

                Telefone telefone = new Telefone(tipoTelefone, numeroTelefone, true);

                Contato contato = new Contato(email, nome, data, telefone);

                if (contatos.Agenda.Contains(contato))
                {
                    MessageBox.Show("ERRO!!! Já existe contato com esse email!");
                }
                else
                {
                    contatos.adicionar(contato);
                    MessageBox.Show("Contato Adicionado com Sucesso!");

                    txtNome.Clear();
                    txtEmail.Clear();
                    txtNumeroTelefone.Clear();
                    cbTipoCelular.SelectedIndex = -1;
                    dtpDataNascimento.Value = DateTime.Now;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ocorreu um erro ao adicionar o contato:\n" + ex.Message);
            }
        }



        private void btnPesquisarContato_Click(object sender, EventArgs e)
        {
            string pesquisarContato = txtPesquisarContato.Text;
            Contato contato = new Contato {Email = pesquisarContato };
            Contato contatoEncontrado = contatos.pesquisar(contato);
            if (contatoEncontrado != null)
            {
                MessageBox.Show(contatoEncontrado.ToString());
            }
            else
            {
                MessageBox.Show("ERRO!!! Nenhum contato encontrado com esse email!");
            }
            txtPesquisarContato.Clear();
        }

        private void btnAlterarContato_Click(object sender, EventArgs e)
        {
            string Email = txtEmailAlterarContato.Text;

            if (!string.IsNullOrEmpty(Email))
            {
                Contato contato = contatos.Agenda.FirstOrDefault(c => c != null && c.Email == Email);

                if (contato != null)
                {
                    if (!string.IsNullOrEmpty(txtNomeAlterarContato.Text))
                    {
                        contato.Nome = txtNomeAlterarContato.Text;
                    }
                    if (dtpAlterarDataNascimento.Checked)
                    {
                        int dia = dtpAlterarDataNascimento.Value.Day;
                        int mes = dtpAlterarDataNascimento.Value.Month;
                        int ano = dtpAlterarDataNascimento.Value.Year;

                        Data data = new Data();
                        data.setData(dia, mes, ano);
                        contato.DtNasc = data;
                    }
                    if (!string.IsNullOrEmpty(txtNumeroAlterarContato.Text) && cbTipoTelefoneAlterarContato.SelectedIndex >= 0)
                    {
                        string tipoTelefone = cbTipoTelefoneAlterarContato.Text;
                        string numero = txtNumeroAlterarContato.Text;
                        bool principal = cbPrincipal.Text == "Sim";

                        Telefone telefone = new Telefone(tipoTelefone, numero, principal);
                        contato.AdicionarOuAtualizarTelefone(telefone);
                    }

                    MessageBox.Show("Contato alterado com sucesso!");
                }
                else
                {
                    MessageBox.Show("Nenhum Contato foi encontrado com esse email!");
                }
            }
            else
            {
                MessageBox.Show("Não tem nenhum email para pesquisar seu contato");
            }

            txtEmailAlterarContato.Clear();
            txtNomeAlterarContato.Clear();
            dtpAlterarDataNascimento.Value = DateTime.Now;
            cbTipoTelefoneAlterarContato.SelectedIndex = -1;
            txtNumeroAlterarContato.Clear();
            cbPrincipal.SelectedIndex = -1;
        }


        private void btnRemoverContato_Click(object sender, EventArgs e)
        {
            String email = txtEmailRemoverContato.Text;
            Contato contato = contatos.Agenda.FirstOrDefault(c => c != null && c.Email == email);
            if(contato != null)
            {
                if (contatos.remover(contato))
                {
                    MessageBox.Show("Contato removido com sucesso!");
                }
            } else
            {
                MessageBox.Show("Nenhum contato foi encontrado com esse email!");
            }
            txtEmailRemoverContato.Clear();
        }

        private void btnListarContatos_Click(object sender, EventArgs e)
        {
            lvListaContatos.Items.Clear(); // Limpa os itens anteriores

            foreach (Contato c in contatos.Agenda)
            {
                if (c != null)
                {
                    ListViewItem item = new ListViewItem(c.ToString());
                    lvListaContatos.Items.Add(item);
                }
            }
        }
    }
}

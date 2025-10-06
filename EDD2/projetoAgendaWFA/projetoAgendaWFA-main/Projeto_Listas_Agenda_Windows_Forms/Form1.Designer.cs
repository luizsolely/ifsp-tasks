namespace Projeto_Listas_Agenda_Windows_Forms
{
    partial class Form1
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnAdicionarContato = new System.Windows.Forms.Button();
            this.txtNome = new System.Windows.Forms.TextBox();
            this.lblAdicionarContato = new System.Windows.Forms.Label();
            this.lblNome = new System.Windows.Forms.Label();
            this.lblEmail = new System.Windows.Forms.Label();
            this.txtEmail = new System.Windows.Forms.TextBox();
            this.dtpDataNascimento = new System.Windows.Forms.DateTimePicker();
            this.lblDtNasc = new System.Windows.Forms.Label();
            this.lblTipoTelefone = new System.Windows.Forms.Label();
            this.cbTipoCelular = new System.Windows.Forms.ComboBox();
            this.lblNumeroTelefone = new System.Windows.Forms.Label();
            this.txtNumeroTelefone = new System.Windows.Forms.TextBox();
            this.lblPesquisarContato = new System.Windows.Forms.Label();
            this.lblDigitarContatoPesquisa = new System.Windows.Forms.Label();
            this.txtPesquisarContato = new System.Windows.Forms.TextBox();
            this.btnPesquisarContato = new System.Windows.Forms.Button();
            this.lblAlterarContato = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.lblEmailA = new System.Windows.Forms.Label();
            this.txtEmailAlterarContato = new System.Windows.Forms.TextBox();
            this.lblNomeA = new System.Windows.Forms.Label();
            this.txtNomeAlterarContato = new System.Windows.Forms.TextBox();
            this.lblDtA = new System.Windows.Forms.Label();
            this.dtpAlterarDataNascimento = new System.Windows.Forms.DateTimePicker();
            this.lblTipoTelefoneA = new System.Windows.Forms.Label();
            this.cbTipoTelefoneAlterarContato = new System.Windows.Forms.ComboBox();
            this.lblNumeroTelefoneA = new System.Windows.Forms.Label();
            this.txtNumeroAlterarContato = new System.Windows.Forms.TextBox();
            this.btnAlterarContato = new System.Windows.Forms.Button();
            this.lblRemoverContato = new System.Windows.Forms.Label();
            this.lblDigitarContatoRemover = new System.Windows.Forms.Label();
            this.txtEmailRemoverContato = new System.Windows.Forms.TextBox();
            this.btnRemoverContato = new System.Windows.Forms.Button();
            this.lvListaContatos = new System.Windows.Forms.ListView();
            this.lblNumeroPrincipal = new System.Windows.Forms.Label();
            this.cbPrincipal = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.btnListarContatos = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btnAdicionarContato
            // 
            this.btnAdicionarContato.Location = new System.Drawing.Point(31, 277);
            this.btnAdicionarContato.Name = "btnAdicionarContato";
            this.btnAdicionarContato.Size = new System.Drawing.Size(194, 42);
            this.btnAdicionarContato.TabIndex = 0;
            this.btnAdicionarContato.Text = "Clique aqui para adicionar contato";
            this.btnAdicionarContato.UseVisualStyleBackColor = true;
            this.btnAdicionarContato.Click += new System.EventHandler(this.btnAdicionarContato_Click);
            // 
            // txtNome
            // 
            this.txtNome.Location = new System.Drawing.Point(70, 67);
            this.txtNome.Name = "txtNome";
            this.txtNome.Size = new System.Drawing.Size(301, 20);
            this.txtNome.TabIndex = 1;
            // 
            // lblAdicionarContato
            // 
            this.lblAdicionarContato.Location = new System.Drawing.Point(134, 23);
            this.lblAdicionarContato.Name = "lblAdicionarContato";
            this.lblAdicionarContato.Size = new System.Drawing.Size(99, 21);
            this.lblAdicionarContato.TabIndex = 2;
            this.lblAdicionarContato.Text = "Adicionar Contato";
            // 
            // lblNome
            // 
            this.lblNome.AutoSize = true;
            this.lblNome.Location = new System.Drawing.Point(28, 70);
            this.lblNome.Name = "lblNome";
            this.lblNome.Size = new System.Drawing.Size(38, 13);
            this.lblNome.TabIndex = 3;
            this.lblNome.Text = "Nome:";
            // 
            // lblEmail
            // 
            this.lblEmail.AutoSize = true;
            this.lblEmail.Location = new System.Drawing.Point(28, 111);
            this.lblEmail.Name = "lblEmail";
            this.lblEmail.Size = new System.Drawing.Size(35, 13);
            this.lblEmail.TabIndex = 4;
            this.lblEmail.Text = "Email:";
            // 
            // txtEmail
            // 
            this.txtEmail.Location = new System.Drawing.Point(70, 108);
            this.txtEmail.Name = "txtEmail";
            this.txtEmail.Size = new System.Drawing.Size(301, 20);
            this.txtEmail.TabIndex = 5;
            // 
            // dtpDataNascimento
            // 
            this.dtpDataNascimento.Location = new System.Drawing.Point(142, 150);
            this.dtpDataNascimento.Name = "dtpDataNascimento";
            this.dtpDataNascimento.Size = new System.Drawing.Size(229, 20);
            this.dtpDataNascimento.TabIndex = 6;
            // 
            // lblDtNasc
            // 
            this.lblDtNasc.AutoSize = true;
            this.lblDtNasc.Location = new System.Drawing.Point(26, 150);
            this.lblDtNasc.Name = "lblDtNasc";
            this.lblDtNasc.Size = new System.Drawing.Size(110, 13);
            this.lblDtNasc.TabIndex = 7;
            this.lblDtNasc.Text = "Data de Nascimento: ";
            // 
            // lblTipoTelefone
            // 
            this.lblTipoTelefone.AutoSize = true;
            this.lblTipoTelefone.Location = new System.Drawing.Point(26, 191);
            this.lblTipoTelefone.Name = "lblTipoTelefone";
            this.lblTipoTelefone.Size = new System.Drawing.Size(76, 13);
            this.lblTipoTelefone.TabIndex = 8;
            this.lblTipoTelefone.Text = "Tipo Telefone:";
            // 
            // cbTipoCelular
            // 
            this.cbTipoCelular.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbTipoCelular.FormattingEnabled = true;
            this.cbTipoCelular.Items.AddRange(new object[] {
            "Fixo",
            "Movel"});
            this.cbTipoCelular.Location = new System.Drawing.Point(110, 188);
            this.cbTipoCelular.Name = "cbTipoCelular";
            this.cbTipoCelular.Size = new System.Drawing.Size(261, 21);
            this.cbTipoCelular.TabIndex = 9;
            // 
            // lblNumeroTelefone
            // 
            this.lblNumeroTelefone.AutoSize = true;
            this.lblNumeroTelefone.Location = new System.Drawing.Point(29, 233);
            this.lblNumeroTelefone.Name = "lblNumeroTelefone";
            this.lblNumeroTelefone.Size = new System.Drawing.Size(107, 13);
            this.lblNumeroTelefone.TabIndex = 10;
            this.lblNumeroTelefone.Text = "Numero de Telefone:";
            // 
            // txtNumeroTelefone
            // 
            this.txtNumeroTelefone.Location = new System.Drawing.Point(143, 233);
            this.txtNumeroTelefone.Name = "txtNumeroTelefone";
            this.txtNumeroTelefone.Size = new System.Drawing.Size(228, 20);
            this.txtNumeroTelefone.TabIndex = 11;
            // 
            // lblPesquisarContato
            // 
            this.lblPesquisarContato.AutoSize = true;
            this.lblPesquisarContato.Location = new System.Drawing.Point(140, 353);
            this.lblPesquisarContato.Name = "lblPesquisarContato";
            this.lblPesquisarContato.Size = new System.Drawing.Size(93, 13);
            this.lblPesquisarContato.TabIndex = 12;
            this.lblPesquisarContato.Text = "Pesquisar Contato";
            // 
            // lblDigitarContatoPesquisa
            // 
            this.lblDigitarContatoPesquisa.AutoSize = true;
            this.lblDigitarContatoPesquisa.Location = new System.Drawing.Point(83, 390);
            this.lblDigitarContatoPesquisa.Name = "lblDigitarContatoPesquisa";
            this.lblDigitarContatoPesquisa.Size = new System.Drawing.Size(233, 13);
            this.lblDigitarContatoPesquisa.TabIndex = 13;
            this.lblDigitarContatoPesquisa.Text = "Digite o email do contato que deseja pesquisar: ";
            // 
            // txtPesquisarContato
            // 
            this.txtPesquisarContato.Location = new System.Drawing.Point(86, 420);
            this.txtPesquisarContato.Name = "txtPesquisarContato";
            this.txtPesquisarContato.Size = new System.Drawing.Size(230, 20);
            this.txtPesquisarContato.TabIndex = 14;
            // 
            // btnPesquisarContato
            // 
            this.btnPesquisarContato.Location = new System.Drawing.Point(86, 462);
            this.btnPesquisarContato.Name = "btnPesquisarContato";
            this.btnPesquisarContato.Size = new System.Drawing.Size(230, 23);
            this.btnPesquisarContato.TabIndex = 15;
            this.btnPesquisarContato.Text = "Clique aqui para pesquisar contato";
            this.btnPesquisarContato.UseVisualStyleBackColor = true;
            this.btnPesquisarContato.Click += new System.EventHandler(this.btnPesquisarContato_Click);
            // 
            // lblAlterarContato
            // 
            this.lblAlterarContato.AutoSize = true;
            this.lblAlterarContato.Location = new System.Drawing.Point(572, 23);
            this.lblAlterarContato.Name = "lblAlterarContato";
            this.lblAlterarContato.Size = new System.Drawing.Size(77, 13);
            this.lblAlterarContato.TabIndex = 16;
            this.lblAlterarContato.Text = "Alterar Contato";
            // 
            // label1
            // 
            this.label1.Location = new System.Drawing.Point(488, 46);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(343, 22);
            this.label1.TabIndex = 17;
            this.label1.Text = "Digite o email do contato e apenas as informações que deseja mudar";
            // 
            // lblEmailA
            // 
            this.lblEmailA.AutoSize = true;
            this.lblEmailA.Location = new System.Drawing.Point(479, 96);
            this.lblEmailA.Name = "lblEmailA";
            this.lblEmailA.Size = new System.Drawing.Size(35, 13);
            this.lblEmailA.TabIndex = 4;
            this.lblEmailA.Text = "Email:";
            // 
            // txtEmailAlterarContato
            // 
            this.txtEmailAlterarContato.Location = new System.Drawing.Point(520, 93);
            this.txtEmailAlterarContato.Name = "txtEmailAlterarContato";
            this.txtEmailAlterarContato.Size = new System.Drawing.Size(301, 20);
            this.txtEmailAlterarContato.TabIndex = 5;
            // 
            // lblNomeA
            // 
            this.lblNomeA.AutoSize = true;
            this.lblNomeA.Location = new System.Drawing.Point(476, 150);
            this.lblNomeA.Name = "lblNomeA";
            this.lblNomeA.Size = new System.Drawing.Size(38, 13);
            this.lblNomeA.TabIndex = 3;
            this.lblNomeA.Text = "Nome:";
            // 
            // txtNomeAlterarContato
            // 
            this.txtNomeAlterarContato.Location = new System.Drawing.Point(516, 144);
            this.txtNomeAlterarContato.Name = "txtNomeAlterarContato";
            this.txtNomeAlterarContato.Size = new System.Drawing.Size(301, 20);
            this.txtNomeAlterarContato.TabIndex = 1;
            // 
            // lblDtA
            // 
            this.lblDtA.AutoSize = true;
            this.lblDtA.Location = new System.Drawing.Point(476, 188);
            this.lblDtA.Name = "lblDtA";
            this.lblDtA.Size = new System.Drawing.Size(110, 13);
            this.lblDtA.TabIndex = 7;
            this.lblDtA.Text = "Data de Nascimento: ";
            // 
            // dtpAlterarDataNascimento
            // 
            this.dtpAlterarDataNascimento.Location = new System.Drawing.Point(593, 189);
            this.dtpAlterarDataNascimento.Name = "dtpAlterarDataNascimento";
            this.dtpAlterarDataNascimento.Size = new System.Drawing.Size(229, 20);
            this.dtpAlterarDataNascimento.TabIndex = 6;
            // 
            // lblTipoTelefoneA
            // 
            this.lblTipoTelefoneA.AutoSize = true;
            this.lblTipoTelefoneA.Location = new System.Drawing.Point(476, 265);
            this.lblTipoTelefoneA.Name = "lblTipoTelefoneA";
            this.lblTipoTelefoneA.Size = new System.Drawing.Size(76, 13);
            this.lblTipoTelefoneA.TabIndex = 8;
            this.lblTipoTelefoneA.Text = "Tipo Telefone:";
            // 
            // cbTipoTelefoneAlterarContato
            // 
            this.cbTipoTelefoneAlterarContato.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbTipoTelefoneAlterarContato.FormattingEnabled = true;
            this.cbTipoTelefoneAlterarContato.Items.AddRange(new object[] {
            "Fixo",
            "Movel"});
            this.cbTipoTelefoneAlterarContato.Location = new System.Drawing.Point(560, 265);
            this.cbTipoTelefoneAlterarContato.Name = "cbTipoTelefoneAlterarContato";
            this.cbTipoTelefoneAlterarContato.Size = new System.Drawing.Size(261, 21);
            this.cbTipoTelefoneAlterarContato.TabIndex = 9;
            // 
            // lblNumeroTelefoneA
            // 
            this.lblNumeroTelefoneA.AutoSize = true;
            this.lblNumeroTelefoneA.Location = new System.Drawing.Point(476, 315);
            this.lblNumeroTelefoneA.Name = "lblNumeroTelefoneA";
            this.lblNumeroTelefoneA.Size = new System.Drawing.Size(107, 13);
            this.lblNumeroTelefoneA.TabIndex = 10;
            this.lblNumeroTelefoneA.Text = "Numero de Telefone:";
            // 
            // txtNumeroAlterarContato
            // 
            this.txtNumeroAlterarContato.Location = new System.Drawing.Point(593, 312);
            this.txtNumeroAlterarContato.Name = "txtNumeroAlterarContato";
            this.txtNumeroAlterarContato.Size = new System.Drawing.Size(228, 20);
            this.txtNumeroAlterarContato.TabIndex = 11;
            // 
            // btnAlterarContato
            // 
            this.btnAlterarContato.Location = new System.Drawing.Point(534, 390);
            this.btnAlterarContato.Name = "btnAlterarContato";
            this.btnAlterarContato.Size = new System.Drawing.Size(194, 42);
            this.btnAlterarContato.TabIndex = 0;
            this.btnAlterarContato.Text = "Clique para alterar o contato";
            this.btnAlterarContato.UseVisualStyleBackColor = true;
            this.btnAlterarContato.Click += new System.EventHandler(this.btnAlterarContato_Click);
            // 
            // lblRemoverContato
            // 
            this.lblRemoverContato.AutoSize = true;
            this.lblRemoverContato.Location = new System.Drawing.Point(572, 462);
            this.lblRemoverContato.Name = "lblRemoverContato";
            this.lblRemoverContato.Size = new System.Drawing.Size(90, 13);
            this.lblRemoverContato.TabIndex = 12;
            this.lblRemoverContato.Text = "Remover Contato";
            // 
            // lblDigitarContatoRemover
            // 
            this.lblDigitarContatoRemover.AutoSize = true;
            this.lblDigitarContatoRemover.Location = new System.Drawing.Point(513, 492);
            this.lblDigitarContatoRemover.Name = "lblDigitarContatoRemover";
            this.lblDigitarContatoRemover.Size = new System.Drawing.Size(226, 13);
            this.lblDigitarContatoRemover.TabIndex = 13;
            this.lblDigitarContatoRemover.Text = "Digite o email do contato que deseja remover: ";
            // 
            // txtEmailRemoverContato
            // 
            this.txtEmailRemoverContato.Location = new System.Drawing.Point(516, 522);
            this.txtEmailRemoverContato.Name = "txtEmailRemoverContato";
            this.txtEmailRemoverContato.Size = new System.Drawing.Size(230, 20);
            this.txtEmailRemoverContato.TabIndex = 14;
            // 
            // btnRemoverContato
            // 
            this.btnRemoverContato.Location = new System.Drawing.Point(516, 560);
            this.btnRemoverContato.Name = "btnRemoverContato";
            this.btnRemoverContato.Size = new System.Drawing.Size(230, 23);
            this.btnRemoverContato.TabIndex = 15;
            this.btnRemoverContato.Text = "Clique aqui para remover contato";
            this.btnRemoverContato.UseVisualStyleBackColor = true;
            this.btnRemoverContato.Click += new System.EventHandler(this.btnRemoverContato_Click);
            // 
            // lvListaContatos
            // 
            this.lvListaContatos.HideSelection = false;
            this.lvListaContatos.Location = new System.Drawing.Point(950, 70);
            this.lvListaContatos.Name = "lvListaContatos";
            this.lvListaContatos.Size = new System.Drawing.Size(366, 503);
            this.lvListaContatos.TabIndex = 18;
            this.lvListaContatos.UseCompatibleStateImageBehavior = false;
            // 
            // lblNumeroPrincipal
            // 
            this.lblNumeroPrincipal.AutoSize = true;
            this.lblNumeroPrincipal.Location = new System.Drawing.Point(476, 353);
            this.lblNumeroPrincipal.Name = "lblNumeroPrincipal";
            this.lblNumeroPrincipal.Size = new System.Drawing.Size(212, 13);
            this.lblNumeroPrincipal.TabIndex = 10;
            this.lblNumeroPrincipal.Text = "Deseja alterar esse numero como principal?";
            // 
            // cbPrincipal
            // 
            this.cbPrincipal.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cbPrincipal.FormattingEnabled = true;
            this.cbPrincipal.Items.AddRange(new object[] {
            "Sim\t",
            "Não"});
            this.cbPrincipal.Location = new System.Drawing.Point(690, 350);
            this.cbPrincipal.Name = "cbPrincipal";
            this.cbPrincipal.Size = new System.Drawing.Size(127, 21);
            this.cbPrincipal.TabIndex = 9;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(456, 236);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(391, 13);
            this.label2.TabIndex = 19;
            this.label2.Text = "Se deseja alterar o telefone é obrigatório preecnher todos os campos de Telefone";
            // 
            // btnListarContatos
            // 
            this.btnListarContatos.Location = new System.Drawing.Point(950, 12);
            this.btnListarContatos.Name = "btnListarContatos";
            this.btnListarContatos.Size = new System.Drawing.Size(366, 52);
            this.btnListarContatos.TabIndex = 0;
            this.btnListarContatos.Text = "Clique para listar todos seus contatos";
            this.btnListarContatos.UseVisualStyleBackColor = true;
            this.btnListarContatos.Click += new System.EventHandler(this.btnListarContatos_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.ClientSize = new System.Drawing.Size(1365, 616);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.lvListaContatos);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.lblAlterarContato);
            this.Controls.Add(this.btnRemoverContato);
            this.Controls.Add(this.btnPesquisarContato);
            this.Controls.Add(this.txtEmailRemoverContato);
            this.Controls.Add(this.txtPesquisarContato);
            this.Controls.Add(this.lblDigitarContatoRemover);
            this.Controls.Add(this.lblDigitarContatoPesquisa);
            this.Controls.Add(this.lblRemoverContato);
            this.Controls.Add(this.lblPesquisarContato);
            this.Controls.Add(this.txtNumeroAlterarContato);
            this.Controls.Add(this.txtNumeroTelefone);
            this.Controls.Add(this.lblNumeroPrincipal);
            this.Controls.Add(this.lblNumeroTelefoneA);
            this.Controls.Add(this.lblNumeroTelefone);
            this.Controls.Add(this.cbPrincipal);
            this.Controls.Add(this.cbTipoTelefoneAlterarContato);
            this.Controls.Add(this.cbTipoCelular);
            this.Controls.Add(this.lblTipoTelefoneA);
            this.Controls.Add(this.lblTipoTelefone);
            this.Controls.Add(this.lblDtA);
            this.Controls.Add(this.lblDtNasc);
            this.Controls.Add(this.dtpAlterarDataNascimento);
            this.Controls.Add(this.dtpDataNascimento);
            this.Controls.Add(this.txtEmailAlterarContato);
            this.Controls.Add(this.txtEmail);
            this.Controls.Add(this.lblEmailA);
            this.Controls.Add(this.lblEmail);
            this.Controls.Add(this.lblNomeA);
            this.Controls.Add(this.lblNome);
            this.Controls.Add(this.lblAdicionarContato);
            this.Controls.Add(this.txtNomeAlterarContato);
            this.Controls.Add(this.txtNome);
            this.Controls.Add(this.btnListarContatos);
            this.Controls.Add(this.btnAlterarContato);
            this.Controls.Add(this.btnAdicionarContato);
            this.Name = "Form1";
            this.Text = "Agenda";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btnAdicionarContato;
        private System.Windows.Forms.TextBox txtNome;
        private System.Windows.Forms.Label lblAdicionarContato;
        private System.Windows.Forms.Label lblNome;
        private System.Windows.Forms.Label lblEmail;
        private System.Windows.Forms.TextBox txtEmail;
        private System.Windows.Forms.DateTimePicker dtpDataNascimento;
        private System.Windows.Forms.Label lblDtNasc;
        private System.Windows.Forms.Label lblTipoTelefone;
        private System.Windows.Forms.ComboBox cbTipoCelular;
        private System.Windows.Forms.Label lblNumeroTelefone;
        private System.Windows.Forms.TextBox txtNumeroTelefone;
        private System.Windows.Forms.Label lblPesquisarContato;
        private System.Windows.Forms.Label lblDigitarContatoPesquisa;
        private System.Windows.Forms.TextBox txtPesquisarContato;
        private System.Windows.Forms.Button btnPesquisarContato;
        private System.Windows.Forms.Label lblAlterarContato;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label lblEmailA;
        private System.Windows.Forms.TextBox txtEmailAlterarContato;
        private System.Windows.Forms.Label lblNomeA;
        private System.Windows.Forms.TextBox txtNomeAlterarContato;
        private System.Windows.Forms.Label lblDtA;
        private System.Windows.Forms.DateTimePicker dtpAlterarDataNascimento;
        private System.Windows.Forms.Label lblTipoTelefoneA;
        private System.Windows.Forms.ComboBox cbTipoTelefoneAlterarContato;
        private System.Windows.Forms.Label lblNumeroTelefoneA;
        private System.Windows.Forms.TextBox txtNumeroAlterarContato;
        private System.Windows.Forms.Button btnAlterarContato;
        private System.Windows.Forms.Label lblRemoverContato;
        private System.Windows.Forms.Label lblDigitarContatoRemover;
        private System.Windows.Forms.TextBox txtEmailRemoverContato;
        private System.Windows.Forms.Button btnRemoverContato;
        private System.Windows.Forms.ListView lvListaContatos;
        private System.Windows.Forms.Label lblNumeroPrincipal;
        private System.Windows.Forms.ComboBox cbPrincipal;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Button btnListarContatos;
    }
}


using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Models;
using View;
using System.Collections.Generic;

namespace Controller
{
    public class AgendaController
    {
        private Contatos agenda;
        private ConsoleView view;

        public AgendaController()
        {
            agenda = new Contatos();
            view = new ConsoleView();
        }

        public void Iniciar()
        {
            int opcao;
            do
            {
                view.MostrarMenu();
                if (!int.TryParse(System.Console.ReadLine(), out opcao)) continue;

                switch (opcao)
                {
                    case 0:
                        view.MostrarMensagem("Saindo...");
                        break;
                    case 1:
                        var novo = view.ObterContato();
                        if (agenda.Adicionar(novo))
                            view.MostrarMensagem("Contato adicionado com sucesso!");
                        else
                            view.MostrarMensagem("Contato já existe.");
                        break;
                    case 2:
                        var emailPesquisa = view.ObterEmail();
                        var contatoPesquisado = agenda.Pesquisar(new Contato { Email = emailPesquisa });
                        view.MostrarContato(contatoPesquisado);
                        break;
                    case 3:
                        var emailAlt = view.ObterEmail();
                        var existente = agenda.Pesquisar(new Contato { Email = emailAlt });
                        if (existente != null)
                        {
                            var novoAlt = view.ObterContato();
                            if (agenda.Alterar(novoAlt))
                                view.MostrarMensagem("Contato alterado com sucesso!");
                        }
                        else
                            view.MostrarMensagem("Contato não encontrado.");
                        break;
                    case 4:
                        var emailRem = view.ObterEmail();
                        if (agenda.Remover(new Contato { Email = emailRem }))
                            view.MostrarMensagem("Contato removido com sucesso.");
                        else
                            view.MostrarMensagem("Contato não encontrado.");
                        break;
                    case 5:
                        view.MostrarContatos(new List<Contato>(agenda.Agenda));
                        break;
                    default:
                        view.MostrarMensagem("Opção inválida.");
                        break;
                }

            } while (opcao != 0);
        }
    }
}

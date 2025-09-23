using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Models;
using System;
using System.Collections.Generic;

namespace View
{
    public class ConsoleView
    {
        public void MostrarMenu()
        {
            Console.WriteLine("\n------ AGENDA ------");
            Console.WriteLine("0. Sair");
            Console.WriteLine("1. Adicionar contato");
            Console.WriteLine("2. Pesquisar contato");
            Console.WriteLine("3. Alterar contato");
            Console.WriteLine("4. Remover contato");
            Console.WriteLine("5. Listar contatos");
            Console.Write("Escolha uma opção: ");
        }

        public Contato ObterContato()
        {
            var contato = new Contato();
            Console.Write("Nome: ");
            contato.Nome = Console.ReadLine();
            Console.Write("Email: ");
            contato.Email = Console.ReadLine();

            Console.WriteLine("Data de nascimento:");
            Console.Write("Dia: ");
            int dia = int.Parse(Console.ReadLine());
            Console.Write("Mês: ");
            int mes = int.Parse(Console.ReadLine());
            Console.Write("Ano: ");
            int ano = int.Parse(Console.ReadLine());

            contato.DtNasc = new Data();
            contato.DtNasc.SetData(dia, mes, ano);

            Console.WriteLine("Telefone:");
            var telefone = new Telefone();
            Console.Write("Tipo (ex: celular, fixo): ");
            telefone.Tipo = Console.ReadLine();
            Console.Write("Número: ");
            telefone.Numero = Console.ReadLine();
            Console.Write("É principal? (s/n): ");
            telefone.Principal = Console.ReadLine().ToLower() == "s";

            contato.AdicionarTelefone(telefone);

            return contato;
        }

        public string ObterEmail()
        {
            Console.Write("Digite o email do contato: ");
            return Console.ReadLine();
        }

        public void MostrarContato(Contato c)
        {
            if (c == null)
                Console.WriteLine("Contato não encontrado.");
            else
                Console.WriteLine("\n" + c.ToString());
        }

        public void MostrarContatos(List<Contato> contatos)
        {
            if (contatos.Count == 0)
            {
                Console.WriteLine("Nenhum contato cadastrado.");
            }
            else
            {
                foreach (var c in contatos)
                {
                    Console.WriteLine("----------------------------");
                    MostrarContato(c);
                }
            }
        }

        public void MostrarMensagem(string msg)
        {
            Console.WriteLine(msg);
        }
    }
}

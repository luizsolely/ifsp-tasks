using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Projeto_Listas_Agenda
{
    internal class Contatos
    {
        private List<Contato> agenda = new List<Contato>();
        public List<Contato> Agenda { get => agenda; set => agenda = value; }

        public bool adicionar(Contato c)
        {
            if (Agenda.Contains(c))
                return false;

            Agenda.Add(c);
            return true;
        }

        public Contato pesquisar(Contato c)
        {
            return Agenda.FirstOrDefault(a => a.Email == c.Email);
        }

        public bool alterar(Contato c)
        {
            Contato existente = pesquisar(c);
            if (existente != null)
            {
                existente.Email = c.Email;
                existente.Nome = c.Nome;
                existente.Telefones = c.Telefones;
                existente.DtNasc = c.DtNasc;
                return true;
            }
            return false;
        }

        public bool remover(Contato c)
        {
            Contato existente = pesquisar(c);
            if (existente != null)
            {
                Agenda.Remove(existente);
                return true;
            }
            return false;
        }
    }
}
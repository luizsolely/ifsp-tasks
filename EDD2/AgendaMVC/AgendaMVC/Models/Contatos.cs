using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections.Generic;

namespace Models
{
    public class Contatos
    {
        private List<Contato> agenda = new List<Contato>();

        public IReadOnlyList<Contato> Agenda => agenda.AsReadOnly();

        public bool Adicionar(Contato c)
        {
            if (agenda.Contains(c)) return false;
            agenda.Add(c);
            return true;
        }

        public Contato Pesquisar(Contato c)
        {
            return agenda.Find(x => x.Equals(c));
        }

        public bool Alterar(Contato c)
        {
            var existente = Pesquisar(c);
            if (existente != null)
            {
                agenda.Remove(existente);
                agenda.Add(c);
                return true;
            }
            return false;
        }

        public bool Remover(Contato c)
        {
            return agenda.Remove(c);
        }
    }
}


using System;
using System.Linq;

namespace ProjEscola
{
    internal class Curso
    {
        private int id;
        private string descricao;
        private Disciplina[] disciplinas;
        private int qtd;

        public int Id { get => id; }
        public string Descricao { get => descricao; }

        public Curso(int id, string descricao)
        {
            this.id = id;
            this.descricao = descricao;
            this.disciplinas = new Disciplina[12];
            this.qtd = 0;
        }

        public bool AdicionarDisciplina(Disciplina disciplina)
        {
            if (qtd < 12)
            {
                disciplinas[qtd++] = disciplina;
                return true;
            }
            return false;
        }

        public Disciplina PesquisarDisciplina(int id)
        {
            for (int i = 0; i < qtd; i++)
                if (disciplinas[i].Id == id)
                    return disciplinas[i];
            return null;
        }

        public bool RemoverDisciplina(Disciplina d)
        {
            for (int i = 0; i < qtd; i++)
            {
                if (disciplinas[i] == d)
                {
                    if (disciplinas[i].Alunos.Any(a => a != null)) return false;

                    for (int j = i; j < qtd - 1; j++)
                        disciplinas[j] = disciplinas[j + 1];
                    disciplinas[--qtd] = null;
                    return true;
                }
            }
            return false;
        }

        public Disciplina[] GetDisciplinas() => disciplinas.Take(qtd).ToArray();

        public override string ToString()
        {
            string d = string.Join("\n  ", disciplinas.Take(qtd).Select(x => x.Descricao));
            return $"Curso {id} - {descricao}\n  Disciplinas:\n  {d}";
        }
    }
}

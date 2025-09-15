using System;
using System.Linq;

namespace ProjEscola
{
    internal class Aluno
    {
        private int id;
        private string nome;
        private Curso curso;
        private Disciplina[] disciplinas;
        private int qtdDisciplinas;

        public int Id { get => id; }
        public string Nome { get => nome; }
        public Curso Curso { get => curso; set => curso = value; }
        public Disciplina[] Disciplinas { get => disciplinas; }

        public Aluno(int id, string nome)
        {
            this.id = id;
            this.nome = nome;
            this.disciplinas = new Disciplina[6];
            this.qtdDisciplinas = 0;
        }

        public bool PodeMatricular(Curso curso)
        {
            return this.curso == null || this.curso == curso;
        }

        public bool AddDisciplina(Disciplina d)
        {
            if (qtdDisciplinas < 6)
            {
                disciplinas[qtdDisciplinas++] = d;
                return true;
            }
            return false;
        }

        public bool RemoveDisciplina(Disciplina d)
        {
            for (int i = 0; i < qtdDisciplinas; i++)
            {
                if (disciplinas[i] == d)
                {
                    for (int j = i; j < qtdDisciplinas - 1; j++)
                        disciplinas[j] = disciplinas[j + 1];
                    disciplinas[--qtdDisciplinas] = null;
                    return true;
                }
            }
            return false;
        }

        public override string ToString()
        {
            string d = string.Join(", ", disciplinas.Take(qtdDisciplinas).Select(x => x.Descricao));
            return $"Aluno {id} - {nome} | Curso: {curso?.Descricao ?? "Nenhum"} | Disciplinas: {d}";
        }
    }
}

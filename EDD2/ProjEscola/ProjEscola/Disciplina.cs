using System;
using System.Linq;

namespace ProjEscola
{
    internal class Disciplina
    {
        private int id;
        private string descricao;
        private Aluno[] alunos;
        private int qtd;

        public int Id { get => id; }
        public string Descricao { get => descricao; }
        public Aluno[] Alunos { get => alunos; }

        public Disciplina(int id, string descricao)
        {
            this.id = id;
            this.descricao = descricao;
            this.alunos = new Aluno[15];
            this.qtd = 0;
        }

        public bool MatricularAluno(Aluno aluno)
        {
            if (qtd >= 15) return false;
            if (!aluno.PodeMatricular(aluno.Curso)) return false;

            alunos[qtd++] = aluno;
            aluno.AddDisciplina(this);
            return true;
        }

        public bool DesmatricularAluno(Aluno aluno)
        {
            for (int i = 0; i < qtd; i++)
            {
                if (alunos[i] == aluno)
                {
                    for (int j = i; j < qtd - 1; j++)
                        alunos[j] = alunos[j + 1];
                    alunos[--qtd] = null;
                    aluno.RemoveDisciplina(this);
                    return true;
                }
            }
            return false;
        }

        public override string ToString()
        {
            string lista = string.Join(", ", alunos.Take(qtd).Select(a => a.Nome));
            return $"Disciplina {id} - {descricao} | Alunos: {lista}";
        }
    }
}

using System;
using System.Linq;

namespace ProjEscola
{
    internal class Escola
    {
        private Curso[] cursos;
        private int qtd;

        public Escola()
        {
            cursos = new Curso[5];
            qtd = 0;
        }

        public bool AdicionarCurso(Curso curso)
        {
            if (qtd < 5)
            {
                cursos[qtd++] = curso;
                return true;
            }
            return false;
        }

        public Curso PesquisarCurso(int id)
        {
            for (int i = 0; i < qtd; i++)
                if (cursos[i].Id == id)
                    return cursos[i];
            return null;
        }

        public bool RemoverCurso(Curso curso)
        {
            for (int i = 0; i < qtd; i++)
            {
                if (cursos[i] == curso)
                {
                    if (cursos[i].GetDisciplinas().Length > 0) return false;

                    for (int j = i; j < qtd - 1; j++)
                        cursos[j] = cursos[j + 1];
                    cursos[--qtd] = null;
                    return true;
                }
            }
            return false;
        }

        public Curso[] GetCursos() => cursos.Take(qtd).ToArray();

        public override string ToString()
        {
            return string.Join("\n", cursos.Take(qtd));
        }
    }
}

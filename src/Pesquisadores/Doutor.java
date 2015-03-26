package Pesquisadores;

public class Doutor extends Mestre{

    private int alunosDeMestrado;
    private int alunosDeDoutorado;

    public static final int PESO_ALUNO_MESTRADO = 20;
    public static final int PESO_ALUNO_DOUTORADO = 30;

    public Doutor(int id, int horas_ic, int horas_estagio_docencia,
                  int alunosDeGraduacao, int alunosDeMestrado, int alunosDeDoutorado) {
        super(id, horas_ic, horas_estagio_docencia, alunosDeGraduacao);

        this.alunosDeMestrado = alunosDeMestrado;
        this.alunosDeDoutorado = alunosDeDoutorado;
    }

    @Override
    public float popularidade() {
        return super.popularidade() + (PESO_ALUNO_MESTRADO * this.alunosDeMestrado) +
                (PESO_ALUNO_DOUTORADO * this.alunosDeDoutorado);
    }

}
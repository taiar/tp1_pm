package Pesquisadores;

/**
 * Classe mais especializada em sua hierarquia, o Doutor pode ter como
 * orientandos membros de todos os niveis da hierarquia
 */
public class Doutor extends Mestre{

    private int alunosDeMestrado;
    private int alunosDeDoutorado;

    protected static final int PESO_ALUNO_MESTRADO = 20;
    protected static final int PESO_ALUNO_DOUTORADO = 30;

    public Doutor(int id, int horas_ic, int horas_estagio_docencia,
                  int alunosDeGraduacao, int alunosDeMestrado, int alunosDeDoutorado) {
        super(id, horas_ic, horas_estagio_docencia, alunosDeGraduacao);

        this.alunosDeMestrado = alunosDeMestrado;
        this.alunosDeDoutorado = alunosDeDoutorado;
    }

    /**
     * @return Numero de alunos de mestrado
     */
    protected int getAlunosDeMestrado() {
        return this.alunosDeMestrado;
    }

    /**
     * @return Numero de alunos de doutorado
     */
    protected int getAlunosDeDoutorado() {
        return this.alunosDeDoutorado;
    }

    @Override
    public String getTipo() {
        return "Doutor";
    }

    @Override
    public double popularidade() {
        return super.popularidade() + (PESO_ALUNO_MESTRADO * this.alunosDeMestrado) + (PESO_ALUNO_DOUTORADO *
                this.alunosDeDoutorado);
    }

}
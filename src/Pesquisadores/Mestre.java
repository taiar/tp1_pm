package Pesquisadores;

public class Mestre extends Graduado{

    protected int alunosDeGraduacao;

    protected static final int PESO_ALUNO_GRADUACAO = 10;

    public Mestre(int id, int horas_ic, int horas_estagio_docencia, int alunosDeGraduacao) {
        super(id, horas_ic, horas_estagio_docencia);
        this.alunosDeGraduacao = alunosDeGraduacao;
    }

    @Override
    protected float popularidade() {
        return super.popularidade() + (PESO_ALUNO_GRADUACAO * this.alunosDeGraduacao);
    }

}

package Pesquisadores;

public class Mestre extends Graduado{

    private int alunosDeGraduacao;

    protected static final int PESO_ALUNO_GRADUACAO = 10;

    public Mestre(int id, int horas_ic, int horas_estagio_docencia, int alunosDeGraduacao) {
        super(id, horas_ic, horas_estagio_docencia);
        this.alunosDeGraduacao = alunosDeGraduacao;
    }

    protected int getAunosDeGraduacao() {
        return this.alunosDeGraduacao;
    }

    @Override
    public float popularidade() {
        return super.popularidade() + (PESO_ALUNO_GRADUACAO * this.alunosDeGraduacao);
    }

}

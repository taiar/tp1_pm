package Pesquisadores;

/**
 * Classe que representa um aluno de mestrado, que tambem e um Pesquisador e Graduado
 */
public class Mestre extends Graduado{

    private int alunosDeGraduacao;

    protected static final int PESO_ALUNO_GRADUACAO = 10;

    public Mestre(int id, int horas_ic, int horas_estagio_docencia, int alunosDeGraduacao) {
        super(id, horas_ic, horas_estagio_docencia);
        this.alunosDeGraduacao = alunosDeGraduacao;
    }

    /**
     * @return numero de alunos de graduacao orientados pelo mestre
     */
    protected int getAunosDeGraduacao() {
        return this.alunosDeGraduacao;
    }

    @Override
    public String getTipo() {
        return "Mestre";
    }

    @Override
    public double popularidade() {
        return super.popularidade() + (PESO_ALUNO_GRADUACAO * this.alunosDeGraduacao);
    }

}

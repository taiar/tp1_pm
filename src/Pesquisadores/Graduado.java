package Pesquisadores;

public class Graduado extends Pesquisador{

    private int horas_ic;
    private int horas_estagio_docencia;

    public Graduado(int id, int horas_ic, int horas_estagio_docencia) {
        super(id);
        this.horas_ic = horas_ic;
        this.horas_estagio_docencia = horas_estagio_docencia;
    }

    protected int getHoras_ic() {
        return horas_ic;
    }

    protected int getHoras_estagio_docencia() {
        return horas_estagio_docencia;
    }

    @Override
    public float popularidade() {
        return super.popularidade() + this.horas_ic() +
                this.horas_estagio_docencia();
    }
}

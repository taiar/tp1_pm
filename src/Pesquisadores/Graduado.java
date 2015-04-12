package Pesquisadores;

/**
 * Classe que representa um graduado, nivel mais alto concreto de sua hierarquia
 */
public class Graduado extends Pesquisador{

    private int horas_ic;
    private int horas_estagio_docencia;

    public Graduado(int id, int horas_ic, int horas_estagio_docencia) {
        super(id);
        this.horas_ic = horas_ic;
        this.horas_estagio_docencia = horas_estagio_docencia;
    }

    /**
     * @return horas gastas com iniciacao cientifica
     */
    protected int getHoras_ic() {
        return horas_ic;
    }

    /**
     * @return horas gastas com o estagio de docencia
     */
    protected int getHoras_estagio_docencia() {
        return horas_estagio_docencia;
    }

    @Override
    public String getTipo() {
        return "Grad";
    }

    @Override
    public double popularidade() {
        return super.popularidade() + this.horas_ic + this.horas_estagio_docencia;
    }
}

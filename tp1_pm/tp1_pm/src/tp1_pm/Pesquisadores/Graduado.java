package tp1_pm.Pesquisadores;

public class Graduado extends Pesquisador{

    public Graduado(int id, int horas_ic, int horas_estagio_docencia) {
        super(id, horas_ic, horas_estagio_docencia);
    }

    @Override
    public float popularidade() {
        return super.popularidade() + super.getHoras_ic() +
                super.getHoras_estagio_docencia();
    }

    public void printPopularidade(){
        System.out.println(popularidade());
    }
}

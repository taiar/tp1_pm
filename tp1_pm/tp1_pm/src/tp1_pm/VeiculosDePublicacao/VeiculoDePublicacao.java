package tp1_pm.VeiculosDePublicacao;

public abstract class VeiculoDePublicacao {
    private int id;
    
    public VeiculoDePublicacao(int id){
        this.id = id;
    }
    
    public String toString(){
        return "ID da publicacao: " + id;
    }
}

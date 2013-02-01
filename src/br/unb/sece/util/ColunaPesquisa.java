package br.unb.sece.util;


/**
 *
 * @author Gustavo
 */
public class ColunaPesquisa {
    private String coluna;
    
    private String metodo;

    public ColunaPesquisa(String coluna,String metodo){
        this.setColuna(coluna);
        this.setMetodo(metodo);
    }
    public String getColuna() {
        return coluna;
    }

    public void setColuna(String coluna) {
        this.coluna = coluna;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    
    
}

package model.custom;

import model.Categoria;

public class CountCategoria {

    private Long total;
    private Categoria categoria;

    public CountCategoria(Long total, Categoria categoria) {
        this.total = total;
        this.categoria = categoria;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }




}

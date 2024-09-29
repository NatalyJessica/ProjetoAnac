class Aeroporto {
    private String nomeCidade;
    private String codigo;
   

    public Aeroporto(String nomeCidade, String codigo) {
        this.nomeCidade = nomeCidade;
        this.codigo = codigo;
      
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "Aeroporto de: " + nomeCidade + "-codigo:" +
                 codigo + ".";
    }
}

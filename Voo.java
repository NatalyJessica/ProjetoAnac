class Voo {
    private int numero;
    private Aeroporto origem;
    private Aeroporto destino;

    public Voo(int numero, Aeroporto origem, Aeroporto destino) {
        this.numero = numero;
        this.origem = origem;
        this.destino = destino;
    }
    
    public int getNumero() {
        return numero;
    }

    public Aeroporto getOrigem() {
        return origem;
    }

    public Aeroporto getDestino() {
        return destino;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "numero=" + numero +
                ", origem=" + origem.getCodigo() +
                ", destino=" + destino.getCodigo() +
                '}';
    }
}

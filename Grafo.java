public class Grafo {
    private ListaSimplesDesordenada<Aeroporto> aeroportos;
    private ListaSimplesDesordenada<Voo> voos; // Lista de voos

    public Grafo() {
        this.aeroportos = new ListaSimplesDesordenada<>();
        this.voos = new ListaSimplesDesordenada<>();
        
    }
    
    public void adicionarAeroporto(String nomeCidade, String codigo) {
        try {
            Aeroporto aeroporto = new Aeroporto(nomeCidade, codigo);
            aeroportos.guardeUmItemNoInicio(aeroporto);
            //System.out.println("Aeroporto " + nomeCidade + " adicionado.");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar aeroporto: " + e.getMessage());
        }
    }
    

    public void adicionarVoo(int numero, String codigoOrigem, String codigoDestino) {
        Aeroporto origem = buscarAeroporto(codigoOrigem);
        Aeroporto destino = buscarAeroporto(codigoDestino);
    
        // Verifica se os aeroportos de origem e destino existem
        if (origem == null) {
            System.out.println("Aeroporto de origem não encontrado: " + codigoOrigem);
            return; // Retorna imediatamente se o aeroporto de origem não for encontrado
        }
    
        if (destino == null) {
            System.out.println("Aeroporto de destino não encontrado: " + codigoDestino);
            return; // Retorna imediatamente se o aeroporto de destino não for encontrado
        }
    
        // Ambos os aeroportos foram encontrados
        try {
            Voo voo = new Voo(numero, origem, destino); // Supondo que Voo tem um construtor adequado
            voos.guardeUmItemNoInicio(voo); // Adiciona o voo à lista de voos no grafo
            System.out.println("Voo " + numero + " adicionado de " + origem.getCodigo() + " para " + destino.getCodigo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar voo: " + e.getMessage());
        }
    }
    
    
    
    public Aeroporto buscarAeroporto(String codigo) {
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                Aeroporto aeroporto = aeroportos.getElemento(i);
                if (aeroporto.getCodigo().equals(codigo)) {
                    return aeroporto;
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return null;
    }

    public void printListaAeroportos() {
        if (aeroportos.getQuantidade() == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return;
        }

        System.out.println("Lista de Aeroportos:");
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                Aeroporto aeroporto = aeroportos.getElemento(i);
                System.out.println(aeroporto); // Supondo que a classe Aeroporto tem um método toString
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void printListaVoos() {
        if (voos.getQuantidade() == 0) {
            System.out.println("Nenhum voo cadastrado.");
            return;
        }
    
        System.out.println("Lista de Voos:");
        for (int i = 0; i < voos.getQuantidade(); i++) {
            try {
                Voo voo = voos.getElemento(i);
                System.out.println(voo); // Supondo que a classe Voo tem um método toString
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    public void removerVoo(int numero) {
        for (int i = 0; i < voos.getQuantidade(); i++) {
            try {
                Voo voo = voos.getElemento(i);
                if (voo.getNumero() == numero) { // Supondo que Voo tem um método getNumero()
                    voos.removaItemIndicado(voo); // Supondo que removaItem é um método que remove um item pelo índice
                    System.out.println("Voo " + numero + " removido com sucesso.");
                    return; // Sai do método após remover o voo
                }
            } catch (Exception e) {
                System.out.println("Erro ao remover voo: " + e.getMessage());
            }
        }
        System.out.println("Voo não encontrado: " + numero); // Caso o voo não seja encontrado
    }
    
    public void listarTodosOsTrajetos() {
        if (aeroportos.getQuantidade() == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return;
        }
    
        System.out.println("Lista de todos os trajetos possíveis:");
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                Aeroporto origem = aeroportos.getElemento(i);
                for (int j = 0; j < aeroportos.getQuantidade(); j++) {
                    Aeroporto destino = aeroportos.getElemento(j);
                    if (!origem.equals(destino)) {
                        // Exibe apenas a informação de que existe um trajeto possível
                        System.out.println("Possível trajeto de " + origem.getCodigo() + " para " + destino.getCodigo());
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    
    

}

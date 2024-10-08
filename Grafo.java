public class Grafo {
    // Duas listas encadeadas simples desordenadas para armazenar aeroportos e voos
    private ListaSimplesDesordenada<Aeroporto> aeroportos; 
    private ListaSimplesDesordenada<Voo> voos; // Lista de voos

    // Construtor da classe Grafo que inicializa as listas
    public Grafo() {
        this.aeroportos = new ListaSimplesDesordenada<>();
        this.voos = new ListaSimplesDesordenada<>();
    }

    // Método para adicionar um aeroporto à lista
    public void adicionarAeroporto(String nomeCidade, String codigo) throws Exception {
        // Verifica se os parâmetros estão corretos (não nulos)
        if (nomeCidade == null || codigo == null) {
            throw new Exception("Informações ausentes."); // Lança uma exceção caso faltem informações
        } else {
            // Cria um novo objeto Aeroporto com o nome da cidade e o código
            Aeroporto aeroporto = new Aeroporto(nomeCidade, codigo);
            // Adiciona o aeroporto na lista de aeroportos
            aeroportos.guardeUmItemNoInicio(aeroporto);
        }
    }

    // Método para adicionar um voo ao grafo
    public void adicionarVoo(int numero, String codigoOrigem, String codigoDestino) {
        // Busca os aeroportos de origem e destino pelo código
        Aeroporto origem = buscarAeroporto(codigoOrigem);
        Aeroporto destino = buscarAeroporto(codigoDestino);

        // Verifica se o aeroporto de origem foi encontrado
        if (origem == null) {
            System.out.println("Aeroporto de origem não encontrado: " + codigoOrigem);
            return; 
        }
        // Verifica se o aeroporto de destino foi encontrado
        if (destino == null) {
            System.out.println("Aeroporto de destino não encontrado: " + codigoDestino);
            return;
        }
        // Se os aeroportos forem encontrados
        try {
            // Cria um novo objeto Voo com o número, origem e destino
            Voo voo = new Voo(numero, origem, destino); // Supondo que Voo tem um construtor adequado
            // Adiciona o voo à lista de voos
            voos.guardeUmItemNoInicio(voo);
            // Exibe uma mensagem informando que o voo foi adicionado com sucesso
            System.out.println("Voo " + numero + " adicionado de " + origem.getCodigo() + " para " + destino.getCodigo());
        } catch (Exception e) {
            System.out.println("Erro ao adicionar voo: " + e.getMessage());
        }
    }

    // Método para buscar um aeroporto na lista de aeroportos pelo código
    public Aeroporto buscarAeroporto(String codigo) {
        // Itera sobre a lista de aeroportos
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                // Obtém o aeroporto na posição 'i'
                Aeroporto aeroporto = aeroportos.getElemento(i);
                // Verifica se o código do aeroporto é o mesmo procurado
                if (aeroporto.getCodigo().equals(codigo)) {
                    return aeroporto; 
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return null; 
    }

    // Método para imprimir a lista de aeroportos
    public void printListaAeroportos() {
        // Verifica se a lista de aeroportos está vazia
        if (aeroportos.getQuantidade() == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return;
        }
        // Exibe a lista de aeroportos
        System.out.println("Lista de Aeroportos:");
        // Itera sobre a lista de aeroportos
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                // Obtém o aeroporto na posição 'i'
                Aeroporto aeroporto = aeroportos.getElemento(i);
                System.out.println(aeroporto); 
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // Método para imprimir a lista de voos
    public void printListaVoos() {
        // Verifica se a lista de voos está vazia
        if (voos.getQuantidade() == 0) {
            System.out.println("Nenhum voo cadastrado.");
            return; 
        }
        // Exibe a lista de voos
        System.out.println("Lista de Voos:");
        // Itera sobre a lista de voos
        for (int i = 0; i < voos.getQuantidade(); i++) {
            try {
                // Obtém o voo na posição 'i'
                Voo voo = voos.getElemento(i);
                System.out.println(voo); 
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // Método para remover um voo da lista pelo número do voo
    public void removerVoo(int numero) {
        // Itera sobre a lista de voos
        for (int i = 0; i < voos.getQuantidade(); i++) {
            try {
                Voo voo = voos.getElemento(i);
                // Verifica se o número do voo corresponde ao número passado como parâmetro
                if (voo.getNumero() == numero) { 
                    // Remove o voo da lista
                    voos.removaItemIndicado(voo); 
                    System.out.println("Voo " + numero + " removido com sucesso.");
                    return; 
                }
            } catch (Exception e) {
                System.out.println("Erro ao remover voo: " + e.getMessage());
            }
        }
        System.out.println("Voo não encontrado: " + numero);
    }

    // Método para listar todos os trajetos possíveis entre os aeroportos
    public void listarTodosOsTrajetos() {
        // Verifica se a lista de aeroportos está vazia
        if (aeroportos.getQuantidade() == 0) {
            System.out.println("Nenhum aeroporto cadastrado.");
            return; 
        }
        // Exibe a lista de todos os trajetos possíveis entre os aeroportos
        System.out.println("Lista de todos os trajetos possíveis:");
        for (int i = 0; i < aeroportos.getQuantidade(); i++) {
            try {
                // Obtém o aeroporto de origem
                Aeroporto origem = aeroportos.getElemento(i);
                // Itera sobre a lista de aeroportos para definir o destino
                for (int j = 0; j < aeroportos.getQuantidade(); j++) {
                    // Obtém o aeroporto de destino
                    Aeroporto destino = aeroportos.getElemento(j);
                    // Verifica se o destino é diferente da origem
                    if (!origem.equals(destino)) {
                        // Exibe a informação do trajeto possível
                        System.out.println("Possível trajeto de " + origem.getCodigo() + " para " + destino.getCodigo());
                    }
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}

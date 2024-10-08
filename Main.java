import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Grafo grafo = new Grafo(); // Instância do Grafo

    public static void main(String[] args) {
        try {
            grafo.adicionarAeroporto("Belo Horizonte", "CNF");
            grafo.adicionarAeroporto("Brasília", "BSB");
            grafo.adicionarAeroporto("Rio de Janeiro", "GIG");
            grafo.adicionarAeroporto("Salvador", "SSA");
            grafo.adicionarAeroporto("São Paulo", "GRU");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar aeroporto: " + e.getMessage());
        }
          
        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Aeroporto");
            System.out.println("2. Adicionar Voo");
            System.out.println("3. Listar Aeroportos");
            System.out.println("4. Listar Voos");
            System.out.println("5. Remover Voos");
            System.out.println("6. Listar Trajetos");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    adicionarAeroporto();
                    break;
                case 2:
                    cadastrarVoo();
                    break;
                case 3:
                    grafo.printListaAeroportos();
                    break;
                case 4:
                    grafo.printListaVoos();
                    break;
                case 5:
                    removerVoo();
                    break;
                case 6: 
                    grafo.listarTodosOsTrajetos();
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 7);
    }

    private static void adicionarAeroporto() {
        try {
            System.out.print("Digite o nome da cidade do aeroporto: ");
            String nomeCidade = scanner.nextLine();
            System.out.print("Digite o código do aeroporto: ");
            String codigo = scanner.nextLine();

            grafo.adicionarAeroporto(nomeCidade, codigo);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar aeroporto: " + e.getMessage());
        }
    }

    private static void cadastrarVoo() {
        try {
            System.out.print("Digite o código do aeroporto de origem: ");
            String codigoOrigem = scanner.nextLine();
            Aeroporto origem = grafo.buscarAeroporto(codigoOrigem);

            if (origem == null) {
                System.out.println("Erro: Aeroporto de origem não encontrado: " + codigoOrigem);
                return; 
            }

            System.out.print("Digite o código do aeroporto de destino: ");
            String codigoDestino = scanner.nextLine();
            Aeroporto destino = grafo.buscarAeroporto(codigoDestino);

            if (destino == null) {
                System.out.println("Erro: Aeroporto de destino não encontrado: " + codigoDestino);
                return;
            }

            System.out.print("Digite o número do voo: ");
            int numeroVoo = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            // Chama o método de adicionar voo da classe Grafo
            grafo.adicionarVoo(numeroVoo, codigoOrigem, codigoDestino);
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar voo: " + e.getMessage());
        }
    }

    private static void removerVoo() {
        System.out.print("Digite o número do voo a ser removido: ");
        int numeroVoo = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        grafo.removerVoo(numeroVoo); // Chama o método de remover voo
    }

}

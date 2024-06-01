import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static ArrayList<Produto> listaDeProdutos = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Operações CRUD Loja de Produtos =====");
            System.out.println("1. Create (Criar)");
            System.out.println("2. Read (Visualizar/Ler)");
            System.out.println("3. Update (Atualizar)");
            System.out.println("4. Delete (Apagar)");
            System.out.println("5. Exit");
            System.out.print("Digite a opção desejada: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consome a entrada de dados da próxima linha

            switch (choice) {
                case 1:
                    createProduto(scanner);
                    break;
                case 2:
                    readProdutos();
                    break;
                case 3:
                    updateProduto(scanner);
                    break;
                case 4:
                    deleteProduto(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Escolha outra opção!");
                    break;
            }
        }

        scanner.close();
    }

    private static void createProduto(Scanner scanner) {
        System.out.println("Escolha o tipo de produto:");
        System.out.println("1. Livro");
        System.out.println("2. Ebook");
        int tipo = scanner.nextInt();
        scanner.nextLine(); // consome a entrada de dados da próxima linha

        System.out.print("Digite o título: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o autor: ");
        String autor = scanner.nextLine();
        System.out.print("Digite o preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // consome a entrada de dados da próxima linha

        if (tipo == 1) {
            System.out.print("Digite o gênero: ");
            String genero = scanner.nextLine();
            System.out.print("Digite a editora: ");
            String editora = scanner.nextLine();
            System.out.print("Digite o número de páginas: ");
            int numeroDePaginas = scanner.nextInt();
            scanner.nextLine(); // consome a entrada de dados da próxima linha

            Produto livro = new Livro(titulo, autor, preco, genero, editora, numeroDePaginas);
            listaDeProdutos.add(livro);
            System.out.println("Livro adicionado com sucesso!");
        } else if (tipo == 2) {
            System.out.print("Digite o tamanho do arquivo (MB): ");
            double tamanhoDoArquivo = scanner.nextDouble();
            scanner.nextLine(); // consome a entrada de dados da próxima linha
            System.out.print("Digite o formato do arquivo: ");
            String formatoDoArquivo = scanner.nextLine();

            Produto ebook = new Ebook(titulo, autor, preco, tamanhoDoArquivo, formatoDoArquivo);
            listaDeProdutos.add(ebook);
            System.out.println("Ebook adicionado com sucesso!");
        } else {
            System.out.println("Tipo de produto inválido.");
        }
    }

    private static void readProdutos() {
        if (listaDeProdutos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado. Comece a cadastrar para visualizar os itens aqui.");
        } else {
            System.out.println("\n===== Lista de Produtos da Loja =====");
            for (Produto produto : listaDeProdutos) {
                System.out.println(produto);
            }
        }
    }

    private static void updateProduto(Scanner scanner) {
        System.out.print("Digite o título do produto que deseja atualizar: ");
        String titulo = scanner.nextLine();

        boolean encontrado = false;
        for (Produto produto : listaDeProdutos) {
            if (produto.getTitulo().equals(titulo)) {
                System.out.print("Digite o novo título: ");
                String novoTitulo = scanner.nextLine();
                System.out.print("Digite o novo autor: ");
                String novoAutor = scanner.nextLine();
                System.out.print("Digite o novo preço: ");
                double novoPreco = scanner.nextDouble();
                scanner.nextLine(); // consome a entrada de dados da próxima linha

                produto.setTitulo(novoTitulo);
                produto.setAutor(novoAutor);
                produto.setPreco(novoPreco);

                if (produto instanceof Livro) {
                    Livro livro = (Livro) produto;
                    System.out.print("Digite o novo gênero: ");
                    String genero = scanner.nextLine();
                    System.out.print("Digite a nova editora: ");
                    String editora = scanner.nextLine();
                    System.out.print("Digite o novo número de páginas: ");
                    int numeroDePaginas = scanner.nextInt();
                    scanner.nextLine(); // consome a entrada de dados da próxima linha

                    livro.setGenero(genero);
                    livro.setEditora(editora);
                    livro.setNumeroDePaginas(numeroDePaginas);
                } else if (produto instanceof Ebook) {
                    Ebook ebook = (Ebook) produto;
                    System.out.print("Digite o novo tamanho do arquivo (MB): ");
                    double tamanhoDoArquivo = scanner.nextDouble();
                    scanner.nextLine(); // consome a entrada de dados da próxima linha
                    System.out.print("Digite o novo formato do arquivo: ");
                    String formatoDoArquivo = scanner.nextLine();

                    ebook.setTamanhoDoArquivo(tamanhoDoArquivo);
                    ebook.setFormatoDoArquivo(formatoDoArquivo);
                }

                encontrado = true;
                System.out.println("Produto atualizado com sucesso!");
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Produto não encontrado! Verifique o título: " + titulo);
        }
    }

    private static void deleteProduto(Scanner scanner) {
        System.out.print("Digite o título do produto que deseja remover: ");
        String titulo = scanner.nextLine();

        boolean removido = listaDeProdutos.removeIf(produto -> produto.getTitulo().equals(titulo));

        if (removido) {
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado! Verifique o título: " + titulo);
        }
    }
}

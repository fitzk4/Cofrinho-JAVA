package cofrinhoUninter;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Cofrinho<Moeda> cofrinho;

    public Menu() {
        scanner = new Scanner(System.in);
        cofrinho = new Cofrinho<Moeda>();
    }

    public void menuPrincipal() {
        boolean sair = false;
        while (!sair) {  // Utilizei o while para exibir o menu até que uma opção válida seja selecionada.
            System.out.println();
            System.out.println("----- COFRINHO -----\n");
            System.out.println("1- Adicionar moeda");
            System.out.println("2- Remover moeda");
            System.out.println("3- Listar moedas");
            System.out.println("4- Calcular valor em real");
            System.out.println("0- Sair");

            String opcao = scanner.next();

            switch (opcao) {
                case "0":
                    System.out.println("----- Programa finalizado -----");
                    sair = true;
                    break;
                case "1":
                    exibirAdicionarMoedas();
                    break;
                case "2":
                    exibirRemoverMoedas();
                    break;
                case "3":
                    cofrinho.listagemMoedas();
                    break;
                case "4":
                    double valorTotalConvertido = cofrinho.totalConvertido();
                    DecimalFormat decimalFormat = new DecimalFormat("#,##0.00"); 
                    String valorTotalConvertidoTexto = decimalFormat.format(valorTotalConvertido);
                    System.out.println("O valor convertido: " + valorTotalConvertidoTexto);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close(); // Evita o vazamentos de memória.
    }

    private void exibirAdicionarMoedas() {
        System.out.println("Escolha a Moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int selecaoMoeda;
        try { 
            selecaoMoeda = scanner.nextInt();
        } catch (InputMismatchException e) { // Captura e trata exceptions.
            System.out.println("Opção inválida! Digite um número inteiro.");
            scanner.nextLine(); // Limpa o buffer do scanner
            return;
        }

        System.out.println("Digite o valor: ");
        String valorTextoMoeda = scanner.next();

        double valorMoeda;
        try {
            valorMoeda = Double.parseDouble(valorTextoMoeda.replace(",", "."));
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Digite um número válido.");
            return;
        }

        Moeda moeda = null;

        switch (selecaoMoeda) {
            case 1:
                moeda = new Real(valorMoeda);
                break;
            case 2:
                moeda = new Dolar(valorMoeda);
                break;
            case 3:
                moeda = new Euro(valorMoeda);
                break;
            default:
                System.out.println("Moeda inválida ou inexistente!");
                return;
        }

        cofrinho.adicionar(moeda);
        System.out.println("Moeda adicionada!");
    }


    private void exibirRemoverMoedas() {
        System.out.println("Escolha a Moeda:");
        System.out.println("1 - Real");
        System.out.println("2 - Dolar");
        System.out.println("3 - Euro");

        int selecaoMoeda;
        try {
            selecaoMoeda = scanner.nextInt();
        } catch (InputMismatchException e) { // Captura e trata exceptions.
            System.out.println("Opção inválida! Digite um número inteiro.");
            scanner.nextLine(); // Limpa o buffer do scanner
            return;
        }

        System.out.println("Digite o valor: ");
        String valorTextoMoeda = scanner.next();

        double valorMoeda;
        try {
            valorMoeda = Double.parseDouble(valorTextoMoeda.replace(",", ".")); // Substitui a virgula por ponto.
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido! Digite um número válido.");
            return;
        }

        Moeda moeda = null;

        switch (selecaoMoeda) {
            case 1:
                moeda = new Real(valorMoeda);
                break;
            case 2:
                moeda = new Dolar(valorMoeda);
                break;
            case 3:
                moeda = new Euro(valorMoeda);
                break;
            default:
                System.out.println("Moeda inválida ou inexistente!");
                return;
        }

        boolean removeuMoeda;
        try {
            removeuMoeda = cofrinho.remover(moeda);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao remover a moeda: " + e.getMessage()); // Nesse caso utilizei o getMessage para retornar a minha frase ao invés do exception.
            return;
        }

        if (removeuMoeda) {
            System.out.println("Moeda removida!");
        } else {
            System.out.println("Não existe nenhuma moeda com esse valor!");
        }
    }

}

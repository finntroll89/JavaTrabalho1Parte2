package cadastropoo;

import model.PessoaFisicaRepo;
import model.PessoaFisica;
import model.PessoaJuridicaRepo;
import model.PessoaJuridica;

import java.io.IOException;
import java.util.Scanner;

public class CadastroPOO {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PessoaFisicaRepo pessoaFisicaRepo = new PessoaFisicaRepo();
        PessoaJuridicaRepo pessoaJuridicaRepo = new PessoaJuridicaRepo();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir pelo ID");
            System.out.println("5 - Exibir todos");
            System.out.println("6 - Salvar dados");
            System.out.println("7 - Recuperar dados");
            System.out.println("0 - Finalizar execução");

            int opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            switch (opcao) {
                case 1:
                    incluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 2:
                    alterar(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 3:
                    excluir(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 4:
                    exibirPeloId(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 5:
                    exibirTodos(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 6:
                    salvarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 7:
                    recuperarDados(scanner, pessoaFisicaRepo, pessoaJuridicaRepo);
                    break;
                case 0:
                    System.out.println("Finalizando execução.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void incluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Tipo de pessoa (1 - Física, 2i - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (tipo == 1) {
            System.out.println("ID:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("CPF:");
            String cpf = scanner.nextLine();
            System.out.println("Idade:");
            int idade = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            pessoaFisicaRepo.inserir(new PessoaFisica(id, nome, cpf, idade));
            System.out.println("Pessoa Física incluída com sucesso.");
        } else if (tipo == 2) {
            System.out.println("ID:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer
            System.out.println("Nome:");
            String nome = scanner.nextLine();
            System.out.println("CNPJ:");
            String cnpj = scanner.nextLine();

            pessoaJuridicaRepo.inserir(new PessoaJuridica(id, nome, cnpj));
            System.out.println("Pessoa Jurídica incluída com sucesso.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void alterar(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Tipo de pessoa (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (tipo == 1) {
            System.out.println("ID da pessoa a ser alterada:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            PessoaFisica pf = pessoaFisicaRepo.obter(id);
            if (pf == null) {
                System.out.println("Pessoa Física não encontrada.");
                return;
            }

            System.out.println("Dados atuais:");
            pf.exibir();

            System.out.println("Novo nome:");
            String nome = scanner.nextLine();
            System.out.println("Novo CPF:");
            String cpf = scanner.nextLine();
            System.out.println("Nova idade:");
            int idade = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            pessoaFisicaRepo.alterar(new PessoaFisica(id, nome, cpf, idade));
            System.out.println("Pessoa Física alterada com sucesso.");
        } else if (tipo == 2) {
            System.out.println("ID da pessoa a ser alterada:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            PessoaJuridica pj = pessoaJuridicaRepo.obter(id);
            if (pj == null) {
                System.out.println("Pessoa Jurídica não encontrada.");
                return;
            }

            System.out.println("Dados atuais:");
            pj.exibir();

            System.out.println("Novo nome:");
            String nome = scanner.nextLine();
            System.out.println("Novo CNPJ:");
            String cnpj = scanner.nextLine();

            pessoaJuridicaRepo.alterar(new PessoaJuridica(id, nome, cnpj));
            System.out.println("Pessoa Jurídica alterada com sucesso.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void excluir(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Tipo de pessoa (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (tipo == 1) {
            System.out.println("ID da pessoa a ser excluída:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            pessoaFisicaRepo.excluir(id);
            System.out.println("Pessoa Física excluída com sucesso.");
        } else if (tipo == 2) {
            System.out.println("ID da pessoa a ser excluída:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            pessoaJuridicaRepo.excluir(id);
            System.out.println("Pessoa Jurídica excluída com sucesso.");
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirPeloId(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Tipo de pessoa (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (tipo == 1) {
            System.out.println("ID da pessoa:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            PessoaFisica pf = pessoaFisicaRepo.obter(id);
            if (pf == null) {
                System.out.println("Pessoa Física não encontrada.");
            } else {
                pf.exibir();
            }
        } else if (tipo == 2) {
            System.out.println("ID da pessoa:");
            int id = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer

            PessoaJuridica pj = pessoaJuridicaRepo.obter(id);
            if (pj == null) {
                System.out.println("Pessoa Jurídica não encontrada.");
            } else {
                pj.exibir();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void exibirTodos(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Tipo de pessoa (1 - Física, 2 - Jurídica):");
        int tipo = scanner.nextInt();
        scanner.nextLine();  // Limpar o buffer

        if (tipo == 1) {
            for (PessoaFisica pf : pessoaFisicaRepo.obterTodos()) {
                pf.exibir();
            }
        } else if (tipo == 2) {
            for (PessoaJuridica pj : pessoaJuridicaRepo.obterTodos()) {
                pj.exibir();
            }
        } else {
            System.out.println("Tipo inválido.");
        }
    }

    private static void salvarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o prefixo dos arquivos:");
        String prefixo = scanner.nextLine();

        try {
            pessoaFisicaRepo.persistir(prefixo + ".fisica.bin");
            pessoaJuridicaRepo.persistir(prefixo + ".juridica.bin");
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private static void recuperarDados(Scanner scanner, PessoaFisicaRepo pessoaFisicaRepo, PessoaJuridicaRepo pessoaJuridicaRepo) {
        System.out.println("Digite o prefixo dos arquivos:");
        String prefixo = scanner.nextLine();

        try {
            pessoaFisicaRepo.recuperar(prefixo + ".fisica.bin");
            pessoaJuridicaRepo.recuperar(prefixo + ".juridica.bin");
            System.out.println("Dados recuperados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar dados: " + e.getMessage());
        }
    }
}

package cadastropoo;

import model.PessoaFisicaRepo;
import model.PessoaFisica;
import model.PessoaJuridicaRepo;
import model.PessoaJuridica;
import java.io.IOException;

public class CadastroPOO {
    public static void main(String[] args) {
        try {
            // Repositório de pessoas físicas
            PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
            repo1.inserir(new PessoaFisica(1, "Bruno", "12345678901", 30));
            repo1.inserir(new PessoaFisica(2, "Maria", "98765432101", 25));
            repo1.persistir("pessoasFisicas.dat");

            PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
            repo2.recuperar("pessoasFisicas.dat");
            for (PessoaFisica pf : repo2.obterTodos()) {
                pf.exibir();
            }

            // Repositório de pessoas jurídicas
            PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
            repo3.inserir(new PessoaJuridica(1, "Empresa A", "11122233344455"));
            repo3.inserir(new PessoaJuridica(2, "Empresa B", "55544433322211"));
            repo3.persistir("pessoasJuridicas.dat");

            PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
            repo4.recuperar("pessoasJuridicas.dat");
            for (PessoaJuridica pj : repo4.obterTodos()) {
                pj.exibir();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

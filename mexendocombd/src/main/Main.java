package main;

import java.util.List;
import java.util.Scanner;

import cartao.CartaoDAO;
import cartao.Carto;

public class Main {

	private final int CADASTRAR = 1;
	private final int EDITAR = 2;
	private final int LISTAR = 3;
	private final int REMOVER = 4;
	private final int SAIR = 9;

	private Scanner leia;
	private Carto cartao;
	private CartaoDAO cartaoDAO;

	public Main() {

		leia = new Scanner(System.in);
		cartao = new Carto();
		cartaoDAO = new CartaoDAO();
	}

	public static void main(String[] args) {
		new Main().executar();
	}

	private void executar() {
		int escolha = 1;

		do {
			System.out.println("\n--------------------------------------------------------\n"
					+ "Programa de gerenciamento de Cartao de Credito \n\n" + "1 - Cadastrar\n" + "2 - Editar\n"
					+ "3 - Listar\n" + "4 - Remover\n" + "9 - Sair\n" + "O que deseja?\n");
			escolha = leia.nextInt();

			if (escolha == CADASTRAR) {

				cadastrar();
			} else if (escolha == EDITAR) {
				editar();
			} else if (escolha == REMOVER) {
				remover();
			} else if (escolha == LISTAR) {
				listar();
			}
		} while (escolha != SAIR);
	}

	public void cadastrar() {
		cartao = new Carto();
		
		System.out.println("Qual o nome do dono do cartao? ");
		String nome = leia.next();
		System.out.println("Qual o numero do cartao? ");
		int numero = leia.nextInt();
		
		cartao.setNome(nome);
		cartao.setNumero(numero);
		cartaoDAO.salvar(cartao);
	}

	public void editar() {
		System.out.println("Qual id do cartao que deseja apagar?");
		int editar = leia.nextInt();

		cartao = cartaoDAO.findById(editar);
		
		System.out.println("Pra qual nome deseja alterar?");
		String nome = leia.next();
		System.out.println("Para qual numero deseja alterar?");
		int numero = leia.nextInt();
		
		cartao.setNome(nome);
		cartao.setNumero(numero);
		cartaoDAO.atualizar(cartao);
	}

	public void remover() {
		System.out.println("Qual id do cartao que deseja remover?");
		int apagar = leia.nextInt();

		cartao = cartaoDAO.findById(apagar);

		cartaoDAO.remover(cartao);
	}

	public void listar() {

		List<Carto> cartao = cartaoDAO.listar();

		for (int i = 0; i < cartao.size(); i++) {
			System.out.println("\n Id: " + cartao.get(i).getId());
			System.out.println("Nome: " + cartao.get(i).getNome());
			System.out.println("Numero do cartao : " + cartao.get(i).getNumero());
		}
	}

}

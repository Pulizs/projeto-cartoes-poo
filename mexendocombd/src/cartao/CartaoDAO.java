package cartao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class CartaoDAO {

	private EntityManagerFactory emf;
	private EntityManager em;

	public CartaoDAO() {

		emf = Persistence.createEntityManagerFactory("xuxu");
		em = emf.createEntityManager();
	}

	public void fechar() {

		em.close();
		emf.close();
	}

	public Carto findById(int id) {
		return em.find(Carto.class, id);
	}

	public void salvar(Carto cartao) {
		em.getTransaction().begin();
		em.persist(cartao);
		em.getTransaction().commit();
	}

	public void atualizar(Carto cartao) {

		em.getTransaction().begin();
		em.merge(cartao);
		em.getTransaction().commit();

	}

	public void remover(Carto cartao) {

		em.getTransaction().begin();
		em.remove(cartao);
		em.getTransaction().commit();

	}

	public List<Carto> listar() {

		String consultaHQL = "from Carto";
		Query queryHQL = em.createQuery(consultaHQL);
		List<Carto> usuarios = queryHQL.getResultList();

		return usuarios;
	}
	
//	for (int i = 0; i < usuarios.size(); i++) {
//	System.out.println("");
//	System.out.println("Id: " + usuarios.get(i).getId());
//	System.out.println("Nome: " + usuarios.get(i).getNome());
//	System.out.println("Login: " + usuarios.get(i).getLogin());
//	System.out.println("Senha: " + usuarios.get(i).getSenha());
//	System.out.println("Sexo: " + usuarios.get(i).getSexo());
//	System.out.println("");
//}

}

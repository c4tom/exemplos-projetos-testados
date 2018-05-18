package br.com.feltex.academicnet.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.feltex.academicnet.dao.AlunoDAO;
import br.com.feltex.academicnet.entidade.Aluno;
import br.com.feltex.hibernate.util.HibernateUtil;

public class AlunoHibernateDAO implements AlunoDAO {

	private Session session;

	public void alterar(Aluno p) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.update(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public Aluno consultar(Aluno aluno) {
		Aluno retorno = new Aluno();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			retorno = (Aluno) session.get(Aluno.class, aluno.getMatricula());
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return retorno;
	}

	public void excluir(Aluno p) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.delete(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public boolean existe(Aluno aluno) {

		Aluno a = consultar(aluno);
		return (a.getMatricula() != null);
	}

	public void inserir(Aluno p) {
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			session.save(p);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar() {
		List<Aluno> lista = new ArrayList<Aluno>();
		try {
			session = HibernateUtil.getSession();
			session.beginTransaction();
			lista = (List<Aluno>) session.createCriteria(Aluno.class).list();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return lista;
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> listar(Aluno aluno) {
		Criteria c = session.createCriteria(Aluno.class);
		if (aluno.getNome().length() > 0) {
			c.add(Restrictions.like("nome", aluno.getNome() + "%"));
		}
		c.addOrder(Order.asc("nome"));
		return (List<Aluno>) c.list();
	}
}

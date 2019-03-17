package com.xworkz.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.hibernate.util.HibernateUtil;
import com.xworkz.spring.dto.BookDTO;


public class BookDAO {
	
	private SessionFactory sf;

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	public BookDAO() {
		System.out.println("created.....\t" + this.getClass().getSimpleName());
	}

	public void save(BookDTO dto) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();

		try {
			System.out.println("invoked save method with args\t" + dto);
			session.save(dto);
			tx.commit();
			System.out.println("data was saved successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}

	public void getData(String name) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		try {
			BookDTO dto = session.get(BookDTO.class, name);
			System.out.println(dto);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}

	public void update(String name, int price) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			BookDTO dto = session.get(BookDTO.class, name);
			if (dto != null) {
				dto.setPrice(price);
				session.update(dto);
				tx.commit();
			} else {
				System.out.println("data no updated");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}

	public void delete(int id) {

		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try {
			BookDTO dto = session.get(BookDTO.class, id);
			if (dto != null) {
				session.delete(dto);
				tx.commit();
			} else {
				System.out.println("data not deleted");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("exception created :\t");
			e.printStackTrace();
		}

		finally {
			session.close();
		}
	}
}

package com.app.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.Product;
import com.app.util.HibernateUtil;

public class HqlNamedParameterTest {

	public static void main(String[] args) {
		try(Session ses = HibernateUtil.getSf().openSession()) {
			Transaction tx = ses.beginTransaction();
			String sql = "from com.app.model.Product where productId=:id";
			Query query = ses.createQuery(sql);
			query.setParameter("id", 7777);
			Product product = (Product) query.uniqueResult();
			ses.delete(product);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//main

}//class

package com.getbestplace.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.getbestplace.listener.HibernateListener;
import com.getbestplace.model.Place;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPlaceFirst extends ActionSupport{
	
	private static final long serialVersionUID = 1110054598L;
	static final Logger LOGGER = Logger.getLogger(SearchPlaceFirst.class);
	
	private String locality;
	
	@Override
	public String execute(){
		LOGGER.info("we are inside SearchPlaceFirst with locality="+locality);
		SessionFactory sessionFactory=(SessionFactory)ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		try{
			FullTextSession fullTextSession = Search.getFullTextSession(session);
			fullTextSession.createIndexer().startAndWait();
			Transaction tx = fullTextSession.beginTransaction();
			
			QueryBuilder qb = fullTextSession.getSearchFactory()
				    .buildQueryBuilder().forEntity(Place.class).get();
			org.apache.lucene.search.Query query = qb
			  .keyword()
			  .onField("locality")
			  .matching(locality)
			  .createQuery();
			org.hibernate.Query hibQuery=  fullTextSession.createFullTextQuery(query, Place.class);
			
			List result = hibQuery.list();
			
			LOGGER.info(result);
			
			tx.commit();
		}
		catch(InterruptedException ie){
			LOGGER.info(ie);
			ie.printStackTrace();
		}
		finally{
			session.close();
		}
		return SUCCESS;
	}
	
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

}

package com.fit.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fit.entity.HocPhan;
@Repository
public class HocPhanDAOImpl implements HocPhanDAO {
	@Autowired
	private SessionFactory sessionFac;
	@Override
	@Transactional
	public List<HocPhan> getAllHocPhan(){
		Session session=sessionFac.getCurrentSession();
		CriteriaBuilder cb=session.getCriteriaBuilder();
		CriteriaQuery<HocPhan>cq=cb.createQuery(HocPhan.class);
		Root<HocPhan> root=cq.from(HocPhan.class);
		cq.select(root);
		Query query=session.createQuery(cq);
		return query.getResultList();
		
	}
	@Override
	@Transactional
	public void saveHocphan(HocPhan hocphan) {
		Session currentSession=sessionFac.getCurrentSession();
		currentSession.saveOrUpdate(hocphan);
		
		
	}
	@Override
	@Transactional
	public HocPhan getHocPhan(int theId) {
		Session current=sessionFac.getCurrentSession();
		HocPhan hocPhan=current.get(HocPhan.class, theId);
		
		return hocPhan;
	}
	@Override
	@Transactional
	public void deleteHocPhan(int theId) {
		Session currentSession=sessionFac.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete from HocPhan where malop=:theId");
		theQuery.setParameter("theId", theId);
		theQuery.executeUpdate();
		
	}
	
}

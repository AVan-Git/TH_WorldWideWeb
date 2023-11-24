package com.fit.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fit.dao.HocPhanDAO;
import com.fit.entity.HocPhan;
@Service
public class HocPhanServiceImpl implements HocPhanService{
	 @Autowired
	   private HocPhanDAO hocPhanDAO;
	   @Override
	   @Transactional
	   public List<HocPhan> getAllHocPhans() {
			
			return hocPhanDAO.getAllHocPhan();
		}
	@Override
	@Transactional
	public void saveHocphan(HocPhan customer) {
		hocPhanDAO.saveHocphan(customer);
		
	}
	@Override
	@Transactional
	public HocPhan getHocPhan(int theId) {
		
		return hocPhanDAO.getHocPhan(theId);
	}
	@Override
	@Transactional
	public void deleteHocPhan(int theId) {
		hocPhanDAO.deleteHocPhan(theId);
		
	}
}

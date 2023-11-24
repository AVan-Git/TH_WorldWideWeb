package com.fit.services;

import java.util.List;

import com.fit.entity.HocPhan;

public interface HocPhanService {
  
	 public List<HocPhan> getAllHocPhans();
	    public void saveHocphan(HocPhan customer);
	    public HocPhan getHocPhan(int theId);
	    public void deleteHocPhan(int theId);


	
}

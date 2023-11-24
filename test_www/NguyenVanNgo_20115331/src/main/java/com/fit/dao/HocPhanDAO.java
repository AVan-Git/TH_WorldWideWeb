package com.fit.dao;

import java.util.List;

import com.fit.entity.HocPhan;

public interface HocPhanDAO {
    
	 public List<HocPhan> getAllHocPhan();
	   public void saveHocphan(HocPhan hocphan);
	    public HocPhan getHocPhan(int theId);
	    public void deleteHocPhan(int theId);

}

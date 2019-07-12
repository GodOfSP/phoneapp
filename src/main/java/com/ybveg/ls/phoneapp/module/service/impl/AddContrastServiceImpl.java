package com.ybveg.ls.phoneapp.module.service.impl;


import com.ybveg.ls.phoneapp.module.dao.AddContrastDao;
import com.ybveg.ls.phoneapp.module.dao.impl.AddContrastDaoImpl;
import com.ybveg.ls.phoneapp.module.service.AddContrastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddContrastServiceImpl implements AddContrastService {

    @Autowired
    private AddContrastDao addContrastDao;
    @Override
    public int addContrast(String userId, String phoneId) throws Exception {
        return addContrastDao.addContrast(userId,phoneId);
    }

    @Override
    public String getContrastNum(String userId) throws Exception {
        return addContrastDao.getContrastNum(userId);
    }
}

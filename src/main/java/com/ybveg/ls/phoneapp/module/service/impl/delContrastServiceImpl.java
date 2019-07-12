package com.ybveg.ls.phoneapp.module.service.impl;


import com.ybveg.ls.phoneapp.module.dao.delContrastDao;
import com.ybveg.ls.phoneapp.module.service.delContastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class delContrastServiceImpl implements delContastService {

    @Autowired
    private delContrastDao dao;

    @Override
    public int delContrast(String cId) throws Exception {
        return dao.delContrast(cId);
    }
}

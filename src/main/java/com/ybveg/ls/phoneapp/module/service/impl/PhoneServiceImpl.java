package com.ybveg.ls.phoneapp.module.service.impl;



import com.ybveg.ls.phoneapp.module.dao.PhoneDao;
import com.ybveg.ls.phoneapp.module.dao.impl.PhoneDaoImpl;
import com.ybveg.ls.phoneapp.module.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    PhoneDaoImpl phoneDao ;

    @Override
    public List<Map<String,Object>> getPhoneList() throws Exception {
        return phoneDao.getPhoneList();
    }
}

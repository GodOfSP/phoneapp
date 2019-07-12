package com.ybveg.ls.phoneapp.module.service.impl;



import com.ybveg.ls.phoneapp.module.dao.PhoneDetailDao;
import com.ybveg.ls.phoneapp.module.dao.impl.PhoneDetailDaoImpl;
import com.ybveg.ls.phoneapp.module.service.PhoneDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PhoneDetailServiceImpl implements PhoneDetailService {

    @Autowired
    PhoneDetailDao phoneDetailDao;
    @Override
    public  List<Map<String,Object>> getPhoneDetail(String phoneId) throws Exception {
        return phoneDetailDao.getPhoneDetail(phoneId);
    }
}

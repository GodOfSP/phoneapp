package com.ybveg.ls.phoneapp.module.service.impl;



import com.ybveg.ls.phoneapp.module.dao.getContrastListDao;
import com.ybveg.ls.phoneapp.module.dao.impl.getContrastListDaoImpl;
import com.ybveg.ls.phoneapp.module.service.getContrastListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class getContrastListServiceImpl implements getContrastListService {

    @Autowired
    private getContrastListDaoImpl contrastListDao;

    @Override
    public List<Map<String, Object>> getContrastList(String userId) throws Exception {
        return contrastListDao.getContrastList(userId);
    }
}

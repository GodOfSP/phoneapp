package com.ybveg.ls.phoneapp.module.dao.impl;



import com.ybveg.ls.phoneapp.module.dao.PhoneDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PhoneDetailDaoImpl implements PhoneDetailDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public  List<Map<String,Object>> getPhoneDetail(String phoneId) throws Exception {
        String sql = "SELECT tpd.* FROM t_phone tp JOIN t_phone_detail tpd ON tp.id = tpd.phoneId where tp.id = ?";
        List<Map<String,Object>> l = jdbc.queryForList(sql,new Object[]{phoneId});
        return l;
    }
}

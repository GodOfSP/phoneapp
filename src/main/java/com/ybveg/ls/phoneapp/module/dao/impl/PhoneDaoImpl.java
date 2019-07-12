package com.ybveg.ls.phoneapp.module.dao.impl;


import com.ybveg.ls.phoneapp.module.dao.PhoneDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PhoneDaoImpl implements PhoneDao {


    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Map<String,Object>> getPhoneList() throws Exception {

        String sql = "SELECT tp.* FROM t_phone tp JOIN t_phone_detail tpd ON tp.id = tpd.phoneId;";
        List<Map<String,Object>> l =  this.jdbc.queryForList(sql, new Object[] {});
        return l;
    }
}

package com.ybveg.ls.phoneapp.module.dao.impl;

import com.ybveg.ls.phoneapp.module.dao.getContrastListDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Repository
public class getContrastListDaoImpl implements getContrastListDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public List<Map<String, Object>> getContrastList(String userId) throws Exception {
        String sql = "SELECT  tpd.* FROM t_phone tp JOIN t_phone_detail tpd on tp.id = tpd.phoneId JOIN t_relation_collection trc ON tp.id = trc.phoneId WHERE trc.userId = ?";
        return this.jdbc.queryForList(sql,new Object[]{userId});

    }
}

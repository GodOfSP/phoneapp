package com.ybveg.ls.phoneapp.module.dao.impl;

import com.ybveg.ls.phoneapp.module.dao.delContrastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class delContrastDaoImpl implements delContrastDao {

    @Autowired
    private JdbcTemplate jdbc;

    @Override
    public int delContrast( String cId) throws Exception {
        String sql = "DELETE FROM t_relation_collection WHERE id = ?";
        return this.jdbc.update(sql,new Object[]{cId});
    }
}

package com.ybveg.ls.phoneapp.module.dao.impl;


import com.ybveg.ls.phoneapp.module.dao.AddContrastDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AddContrastDaoImpl implements AddContrastDao {


    @Autowired
    private JdbcTemplate jdbc;

    public int addContrast(String userId, String phoneId) throws Exception {
        String sql = "INSERT INTO  t_relation_collection (userId,phoneId) VALUES (?,?)";
        return this.jdbc.update(sql,new Object[]{userId,phoneId});
    }

    @Override
    public String getContrastNum(String userId) throws Exception {
        String sql = "SELECT COUNT(1) FROM `t_relation_collection` WHERE userId =? GROUP BY userId ";
        String num = "";
        try {
            num = jdbc.queryForObject(sql,String.class,new Object[]{userId});
        }catch (Exception e){

        }
        return num;
    }
}

package com.ybveg.ls.phoneapp.module.dao;

public interface AddContrastDao {
    int addContrast(String userId, String phoneId) throws Exception;
    String getContrastNum(String userId) throws Exception;
}

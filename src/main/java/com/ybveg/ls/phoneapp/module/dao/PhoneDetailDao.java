package com.ybveg.ls.phoneapp.module.dao;


import java.util.List;
import java.util.Map;

public interface PhoneDetailDao {
    List<Map<String,Object>> getPhoneDetail(String phoneId) throws Exception;
}

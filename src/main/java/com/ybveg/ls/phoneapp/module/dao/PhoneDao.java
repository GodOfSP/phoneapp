package com.ybveg.ls.phoneapp.module.dao;


import java.util.List;
import java.util.Map;

public interface PhoneDao {
    List<Map<String,Object>> getPhoneList() throws Exception;
}

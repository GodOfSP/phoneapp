package com.ybveg.ls.phoneapp.module.service;


import java.util.List;
import java.util.Map;

public interface PhoneDetailService {

   List<Map<String,Object>> getPhoneDetail(String phoneId) throws Exception;

}

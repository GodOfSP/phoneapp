package com.ybveg.ls.phoneapp.module.service;

public interface AddContrastService {
    int addContrast(String userId, String phoneId) throws Exception;
    String getContrastNum(String userId) throws Exception;
}

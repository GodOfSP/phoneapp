package com.ybveg.ls.phoneapp.module.service;

import java.util.List;
import java.util.Map;

public interface getContrastListService {
    List<Map<String,Object>> getContrastList(String userId) throws Exception;
}

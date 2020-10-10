package cn.com.mall.orm.service.impl;

import cn.com.mall.orm.mbg.mapper.UmsAdminMapper;
import cn.com.mall.orm.mbg.model.UmsAdmin;
import cn.com.mall.orm.service.UmsAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Autowired
    private UmsAdminMapper umsAdminMapper;


    @Override
    public UmsAdmin getAdminByUsername(String username) {
        return ();
    }
}

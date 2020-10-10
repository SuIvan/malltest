package cn.com.mall.orm.service;

import cn.com.mall.orm.mbg.model.UmsAdmin;

public interface UmsAdminService {
    UmsAdmin getAdminByUsername(String username);
}

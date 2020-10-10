package cn.com.mall.orm.service.impl;

import cn.com.mall.orm.mbg.mapper.PmsBrandMapper;
import cn.com.mall.orm.mbg.model.PmsBrand;
import cn.com.mall.orm.mbg.model.PmsBrandExample;
import cn.com.mall.orm.service.PmsBrandService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * PmsBrandService实现类
 * Created by macro on 2019/4/19.
 */
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    private Logger logger = LoggerFactory.getLogger(PmsBrandServiceImpl.class);

    @Autowired
    private PmsBrandMapper brandMapper;

    @Override
    public List<PmsBrand> listAllBrand() {
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand brand) {
        return brandMapper.insertSelective(brand);
    }

    @Override
    public int updateBrand(Long id, PmsBrand brand) {
        brand.setId(id);
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public int deleteBrand(Long id) {
        return brandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return brandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public int countByTest() throws Exception{
        try {
            List<Long> list =new ArrayList<>();
//            list.add(1L);
            PmsBrandExample pmsBrandExample = new PmsBrandExample();
            pmsBrandExample.createCriteria().andIdNotIn(list);
            return brandMapper.countByExample(pmsBrandExample);
        }catch (Exception e){
            logger.info(this.getClass().getName()+"countByTest() :",e);
            throw e;
        }
    }
}
package io.renren.modules.spider.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.Query;
import io.renren.modules.spider.dao.JobInfoDao;
import io.renren.modules.spider.entity.JobInfoEntity;
import io.renren.modules.spider.service.JobInfoService;
import io.renren.modules.spider.utils.SortUtils;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("jobInfoService")
public class JobInfoServiceImpl extends ServiceImpl<JobInfoDao, JobInfoEntity> implements JobInfoService {
    @Resource
    private JobInfoDao jobInfoDao;
    @Resource
    private SortUtils sortUtils;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<JobInfoEntity> page = this.page(
                new Query<JobInfoEntity>().getPage(params)
        );
        return new PageUtils(page);
    }
}

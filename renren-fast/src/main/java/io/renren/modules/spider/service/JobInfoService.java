package io.renren.modules.spider.service;


import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.spider.entity.JobInfoEntity;

import java.util.List;
import java.util.Map;

public interface JobInfoService extends IService<JobInfoEntity> {
    PageUtils queryPage(Map<String, Object> params);
//    List<JobInfoEntity> getAllJob();
}

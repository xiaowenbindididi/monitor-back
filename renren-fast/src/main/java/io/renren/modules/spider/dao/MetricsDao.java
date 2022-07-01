package io.renren.modules.spider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.renren.modules.spider.entity.MetricsEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MetricsDao extends BaseMapper<MetricsEntity> {
}

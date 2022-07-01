package io.renren.modules.spider.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MetricsVo {
    @ApiModelProperty(name = "指标描述的中文名")
    String name;
    @ApiModelProperty(name = "指标出现的次数")
    Integer count;
}

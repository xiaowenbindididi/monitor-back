package io.renren.modules.spider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName(value = "metrics")
public class MetricsEntity {
    @TableId
    Long id;
    @ApiModelProperty(name = "指标描述的中文名")
    String name;
    @ApiModelProperty(name = "指标描述的英文名")
    @TableField(value = "name_en")
    String enName;
    @ApiModelProperty(name = "描述")
    @TableField(value = "metrics_desc")
    String metricsDesc;
}

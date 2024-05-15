package com.yq.travelmanagement.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist {

  @TableId
  private Integer tid;
  private String name;
  private String card;

  @TableField(select = false)
  @TableLogic(value = "0",delval = "1")
  private Integer deleted;
  @Version
  private Integer version;

}

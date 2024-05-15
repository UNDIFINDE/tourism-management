package com.yq.travelmanagement.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TouristGroups {

  @TableId
  private Integer tgId;
  private String tgName;
  private double price;
  private String address;
  private String context;
  @TableLogic(value = "0",delval = "1")
  @TableField(select = false)
  private int deleted;
  @Version
  private int version;


}

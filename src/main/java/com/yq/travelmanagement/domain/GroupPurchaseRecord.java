package com.yq.travelmanagement.domain;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupPurchaseRecord {

  @TableId
  private long id;
  private long gid;
  private long tgId;
  private long tid;
  private Timestamp travelTime;
  private double cost;


  @TableLogic(value = "0",delval = "1")
  private Integer deleted;
  @Version
  private Integer version;

}

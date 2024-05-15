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
public class Guide {

  @TableId
  private Integer gid;
  private String name;
  private long age;
  private long sex;
  private java.sql.Timestamp entryTime;
  private String context;
  private long flag;
  private java.sql.Date separationTime;
  private String address;

  @TableLogic(value = "0",delval = "1")
  @TableField(select = false)
  private long deleted;
  @Version
  private long version;

}

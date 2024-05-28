package com.icia.mbc.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Comments {
   private int cNum;
   private int cbNum;
   private String cWriter;
   private String cContents;
   private Date cDate;
}

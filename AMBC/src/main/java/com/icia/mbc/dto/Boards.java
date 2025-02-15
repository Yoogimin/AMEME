package com.icia.mbc.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Boards {
  private int bNum;
  private String bWriter;
  private String bTitle;
  private String bContents;
  private Date bDate;
  private int bHit;
  
  private MultipartFile bFile;
  private String bFileName;
  
}

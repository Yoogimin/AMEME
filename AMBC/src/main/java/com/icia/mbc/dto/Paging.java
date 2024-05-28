package com.icia.mbc.dto;

import lombok.Data;

@Data
public class Paging {
  private int page;
  private int maxPage;
  
  private int startPage;
  private int endPage;
  
  private int startRow;
  private int endRow;
  private int limit;
}

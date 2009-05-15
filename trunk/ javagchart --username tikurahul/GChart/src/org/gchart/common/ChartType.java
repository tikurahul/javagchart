package org.gchart.common;

public enum ChartType {
      //line charts  
      LINE_SPACES ("lc"), LINE_SPARK ("ls"), LINE_XY ("lxy"),
      //bar charts
      BAR_HORIZONTAL_STACK ("bhs"), BAR_VERTICAL_STACK ("bvs"), BAR_HORIZONTAL_GROUP ("bhg"), BAR_VERTICAL_GROUP ("bvg"),
      //pie charts
      PIE_2D ("p"), PIE_3D ("p3"), PIE_CONCERNTRIC ("pc");
  
  private final String urlParam;
  
  ChartType (String urlParam){
    this.urlParam = urlParam;
  }
  
  public String getUrlParam(){
    return urlParam;
  }
  
}

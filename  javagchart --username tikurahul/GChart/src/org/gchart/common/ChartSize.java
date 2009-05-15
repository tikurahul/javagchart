package org.gchart.common;

public class ChartSize {
  protected int width;
  protected int height;
  
  public ChartSize(int width, int height){
    if(isValidSize(width, height)){
      this.width = width;
      this.height = height;
    }else {
      throw new GChartException("Invalid chart size.");
    }
  }
  
  private boolean isValidSize(int width, int height){
    return (width * height <= 300000);
  }
  
  @Override
  public String toString(){
    return width + "x" + height;
  }
  
}

package org.gchart.common;

public class GChartException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public GChartException(){
    //do nothing
  }
  
  public GChartException(String message){
    super(message);
  }
  
  public GChartException(Throwable e){
    super(e);
  }
  
  public GChartException(String message, Throwable e){
    super(message, e);
  }
}

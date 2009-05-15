package org.gchart.data;

import java.util.List;

public abstract class Encoder<T extends Number> {
  
  protected List<T> data;
  
  public abstract String encodeData();
  
  public abstract String encodeData(T noValue);
  
  public abstract boolean isValidData();
  
  public abstract EncoderType getEncoderType();
  
  public List<T> getData(){
    return data;
  }
    
}

package org.gchart.data;

import java.util.List;

import org.gchart.util.GChartUtil;

public class SimpleEncoder<T extends Number> extends Encoder<T> {
  
  private double min;
  
  private double max;
  
  public static String MISSING_VALUE = "_";
  
  public SimpleEncoder(List<T> data){
    this.data = data;
    Double [] min_max = GChartUtil.getMinMax(data);
    min = min_max[0];
    max = min_max[1];
  }
  
  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }
  
  public void setMin(double min){
    this.min = min;
  }
  
  public void setMax(double max){
    this.max = max;
  }
  
  @Override
  public String encodeData() {
    String encodedString = "";
    for(T d : data){
      encodedString += encode(d) == ' ' ? MISSING_VALUE : encode(d);
    }
    return encodedString;
  }

  @Override
  public String encodeData(T noValue) {
    String encodedString = "";
    for(T d : data){
      if(d.equals(noValue)){
        encodedString += MISSING_VALUE;
      }else {
        encodedString += encode(d) == ' ' ? MISSING_VALUE : encode(d);
      }
    }
    return encodedString;
  }

  @Override
  public EncoderType getEncoderType() {
    return EncoderType.SIMPLE;
  }

  @Override
  public boolean isValidData() {
    //no pre-specified ranges
    return true;
  }
  
  private char encode(T t){
    String lookupString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    double value = GChartUtil.coerce(t);
    if(value < 0){
      return ' ';
    }else {
      return lookupString.charAt((int)Math.round((lookupString.length() - 1) * value / getMax()));
    }
  }
  
}

package org.gchart.data;

import java.util.List;

import org.gchart.common.GChartException;
import org.gchart.util.GChartUtil;

public class TextEncoder<T extends Number> extends Encoder<T> {
  
  public static String MISSING_VALUE = "-1";

  public TextEncoder(List<T> data){
    this.data = data;
  }
  
  @Override
  public String encodeData() {
    if(isValidData())
      return GChartUtil.csv(data);
    else
      throw new GChartException("Data out of range. Please check input data.");
  }

  @Override
  public String encodeData(T noValue) {
    if(isValidData())
      return GChartUtil.csv(data, noValue, MISSING_VALUE);
    else 
      throw new GChartException("Data out of range. Please check input data.");
  }

  @Override
  public boolean isValidData() {
    boolean isValidData = true;
    for(T d : data){
      if(GChartUtil.coerce(d) < 0 || GChartUtil.coerce(d) > 100){
        isValidData = false;
        break;
      }
    }
    return isValidData;
  }

  @Override
  public EncoderType getEncoderType() {
    return EncoderType.TEXT;
  }
  
}

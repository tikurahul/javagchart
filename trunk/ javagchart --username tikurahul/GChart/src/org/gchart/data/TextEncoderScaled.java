package org.gchart.data;

import java.util.List;

import org.gchart.common.GChartException;
import org.gchart.util.GChartUtil;

public class TextEncoderScaled<T extends Number> extends Encoder<T> {

  private double min;
  
  private double max;
  
  public static String MISSING_VALUE = "-1";
  
  public TextEncoderScaled(List<T> data){
    this.data = data;
    //setting min/max
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
    //no pre-specified ranges
    return true;
  }

  @Override
  public EncoderType getEncoderType() {
    return EncoderType.TEXT;
  }

}

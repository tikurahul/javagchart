package org.gchart.data.urls;

import java.util.ArrayList;
import java.util.List;

import org.gchart.common.GChartException;
import org.gchart.data.Encoder;
import org.gchart.data.EncoderType;
import org.gchart.data.SimpleEncoder;
import org.gchart.util.GChartUtil;

public class SimpleDataURLGenerator<T extends Number> extends DataURLGenerator<T> {
  
  public static final String CHART_DATA = "chd=s:";
  
  public SimpleDataURLGenerator(){
    this.encoders = new ArrayList<Encoder<T>>();
    this.encoderType = EncoderType.SIMPLE;
  }
  
  @Override
  public void addEncoder(Encoder<T> encoder) {
    if(!isSameEncoderType(encoder))
      throw new GChartException("Encoders used should be of type EncoderType.SIMPLE");
    
    encoders.add(encoder);
    updateEncoders();
  }

  @Override
  public String getUrlPart() {
    
    List<String> chartDataParts = new ArrayList<String>();
    for(Encoder<T> encoder : encoders){
      chartDataParts.add(encoder.encodeData());
    }
    
    return CHART_DATA + GChartUtil.delimit(chartDataParts, ",");
  }

  @Override
  public boolean isSameEncoderType(Encoder<T> encoder) {
    return encoderType.equals(encoder.getEncoderType());
  }

  @Override
  public String getUrlPart(T noValue) {
    
    List<String> chartDataParts = new ArrayList<String>();
    for(Encoder<T> encoder : encoders){
      chartDataParts.add(encoder.encodeData(noValue));
    }
    
    return CHART_DATA + GChartUtil.delimit(chartDataParts, ",");
  }
  
  //this method is used to normalize min, max values across different sets of data.
  private void updateEncoders(){
    
    double min = Double.MAX_VALUE;
    double max = Double.MIN_VALUE;
    
    for(Encoder<T> encoder : encoders){
      if(encoder instanceof SimpleEncoder){
        SimpleEncoder<T> simpleEncoder = (SimpleEncoder<T>) encoder;
        if(simpleEncoder.getMin() < min)
          min = simpleEncoder.getMin();
        
        if(max < simpleEncoder.getMax())
          max=simpleEncoder.getMax();
      }
    }
    
    for(Encoder<T> encoder : encoders){
      if(encoder instanceof SimpleEncoder){
        SimpleEncoder<T> simpleEncoder = (SimpleEncoder<T>) encoder;
        simpleEncoder.setMin(min);
        simpleEncoder.setMax(max);
      }
    }
    
  }

}

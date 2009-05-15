package org.gchart.data.urls;

import java.util.ArrayList;
import java.util.List;

import org.gchart.common.GChartException;
import org.gchart.data.Encoder;
import org.gchart.data.EncoderType;
import org.gchart.data.TextEncoder;
import org.gchart.data.TextEncoderScaled;
import org.gchart.util.GChartUtil;

public class TextDataURLGenerator<T extends Number> extends DataURLGenerator<T> {
  
  public static final String CHART_DATA = "chd=t:";
  
  public static final String CHART_DATA_STRING = "chds";
  
  public TextDataURLGenerator(){
    this.encoders = new ArrayList<Encoder<T>>();
    this.encoderType = EncoderType.TEXT;
  }

  @Override
  public void addEncoder(Encoder<T> encoder) {
    if(!isSameEncoderType(encoder))
      throw new GChartException("Encoders used should be of type EncoderType.TEXT");
      
    this.encoders.add(encoder);
  }

  @Override
  public boolean isSameEncoderType(Encoder<T> encoder) {
    return this.encoderType.equals(encoder.getEncoderType());
  }

  
  @Override
  public String getUrlPart() {
    
    List<String> chartDataParts = new ArrayList<String>();
    
    List<Double> minValues = new ArrayList<Double>();
    List<Double> maxValues = new ArrayList<Double>();
    
    for(Encoder<T> encoder : encoders){
      chartDataParts.add(encoder.encodeData());
       if(encoder instanceof TextEncoder){
         minValues.add(0.0d);
         maxValues.add(100.0d);
       }else if(encoder instanceof TextEncoderScaled) {
         TextEncoderScaled<? extends Number> textEncoder = (TextEncoderScaled<? extends Number>) encoder;
         minValues.add(textEncoder.getMin());
         maxValues.add(textEncoder.getMax());
       }
    }
    
    Double [] min = GChartUtil.getMinMax(minValues);
    Double [] max = GChartUtil.getMinMax(maxValues);
    
    
    return CHART_DATA + GChartUtil.delimit(chartDataParts, "|") + "&" +
           CHART_DATA_STRING + "=" + String.format("%1$.1f", min[0]) + "," + String.format("%1$.1f", max[1]);
    
  }

  @Override
  public String getUrlPart(T noValue) {
    
    List<String> chartDataParts = new ArrayList<String>();

    List<Double> minValues = new ArrayList<Double>();
    List<Double> maxValues = new ArrayList<Double>();
    
    for(Encoder<T> encoder : encoders){
      chartDataParts.add(encoder.encodeData(noValue));
       if(encoder instanceof TextEncoder){
         minValues.add(0.0d);
         maxValues.add(100.0d);
       }else if(encoder instanceof TextEncoderScaled) {
         TextEncoderScaled<? extends Number> textEncoder = (TextEncoderScaled<? extends Number>) encoder;
         minValues.add(textEncoder.getMin());
         maxValues.add(textEncoder.getMax());
       }
    }
    
    Double [] min = GChartUtil.getMinMax(minValues);
    Double [] max = GChartUtil.getMinMax(maxValues);
    
    return CHART_DATA + GChartUtil.delimit(chartDataParts, "|") + "&" + 
           CHART_DATA_STRING + "=" + String.format("%1$.1f", min[0]) + "," + String.format("%1$.1f", max[1]);
  }

}

package org.gchart.data.urls;

import java.util.List;

import org.gchart.data.Encoder;
import org.gchart.data.EncoderType;

public abstract class DataURLGenerator<T extends Number> {
  
  protected List<Encoder<T>> encoders;
 
  protected EncoderType encoderType;
  
  public abstract void addEncoder(Encoder<T> encoder);
  
  public abstract boolean isSameEncoderType(Encoder<T> encoder);
  
  public abstract String getUrlPart();
  
  public abstract String getUrlPart(T noValue);
  
  public List<Encoder<T>> getAllEncoders(){
    return encoders;
  }
  
}

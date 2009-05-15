package org.gchart.util;

import java.util.List;

import org.gchart.common.GChartException;

public class GChartUtil {
  
  public static <T extends Number> String csv(List<T> collection){
    if(collection == null)
      throw new GChartException("Invalid input data. Could not convert to comma seperated values.");
   
    String csv = "";
    for(int i=0; i<collection.size(); i++){
      csv += String.format("%1$.1f", GChartUtil.coerce(collection.get(i)));
      csv += i != collection.size()-1 ?  "," : ""; 
    }
    return csv;
  } 
  
  public static <T extends Number> String csv(List<T> collection, T noValue, String replaceBy){
    if(collection == null || noValue == null || replaceBy == null)
      throw new GChartException("Invalid input data. Could not convert to comma seperated values.");
   
    String csv = "";
    for(int i=0; i<collection.size(); i++){
      if(noValue.equals(collection.get(i))){
        csv += replaceBy;
        csv += i != collection.size()-1 ?  "," : "";
      }
      else {
        csv += String.format("%1$.1f", GChartUtil.coerce(collection.get(i)));
        csv += i != collection.size()-1 ?  "," : "";
      }
    }
    return csv;
  }
  
  public static <T> String delimit (List<T> collection, String delimiter){
    if(collection == null)
      throw new GChartException("Invalid collection. Could not convert to delimiter seperated values.");
   
    String demilitedText = "";
    for(int i=0; i<collection.size(); i++){
      demilitedText += collection.get(i);
      demilitedText += i != collection.size()-1 ?  delimiter : ""; 
    }
    return demilitedText;
  }
  
  public static <T> String delimit (List<T> collection, String delimiter, T noValue, String replaceBy){
    if(collection == null || noValue == null || replaceBy == null)
      throw new GChartException("Invalid collection. Could not convert to delimiter seperated values.");
   
    String csv = "";
    for(int i=0; i<collection.size(); i++){
      if(noValue.equals(collection.get(i))){
        csv += replaceBy;
        csv += i != collection.size()-1 ?  delimiter : "";
      }
      else {
        csv += collection.get(i);
        csv += i != collection.size()-1 ?  delimiter : "";
      }
    }
    return csv;
  }
  
  public static <T extends Number>  Double coerce(T t){
    Double result = null;
    try{
      result = Double.parseDouble(String.valueOf(t));
    }catch (Exception e){
      throw new GChartException(e);
    }
    return result;
  }
  
  public static <T extends Number>  Double [] getMinMax (List<T> data){
    Double [] result = new Double[2];
    //min
    result[0] = Double.MAX_VALUE;
    //max
    result[1] = Double.MIN_VALUE;
    
    for(T d : data){
       double value = GChartUtil.coerce(d); 
      if(result[0] > value){
        result[0] = value;
      }
      if(value > result[1]){
        result[1] = value;
      }
    }
    return result;
  }
  
}

package org.gchart.tests;

import java.util.Arrays;
import java.util.List;

import org.gchart.Chart;
import org.gchart.common.ChartSize;
import org.gchart.common.ChartType;
import org.gchart.common.Color;
import org.gchart.data.SimpleEncoder;
import org.gchart.data.TextEncoder;
import org.gchart.data.TextEncoderScaled;
import org.gchart.data.urls.SimpleDataURLGenerator;
import org.gchart.data.urls.TextDataURLGenerator;
import org.gchart.renderers.ColorRenderer;
import org.gchart.renderers.SimpleColorRenderer;

public class SimpleTests {
  
  public static void main(String[] args) {
    testChartUrl2();
  }
  
  public static void testSimpleEncoding(){
    List<Float> list = Arrays.asList(new Float [] {0.0f,19.0f,27.0f,53.0f,61.0f,-1f});
    List<Float> list2 = Arrays.asList(new Float [] {12.0f,39.0f,57.0f,45.0f,51.0f,27.0f});
    SimpleEncoder<Float> encoder = new SimpleEncoder<Float>(list);
    SimpleEncoder<Float> encoder2 = new SimpleEncoder<Float>(list2);
    SimpleDataURLGenerator<Float> urlMaker = new SimpleDataURLGenerator<Float>();
    urlMaker.addEncoder(encoder);
    urlMaker.addEncoder(encoder2);
    System.out.println(urlMaker.getUrlPart());
  } 
  
  public static void testTextEncoding(){
    List<Float> list = Arrays.asList(new Float [] {10.0f,20.0f, 30.0f, 40.0f, 50.0f, 60.0f });
    TextEncoder<Float> encoder = new TextEncoder<Float>(list);
    TextEncoderScaled<Float> encoder1 = new TextEncoderScaled<Float>(list);
    TextDataURLGenerator<Float> urlMaker = new TextDataURLGenerator<Float>();
    urlMaker.addEncoder(encoder);
    urlMaker.addEncoder(encoder1);
    System.out.println(urlMaker.getUrlPart());
  }
  
  public static void testChartUrl(){
    //data url generator
    List<Float> list = Arrays.asList(new Float [] {10.0f,20.0f, 30.0f, 40.0f, 50.0f, 60.0f });
    List<Float> list2 = Arrays.asList(new Float [] {20.0f,30.0f, 40.0f, 50.0f, 60.0f, 70.0f });
    TextEncoder<Float> encoder = new TextEncoder<Float>(list);
    TextEncoderScaled<Float> encoder2 = new TextEncoderScaled<Float>(list2);
    TextDataURLGenerator<Float> urlMaker = new TextDataURLGenerator<Float>();
    urlMaker.addEncoder(encoder);
    urlMaker.addEncoder(encoder2);
    
    //chartsize
    ChartSize size = new ChartSize(256, 256);
    
    //colors
    ColorRenderer renderer = new SimpleColorRenderer(Arrays.asList(new Color [] {new Color(255,0,0), new Color(0,255,0)}));
    
    //chartType
    ChartType type = ChartType.LINE_SPARK;
    
    //chartTitle
    String chartTitle = "Testing Google Charts";
    
    //create chart
    Chart chart= new Chart(urlMaker, type, renderer, size, chartTitle);
    
    System.out.println(chart.getChartUrl());
  }
  
  public static void testChartUrl2(){
    //data url generator
    List<Float> list = Arrays.asList(new Float [] {10.0f,20.0f, 30.0f, 40.0f, 50.0f, 60.0f });
    List<Float> list2 = Arrays.asList(new Float [] {20.0f,30.0f, 40.0f, 50.0f, 60.0f, 70.0f });
    SimpleEncoder<Float> encoder = new SimpleEncoder<Float>(list);
    SimpleEncoder<Float> encoder2 = new SimpleEncoder<Float>(list2);
    SimpleDataURLGenerator<Float> urlMaker = new SimpleDataURLGenerator<Float>();
    urlMaker.addEncoder(encoder);
    urlMaker.addEncoder(encoder2);
    
    //chartsize
    ChartSize size = new ChartSize(256, 256);
    
    //colors
    ColorRenderer renderer = new SimpleColorRenderer(Arrays.asList(new Color [] {new Color(255,0,0), new Color(0,255,0)}));
    
    //chartType
    ChartType type = ChartType.PIE_CONCERNTRIC;
    
    //chartTitle
    String chartTitle = "Testing Google Charts";
    
    //create chart
    Chart chart= new Chart(urlMaker, type, renderer, size, chartTitle);
    
    System.out.println(chart.getChartUrl());
  }
}

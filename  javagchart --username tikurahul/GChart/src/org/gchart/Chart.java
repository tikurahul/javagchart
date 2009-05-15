package org.gchart;

import org.gchart.common.ChartSize;
import org.gchart.common.ChartType;
import org.gchart.data.urls.DataURLGenerator;
import org.gchart.renderers.ColorRenderer;

public class Chart {
  
  public static final String GOOGLE_CHART_PREFIX = "http://chart.apis.google.com/chart?";
  
  public static final String CHART_TYPE_PREFIX = "cht";
  
  public static final String CHART_TITLE_PREFIX = "chtt";
  
  public static final String CHART_SIZE_PREFIX = "chs";
  
  //data
  protected DataURLGenerator<? extends Number> dataUrlGenerator;

  //chart type
  protected ChartType chartType;
  
  //color renderers
  protected ColorRenderer renderer;
  
  //chart size
  protected ChartSize size;
  
  //chart title
  protected String chartTitle;
  
  public Chart(DataURLGenerator<? extends Number> dataUrlGenerator, ChartType chartType, ColorRenderer renderer, ChartSize size, String chartTitle){
    this.dataUrlGenerator = dataUrlGenerator;
    this.chartType = chartType;
    this.renderer = renderer;
    this.size = size;
    this.chartTitle = chartTitle;
  }
  
  public String getChartUrl(){
    return GOOGLE_CHART_PREFIX + CHART_SIZE_PREFIX + "=" + size + "&" + 
           CHART_TYPE_PREFIX + "=" + chartType.getUrlParam() + "&" +
           dataUrlGenerator.getUrlPart() + "&" + 
           renderer.getUrlPart() + "&" + 
           CHART_TITLE_PREFIX + "=" + chartTitle;
  }
}

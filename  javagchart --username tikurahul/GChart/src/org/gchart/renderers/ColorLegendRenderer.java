package org.gchart.renderers;

import java.util.List;

import org.gchart.common.Color;
import org.gchart.common.GChartException;

public class ColorLegendRenderer extends ColorRenderer {
  
  protected List<String> legendLabels;
  protected List<Color> colors;
  
  @Override
  public String getUrlPart() {
    throw new GChartException("Not Implemented.");
  }

}

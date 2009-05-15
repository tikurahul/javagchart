package org.gchart.renderers;

import java.util.List;

import org.gchart.common.Color;
import org.gchart.util.GChartUtil;

public class SimpleColorRenderer extends ColorRenderer {
  
  private static final String PARAM_NAME = "chco";
  protected List<Color> colors;
  
  //consists of bunch of colors specified in a csv format.
  //gets added as  chco=<color 1>,...<color n> where <color> is an RRGGBB format hexadecimal number.
  
  public SimpleColorRenderer(List<Color> colors){
    this.colors = colors;
  }

  @Override
  public String getUrlPart() {
    return PARAM_NAME + "=" + GChartUtil.delimit(colors, ",");
  }
}

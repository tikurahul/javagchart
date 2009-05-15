package org.gchart.common;

public class Color {
  
  private int red, green, blue;
 
  public Color(int red, int green, int blue){
    this.red = red;
    this.green = green;
    this.blue = blue;
  }
  
  public int getRed() {
    return red;
  }

  public void setRed(int red) {
    this.red = red;
  }

  public int getGreen() {
    return green;
  }

  public void setGreen(int green) {
    this.green = green;
  }

  public int getBlue() {
    return blue;
  }

  public void setBlue(int blue) {
    this.blue = blue;
  }
  
  private boolean isValidColor(){
    if((red >=0 && red<=255) && (green >=0 && green<=255) && (blue >=0 && blue<=255)){
      return true;
    }else {
      return false;
    }
  }
  
  @Override
  public String toString(){
    if(isValidColor()){
      return String.format("%1$02x%2$02x%3$02x", red, green, blue);
    }else {
      throw new GChartException("Invalid RGB values.");
    }
  }
}

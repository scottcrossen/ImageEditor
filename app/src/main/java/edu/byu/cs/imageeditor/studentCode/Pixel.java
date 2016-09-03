package edu.byu.cs.imageeditor.studentCode;


/**
 * Created by slxn42 on 9/3/16.
 */
public class Pixel {
    private Color red;
    private Color green;
    private Color blue;
    public Pixel(int new_red, int new_green, int new_blue){
        red=new Color(new_red);
        green=new Color(new_green);
        blue=new Color(new_blue);
    }
    public void invert(){
        red.invert();
        green.invert();
        blue.invert();
    }
    public void grayscale(){
        int average=(red.value+green.value+blue.value)/3;
        red.set_value(average);
        green.set_value(average);
        blue.set_value(average);
    }
    public String toString(){
        return red.toString().concat("\n").concat(blue.toString()).concat("\n").concat(green.toString()).concat("\n");
    }
}

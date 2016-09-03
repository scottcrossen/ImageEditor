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
        blue.invert();
        green.invert();
    }
}

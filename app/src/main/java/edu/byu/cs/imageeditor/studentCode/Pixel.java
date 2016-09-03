package edu.byu.cs.imageeditor.studentCode;


/**
 * Created by slxn42 on 9/3/16.
 */
public class Pixel {
    private Color red;
    private Color blue;
    private Color green;
    public Pixel(int new_red, int new_blue, int new_green){
        red=new Color(new_red);
        blue=new Color(new_blue);
        green=new Color(new_green);
    }
}

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
        return red.toString().concat("\n").concat(green.toString()).concat("\n").concat(blue.toString()).concat("\n");
    }
    void set_to_middle(){
        red.set_value(128);
        green.set_value(128);
        blue.set_value(128);
    }
    void maximize(Pixel second){
        int red_diff=red.value-second.red.value;
        int green_diff=green.value-second.green.value;
        int blue_diff=blue.value-second.blue.value;
        int new_value;
        if(Math.abs(red_diff)>= Math.abs(green_diff) && Math.abs(red_diff)>= Math.abs(blue_diff)) new_value=128+red_diff;
        else if(Math.abs(green_diff)> Math.abs(red_diff) && Math.abs(green_diff)>= Math.abs(blue_diff)) new_value=128+green_diff;
        else new_value=128+blue_diff;
        red.set_value(new_value);
        green.set_value(new_value);
        blue.set_value(new_value);
    }
    public int return_red_value(){return red.value;}
    public int return_green_value(){return green.value;}
    public int return_blue_value(){return blue.value;}
}

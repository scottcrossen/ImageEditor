package edu.byu.cs.imageeditor.studentCode;

/**
 * Created by slxn42 on 9/3/16.
 */
public class Color {
    public int value;
    public Color(int new_int){
        value=new_int;
    }
    public void invert(){
        value=255-value;
    }
    public String toString(){
        return Integer.toString(value);
    }
    public void set_value(int new_int){
        value=new_int;
    }
}

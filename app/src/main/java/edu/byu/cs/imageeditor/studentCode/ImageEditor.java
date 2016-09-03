package edu.byu.cs.imageeditor.studentCode;

import java.io.BufferedReader;

/**
 * Created by slxn42 on 9/3/16.
 */
public class ImageEditor implements IImageEditor {
    public Image current_image;
    public ImageEditor(){}
    public void load(BufferedReader bufferedReader){
        current_image=new Image(bufferedReader);
    }
    public String invert(){
        return current_image.invert();
    }
    public String grayscale(){
        return current_image.grayscale();
    }
    public String emboss(){
        return current_image.emboss();
    }
    public String motionblur(int blurLength){
        return current_image.motionblur(blurLength);
    }
}

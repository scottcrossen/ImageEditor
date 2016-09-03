package edu.byu.cs.imageeditor.studentCode;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * Created by slxn42 on 9/3/16.
 */
public class Image {
    public String color_code;
    public int width;
    public int height;
    public int max_color;
    private Pixel[][] pixel_array;
    private Scanner scanner;
    public Image(BufferedReader bufferedReader){
        scanner=new Scanner(bufferedReader);
        scanner.useDelimiter("(\\s+)(#[^\\n]*)?(\\s*)|(#[^\\n]*\\n)(\\s*)");
        color_code=scanner.next();
        width=scanner.nextInt();
        height=scanner.nextInt();
        max_color=scanner.nextInt();
        pixel_array=new Pixel[height][width];
        int iterator=0;
        while(scanner.hasNextInt() && iterator < height*width){
            int new_red=scanner.nextInt();
            int new_green=scanner.nextInt();
            int new_blue=scanner.nextInt();
            pixel_array[0][iterator]=new Pixel(new_red, new_green, new_blue);
            iterator++;
        }
    }
    public Pixel[][] getPixel2dArray() {
        return pixel_array;
    }
    public void setPixel2dArray(Pixel[][] pixel2dArray) {
        this.pixel_array = pixel2dArray;
    }
    public String invert(){
        return "";
    }
    public String grayscale(){
        return "";
    }
    public String emboss(){
        return "";
    }
    public String motionblur(int blurLength){
        return "";
    }
}

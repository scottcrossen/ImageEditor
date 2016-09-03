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
    private Pixel[] pixel_array;
    private Scanner scanner;
    public Image(BufferedReader bufferedReader){
        scanner=new Scanner(bufferedReader);
        scanner.useDelimiter("(\\s+)(#[^\\n]*)?(\\s*)|(#[^\\n]*\\n)(\\s*)");
        color_code=scanner.next();
        width=scanner.nextInt();
        height=scanner.nextInt();
        max_color=scanner.nextInt();
        pixel_array=new Pixel[height*width];
        int iterator=0;
        while(scanner.hasNextInt() && iterator < height*width){
            int new_red=scanner.nextInt();
            int new_green=scanner.nextInt();
            int new_blue=scanner.nextInt();
            pixel_array[iterator]=new Pixel(new_red, new_green, new_blue);
            iterator++;
        }
    }
    public Pixel[] getPixel2dArray() {
        return pixel_array;
    }
    public void setPixel2dArray(Pixel[] new_array) {
        this.pixel_array = new_array;
    }
    public String invert(){
        StringBuilder output= new StringBuilder();
        output.append(print_image_header());
        for(int iterator=0; iterator<height*width; iterator++) {
            pixel_array[iterator].invert();
            output.append(pixel_array[iterator].toString());
        }
        return output.toString();
    }
    public String grayscale(){
        StringBuilder output= new StringBuilder();
        output.append(print_image_header());
        for(int iterator=0; iterator<height*width; iterator++) {
            pixel_array[iterator].grayscale();
            output.append(pixel_array[iterator].toString());
        }
        return output.toString();
    }
    public String emboss(){
        StringBuilder output= new StringBuilder();
        output.append(print_image_header());
        for(int iterator=height*width-1; iterator>=0; iterator--) {
            if((iterator % width == 0) || (iterator < width)) {
                pixel_array[iterator].set_to_middle();
            }
            else{
                pixel_array[iterator].maximize(pixel_array[iterator-width-1]);
            }
        }
        for(int iterator=0; iterator<height*width; iterator++) {
            output.append(pixel_array[iterator].toString());
        }
        return output.toString();
    }
    public String motionblur(int blurLength){
        StringBuilder output= new StringBuilder();
        output.append(print_image_header());
        for(int iterator=0; iterator<height*width-1; iterator++) {
            int red_sum=pixel_array[iterator].return_red_value();
            int green_sum=pixel_array[iterator].return_green_value();
            int blue_sum=pixel_array[iterator].return_blue_value();
            int pixel_count=1;
            for (int blur_iterator = iterator + 1; ((blur_iterator + 1) % width != 0) && (blur_iterator - iterator < blurLength); blur_iterator++) {
                red_sum += pixel_array[blur_iterator].return_red_value();
                green_sum += pixel_array[blur_iterator].return_green_value();
                blue_sum += pixel_array[blur_iterator].return_blue_value();
                pixel_count++;
            }
            pixel_array[iterator]= new Pixel(red_sum/pixel_count, green_sum/pixel_count, blue_sum/pixel_count);
            output.append(pixel_array[iterator].toString());
        }
        output.append(pixel_array[height*width-1].toString());
        return output.toString();
    }
    private String print_image_header() {
        StringBuilder output=new StringBuilder();
        output.append(color_code + "\n");
        output.append(width + " ");
        output.append(height + "\n");
        output.append(max_color + "\n");
        return output.toString();
    }
}

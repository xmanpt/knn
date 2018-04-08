package eu.rm.knn;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class Random2DImage{

    private static final String DATASET_PATH = System.getProperty("user.dir") + "/src/main" + "/resources/Output.png";

    public static void createImage(String args[])throws IOException {

        int width = 640;
        int height = 320;

        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);


        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int a = (int) (Math.random() * 256); //alpha
                int r = (int) (Math.random() * 256); //red
                int g = (int) (Math.random() * 256); //green
                int b = (int) (Math.random() * 256); //blue

                int p = (a << 24) | (r << 16) | (g << 8) | b; //pixel

                img.setRGB(x, y, p);
            }
        }


        try{
            File f =  new File(DATASET_PATH);
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println("Error: " + e);
        }

    }




}
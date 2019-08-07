package com.example.demodemosqls;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageProcessing {
	

	public ImageProcessing() {
		
	}
	
	public void scaleImage(File file) throws IOException {
		
		if((null!=file && file.listFiles().length > 0) ) {
			File[] listOfFiles = file.listFiles();
			Image img = null;
			BufferedImage tempPNG = null;
			BufferedImage tempJPG = null;
			File newFilePNG = null;
			//File newFileJPG = null;
			
			for(int i=0; i<listOfFiles.length;i++) {
				if(listOfFiles[i].isFile()) {
					System.out.println(" Processing File Name: "+ listOfFiles[i].getName());
					
					System.out.println(listOfFiles[i].getAbsolutePath());
					System.out.println(listOfFiles[i].getCanonicalPath());
					
					  img = ImageIO.read(new File(listOfFiles[i].getAbsolutePath()));
					  
					  double aspectRatio = (double) img.getWidth(null)/(double)img.getHeight(null);
					  tempPNG = resizeImage(img, 100, (int)(100/aspectRatio));
					  
					  newFilePNG = new File("C:\\Users\\u0148565\\targetImage\\" +listOfFiles[i].getName());
					  ImageIO.write(tempPNG, "png", newFilePNG);
					 
					  //newFileJPG = new File("targetImage/"+listOfFiles[i].getName()+"_New.jpg");
					  //ImageIO.write(tempJPG, "jpg",newFileJPG);
					 
				}
			}
			System.out.println("Directory exists");
		}else {
			System.out.println("NO!!!!!!!");
		}
			
	}
	
	/**
	 * This function resize the image file and returns the BufferedImage object that can be saved to file system.
	 */
	public BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
	
	public static void reScaleImage() {
		
	}
}

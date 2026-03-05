/*
  ImageApp: 
 */
import java.awt.Color;
public class ImageApp
{
  public static void main(String[] args)
  {
    // use any file from the lib folder
    String pictureFile = "C:\\Users\\cheki\\OneDrive\\Documents\\Python code\\Java Code\\3.3.4\\lib\\beach.jpg";
    String smallPictureFile = "C:\\Users\\cheki\\OneDrive\\Documents\\Python code\\Java Code\\3.3.4\\lib2\\balloon.png";
    // Get an image, get 2d array of pixels, show a color of a pixel, and display the image
    Picture origImg = new Picture(pictureFile);
    Pixel[][] origPixels = origImg.getPixels2D();
    System.out.println(origPixels[0][0].getColor());
    origImg.explore();

    // Image #1 Using the original image and pixels, recolor an image by changing the RGB color of each Pixel
    Picture recoloredImg = new Picture(pictureFile);
    Pixel[][] recoloredPixels = recoloredImg.getPixels2D();

    /* to be implemented */
    //making the whiter and if it is already white, it will turn black
    for(Pixel[] rows : recoloredPixels){
      for(Pixel cols : rows){
        if(cols.getRed()+100>255){
          cols.setRed(0);
        }
        else{
          cols.setRed(cols.getRed()+100);
        }
        if(cols.getGreen()+100>255){
          cols.setGreen(0);
        }
        else{
          cols.setGreen(cols.getGreen()+100);
        }
        if(cols.getBlue()+100>255){
          cols.setBlue(0);
        }
        else{
          cols.setBlue(cols.getBlue()+100);
        }
      }
    }
    recoloredImg.show();

    // Image #2 Using the original image and pixels, create a photographic negative of the image
    Picture negImg = new Picture(pictureFile);
    Pixel[][] negPixels = negImg.getPixels2D();

    /* to be implemented */
    for(Pixel[] rows : negPixels){
      for(Pixel cols : rows){
        cols.setRed(255-cols.getRed());
        cols.setGreen(255-cols.getGreen());
        cols.setBlue(255-cols.getBlue());
      }
    }
    negImg.show();

    // Image #3 Using the original image and pixels, create a grayscale version of the image
    Picture grayscaleImg = new Picture(pictureFile);
    Pixel[][] grayscalePixels = grayscaleImg.getPixels2D();

    // 0.299R + 0.587G + 0.114B for a Greyscale
    for(Pixel[] rows : grayscalePixels){
      for(Pixel cols : rows){
        cols.setRed((int)((cols.getRed()+cols.getBlue()+cols.getGreen())/3));
        cols.setGreen((int)((cols.getRed()+cols.getBlue()+cols.getGreen())/3));
        cols.setBlue((int)((cols.getRed()+cols.getBlue()+cols.getGreen())/3));
      }
    }
    grayscaleImg.show();

    // Image #4 Using the original image and pixels, rotate it 180 degrees
    Picture upsidedownImage = new Picture(pictureFile);
    Pixel[][] upsideDownPixels = upsidedownImage.getPixels2D();
    Picture relativeupsideDown = new Picture(pictureFile);
    Pixel[][] relativeImageUpsideDown = relativeupsideDown.getPixels2D();
    int upsideDownImageRow = upsideDownPixels.length;
    int upsideDownImageCol = upsideDownPixels[0].length;
    /* to be implemented */
    //[0,1,2,3,a]
    //[4,5,6,7,b]
    //[8,9,10,11,c]
    //[12,13,14,15,d]
    int inverseI = 0;
    int inverseJ = 0;
    for(int i = 0; i < upsideDownImageRow; i++){//i=3, i=2, i=1, i=0
      inverseI = upsideDownImageRow - 1 - i; //inverse=0, inverse=1, inverse=2, inverse=3
      for(int j = 0; j < upsideDownImageCol; j++){//j=3, j=2, j=1, j=0
        int blue = upsideDownPixels[i][j].getBlue();
        int green = upsideDownPixels[i][j].getGreen();
        int red = upsideDownPixels[i][j].getRed();
        inverseJ = upsideDownImageCol - 1 - j;//inverse=0,inverse=1,inverse=2,inverse=3
        relativeImageUpsideDown[inverseI][inverseJ].setRed(red);
        relativeImageUpsideDown[inverseI][inverseJ].setGreen(green);
        relativeImageUpsideDown[inverseI][inverseJ].setBlue(blue);
      }
    }
    relativeupsideDown.show();

    // Image #5 Using the original image and pixels, rotate image 90
    Picture rotateImg = new Picture(pictureFile);
    Pixel[][] rotatePixels = rotateImg.getPixels2D();
    
    int totalRows = rotatePixels.length;
    int totalCols = rotatePixels[0].length;
    Picture relativeRotatedImage = new Picture(totalCols, totalRows);
    Pixel[][] relativeRotatedPixels = relativeRotatedImage.getPixels2D();

    for(int i = 0; i < totalRows; i++){
      for(int j = 0; j < totalCols; j++){

        //relativeRotatedPixels[i][totalRows - 1 - i] = new Pixel(rotateImg)
        
        int red = rotatePixels[i][j].getRed();
        int blue = rotatePixels[i][j].getBlue();
        int green = rotatePixels[i][j].getGreen();

        relativeRotatedPixels[j][totalRows - 1 - i].setRed(red);
        relativeRotatedPixels[j][totalRows-1-i].setGreen(green);
        relativeRotatedPixels[j][totalRows-1-i].setBlue(blue);
      }
    }

    relativeRotatedImage.show();

    // Image #6 Using the original image and pixels, rotate image -90
    Picture rotateImg2 = new Picture(pictureFile);
    Pixel[][] rotatePixels2 = rotateImg2.getPixels2D();

    Picture relativeNegativeRotatedPicture = new Picture(totalCols, totalRows);
    Pixel[][] relativeNegativeRotatedPixels = relativeNegativeRotatedPicture.getPixels2D();

    for(int i = 0; i < totalRows; i++){
      for(int j = 0; j < totalCols; j++){

        int red = rotatePixels2[i][j].getRed();
        int green = rotatePixels2[i][j].getGreen();
        int blue = rotatePixels2[i][j].getBlue();

        relativeNegativeRotatedPixels[totalCols - 1 - j][i].setRed(red);
        relativeNegativeRotatedPixels[totalCols - 1 - j][i].setGreen(green);
        relativeNegativeRotatedPixels[totalCols - 1 - j][i].setBlue(blue);


      }
    }
    relativeNegativeRotatedPicture.show();
    /* to be implemented */


    // Final Image: Add a small image to a larger one

    Picture largePicture = new Picture(pictureFile);
    Picture smallPicture = new Picture(smallPictureFile);
    Picture finalPicture = new Picture(totalRows, totalCols);
    Pixel[][] largePixels = largePicture.getPixels2D();
    Pixel[][] smallPixels = smallPicture.getPixels2D();
    int totalSmallRows = smallPixels.length;
    int totalSmallCols = smallPixels[0].length;
    Pixel[][] finalPixels = finalPicture.getPixels2D();
    /* to be implemented */
    for(int i = 0; i < totalRows; i++){
      for(int j = 0; j < totalCols; j++){
        finalPixels[i][j].setColor(largePixels[i][j].getColor());
      }
    }
    for(int i = 0; i < totalSmallRows; i++){
      for(int j = 0; j < totalSmallCols; j++){
        finalPixels[i][j].setColor(smallPixels[i][j].getColor());
      }
    }
    finalPicture.show();


    // for testing  2D algorithms
    int[][] test1 = { { 1, 2, 3, 4 },
        { 5, 6, 7, 8 },
        { 9, 10, 11, 12 },
        { 13, 14, 15, 16 } };
    int[][] test2 = new int[4][4];


  }
}

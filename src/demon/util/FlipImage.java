package demon.util;

import java.awt.*;
import java.awt.image.BufferedImage;

/*
 * GenMo demon.util
 * @Author:Demon
 * @Date:2021/12/27 9:13
 * @Description:
 */
public abstract class FlipImage
{
    public static BufferedImage flipImage(Image image)
    {
        BufferedImage bufferedimage = toBufferedImage(image);;
        int imageWidth = bufferedimage.getWidth();
        int imageHeight = bufferedimage.getHeight();

        BufferedImage img;
        Graphics2D graphics2d = null;

        try
        {
            (graphics2d = (img = new BufferedImage(imageWidth, imageHeight, bufferedimage
                    .getColorModel().getTransparency())).createGraphics())
                    .drawImage(bufferedimage, 0, 0, imageWidth, imageHeight, imageWidth, 0, 0, imageHeight, null);
        } catch (Exception e)
        {
            throw e;
        } finally
        {
            graphics2d.dispose();
        }
        return img;
    }

    public static BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }
        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        // Return the buffered image
        return bimage;
    }
}

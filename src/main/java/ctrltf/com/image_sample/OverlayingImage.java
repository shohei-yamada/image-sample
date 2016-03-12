package ctrltf.com.image_sample;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 画像を重ねる。
 *
 */
public class OverlayingImage 
{
	public static void main( String[] args )
	{
		try {
			BufferedImage img = createImageBgWhite();
			BufferedImage img2 = ImageIO.read(new File("in/neko.jpg"));
			Graphics2D gr = img.createGraphics();
			gr.setComposite(
					AlphaComposite.getInstance(AlphaComposite.SRC_OVER)
					);
			gr.drawImage(img2,0, 15, null);
			gr.dispose();
			ImageIO.write(img, "jpg", new File("out/result.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static BufferedImage createImageBgWhite() throws IOException {
		int width = 100;
		int height = 100;
		BufferedImage im = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g = im.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, im.getWidth(), im.getHeight());
		im.flush();
		return im;
	}
}

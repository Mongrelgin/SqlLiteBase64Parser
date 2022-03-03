import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Base64ToPhoto {
    public void base64Parsing(List<Photo> base64Photos) throws IOException {
        for (Photo photo : base64Photos) {
            BufferedImage image;
            byte[] imageByte;
            BASE64Decoder decoder = new BASE64Decoder();
            String[] mass = photo.getBase64Photo().split(",");
            imageByte = decoder.decodeBuffer(mass[1]);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();
            File outputfile = new File("C://Users//mongr//Desktop//Work//Sportsoft//DBPHOTOS//" + photo.getPersonId() + ".png");
            ImageIO.write(image, "png", outputfile);
        }
    }
}

package Futronic.service;

import Futronic.openFinger.WrapperOuterClass;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Service
public class ConvertingService {

    public WrapperOuterClass.Wrapper parser (Socket clientSocket) throws IOException, InterruptedException{
        InputStream is = clientSocket.getInputStream();
        DataInputStream ds = new DataInputStream(is);
        byte[] buffer = new byte[100];
        int a;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int b = 0;
        WrapperOuterClass.Wrapper response;
        do{
            a = ds.read(buffer);
            output.write(buffer,0,a);
            b = b + a;
            byte[] out = output.toByteArray();
            try {
                response = WrapperOuterClass.Wrapper.parseFrom(out);
                break;
            }catch(Exception e){
            }
        }while(true);

        return response;
    }
    public BufferedImage invertimage(BufferedImage image1) {
        for (int y = 0; y < image1.getHeight(); y++) {
            for (int x = 0; x < image1.getWidth(); x++) {
                int p = image1.getRGB(x, y);
                int a = (p >> 24) & 0xff;
                int r = (p >> 16) & 0xff;
                int g = (p >> 8) & 0xff;
                int b = p & 0xff;
                //subtract RGB from 255
                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                //set new RGB value
                p = (a << 24) | (r << 16) | (g << 8) | b;
                image1.setRGB(x, y, p);
            }
        }
        return image1;
    }


}

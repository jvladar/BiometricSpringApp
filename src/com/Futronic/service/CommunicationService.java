package Futronic.service;

import Futronic.openFinger.WrapperOuterClass;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

@Service
public class CommunicationService {

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

}

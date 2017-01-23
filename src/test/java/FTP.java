import com.miri.blephone.mediainjector.uitls.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class FTP {

    public static void main(String[] args) {

        String url = "ftp://gdydott:mangguo123@183.235.21.141/asset/adi/2017/1/3/10/E1058313-regist.xml";

        String outputDir = "D:/2";
        try {
            String s = FtpUtils.downloadFile(url, outputDir);

            System.out.print(s);
        }
        catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
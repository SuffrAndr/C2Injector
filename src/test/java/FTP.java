import java.io.IOException;
import java.net.URISyntaxException;

public class FTP {

    public static void main(String[] args) {

        String url = "ftp://ftper:ftper@183.235.11.104:2121/adi/resp_dc35107b6fdd4e5aa926211632bb6ff4_1467563494691.xml";

        String outputDir = "D:/2";
        try {
            com.miri.blephone.mediainjector.uitls.FtpUtils.downloadFile(url, outputDir);
        }
        catch (IOException | URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
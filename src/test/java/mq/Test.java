package mq;

public class Test {

    public static void main(final String[] args) {

        final String urlPrefix = "ftp://ftper:ftper@183.235.11.104:2121/aa";

        final String fileNmae = "adi/resp_dc35107b6fdd4e5aa926211632bb6ff4_1467563494691.xml";
        final String url = com.miri.blephone.mediainjector.uitls.UrlUtils.getUrl(urlPrefix, fileNmae);

        System.out.println(url);

    }
}

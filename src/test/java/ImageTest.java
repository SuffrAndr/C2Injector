import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;

import com.miri.blephone.mediainjector.uitls.UrlUtils;

public class ImageTest {
    public static void main(final String[] args) {

        try (final CloseableHttpClient httpclient = HttpClients.custom()
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, false)).build();) {

            final String httpPrfix = "http://116.255.245.161:50500/";

            final String imageFilename = "/Image/2016/03/0301/16/0dfc8d170a29471b9fab5e50e56a60c7.jpg";

            final String storePath = "D:/img";
            final HttpGet httpGet = new HttpGet(UrlUtils.getUrl(httpPrfix, imageFilename));

            final HttpResponse rsp = httpclient.execute(httpGet);

            if (rsp.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {

                InputStream input = null;
                FileOutputStream output = null;
                try {

                    input = rsp.getEntity().getContent();

                    final String fileName = UrlUtils.getFileName(imageFilename);
                    final String dir = FilenameUtils.getFullPath(fileName);

                    final File file = new File(storePath, dir);

                    if (!file.exists()) {
                        file.mkdirs();
                    }

                    final File tempFile = new File(file, FilenameUtils.getName(fileName));

                    if (!tempFile.exists()) {
                        tempFile.createNewFile();
                    }

                    output = new FileOutputStream(tempFile);

                    IOUtils.copy(input, output);
                    output.flush();
                }
                catch (final Exception e) {
                }
                finally {
                    IOUtils.closeQuietly(output);
                    IOUtils.closeQuietly(input);
                }
            }
        }
        catch (final Exception e) {
        }
    }
}

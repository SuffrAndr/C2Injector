package com.miri.blephone.mediainjector.uitls;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.joda.time.DateTime;

public final class FtpUtils {

    public static String downloadFile(final String url, String outputDir) throws IOException, URISyntaxException {

        FTPClient ftp = new FTPClient();
        FileOutputStream fos = null;
        try {

            java.net.URI uri = new java.net.URI(url);

            String rawUserInfo = uri.getRawUserInfo();
            String[] splits = StringUtils.split(rawUserInfo, ':');
            String username = splits[0];
            String password = splits[1];

            String host = uri.getHost();
            int port = uri.getPort();
            String path = uri.getPath();

            int reply;
            ftp.connect(host, port);
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
            }

            String filename = FilenameUtils.getName(path);

            String filePath = FtpUtils.createFile(filename, outputDir);

            fos = new FileOutputStream(filePath);

            ftp.enterLocalPassiveMode();
            ftp.setAutodetectUTF8(true);
            ftp.setFileType(FTP.BINARY_FILE_TYPE);

            boolean retrieveFileFlag = ftp.retrieveFile(path, fos);

            ftp.logout();

            if (!retrieveFileFlag) {
                throw new IOException("Get file fail.");
            }

            return filePath;
        }
        finally {

            IOUtils.closeQuietly(fos);

            if (ftp.isConnected()) {
                ftp.disconnect();
            }

        }
    }

    protected static String createFile(final String fileName, String outputDir) throws IOException {

        final DateTime dateTime = new DateTime();

        final String dirPath = String.format("%s/%s/%s/%s", dateTime.getYear(), dateTime.getMonthOfYear(),
                dateTime.getDayOfMonth(), dateTime.getHourOfDay());

        final File dirPathFile = new File(outputDir, dirPath);

        if (!dirPathFile.exists()) {
            dirPathFile.mkdirs();
        }

        final File file = new File(dirPathFile, fileName);

        if (!file.exists()) {
            file.createNewFile();
        }

        return file.getCanonicalPath();
    }

    public static String getFtpPath(String ftpPrifx) throws URISyntaxException {
        URI uri = new URI(ftpPrifx);
        return uri.getPath();
    }
}

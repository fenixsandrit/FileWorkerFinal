package com.company;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;

public class Md5Executor implements IExecutable {

    Md5Executor()throws IOException {

    }
    @Override
    public String process(File f) {
        StringBuffer result = new StringBuffer(f.getName());
        var md5 = getMd5OfFile(f);
        result.append(" ");
        result.append(md5);
        //System.out.println(f.getAbsoluteFile() + " " + result);
        return result.toString();
    }
    private static String getMd5OfFile(File f) {
        String returnVal = "";
        try {
            InputStream input = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            MessageDigest md5Hash = MessageDigest.getInstance("MD5");
            int numRead = 0;
            while (numRead != -1) {
                numRead = input.read(buffer);
                if (numRead > 0)
                    md5Hash.update(buffer, 0, numRead);
            }
            input.close();

            byte[] md5Bytes = md5Hash.digest();
            for (int i = 0; i < md5Bytes.length; i++)
                returnVal += Integer.toString((md5Bytes[i] & 0xff) + 0x100, 16).substring(1);

        } catch (Throwable t) {
            t.printStackTrace();
        }

        return returnVal.toUpperCase();
    }
}

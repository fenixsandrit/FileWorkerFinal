package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyExecutor implements IExecutable {

    public CopyExecutor() throws IOException {
    }
    @Override
    public String process(File f)throws IOException {

        StringBuffer result = new StringBuffer(f.getName());
        var newFile = new File(f.getParentFile().getPath() + "//" +
                f.getName().substring(0, f.getName().lastIndexOf('.'))
                + "_copy." + getFileExtension(f));

        newFile.createNewFile();
        try (FileInputStream fin = new FileInputStream(f);
             FileOutputStream fos = new FileOutputStream(newFile)) {
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, buffer.length);
            fos.write(buffer, 0, buffer.length);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        result.append(" " + newFile.getName());
        //System.out.println(f.getAbsoluteFile() + " " + newFile.getAbsoluteFile());
        return result.toString();
    }
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}

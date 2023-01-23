package com.company;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HTMLResulter extends Resulter {

    HTMLResulter(FileWorker fileworker) {
        super(fileworker);
    }

    @Override
    public void ShowResult() {
        var resultFile = new File(fileworker.getPath() + "\\"  + "HtmlResult.html");
        var queue = fileworker.getResult();
        var resultText = new StringBuffer("<html>\n" +
                " <head>\n" +
                "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
                "  <title>Моя первая веб-страница</title>\n" +
                " </head>\n" +
                " <body>\n" +
                "\n" +
                "  <h1>Html_Result</h1>\n" +
                "  <p>");

        resultText.append(queue.peek() + "<br>");

        var sufix = "</p>\n" +
                "\n" +
                " </body>\n" +
                "</html>";

        try (var out = new FileOutputStream(resultFile)) {
            out.write((resultText.toString() + sufix).getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            Desktop.getDesktop().browse(resultFile.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

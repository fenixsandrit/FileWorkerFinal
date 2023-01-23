package com.company;
import java.io.File;
import java.io.IOException;

public interface IExecutable {
    String process(File f) throws IOException;
}

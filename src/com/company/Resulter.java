package com.company;

import java.io.IOException;

abstract public class Resulter {

    protected FileWorker fileworker;

    Resulter(FileWorker fileworker){
        this.fileworker = fileworker;
    }

    public void ShowResult(){};

    public void execute(IExecutable executor) throws IOException {
        fileworker.execute(executor);
    }
}

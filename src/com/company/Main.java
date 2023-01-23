package com.company;

import com.company.Commands.FileCommandFactory;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        var fileWorker = new FileWorker("C:\\test");
        var consoleResulter = new ConsoleRusulter(fileWorker);
        var htlmResulter = new HTMLResulter(fileWorker);
        fileWorker.setisRecursive(false);
        var fileCommandFactory = new FileCommandFactory(fileWorker);
        CommandQueue.addCommand(fileCommandFactory.instanceCommand(new CopyExecutor()));
        CommandQueue.addCommand(fileCommandFactory.instanceCommand(new Md5Executor()));

        for (var  i: CommandQueue.getIter()){
            i.execute();
            consoleResulter.ShowResult();
            htlmResulter.ShowResult();
        }
    }
}

package com.company;

import com.company.Commands.FileCommandFactory;
import com.company.Commands.ICommand;
import com.company.executors.CopyExecutor;
import com.company.executors.Md5Executor;
import com.company.resulters.ConsoleResulter;
import com.company.resulters.HTMLResulter;
import com.company.resulters.Resulter;

import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        FileWorker fileWorker = new FileWorker("/home/iyumagulov/test/test.txt");
        fileWorker.setIsRecursive(false);

        Resulter consoleResulter = new ConsoleResulter(fileWorker);
        //Resulter htlmResulter = new HTMLResulter(fileWorker);


        FileCommandFactory fileCommandFactory = new FileCommandFactory(fileWorker);
        CommandQueue.addCommand(fileCommandFactory.instanceCommand(new CopyExecutor()));
        CommandQueue.addCommand(fileCommandFactory.instanceCommand(new Md5Executor()));

        for (ICommand command: CommandQueue.getIterator())
        {
            command.execute();
            consoleResulter.showResult();
            //htlmResulter.showResult();
        }
    }
}

package com.company.resulters;

import com.company.Commands.ICommand;
import com.company.FileWorker;
import com.company.executors.IExecutable;

import java.util.ArrayDeque;

public class ConsoleResulter extends Resulter
{
    public ConsoleResulter(FileWorker fileworker)
    {
        super(fileworker);
    }
    @Override
    public void showResult()
    {
        System.out.println("ConsoleResulter:\n" + fileworker.getResult());
    }

    public static class FileCommand implements ICommand {

        private FileWorker fileWorker;
        private IExecutable executor;
        @Override
        public void execute(){
            fileWorker.execute(executor);
        }
        public FileCommand(FileWorker fileworker,IExecutable executor){
            this.fileWorker = fileworker;
            this.executor = executor;
        }


    }
}

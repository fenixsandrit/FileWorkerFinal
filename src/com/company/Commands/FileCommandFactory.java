package com.company.Commands;

import com.company.FileWorker;
import com.company.executors.IExecutable;

public class FileCommandFactory implements CommandFactory
{
    private FileWorker fileworker;
    public FileCommandFactory(FileWorker fileworker)
    {
        this.fileworker = fileworker;
    }
    @Override
    public ICommand instanceCommand(IExecutable executor)
    {
        return new FileCommand(fileworker, executor);
    }
}

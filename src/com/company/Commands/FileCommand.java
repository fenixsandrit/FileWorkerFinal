package com.company.Commands;

import com.company.FileWorker;
import com.company.executors.IExecutable;

public class FileCommand implements ICommand
{
    private FileWorker fileWorker;
    private IExecutable executor;

    public FileCommand(FileWorker fileWorker, IExecutable executor)
    {
        this.fileWorker = fileWorker;
        this.executor = executor;
    }

    @Override
    public void execute()
    {
        fileWorker.execute(executor);
    }
}

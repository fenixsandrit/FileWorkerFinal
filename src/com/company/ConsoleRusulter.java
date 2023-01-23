package com.company;

import com.company.Commands.ICommand;

import java.util.ArrayDeque;

public class ConsoleRusulter extends Resulter {
    ConsoleRusulter(FileWorker fileworker) {
        super(fileworker);
    }
    @Override
    public void ShowResult() {
        var result = fileworker.getResult();
        var copy = new ArrayDeque<String>();
        System.out.print("ConsoleResulter:\n");
        System.out.print(result.peek() );
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

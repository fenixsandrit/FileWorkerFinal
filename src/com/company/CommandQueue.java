package com.company;

import com.company.Commands.ICommand;

import java.util.ArrayDeque;

public class CommandQueue {
    private static ArrayDeque<ICommand> commandHistory = new ArrayDeque<>();


    public static void addCommand(ICommand command){
        commandHistory.offer(command);
    }

    public static Iterable<ICommand> getIter(){
        return commandHistory;
    }

    public static ICommand popCommand(){
        if (commandHistory.size() != 0)
            return commandHistory.poll();
        else return null;
    }
}

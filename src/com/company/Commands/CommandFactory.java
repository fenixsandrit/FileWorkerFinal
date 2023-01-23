package com.company.Commands;

import com.company.executors.IExecutable;

public interface CommandFactory {
    ICommand instanceCommand(IExecutable executor);
}

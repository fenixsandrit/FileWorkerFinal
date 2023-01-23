package com.company.Commands;

import com.company.IExecutable;

public interface CommandFactory {
    ICommand instanceCommand(IExecutable executor);
}

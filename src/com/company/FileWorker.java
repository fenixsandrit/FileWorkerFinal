package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Stack;

public class FileWorker {

    private boolean isRecursive;

    private String path;

    private StringBuffer strResult;

    //private ArrayDeque<String> result;

    private Stack<String> result;

    public void setisRecursive(boolean recursive){ isRecursive = recursive; }

    public boolean getisRecursive(){return isRecursive;}
    public String getPath(){ return path;}

    FileWorker(String path){
        this.result = new Stack<String>();
        this.path = path;
        this.strResult = new StringBuffer();
    }
    public Stack<String> getResult(){
        return result;
    }

    public void execute(IExecutable executor){
        if(!strResult.isEmpty()) {
            strResult.delete(0,strResult.length());
        }
        try {
            if(isRecursive)recursiveProcessing(executor);
            else simpleProcessing(executor);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        //result.offer(strResult.toString());
        result.push(strResult.toString());
    }

    private void simpleProcessing(IExecutable executor)throws IOException {
        for(var f: Objects.requireNonNull(new File(path).listFiles())){
            if(!f.isDirectory()){
                //result.offer(executor.process(f));
                strResult.append(executor.process(f)+'\n');
            }

        }
    }

    private void recursiveProcessing(IExecutable executor)throws IOException{
        for(var f: Objects.requireNonNull(new File(path).listFiles())){
            if (f.isDirectory())
                recursiveProcessing(executor);
            else strResult.append(executor.process(f)+'\n');
        }
    }
}

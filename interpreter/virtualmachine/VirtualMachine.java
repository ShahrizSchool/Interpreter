package interpreter.virtualmachine;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.DumpCode;
import interpreter.bytecode.ReadCode;

import java.util.Stack;
import java.util.Scanner;

public class VirtualMachine {

    private RunTimeStack   runTimeStack;
    private Stack<Integer> returnAddress;
    private Program        program;
    private int            programCounter;
    private boolean        isRunning;
    private boolean dumper;

    public VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        programCounter = 0;
        runTimeStack = new RunTimeStack();
        returnAddress = new Stack<>();
        isRunning = true;
        dumper = false;

        while(isRunning){
            ByteCode bc = program.getCode(programCounter);

            bc.execute(this);

            if(dumper){
                if(!(bc instanceof DumpCode)){
                    System.out.println(bc);
                    runTimeStack.dump();
                }
            }
            programCounter++;
        }
    }


    public void setIsRunning(boolean bol){
        isRunning = bol;
    }

    public int popRunTimeStack(){
        return runTimeStack.pop();
    }

    public int getProgramCounterC(){
        return this.programCounter;
    }

    public void setProgramCounter(int pc){
        this.programCounter = pc;
    }

    public int StoreRunTimeStack(int offset){
        return runTimeStack.store(offset);
    }

    public int loadRunTimeStack(int offset){
        return runTimeStack.load(offset);
    }

    public Integer pushRunTimeStack(Integer value){
        return runTimeStack.push(value);
    }

    public void popFrameRunTimeStack(){
        runTimeStack.popFrame();
    }

    public void newFrameRunTimeStack(int offset){
        runTimeStack.newFrameAt(offset);
    }

    public void pushReturnAddress(int address){
        this.returnAddress.push(address);
    }

    public int popReturnAddress(){
        return (int) this.returnAddress.pop();
    }

    public String peekFrameRunTimeStack(){
        return runTimeStack.peekFrame();
    }

    public int peekRunTimeStack(){
        return runTimeStack.peek();
    }

    public void setDumpState(boolean dumper){
        dumper = dumper;
    }

}

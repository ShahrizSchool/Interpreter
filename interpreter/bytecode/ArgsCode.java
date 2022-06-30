package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode{

    private int framePush;
    @Override
    public void init(ArrayList<String> args) {
        framePush = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.newFrameRunTimeStack(framePush);
    }

    @Override
    public String print() {
        return ("ArgsCode " + framePush);
    }
}

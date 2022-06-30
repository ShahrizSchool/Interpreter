package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class PopCode extends ByteCode{

    private int PopCodeValue;
    @Override
    public void init(ArrayList<String> args) {
        PopCodeValue = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine vm) {
        for(int i = 1; i<= PopCodeValue; i++){
            vm.popRunTimeStack();
        }
    }

    @Override
    public String print() {
        return ("PopCode " + PopCodeValue);
    }
}

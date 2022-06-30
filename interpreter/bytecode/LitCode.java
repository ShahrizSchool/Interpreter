package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode{
    private int value;
    private String id;
    @Override
    public void init(ArrayList<String> args) {
        value = Integer.parseInt(args.get(0));
        if(args.size() > 1){
            id = args.get(1);
        }
    }

    @Override
    public void execute(VirtualMachine vm) {
        vm.pushRunTimeStack(value);
    }

    @Override
    public String print() {
        String base = "LIT" + value;
        if(id != null){
            base += (" int " + id);
        }
        return base;
    }
}

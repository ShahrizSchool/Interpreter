package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode{
    private String dumpCode;
    @Override
    public void init(ArrayList<String> args) {
        dumpCode = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        if(dumpCode.compareToIgnoreCase("ON") == 0){
            vm.setDumpState(true);
        }
        else{
            vm.setDumpState(false);
        }
    }
}

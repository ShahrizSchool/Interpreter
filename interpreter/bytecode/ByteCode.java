package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;
import java.util.ArrayList;
public abstract class ByteCode{
    public abstract void init(ArrayList<String> args);
    public abstract void execute(VirtualMachine vm);

    public String print(){
        return "";
    }

    public boolean getResolvedAddress(){

        return false;
    }
}


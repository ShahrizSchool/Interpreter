package interpreter.bytecode;

public abstract class BranchCode extends ByteCode{
    public abstract int getTargetAddress();
    public abstract void setTargetAddress(int n);
    public abstract String getLabel();
}

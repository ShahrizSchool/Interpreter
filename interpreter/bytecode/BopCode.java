package interpreter.bytecode;

import interpreter.virtualmachine.VirtualMachine;

import java.util.ArrayList;

public class BopCode extends ByteCode{
    private int valueOne, valueTwo;
    private String eval;
    @Override
    public void init(ArrayList<String> args) {
        eval = args.get(0);
    }

    @Override
    public void execute(VirtualMachine vm) {
        valueOne = vm.popRunTimeStack();
        valueTwo = vm.popRunTimeStack();

        switch (eval){
            case "+":
                vm.pushRunTimeStack(valueOne + valueTwo);
                break;
            case "-":
                vm.pushRunTimeStack(valueOne - valueTwo);
                break;
            case "*":
                vm.pushRunTimeStack(valueOne * valueTwo);
                break;
            case "/":
                vm.pushRunTimeStack(valueOne / valueTwo);
                break;
            case "==":
                if(valueTwo == valueOne){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case "!=":
                if(valueTwo == valueOne){
                    vm.pushRunTimeStack(0);
                }
                else{
                    vm.pushRunTimeStack(1);
                }
                break;
            case "<=":
                if(valueOne <= valueTwo){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case ">":
                if(valueOne > valueTwo){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case ">=":
                if(valueOne == valueTwo){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case "<":
                if(valueOne < valueTwo){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case "|":
                if((valueOne + valueTwo) > 0){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
            case "&":
                if(((valueOne + valueTwo) == 0 || ((valueOne + valueTwo) == 2))){
                    vm.pushRunTimeStack(1);
                }
                else {
                    vm.pushRunTimeStack(0);
                }
                break;
        }
    }

    @Override
    public String print() {
        return ("BopCode " + eval);
    }
}

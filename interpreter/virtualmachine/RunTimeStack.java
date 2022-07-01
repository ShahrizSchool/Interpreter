package interpreter.virtualmachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.*;

class RunTimeStack {

    private List<Integer>  runTimeStack;
    private Stack<Integer> framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }

//    public static void main(String[] args){
//        RunTimeStack rs = new RunTimeStack();
//
//        rs.push(1);
//        rs.push(2);
//        rs.push(3);
//        rs.push(4);
//
//        rs.runTimeStack.forEach(val -> System.out.println(val));
//        rs.push(10);
//        System.out.println(rs.peek());
//
//        rs.push(100);
//        System.out.println(rs.peek());
//
//        rs.pop();
//        System.out.println(rs.peek());
//        System.out.println("\n\n");
//        rs.runTimeStack.forEach(val -> System.out.println(val));
//
//        for(int val: rs.runTimeStack){
//            System.out.println(val);
//        }
//
//        for(int i = 0; i < rs.runTimeStack.size(); i++){
//            System.out.println(rs.runTimeStack.get(i));
//        }
//
//    }

    public int peek() {
        return this.runTimeStack.get(this.runTimeStack.size()-1);
    }
    public int pop(){
        int popValue = peek();

        if(!runTimeStack.isEmpty() && (runTimeStack.size() > framePointer.peek())){
            runTimeStack.remove(runTimeStack.size() -1);
        }
        else {
            return 0;
        }
        return popValue;
    }

    public int store(int offset){
        int val = (int) runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek() + offset, val);
        return val;
    }

    public int load(int offset){
        int val = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(val);
        return val;
    }

    public int push(int value){
        if(runTimeStack.isEmpty()){
            runTimeStack.add(0, value);
        }
        else {
            runTimeStack.add((runTimeStack.size()), value);
        }

        return value;
    }

    public void popFrame(){
        int imp = (int) runTimeStack.remove(runTimeStack.size()-1);
        int amp = framePointer.peek();
        while(runTimeStack.size() >= amp){
            runTimeStack.remove(runTimeStack.size()-1);
        }
        framePointer.pop();
        runTimeStack.add(imp);
    }

    public String peekFrame(){
        String frameVal = "";

        for (int i = framePointer.peek(); i<= (runTimeStack.size() - 1); i++){
            frameVal = (frameVal + runTimeStack.get(1));
            if(i != (runTimeStack.size() - 1)){
                frameVal = frameVal + ",";
            }
        }
        return frameVal;
    }

    public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size() - offset);
    }

    public void dump() {

        System.out.println("[");

        ArrayList<Integer> arrList = new ArrayList<>();

        if (!runTimeStack.isEmpty()) {
            for (int i = 0; i < framePointer.size(); i++) {
                if (framePointer.get(i) > 0) {
                    arrList.add(framePointer.get(i));
                }
            }
        }

        boolean comma = true;

        int sizeOfStack = runTimeStack.size();

        for (int i = 0; i < sizeOfStack; i++) {
            int imp = 0;
            if (arrList.get(imp) == i) {
                System.out.println("] [");
            } else if (arrList.get(imp) == i + 1) {
                comma = false;
            }
            System.out.println(runTimeStack.get(i));

            if (!runTimeStack.isEmpty() && sizeOfStack != i + 1) {
                if (!comma) {
                    comma = true;
                } else {
                    System.out.println(",");
                }

            }
        }
        System.out.println("]");
    }
}

package org.example.ThreadSequence3;

public class SequenceGenerator implements Runnable{

    private NumberGenerator numberGenerator;
    private int modVal;

    public SequenceGenerator(NumberGenerator numberGenerator, int modVal) {
        this.numberGenerator = numberGenerator;
        this.modVal = modVal;
    }

    @Override
    public void run() {
        numberGenerator.printNumbers(modVal);
    }
}

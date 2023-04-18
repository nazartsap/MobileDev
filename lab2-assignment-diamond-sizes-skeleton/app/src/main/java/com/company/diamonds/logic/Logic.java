package com.company.diamonds.logic;

import com.company.diamonds.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early
 * Android interactions.  Designing the assignments this way allows
 * you to first learn key 'Java' features without having to beforehand
 * learn the complexities of Android.
 */
public class Logic
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG = Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface [MainActivity.java].
     * <p>
     * It is called 'out' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'out' is good enough).
     */
    private OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance (which
     * implements [OutputInterface]) to 'out'.
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labeled 'Process...' is pressed.
     */
    public void process(int size) { // size определяет размер ромба
        //вертикальная ось row
        for (int row = -size; row <= size; row++) {
            //горизонтальная ось col
            for (int col = -size - 1; col <= size + 1; col++) {
                if (col == 0) { //Если это нуль, происходит переход к следующей итерации цикла.
                    continue;
                }
                if (Math.abs(col) == size + 1) {
                    if (Math.abs(row) == size) {
                        mOut.print("+");
                    } else {
                        mOut.print("|");
                    }
                    // середина ромба
                } else if (row == 0 && Math.abs(col) == size) {
                    if(col == -size)
                        mOut.print("<");
                    else
                        mOut.print(">");
                    // внутри ромба если координата точки принадлежит внутренней области ромба, выводится символ "=", если значение (size - row) нечетно "-".
                } else if (Math.abs(row) + Math.abs(col) < size) {
                    if((size - row) % 2 != 0)
                        mOut.print("=");
                    else
                        mOut.print("-");
                    // границы ромба
                } else if (Math.abs(row - col) == size) {
                    mOut.print("\\");
                } else if (Math.abs(row + col) == size) {
                    mOut.print("/");
                    //нижняя и верхняя границы ромба
                } else if (Math.abs(row) == size) {
                    mOut.print("-");
                } else {
                    mOut.print(" ");
                }
            }
            mOut.println(""); // перенос строки
        }
    }
}


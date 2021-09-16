package com.example.mycalculator;

public class CalculateLogic {

    StringBuilder stringBuilder = new StringBuilder();

    private double firstArg;
    private double secondArg;
    private char symbolOperation;
    private State state;

    public CalculateLogic() {
        state = State.FIRST_NUMBER;
    }

    private enum State {
        FIRST_NUMBER,
        OPERATION,
        SECOND_NUMBER,
        EQUALS
    }

    public void numberClick(int buttonId) {
        if (stringBuilder.length() < 9) {

            if (state == State.EQUALS) {
                stringBuilder.setLength(0);
                state = State.FIRST_NUMBER;
            }

            if (state == State.OPERATION) {
                stringBuilder.setLength(0);
                state = State.SECOND_NUMBER;
            }
            switch (buttonId) {
                case R.id.btn_one:
                    stringBuilder.append("1");
                    break;
                case R.id.btn_two:
                    stringBuilder.append("2");
                    break;
                case R.id.btn_three:
                    stringBuilder.append("3");
                    break;
                case R.id.btn_four:
                    stringBuilder.append("4");
                    break;
                case R.id.btn_five:
                    stringBuilder.append("5");
                    break;
                case R.id.btn_six:
                    stringBuilder.append("6");
                    break;
                case R.id.btn_seven:
                    stringBuilder.append("7");
                    break;
                case R.id.btn_eight:
                    stringBuilder.append("8");
                    break;
                case R.id.btn_nine:
                    stringBuilder.append("9");
                    break;
                case R.id.btn_zero:
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("0");
                    }
                    return;
            }
            if (state == State.FIRST_NUMBER) {
                firstArg = Double.parseDouble(stringBuilder.toString());
            } else if (state == State.SECOND_NUMBER) {
                secondArg = Double.parseDouble(stringBuilder.toString());
            }
        }
    }

    public void operationClick(int buttonId) {
        if (state == State.FIRST_NUMBER || state == State.EQUALS) {
            state = State.OPERATION;
            switch (buttonId) {
                case R.id.btn_plus:
                    symbolOperation = '+';
                    break;
                case R.id.btn_minus:
                    symbolOperation = '-';
                    break;
                case R.id.btn_multiplication:
                    symbolOperation = '*';
                    break;
                case R.id.btn_division:
                    symbolOperation = '/';
                    break;
            }
        }
        if(state == State.SECOND_NUMBER) {
            switch (buttonId) {
                case R.id.btn_equals:
                    equals(firstArg, secondArg);
                    break;
            }
        }
    }

    public void equals(double agrOne, double argTwo) {
        if (firstArg != 0 && symbolOperation != ' ') {
            state = State.EQUALS;
            stringBuilder.setLength(0);
            if (symbolOperation == '+') {
                firstArg = agrOne + argTwo;
            } else if (symbolOperation == '-') {
                firstArg = agrOne - argTwo;
            } else if (symbolOperation == '*') {
                firstArg = agrOne * argTwo;
            } else if (symbolOperation == '/') {
                firstArg = agrOne / argTwo;
            }
        }
        symbolOperation = ' ';
    }

    public void discharge() {
        stringBuilder.setLength(0);
        state = State.FIRST_NUMBER;
    }

    public String getText() {
        switch (state) {
            default:
                return stringBuilder.toString();
            case OPERATION:
                stringBuilder.setLength(0);
                return stringBuilder.append(symbolOperation).toString();
            case EQUALS:
                stringBuilder.setLength(0);
                return stringBuilder.append(firstArg).toString();
        }
    }
}

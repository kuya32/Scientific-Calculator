package com.macode.scientific_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bPi, bPoint, bEquals, bPlus, bMinus, bMultiply, bDivide, bFactorial, bSquared, bSquareRoot, bInverse, bSin, bCos, bTan, bLog, bLn, bAllClear, bEntryClear, bLeftParen, bRightParen;
    private TextView calculation, result;
    private String curr, res;
    private String pi = "3.14159265";
    private boolean dotInserted, operatorInserted, facSqRtInserted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculation = (TextView) findViewById(R.id.calculation);
        result = findViewById(R.id.result);

        curr = "";
        res = "";
        dotInserted = false;
        operatorInserted = false;
        facSqRtInserted = false;

        b0 = (Button) findViewById(R.id.button0);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
        b6 = findViewById(R.id.button6);
        b7 = findViewById(R.id.button7);
        b8 = findViewById(R.id.button8);
        b9 = findViewById(R.id.button9);
        bPi = findViewById(R.id.piButton);
        bPoint = findViewById(R.id.pointButton);
        bEquals = findViewById(R.id.equalsButton);
        bPlus = findViewById(R.id.plusButton);
        bMinus = findViewById(R.id.minusButton);
        bMultiply = findViewById(R.id.multiplyButton);
        bDivide = findViewById(R.id.divideButton);
        bFactorial = findViewById(R.id.factorialButton);
        bSquared = findViewById(R.id.squaredButton);
        bSquareRoot = findViewById(R.id.squareRootButton);
        bInverse = findViewById(R.id.inverseButton);
        bSin = findViewById(R.id.sinButton);
        bCos = findViewById(R.id.cosButton);
        bTan = findViewById(R.id.tanButton);
        bLog = findViewById(R.id.logButton);
        bLn = findViewById(R.id.lnButton);
        bAllClear = findViewById(R.id.allClearButton);
        bEntryClear = findViewById(R.id.clearEntryButton);
        bLeftParen = findViewById(R.id.leftParenButton);
        bRightParen = findViewById(R.id.rightParenButton);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "0";
                displayCalculation();
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "1";
                displayCalculation();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "2";
                displayCalculation();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "3";
                displayCalculation();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "4";
                displayCalculation();
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "5";
                displayCalculation();
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "6";
                displayCalculation();
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "7";
                displayCalculation();
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "8";
                displayCalculation();
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "9";
                displayCalculation();
            }
        });


        bPi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + pi;
                displayCalculation();
            }
        });

        bPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (curr.isEmpty()) {
                    curr = curr + "0.";
                    dotInserted = true;
                } else if (!dotInserted) {
                    curr = curr + ".";
                    dotInserted = true;
                }
                displayCalculation();
            }
        });


        bEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = calculation.getText().toString();
                String replacedStr = val.replace('÷', '/').replace('×', '*');
                double result = eval(replacedStr);
                res = String.valueOf(result);
                displayResult();
            }
        });

        bPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                    }
                    if (facSqRtInserted) {
                        String prevResult = result.getText().toString();
                        curr = prevResult + " + ";
                        displayCalculation();
                    } else {
                        curr = curr + " + ";
                    }
                }
                displayCalculation();
            }
        });

        bMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                    }
                    if (facSqRtInserted) {
                        String prevResult = result.getText().toString();
                        curr = prevResult + " - ";
                        displayCalculation();
                    } else {
                        curr = curr + " - ";
                    }
                }
                displayCalculation();
            }
        });

        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                    }
                    if (facSqRtInserted) {
                        String prevResult = result.getText().toString();
                        curr = prevResult + " × ";
                        displayCalculation();
                    } else {
                        curr = curr + " × ";
                    }
                }
                displayCalculation();
            }
        });

        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                    }
                    if (facSqRtInserted) {
                        String prevResult = result.getText().toString();
                        curr = prevResult + " ÷ ";
                        displayCalculation();
                    } else {
                        curr = curr + " ÷ ";
                    }
                }
                displayCalculation();
            }
        });

        bFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facSqRtInserted = true;
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                        displayCalculation();
                    }
                    if (!operatorInserted) {
                        String preCurr = calculation.getText().toString();
                        curr = curr + "!";
                        displayCalculation();
                        int entry = Integer.parseInt(preCurr);
                        int factorial = factorial(entry);
                        res = String.valueOf(factorial);
                        displayResult();
                    }
                }
            }
        });

        bSquared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facSqRtInserted = true;
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                        displayCalculation();
                    }
                    if (!operatorInserted) {
                        String preCurr = calculation.getText().toString();
                        curr = curr + "²";
                        displayCalculation();
                        int entry = Integer.parseInt(preCurr);
                        int finalResult = entry * entry;
                        res = String.valueOf(finalResult);
                        displayResult();
                    }
                }
            }
        });

        bSquareRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facSqRtInserted = true;
                dotInserted = false;
                if (!curr.isEmpty()) {
                    if (curr.substring(curr.length() - 1).equals(".")) {
                        clearEntry();
                        displayCalculation();
                    }
                    if (!operatorInserted) {
                        String preCurr = calculation.getText().toString();
                        curr = "√" + curr;
                        displayCalculation();
                        int entry = Integer.parseInt(preCurr);
                        double finalResult = Math.sqrt(entry);
                        res = String.valueOf(finalResult);
                        displayResult();
                    }
                }
            }
        });

        bInverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "^(-1)";
                displayCalculation();
            }
        });

        bSin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "sin(";
                displayCalculation();
            }
        });

        bCos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "cos(";
                displayCalculation();
            }
        });

        bTan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "tan(";
                displayCalculation();
            }
        });

        bLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "log(";
                displayCalculation();
            }
        });

        bLn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = "ln(" + curr;
                displayCalculation();
            }
        });

        bAllClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allClear();
                displayCalculation();
                displayResult();
            }
        });

        bEntryClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearEntry();
                displayCalculation();
            }
        });

        bLeftParen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + "(";
                displayCalculation();
            }
        });

        bRightParen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr = curr + ")";
                displayCalculation();
            }
        });
    }

    public void displayCalculation() {
        calculation.setText(curr);
    }

    public void displayResult() {
        result.setText(res);
    }

    public void allClear() {
        curr = "";
        res = "0";
        dotInserted = false;
        operatorInserted = false;
        facSqRtInserted = false;
    }

    public void clearEntry() {
        if (!curr.isEmpty()) {
            if (curr.substring(curr.length() - 1).equals(".")) {
                dotInserted = false;
            }
            if (curr.substring(curr.length() - 1).equals(" ")) {
                curr = curr.substring(0, curr.length() - 3);
                operatorInserted = false;
            } else if (curr.substring(curr.length() - 1).equals("!") || curr.substring(curr.length() - 1).equals("²") || curr.substring(0).equals("√")) {
                curr = curr.substring(0, curr.length() - 1);
                facSqRtInserted = false;
            } else {
                curr = curr.substring(0, curr.length() - 1);
            }
        }
    }

    int factorial(int n) {
        return (n == 1 || n == 0) ? 1 : n*factorial(n - 1);
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if (eat('+')) {
                        x += parseTerm();
                    } else if (eat('-')) {
                        x -= parseTerm();
                    } else {
                        return x;
                    }
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if (eat('*')) {
                        x *= parseFactor();
                    } else if (eat('/')) {
                        x /= parseFactor();
                    } else {
                        return x;
                    }
                }
            }

            double parseFactor() {
                if (eat('+')) {
                    return parseFactor();
                }
                if (eat('-')) {
                    return -parseFactor();
                }

                double x;
                int startPos = this.pos;
                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "sqrt":
                            x = Math.sqrt(x);
                            break;
                        case "sin":
                            x = Math.sin(Math.toRadians(x));
                            break;
                        case "cos":
                            x = Math.cos(Math.toRadians(x));
                            break;
                        case "tan":
                            x = Math.tan(Math.toRadians(x));
                            break;
                        case "log":
                            x = Math.log10(x);
                            break;
                        case "ln":
                            x = Math.log(x);
                            break;
                        default:
                            throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) {
                    x = Math.pow(x, parseFactor());
                }

                return x;
            }
        }.parse();
    }
}
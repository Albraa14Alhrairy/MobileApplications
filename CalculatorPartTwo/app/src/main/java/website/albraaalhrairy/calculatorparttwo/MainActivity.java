package website.albraaalhrairy.calculatorparttwo;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
//import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String res = "";   // carry the top screen
    String n = "";     // carry the bottom screen
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bDiv, bMulti, bSub, bEqual, bPlus, bDot, bRem, bC;  // buttons
    TextView result1;  // view of top screen
    TextView num1;     // view of top screen
    double t;
    double total;
    int h;
    boolean ok;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result1 = findViewById(R.id.result);
        num1 = findViewById(R.id.num);

        //Button Of Num '1'
        b1 = findViewById(R.id.b1);
        b1.setOnClickListener(view -> {
            res += b1.getText().toString();
            n += b1.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '2'
        b2 = findViewById(R.id.b2);
        b2.setOnClickListener(view -> {
            res += b2.getText().toString();
            n += b2.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '3'
        b3 = findViewById(R.id.b3);
        b3.setOnClickListener(view -> {
            res += b3.getText().toString();
            n += b3.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '4'
        b4 = findViewById(R.id.b4);
        b4.setOnClickListener(view -> {
            res += b4.getText().toString();
            n += b4.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '5'
        b5 = findViewById(R.id.b5);
        b5.setOnClickListener(view -> {
            res += b5.getText().toString();
            n += b5.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '6'
        b6 = findViewById(R.id.b6);
        b6.setOnClickListener(view -> {
            res += b6.getText().toString();
            n += b6.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '7'
        b7 = findViewById(R.id.b7);
        b7.setOnClickListener(view -> {
            res += b7.getText().toString();
            n += b7.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '8'
        b8 = findViewById(R.id.b8);
        b8.setOnClickListener(view -> {
            res += b8.getText().toString();
            n += b8.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '9'
        b9 = findViewById(R.id.b9);
        b9.setOnClickListener(view -> {
            res += b9.getText().toString();
            n += b9.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '0'
        b0 = findViewById(R.id.bzero);
        b0.setOnClickListener(view -> {
            res += b0.getText().toString();
            n += b0.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '.'
        bDot = findViewById(R.id.bdot);
        bDot.setOnClickListener(view -> {
            res += bDot.getText().toString();
            n += bDot.getText().toString();
            num1.setText(n);
        });

        //Button Of Num '/'
        bDiv = findViewById(R.id.bdiv);
        bDiv.setOnClickListener(view -> {
            if (((res.isEmpty()) && (!n.isEmpty())) || ((!res.isEmpty()) && (!n.isEmpty()))) {
                res += " " + bDiv.getText().toString() + " ";
                n = "";
                num1.setText("");
                result1.setText(res);
            }
        });

        //Button Of Num '*'
        bMulti = findViewById(R.id.bmult);
        bMulti.setOnClickListener(view -> {
            if (((res.isEmpty()) && (!n.isEmpty())) || ((!res.isEmpty()) && (!n.isEmpty()))) {
                res += " " + bMulti.getText().toString() + " ";
                n = "";
                num1.setText("");
                result1.setText(res);
            }
        });

        //Button Of Num '-'
        bSub = findViewById(R.id.bsub);
        bSub.setOnClickListener(view -> {
            if (((res.isEmpty()) && (!n.isEmpty())) || ((!res.isEmpty()) && (!n.isEmpty()))) {
                res += " " + bSub.getText().toString() + " ";
                n = "";
                num1.setText("");
                result1.setText(res);
            }
        });

        //Button Of Num '+'
        bPlus = findViewById(R.id.bplus);
        bPlus.setOnClickListener(view -> {
            if (((res.isEmpty()) && (!n.isEmpty())) || ((!res.isEmpty()) && (!n.isEmpty()))) {
                res += " " + bPlus.getText().toString() + " ";
                n = "";
                num1.setText("");
                result1.setText(res);
            }
        });

        //Button Of Num 'remove'
        bRem = findViewById(R.id.brem);
        bRem.setOnClickListener(view -> {
            if (!n.isEmpty())
            {
                n = n.substring(0, n.length() - 1);
                res = res.substring(0, res.length() - 1);
                num1.setText(n);
            }
        });

        //Button Of Num 'clear'
        bC = findViewById(R.id.c);
        bC.setOnClickListener(view -> {
            n = "";
            res = "";
            num1.setText("");
            result1.setText("");
        });

        //Button Of Num '='
        bEqual = findViewById(R.id.bequal);
        bEqual.setOnClickListener(view -> {
            result1.setText(res);
            ok = true;
            if (!(res.isEmpty() && n.isEmpty())) {
                String[] nums;
                nums = res.split(" ");
                ArrayList<String> arr = new ArrayList<>();

                arr.add(nums[0]);
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i].equals("*")) {
                        t = Double.parseDouble(nums[i + 1]) * Double.parseDouble(arr.get(arr.size() - 1));
                        arr.remove(arr.size() - 1);
                        arr.add(Double.toString(t));
                        i++;
                    } else if (nums[i].equals("/")) {
                        if (nums[i+1].equals("0")) {
                            num1.setText("MathError\nDivisionByZero");
                            ok = false;
                            break;
                        }
                        else {
                            t = Double.parseDouble(arr.get(arr.size() - 1)) / Double.parseDouble(nums[i + 1]);
                            arr.remove(arr.size() - 1);
                            arr.add(Double.toString(t));
                            i++;
                        }
                    } else {
                        arr.add(nums[i]);
                    }
                }

                total = Double.parseDouble(arr.get(0));
                for (int i = 1; i < arr.size(); i += 2) {
                    if (arr.get(i).equals("+")) {
                        total += Double.parseDouble(arr.get(i + 1));
                    } else {
                        total -= Double.parseDouble(arr.get(i + 1));
                    }
                }

                n = "";
                res = "";
                h = (int) total;
                if(ok){
                    if (total - h != 0)
                        num1.setText("" + total); // show result in double representation
                    else
                        num1.setText("" + h);  // show the result in int representation
                }
            }

        });
    }
}
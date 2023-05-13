package com.example.ai;

import android.annotation.SuppressLint;
//import android.content.Intent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
//import android.widget.Toast;

public class Degrees extends AppCompatActivity {

    EditText deg1, deg2, deg3, deg4, deg5, deg6, hours1, hours2, hours3, hours4, hours5, hours6;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dgrees);

        findViewById(R.id.back3).setOnClickListener(view -> finish());

        findViewById(R.id.calc).setOnClickListener(view -> {
            int[] deg = new int[7];
            int[] hour = new int[7];
            String s;
            int t;
            boolean ok = true;

            deg1 = findViewById(R.id.degsub1);
            if (deg1.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Degree 1 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = deg1.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Degree 1 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    deg[0] = t;
            }

            deg2 = findViewById(R.id.gegsub2);
            if (deg2.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Degree 2 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = deg2.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Degree 2 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    deg[1] = t;
            }

            deg3 = findViewById(R.id.gegsub3);
            if (deg3.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Degree 3 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = deg3.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Degree 3 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    deg[2] = t;
            }

            deg4 = findViewById(R.id.gegsub4);
            if (deg4.getText().toString().isEmpty()) {
                Toast.makeText(this, "Degree 4 is Empty", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            else {
                s = deg4.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    Toast.makeText(this, "Degree 4 contain invalid value", Toast.LENGTH_SHORT).show();
                    ok = false;
                } else
                    deg[3] = t;
            }

            deg5 = findViewById(R.id.gegsub5);
            if (deg5.getText().toString().isEmpty()) {
                Toast.makeText(this, "Degree 5 is Empty", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            else {
                s = deg5.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    Toast.makeText(this, "Degree 5 contain invalid value", Toast.LENGTH_SHORT).show();
                    ok = false;
                } else
                    deg[4] = t;
            }

            deg6 = findViewById(R.id.gegsub6);
            if (deg6.getText().toString().isEmpty()) {
                Toast.makeText(this, "Degree 6 is Empty", Toast.LENGTH_SHORT).show();
                ok = false;
            }
            else {
                s = deg6.getText().toString();
                t = Integer.parseInt(s);
                if (t > 100 || t < 0) {
                    Toast.makeText(this, "Degree 6 contain invalid value", Toast.LENGTH_SHORT).show();
                    ok = false;
                } else
                    deg[5] = t;
            }

            hours1 = findViewById(R.id.hoursub1);
            if (hours1.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 1 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours1.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 1 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[0] = t;
            }

            hours2 = findViewById(R.id.hoursub2);
            if (hours2.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 2 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours2.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 2 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[1] = t;
            }

            hours3 = findViewById(R.id.hoursub3);
            if (hours3.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 3 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours3.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 3 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[2] = t;
            }

            hours4 = findViewById(R.id.hoursub4);
            if (hours4.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 4 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours4.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 4 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[3] = t;
            }

            hours5 = findViewById(R.id.hoursub5);
            if (hours5.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 5 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours5.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 5 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[4] = t;
            }

            hours6 = findViewById(R.id.hoursub6);
            if (hours6.getText().toString().isEmpty()) {
                ok = false;
                Toast.makeText(this, "Hour 6 is Empty", Toast.LENGTH_SHORT).show();
            }
            else {
                s = hours6.getText().toString();
                t = Integer.parseInt(s);
                if (t > 4 || t < 0) {
                    ok = false;
                    Toast.makeText(this, "Hour 6 contain invalid value", Toast.LENGTH_SHORT).show();
                } else
                    hour[5] = t;
            }

            if (ok) {
                double total = 0;
                int h = 0;
                for (int i = 0; i < 6; i++) {
                    if (deg[i] >= 90) {
                        total += 4 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 85) {
                        total += 3.7 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 80) {
                        total += 3.3 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 75) {
                        total += 3 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 70) {
                        total += 2.7 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 65) {
                        total += 2.4 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 60) {
                        total += 2 * hour[i];
                        h += hour[i];
                    }
                    else if (deg[i] >= 50) {
                        total += 1.7 * hour[i];
                        h += hour[i];
                    }
                    else {
                        total += 0;
                        h += hour[i];
                    }
                }

                if(h > 18)
                    Toast.makeText(this, "You entered a sum of hours larger than the limit hours", Toast.LENGTH_SHORT).show();
                else {
                    double gpa = total / h;
                    String grade;
                    if (gpa == 4)
                        grade = "A+";
                    else if (gpa >= 3.7)
                        grade = "A";
                    else if (gpa >= 3.3)
                        grade = "B+";
                    else if (gpa >= 3)
                        grade = "B";
                    else if (gpa >= 2.7)
                        grade = "C+";
                    else if (gpa >= 2.4)
                        grade = "C";
                    else if (gpa >= 2)
                        grade = "D+";
                    else if (gpa >= 1.7)
                        grade = "D";
                    else
                        grade = "Fail";


                    Intent i = new Intent(this, Result.class);
                    i.putExtra("gpa", gpa);
                    i.putExtra("grade", grade);
                    startActivity(i);
                }
            }
        });
    }
}
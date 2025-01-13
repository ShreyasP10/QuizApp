package com.shreyaspawar.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private String[] questions={
            "1. Does Android use the Java programming language?",
            "2. Does Android support the Kotlin programming language?",
            "3. Android app run without an Activity?",
            "4. Is the ConstraintLayout more flexible than the LinearLayout for designing complex UI?",
            "5. Is the findViewById() method used to access views in XML layouts?",
            "6. Is RecyclerView a part of the Android Jetpack library?",
            "7. Can the onCreate() method of an Activity be called multiple times during its lifecycle?",
            "8. Does the onPause() lifecycle method of an Activity always get called before onStop()?",
            "9. You can declare permissions in an Android app without using the AndroidManifest.xml file?",
            "10. Does the Android SDK come with built-in tools for app debugging?",
            "11. Does Android’s NDK (Native Development Kit) allow developers to write code in C or C++?",
            "12. Does Android use the Linux kernel?",
            "13. Is SharedPreferences used to store key-value pairs in Android?",
            "14. Is Intent used to start services in Android?",
            "15. Does Android support multi-window mode using Databse?",
            "16. Is ViewBinding not an alternative to findViewById()?",
            "17. Does Android use Manifest.XML for defining layouts?",
            "18. Is Toast used to display Sensetive Information like Bank Details and Password?",
            "19. Can a ContentProvider be used for inter-process communication in Android?",
            "20. Can RecycleView display items in a grid layout using ConstraintLayout?",

    };
    private boolean answers[]={
            true,true,false,true,true,true,false,true,false,true,true,true,true,true,false,false,false,false,true,false
    };
    private  int index=0;
    private int marks=0;


    Button yes;
    Button no;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        yes=findViewById(R.id.yes);
        no=findViewById(R.id.no);
        textView=findViewById(R.id.textView);
        textView.setText(questions[index]);
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1){
                    if(answers[index]){
                        marks++;
                    }
//                    textView.setText(questions[index++]);
                    index++;
                    if (index<=questions.length-1){
                        textView.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "This is Last Page\n Your Marks is "+marks+"/"+questions.length, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Restart App", Toast.LENGTH_SHORT).show();
                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (index<=questions.length-1){
                    if(!answers[index]){
                        marks++;
                    }
//                    textView.setText(questions[index++]);
                    index++;
                    if (index<=questions.length-1){
                        textView.setText(questions[index]);
                    }else {
                        Toast.makeText(MainActivity.this, "This is Last Page\n Your Marks is "+marks, Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Restart App", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
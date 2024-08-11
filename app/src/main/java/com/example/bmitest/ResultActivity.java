package com.example.bmitest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {

    TextView bmitext, bmidetail, bmititel;
    Button closeButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        bmitext = findViewById(R.id.bmitext);
        bmidetail = findViewById(R.id.bmidetail);
        bmititel = findViewById(R.id.bmititel);
        closeButton = findViewById(R.id.closeButton);

        String age = getIntent().getStringExtra("age");
        String weight = getIntent().getStringExtra("weight");
        String height = getIntent().getStringExtra("height");

        String resultText = "Age: " + age + "\nWeight: " + weight + " kg\nHeight: " + height + " m";
        bmitext.setText(resultText);

        // Convert height to meters (assuming height is passed in centimeters)
        double heightInMeters = Double.parseDouble(height) / 100;

        // Calculate BMI
        double bmi = Double.parseDouble(weight) / (heightInMeters * heightInMeters);

        // Display BMI in the bmitext TextView
        bmitext.setText(String.format("%.2f", bmi));
        Toast.makeText(this, "Your BMI is: " + String.format("%.2f", bmi), Toast.LENGTH_SHORT).show();



        if(bmi < 18.5){
            bmititel.setText("আপনার ওজন কম।");
            bmidetail.setText("এক্ষেত্রে আপনার করণীয় হচ্ছে:\n" +
                    "\n" +
                    "※ পুষ্টিকর খাদ্য গ্রহণ: প্রোটিন, কার্বোহাইড্রেট, স্বাস্থ্যকর চর্বি এবং ভিটামিনযুক্ত খাবার গ্রহণ করুন।\n" +
                    "※ নিয়মিত খাবার গ্রহণ: দিনে তিনবারের পরিবর্তে ছোট ছোট ভাগে ৫-৬ বার খাবার খান।\n" +
                    "※ ক্যালরি যুক্ত পানীয়: দুধ, স্মুদি, প্রোটিন শেক পান করুন।\n" +
                    "※ ব্যায়াম: হালকা ওজন তোলার ব্যায়াম করুন যা পেশী বৃদ্ধি করতে সাহায্য করবে।\n" +
                    "※ ডাক্তার বা পুষ্টিবিদের পরামর্শ নিন: তারা আপনার ওজন বাড়ানোর জন্য একটি সঠিক পরিকল্পনা দিতে পারেন।\n");
        }
        else if(bmi > 18.5 && bmi < 24.9){
            bmititel.setText("আপনার ওজন স্বাভাবিক।");
            bmidetail.setText("এক্ষেত্রে আপনার করণীয় হচ্ছে:\n\n" +
                    "※ সুষম খাদ্য গ্রহণ: আপনার ডায়েটে সুষম পরিমাণে সব ধরনের পুষ্টি রাখুন।\n" +
                    "※ নিয়মিত ব্যায়াম: প্রতিদিন অন্তত ৩০ মিনিটের হালকা ব্যায়াম করুন, যেমন হাঁটা, জগিং, সাইক্লিং।\n" +
                    "※ পর্যাপ্ত ঘুম: প্রতিরাতে ৭-৮ ঘণ্টা ঘুমানোর চেষ্টা করুন।\n" +
                    "※ স্ট্রেস ম্যানেজমেন্ট: যোগব্যায়াম, মেডিটেশন বা শ্বাস-প্রশ্বাসের অনুশীলন করুন।\n" +
                    "※ নিয়মিত স্বাস্থ্য পরীক্ষা: রক্তচাপ, রক্তের চিনি ইত্যাদি পরীক্ষা করুন।\n");
        }
        else if(bmi > 25 && bmi < 29.9){
            bmititel.setText("আপনার ওজন বেশি।");
            bmidetail.setText("এক্ষেত্রে আপনার করণীয় হচ্ছে:\n\n" +
                    "※ কম ক্যালরির খাদ্য গ্রহণ: সবুজ শাকসবজি, ফল, লো-ফ্যাট দুগ্ধজাত দ্রব্য বেশি খান।\n" +
                    "※ নিয়মিত ব্যায়াম: প্রতিদিন অন্তত ৩০-৪৫ মিনিট অ্যারোবিক ব্যায়াম করুন, যেমন দৌড়ানো, সাঁতার কাটা।\n" +
                    "※ পানি পান করুন: প্রতিদিন অন্তত ৮ গ্লাস পানি পান করুন।\n" +
                    "※ খাবার নিয়ন্ত্রণ করুন: খাবারের পরিমাণ নিয়ন্ত্রণ করুন এবং বাইরের তেল ও চর্বিযুক্ত খাবার এড়িয়ে চলুন।\n" +
                    "※ ডাক্তার বা পুষ্টিবিদের পরামর্শ নিন: সঠিক ওজন কমানোর পরিকল্পনা পেতে।\n");
        }
        else{
            bmititel.setText("আপনার স্থূলতা।\n");
            bmidetail.setText("এক্ষেত্রে আপনার করণীয় হচ্ছে:\n\n" +
                    "※ স্বাস্থ্যকর খাদ্য গ্রহণ: সঠিক পুষ্টির মাধ্যমে ক্যালরি নিয়ন্ত্রণ করুন।\n" +
                    "※ নিয়মিত এবং অধিক পরিমাণে ব্যায়াম: প্রতিদিন অন্তত ৬০ মিনিট অ্যারোবিক ও শক্তি বৃদ্ধির ব্যায়াম করুন।\n" +
                    "※ ওজন কমানোর লক্ষ্যমাত্রা ঠিক করুন: বাস্তবসম্মত ওজন কমানোর লক্ষ্যমাত্রা নির্ধারণ করুন।\n" +
                    "※ মানসিক সমর্থন নিন: পরিবারের সদস্য, বন্ধু বা সাপোর্ট গ্রুপ থেকে সমর্থন নিন।\n" +
                    "※ চিকিৎসা পরামর্শ নিন: প্রয়োজন হলে ডাক্তার বা পুষ্টিবিদের পরামর্শ নিন এবং প্রয়োজনে চিকিৎসা গ্রহণ করুন।");
        }



        closeButton.setOnClickListener(view -> {
            finish();
        });

    }




}
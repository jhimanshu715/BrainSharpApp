package com.example.brainsharpbrain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    TextView sumTextView;
    ArrayList<Integer> answers = new ArrayList<>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    TextView scoreTextView;
    int score = 0;
    int numberOfQuestions = 0;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timerTextView;
    TextView txtTime;
    TextView txtScore;
    Button playAgainButton;
    ConstraintLayout gameLayout;
    Button btnAdd;
    TextView txtFinalScore;
    ImageView imgMotivationalShow;

    public void playAgain(View view) {
        score = 0;
        numberOfQuestions = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score)+"/"+Integer.toString(numberOfQuestions));
        newQuestions();
        playAgainButton.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        timerTextView.setVisibility(View.VISIBLE);
        sumTextView.setVisibility(View.VISIBLE);
        txtFinalScore.setVisibility(View.INVISIBLE);
        imgMotivationalShow.setVisibility(View.INVISIBLE);
        txtScore.setVisibility(View.VISIBLE);
        txtTime.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);

        new CountDownTimer(30100,1000) {

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Completed!");
                playAgainButton.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                timerTextView.setVisibility(View.INVISIBLE);
                scoreTextView.setVisibility(View.INVISIBLE);
                sumTextView.setVisibility(View.INVISIBLE);
                txtScore.setVisibility(View.INVISIBLE);
                txtTime.setVisibility(View.INVISIBLE);
                txtFinalScore.setVisibility(View.VISIBLE);
                imgMotivationalShow.setVisibility(View.VISIBLE);
                txtFinalScore.setText("Your Score is "+score+" Out of "+numberOfQuestions);
            }
        }.start();
    }

    public void start(View view) {
        btnAdd.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);

        playAgain(findViewById(R.id.timerTextView));
    }

    public void chooseAnswer(View view)
    {
        if(Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            resultTextView.setText("Correct Answer!");
            score++;
        }
        else{
            resultTextView.setText("Wrong Answer!");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestions();
    }

    public void newQuestions() {
        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);


        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++) {
            if (i == locationOfCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a + b) {
                    wrongAnswer = rand.nextInt(41);
                }

                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            sumTextView = findViewById(R.id.sumTextView);
            button0 = findViewById(R.id.button0);
            button1 = findViewById(R.id.button1);
            button2 = findViewById(R.id.button2);
            button3 = findViewById(R.id.button3);
            resultTextView = findViewById(R.id.resultTextView);
            scoreTextView = findViewById(R.id.scoreTextView);
            timerTextView = findViewById(R.id.timerTextView);
            playAgainButton = findViewById(R.id.playAgainButton);
            gameLayout = findViewById(R.id.gameLayout);
            btnAdd = findViewById(R.id.btnAdd);
            txtFinalScore = findViewById(R.id.txtFinalScore);
            imgMotivationalShow = findViewById(R.id.imgMotivationalShow);
            txtTime = findViewById(R.id.txtTime);
            txtScore = findViewById(R.id.txtScore);

        btnAdd.setVisibility(View.VISIBLE);

        gameLayout.setVisibility(View.INVISIBLE);

        }

    }
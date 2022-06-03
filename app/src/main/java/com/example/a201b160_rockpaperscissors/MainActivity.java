package com.example.a201b160_rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button b_rock, b_paper, b_scissor;
    TextView tv_score;
    ImageView iv_HumanChoice, iv_ComputerChoice;

    int HumanScore,ComputerScore=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_paper=(Button) findViewById(R.id.b_paper);
        b_scissor=(Button) findViewById(R.id.b_scissor);
        b_rock=(Button) findViewById(R.id.b_rock);

        iv_ComputerChoice=(ImageView) findViewById(R.id.iv_ComputerChoice);
        iv_HumanChoice=(ImageView) findViewById(R.id.iv_HumanChoice);

        tv_score=(TextView) findViewById(R.id.tv_score);

        //Set the correct picture when a button is clicked
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+"Computer: "+Integer.toString(ComputerScore));

            }

        });

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+"Computer: "+Integer.toString(ComputerScore));


            }
        });

        b_scissor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_HumanChoice.setImageResource(R.drawable.scissors);
                String message = play_turn("scissor");
                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+"Computer: "+Integer.toString(ComputerScore));



            }
        });
    }
    //method or a function
    public String play_turn(String player_choice){
        String computer_choice="";
        Random r=new Random(); //computer choose any one of rock,paper &scissor
        int computer_choice_number=r.nextInt(3)+1; //computer choice number(1 2 or 3)

        if(computer_choice_number==1)
        {
            computer_choice="rock";
        }
        if(computer_choice_number==2)
        {
            computer_choice="scissor";
        }
        if(computer_choice_number==3)
        {
            computer_choice="paper";
        }

        //set the computer image based on his choice
        if(computer_choice=="rock")
        {
            iv_ComputerChoice.setImageResource(R.drawable.rock);
        }
        if(computer_choice=="scissor")
        {
            iv_ComputerChoice.setImageResource(R.drawable.scissors);
        }
        if(computer_choice=="paper")
        {
            iv_ComputerChoice.setImageResource(R.drawable.paper);
        }

        //compare human choice to computer choice to determine winner
        if(computer_choice==player_choice)
        {
            return "Draw! Nobody won.";
        }
        else if(player_choice=="rock" && computer_choice=="scissor")
        {
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if(player_choice=="rock" && computer_choice=="paper")
        {
            ComputerScore++;
            return "Paper covers thr Rock. Computer wins!";
        }
        else if(player_choice=="scissors" && computer_choice=="rock")
        {
            ComputerScore++;
            return "Rock crushes scissors. Computer win!";
        }
        else if(player_choice=="scissors" && computer_choice=="paper")
        {
            HumanScore++;
            return "Scissors cuts Paper. You win!";
        }
        else if(player_choice=="paper" && computer_choice=="rock")
        {
            HumanScore++;
            return "Paper covers the Rock. You win!";
        }
        else if(player_choice=="paper" && computer_choice=="scissor")
        {
            ComputerScore++;
            return "Scissors cuts Paper. Computer wins!";
        }
        else
            return "Not Sure";

    }
}
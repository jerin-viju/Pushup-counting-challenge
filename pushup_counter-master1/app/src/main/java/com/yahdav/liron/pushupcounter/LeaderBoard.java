package com.yahdav.liron.pushupcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by jerin on 27/9/15.
 */
public class LeaderBoard extends Activity {
    LinearLayout layout1;
    LinearLayout layout2;
    LinearLayout layout3;
    LinearLayout layout4;
    LinearLayout layout5;
    TextView name1;
    TextView name2;
    TextView name3;
    TextView name4;
    TextView name5;
    TextView Score1;
    TextView Score2;
    TextView Score3;
    TextView Score4;
    TextView Score5;
    int scr1;
    int scr2;
    int scr3;
    int scr4;
    int scr5;
    ImageView gold1;
    ImageView gold2;
    ImageView gold3;
    ImageView gold4;
    ImageView gold5;

    Intent intent1;
    String[] str1;
    int noofplayers;
    int i=1;
    int[] str3;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.
            Intent intent=new Intent("com.yahdav.liron.pushupcounter.frontpage");
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leaderboard);
        layout1=(LinearLayout)findViewById(R.id.linearlayout1);
        layout2=(LinearLayout)findViewById(R.id.linearlayout2);
        layout3=(LinearLayout)findViewById(R.id.linearlayout3);
        layout4=(LinearLayout)findViewById(R.id.linearlayout4);
        layout5=(LinearLayout)findViewById(R.id.linearlayout5);
        gold1=(ImageView)findViewById(R.id.gold1);
        gold2=(ImageView)findViewById(R.id.gold2);
        gold3=(ImageView)findViewById(R.id.gold3);
        gold4=(ImageView)findViewById(R.id.gold4);
        gold5=(ImageView)findViewById(R.id.gold5);
        name1=(TextView)findViewById(R.id.name1);
        name2=(TextView)findViewById(R.id.name2);
        name3=(TextView)findViewById(R.id.name3);
        name4=(TextView)findViewById(R.id.name4);
        name5=(TextView)findViewById(R.id.name5);
        Score1=(TextView)findViewById(R.id.score1);
        Score2=(TextView)findViewById(R.id.score2);
        Score3=(TextView)findViewById(R.id.score3);
        Score4=(TextView)findViewById(R.id.score4);
        Score5=(TextView)findViewById(R.id.score5);
        intent1=getIntent();
        str1=intent1.getStringArrayExtra("ID_EXTRA1");



        noofplayers=Integer.parseInt(str1[0].toString());
        switch (noofplayers){
            case 1:layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.GONE);
                layout3.setVisibility(View.GONE);
                layout4.setVisibility(View.GONE);
                layout5.setVisibility(View.GONE);
                name1.setText(str1[1]);
                Score1.setText(str1[2]);
                break;
            case 2:layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.GONE);
                layout4.setVisibility(View.GONE);
                layout5.setVisibility(View.GONE);


                        name1.setText(str1[1]);
                        Score1.setText(str1[2]);
                        name2.setText(str1[3]);
                        Score2.setText(str1[4]);
                int pos;
                pos=Integer.parseInt(str1[5].toString());
                switch (pos){
                    case 1:gold1.setImageResource(R.drawable.rightarrow);
                        break;
                    case 2:gold2.setImageResource(R.drawable.rightarrow);
                        break;
                }
                        break;


            case 3:layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.VISIBLE);
                layout4.setVisibility(View.GONE);
                layout5.setVisibility(View.GONE);

                     name1.setText(str1[1]);
                        Score1.setText(str1[2]);
                        name2.setText(str1[3]);
                        Score2.setText(str1[4]);
                        name3.setText(str1[5]);
                        Score3.setText(str1[6]);
                int pos1;
                pos1=Integer.parseInt(str1[7].toString());
                switch (pos1){
                    case 1:gold1.setImageResource(R.drawable.rightarrow);
                        break;
                    case 2:gold2.setImageResource(R.drawable.rightarrow);
                        break;
                    case 3:gold3.setImageResource(R.drawable.rightarrow);
                        break;
                }

                        break;


            case 4:layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.VISIBLE);
                layout4.setVisibility(View.VISIBLE);
                layout5.setVisibility(View.GONE);
                name1.setText(str1[1]);
                Score1.setText(str1[2]);
                name2.setText(str1[3]);
                Score2.setText(str1[4]);
                name3.setText(str1[5]);
                Score3.setText(str1[6]);
                name4.setText(str1[7]);
                Score4.setText(str1[8]);

                int pos2;
                pos2=Integer.parseInt(str1[9].toString());
                switch (pos2){
                    case 1:gold1.setImageResource(R.drawable.rightarrow);
                        break;
                    case 2:gold2.setImageResource(R.drawable.rightarrow);
                        break;
                    case 3:gold3.setImageResource(R.drawable.rightarrow);
                        break;
                    case 4:gold4.setImageResource(R.drawable.rightarrow);
                        break;
                }


            break;
            case 5:layout1.setVisibility(View.VISIBLE);
                layout2.setVisibility(View.VISIBLE);
                layout3.setVisibility(View.VISIBLE);
                layout4.setVisibility(View.VISIBLE);
                layout5.setVisibility(View.VISIBLE);
                name1.setText(str1[1]);
                Score1.setText(str1[2]);
                name2.setText(str1[3]);
                Score2.setText(str1[4]);
                name3.setText(str1[5]);
                Score3.setText(str1[6]);
                name4.setText(str1[7]);
                Score4.setText(str1[8]);
                name5.setText(str1[9]);
                Score5.setText(str1[10]);
                int pos3;
                pos3=Integer.parseInt(str1[11].toString());
                switch (pos3){
                    case 1:gold1.setImageResource(R.drawable.rightarrow);
                        break;
                    case 2:gold2.setImageResource(R.drawable.rightarrow);
                        break;
                    case 3:gold3.setImageResource(R.drawable.rightarrow);
                        break;
                    case 4:gold4.setImageResource(R.drawable.rightarrow);
                        break;
                    case 5:gold5.setImageResource(R.drawable.rightarrow);
                        break;
                }


                break;
        }



    }
}

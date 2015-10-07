package com.yahdav.liron.pushupcounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by jerin on 27/9/15.
 */
public class frontpage extends Activity {
    EditText text1;
    ImageView image;
    Button btn;
    Button go2;
    ImageView go;
    LinearLayout lin;
    LinearLayout lin1;
    LinearLayout lin2;
    LinearLayout lin3;
    LinearLayout lin4;
    LinearLayout lin5;
    EditText pla1;
    EditText pla2;
    EditText pla3;
    EditText pla4;
    EditText pla5;
    int n;
    String p1;
    String p2;
    String p3;
    String p4;
    String p5;

    Intent intent;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            // do something on back.

           System.exit(0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frontpage);
        btn=(Button)findViewById(R.id.go);
        go=(ImageView)findViewById(R.id.go1);
        go2=(Button)findViewById(R.id.go2);
        pla1=(EditText)findViewById(R.id.player1);
        pla2=(EditText)findViewById(R.id.player2);
        pla3=(EditText)findViewById(R.id.player3);
        pla4=(EditText)findViewById(R.id.player4);
        pla5=(EditText)findViewById(R.id.player5);
        text1=(EditText)findViewById(R.id.count);
        lin=(LinearLayout)findViewById(R.id.linear);
        lin1=(LinearLayout)findViewById(R.id.linear1);
        lin2=(LinearLayout)findViewById(R.id.linear2);
        lin3=(LinearLayout)findViewById(R.id.linear3);
        lin4=(LinearLayout)findViewById(R.id.linear4);
        lin5=(LinearLayout)findViewById(R.id.linear5);
        image=(ImageView)findViewById(R.id.person);


         intent= new Intent("com.yahdav.liron.pushupcounter.PushupCounterActivity");
        go2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                switch (n) {
                    case 1:
                        p1 = pla1.getText().toString();
                        intent.putExtra("ID_EXTRA", new String[]{"1", p1});
                        startActivity(intent);
                        break;
                    case 2:
                        p1 = pla1.getText().toString();
                        p2 = pla2.toString();
                        intent.putExtra("ID_EXTRA", new String[]{"2", p1, p2});
                        startActivity(intent);
                        break;
                    case 3:
                        p1 = pla1.getText().toString();
                        p2 = pla2.getText().toString();
                        p3 = pla3.getText().toString();
                        intent.putExtra("ID_EXTRA", new String[]{"3", p1, p2, p3});
                        startActivity(intent);
                        break;
                    case 4:
                        p1 = pla1.getText().toString();
                        p2 = pla2.getText().toString();
                        p3 = pla3.getText().toString();
                        p4 = pla4.getText().toString();
                        intent.putExtra("ID_EXTRA", new String[]{"4", p1, p2, p3, p4});
                        startActivity(intent);
                        break;
                    case 5:
                        p1 = pla1.getText().toString();
                        p2 = pla2.getText().toString();
                        p3 = pla3.getText().toString();
                        p4 = pla4.getText().toString();
                        p5 = pla5.getText().toString();

                        intent.putExtra("ID_EXTRA", new String[]{"5", p1, p2, p3, p4, p5});
                        startActivity(intent);
                        break;
                }

            }
        });

        go.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(!text1.getText().toString().equals("")){
                    //
                    n=Integer.parseInt(text1.getText().toString());
                    switch (n) {
                        case 1:// image.setVisibility(View.GONE);
                         //   btn.setVisibility(View.GONE);
                            go.setVisibility(View.VISIBLE);
                            lin.setVisibility(View.VISIBLE);
                            lin1.setVisibility(View.VISIBLE);
                            lin2.setVisibility(View.GONE);
                            lin3.setVisibility(View.GONE);
                            lin4.setVisibility(View.GONE);
                            lin5.setVisibility(View.GONE);
                            break;
                        case 2:// image.setVisibility(View.GONE);
                          //  btn.setVisibility(View.GONE);
                            go.setVisibility(View.VISIBLE);
                            lin.setVisibility(View.VISIBLE);
                            lin1.setVisibility(View.VISIBLE);
                            lin2.setVisibility(View.VISIBLE);
                            lin3.setVisibility(View.GONE);
                            lin4.setVisibility(View.GONE);
                            lin5.setVisibility(View.GONE);
                            break;
                        case 3:// image.setVisibility(View.GONE);
                           // btn.setVisibility(View.GONE);
                            go.setVisibility(View.VISIBLE);
                            lin.setVisibility(View.VISIBLE);
                            lin1.setVisibility(View.VISIBLE);
                            lin2.setVisibility(View.VISIBLE);
                            lin3.setVisibility(View.VISIBLE);
                            lin4.setVisibility(View.GONE);
                            lin5.setVisibility(View.GONE);
                            break;
                        case 4:// image.setVisibility(View.GONE);
                            //btn.setVisibility(View.GONE);
                            go.setVisibility(View.VISIBLE);
                            lin.setVisibility(View.VISIBLE);
                            lin1.setVisibility(View.VISIBLE);
                            lin2.setVisibility(View.VISIBLE);
                            lin3.setVisibility(View.VISIBLE);
                            lin4.setVisibility(View.VISIBLE);
                            lin5.setVisibility(View.GONE);
                            break;
                        case 5: //image.setVisibility(View.GONE);
                           // btn.setVisibility(View.GONE);
                            go.setVisibility(View.VISIBLE);
                            lin.setVisibility(View.VISIBLE);
                            lin1.setVisibility(View.VISIBLE);
                            lin2.setVisibility(View.VISIBLE);
                            lin3.setVisibility(View.VISIBLE);
                            lin4.setVisibility(View.VISIBLE);
                            lin5.setVisibility(View.VISIBLE);
                            break;
                        default:
                            Toast.makeText(getApplicationContext(),
                                    "Maximum no of players is 5", Toast.LENGTH_LONG)
                                    .show();


                    }

                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Please enter the no of players", Toast.LENGTH_LONG)
                            .show();

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(!text1.getText().toString().equals("")){
             //
                    n=Integer.parseInt(text1.getText().toString());
                    switch (n) {
                            case 1: image.setVisibility(View.GONE);
                                    btn.setVisibility(View.GONE);
                                    go.setVisibility(View.VISIBLE);
                                    lin.setVisibility(View.VISIBLE);
                                    lin2.setVisibility(View.GONE);
                                    lin3.setVisibility(View.GONE);
                                    lin4.setVisibility(View.GONE);
                                    lin5.setVisibility(View.GONE);
                                break;
                            case 2: image.setVisibility(View.GONE);
                                    btn.setVisibility(View.GONE);
                                    go.setVisibility(View.VISIBLE);
                                    lin.setVisibility(View.VISIBLE);
                                    lin3.setVisibility(View.GONE);
                                    lin4.setVisibility(View.GONE);
                                    lin5.setVisibility(View.GONE);
                                break;
                            case 3: image.setVisibility(View.GONE);
                                    btn.setVisibility(View.GONE);
                                    go.setVisibility(View.VISIBLE);
                                    lin.setVisibility(View.VISIBLE);
                                    lin4.setVisibility(View.GONE);
                                    lin5.setVisibility(View.GONE);
                                break;
                            case 4: image.setVisibility(View.GONE);
                                    btn.setVisibility(View.GONE);
                                    go.setVisibility(View.VISIBLE);
                                    lin.setVisibility(View.VISIBLE);
                                    lin5.setVisibility(View.GONE);
                                break;
                            case 5: image.setVisibility(View.GONE);
                                    btn.setVisibility(View.GONE);
                                    go.setVisibility(View.VISIBLE);
                                    lin.setVisibility(View.VISIBLE);
                                break;
                            default:
                                Toast.makeText(getApplicationContext(),
                                        "Maximum no of players is 5", Toast.LENGTH_LONG)
                                        .show();


                        }

                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Please enter the no of players", Toast.LENGTH_LONG)
                            .show();
            }
        });

    /*    btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("com.yahdav.liron.pushupcounter.PushupCounterActivity");
                startActivity(intent);

            }
        });*/

    }
}

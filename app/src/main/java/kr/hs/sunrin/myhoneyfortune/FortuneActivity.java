package kr.hs.sunrin.myhoneyfortune;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.github.kimkevin.hangulparser.HangulParser;
import com.github.kimkevin.hangulparser.HangulParserException;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FortuneActivity extends AppCompatActivity {
    private EditText myNameField;
    private EditText yourNameField;
    private Map<String,Integer> countList = new HashMap<>();
    private TextView[] myNames = new TextView[3];
    private TextView[] yourNames = new TextView[3];

    private int[] firstCollumn = new int[]{0,0,0,0,0,0};
    private int[] secondCollumn = new int[]{0,0,0,0,0};
    private int[] thirdCollumn = new int[]{0,0,0,0};
    private int[] fourth = new int[]{0,0,0};
    int percent = 0;

    private final void initDict(){
        countList.put("ㄱ",2);
        countList.put("ㄲ",4);
        countList.put("ㄴ",2);
        countList.put("ㄷ",3);
        countList.put("ㄸ",6);
        countList.put("ㄹ",5);
        countList.put("ㅁ",4);
        countList.put("ㅂ",4);
        countList.put("ㅃ",8);
        countList.put("ㅅ",2);
        countList.put("ㅆ",4);
        countList.put("ㅇ",1);
        countList.put("ㅈ",3);
        countList.put("ㅉ",6);
        countList.put("ㅊ",4);
        countList.put("ㅋ",3);
        countList.put("ㅌ",4);
        countList.put("ㅍ",4);
        countList.put("ㅎ",3);
        countList.put("ㅏ",2);
        countList.put("ㅐ",3);
        countList.put("ㅑ",3);
        countList.put("ㅒ",4);
        countList.put("ㅓ",2);
        countList.put("ㅔ",3);
        countList.put("ㅕ",3);
        countList.put("ㅖ",4);
        countList.put("ㅘ",4);
        countList.put("ㅙ",5);
        countList.put("ㅚ",3);
        countList.put("ㅛ",3);
        countList.put("ㅜ",2);
        countList.put("ㅝ",4);
        countList.put("ㅞ",5);
        countList.put("ㅟ",3);
        countList.put("ㅠ",3);
        countList.put("ㅡ",1);
        countList.put("ㅢ",2);
        countList.put("ㅣ",1);
        countList.put("ㄳ",4);
        countList.put("ㄵ",5);
        countList.put("ㄶ",5);
        countList.put("ㄺ",7);
        countList.put("ㄻ",9);
        countList.put("ㄼ",9);
        countList.put("ㄽ",7);
        countList.put("ㄾ",9);
        countList.put("ㄿ",9);
        countList.put("ㅀ",8);
        countList.put("ㅄ",6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDict();
        myNames[0] = (TextView) findViewById(R.id.myname1);
        myNames[1] = (TextView) findViewById(R.id.myname2);
        myNames[2] = (TextView) findViewById(R.id.myname3);
        yourNames[0] = (TextView) findViewById(R.id.yourname1);
        yourNames[1] = (TextView) findViewById(R.id.yourname2);
        yourNames[2] = (TextView) findViewById(R.id.yourname3);
        myNameField = (EditText) findViewById(R.id.my_name);
        yourNameField = (EditText) findViewById(R.id.your_name);
        myNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = myNameField.getText().toString();
                char[] chars =name.toCharArray();
                for(int i = 0 ; i < 3 ; i++){
                    if(i<chars.length) {
                        try {
                            myNames[i].setText(""+chars[i]);
                            List<String> list = HangulParser.disassemble(chars[i]);
                            int count = 0;
                            for (String element : list) {
                                Log.e("data","data:"+element);
                                count += countList.get(element);
                            }
                            int index = i * 2;
                            firstCollumn[index] = count;
                            calcCollumn();
                        } catch (HangulParserException e) {
                            e.printStackTrace();
                        }
                    }else{
                        myNames[i].setText("");
                    }
                }
            }
        });
        yourNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String name = yourNameField.getText().toString();
                char[] chars =name.toCharArray();
                for(int i = 0 ; i < 3 ; i++){
                    if(i<chars.length) {
                        try {
                            yourNames[i].setText(""+chars[i]);
                            List<String> list = HangulParser.disassemble(chars[i]);
                            int count = 0;
                            for (String element : list) {
                                count += countList.get(element);
                            }
                            int index = i * 2 + 1;
                            firstCollumn[index] = count;
                            calcCollumn();
                        } catch (HangulParserException e) {
                            e.printStackTrace();
                        }
                    }else{
                        yourNames[i].setText("");
                    }
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calcCollumn(){
        ViewGroup first = (ViewGroup) findViewById(R.id.firstLine);
        TextView[] line1 = new TextView[6];
        TextView[] line2 = new TextView[5];
        TextView[] line3 = new TextView[4];
        TextView[] line4 = new TextView[3];
        int count = 0;
        for(int i = 0 ; i<first.getChildCount();i++){
            if(first.getChildAt(i) instanceof TextView){
                line1[count++] = (TextView) first.getChildAt(i);
            }
        }
        ViewGroup second = (ViewGroup) findViewById(R.id.secondLine);
        count=0;
        for(int i = 0 ; i<second.getChildCount();i++){
            if(second.getChildAt(i) instanceof TextView){
                line2[count++] = (TextView) second.getChildAt(i);
            }
        }
        ViewGroup third = (ViewGroup) findViewById(R.id.thirdLine);
        count = 0;
        for(int i = 0 ; i<third.getChildCount();i++){
            if(third.getChildAt(i) instanceof TextView){
                line3[count++] = (TextView) third.getChildAt(i);
            }
        }
        ViewGroup fourthLine = (ViewGroup) findViewById(R.id.fourthLine);
        for(int i = 0 ; i<fourthLine.getChildCount();i++){
            if(fourthLine.getChildAt(i) instanceof TextView){
                line4[count++] = (TextView) fourthLine.getChildAt(i);
            }
        }
        for(int i = 0;i<firstCollumn.length;i++){
            line1[i].setText(firstCollumn[i]+"");
        }
        for(int i = 0;i<secondCollumn.length;i++){
            secondCollumn[i] = (firstCollumn[i] + firstCollumn[i+1]) % 10;
            line2[i].setText(secondCollumn[i]+"");
        }
        for(int i = 0;i<thirdCollumn.length;i++){
            thirdCollumn[i] = (secondCollumn[i] + secondCollumn[i+1]) % 10;
            line3[i].setText(thirdCollumn[i]+"");
        }
        for(int i = 0;i<fourth.length;i++){
            fourth[i] = (thirdCollumn[i] + thirdCollumn[i+1]) % 10;
            line4[i].setText(fourth[i]+"");
        }

        percent = ((fourth[0]+fourth[1])%10)*10 + ((fourth[1]+fourth[2])%10);
        ((TextView)findViewById(R.id.percent)).setText(percent+"%");
    }

}

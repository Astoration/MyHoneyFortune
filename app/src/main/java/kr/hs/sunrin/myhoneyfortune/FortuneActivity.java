package kr.hs.sunrin.myhoneyfortune;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

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
    private static final char[] CHOSUNG_LIST = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };
    private static final char[] JUNGSUNG_LIST = {
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ',
            'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ',
            'ㅣ'
    };
    private static final char[] JONGSUNG_LIST = {
            ' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ',
            'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ',
            'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };
    private Map<Character,Integer> countList = new HashMap<>();

    private final void initDict(){
        countList.put('ㄱ',2);
        countList.put('ㄲ',4);
        countList.put('ㄴ',2);
        countList.put('ㄷ',3);
        countList.put('ㄸ',6);
        countList.put('ㄹ',5);
        countList.put('ㅁ',4);
        countList.put('ㅂ',4);
        countList.put('ㅃ',8);
        countList.put('ㅅ',2);
        countList.put('ㅆ',4);
        countList.put('ㅇ',1);
        countList.put('ㅈ',3);
        countList.put('ㅉ',6);
        countList.put('ㅊ',4);
        countList.put('ㅋ',3);
        countList.put('ㅌ',4);
        countList.put('ㅍ',4);
        countList.put('ㅎ',3);
        countList.put('ㅏ',2);
        countList.put('ㅐ',3);
        countList.put('ㅑ',3);
        countList.put('ㅒ',4);
        countList.put('ㅓ',2);
        countList.put('ㅔ',3);
        countList.put('ㅕ',3);
        countList.put('ㅖ',4);
        countList.put('ㅘ',4);
        countList.put('ㅙ',5);
        countList.put('ㅚ',3);
        countList.put('ㅛ',3);
        countList.put('ㅜ',2);
        countList.put('ㅝ',4);
        countList.put('ㅞ',5);
        countList.put('ㅟ',3);
        countList.put('ㅠ',3);
        countList.put('ㅡ',1);
        countList.put('ㅢ',2);
        countList.put('ㅣ',1);
        countList.put('ㄳ',4);
        countList.put('ㄵ',5);
        countList.put('ㄶ',5);
        countList.put('ㄺ',7);
        countList.put('ㄻ',9);
        countList.put('ㄼ',9);
        countList.put('ㄽ',7);
        countList.put('ㄾ',9);
        countList.put('ㄿ',9);
        countList.put('ㅀ',8);
        countList.put('ㅄ',6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
                for(int i = 0 ; i < chars.length ; i++){
                    try {
                        List<String> list = HangulParser.disassemble(chars[i]);
                    } catch (HangulParserException e) {
                        e.printStackTrace();
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

}

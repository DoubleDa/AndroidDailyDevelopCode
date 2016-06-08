package com.dyx.cpd.ui.activity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dyx.cpd.R;
import com.dyx.ml.ui.activity.BaseActivity;

/**
 * project name：CodePathDemo
 * class describe：Basic Event Listeners
 * create person：dayongxin
 * create time：16/5/23 下午10:56
 * alter person：dayongxin
 * alter time：16/5/23 下午10:56
 * alter remark：
 */
public class BasicEventListenersAct extends BaseActivity {
    private Button clickBut;
    private ListView mListView;
    private EditText mEditText;
    private NumberPicker mNumberPicker;
    private SeekBar mSeekBar;

    @Override
    protected void initView() {
        setContentView(R.layout.act_basic_event_listeners_layout);
        /**
         * Using Java
         */
        clickBut = (Button) findViewById(R.id.but_click);
        clickBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mListView = (ListView) findViewById(R.id.lv_listener);
        /**
         * setOnItemClickListener
         */
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        /**
         * setOnItemLongClickListener
         */
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                return false;
            }
        });

        /**
         * setOnItemSelectedListener
         */

        mListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        /**
         * EditText
         */
        mEditText = (EditText) findViewById(R.id.et_input);
        /**
         * addTextChangedListener:Fires each time the text in the field is being changed
         */
        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Fires right before text is changing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Fires right as the text is being changed (even supplies the range of text)
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Fires right after the text has changed
                Toast.makeText(BasicEventListenersAct.this, "Success!", Toast.LENGTH_SHORT).show();
            }
        });
        /**
         * setOnEditorActionListener:Fires when an "action" button on the soft keyboard is pressed
         */
        mEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String temp = v.getText().toString();
                    Toast.makeText(BasicEventListenersAct.this, temp, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        mNumberPicker = (NumberPicker) findViewById(R.id.np_test);
        /**
         * setOnValueChangedListener
         */
        mNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                //Changes based on number here
            }
        });

        mSeekBar = (SeekBar) findViewById(R.id.sb_test);
        /**
         * setOnSeekBarChangeListener
         */
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Notification that the progress level has changed.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //Notification that the user has started a touch gesture.
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Notification that the user has finished a touch gesture.
            }
        });
    }

    /**
     * Using XML
     */
    public void showMsg(View view) {

    }
}

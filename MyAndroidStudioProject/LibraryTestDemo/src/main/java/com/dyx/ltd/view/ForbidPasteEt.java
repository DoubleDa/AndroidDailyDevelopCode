package com.dyx.ltd.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

/**
 * Created by Da on 2016/3/30.
 * forbid paste edittext
 */
public class ForbidPasteEt extends EditText {
    private Context mContext;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ForbidPasteEt(Context context) {
        super(context);
        this.mContext = context;
        initEt();
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ForbidPasteEt(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initEt();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ForbidPasteEt(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initEt();
    }


    private boolean isAllowPaste() {
        return false;
    }

    @Override
    public boolean isSuggestionsEnabled() {
        return false;
    }

    private void initEt() {
        this.setCustomSelectionActionModeCallback(new ActionModeCallbackInterceptor());
        this.setLongClickable(false);
    }

    private class ActionModeCallbackInterceptor implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }
}

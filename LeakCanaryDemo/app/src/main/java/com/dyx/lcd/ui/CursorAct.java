package com.dyx.lcd.ui;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;

import com.dyx.lcd.R;

/**
 * project name：LeakCanaryDemo
 * class describe：
 * create person：dayongxin
 * create time：2016/11/1 下午1:57
 * alter person：dayongxin
 * alter time：2016/11/1 下午1:57
 * alter remark：
 */
public class CursorAct extends Activity {
    private String results[] = new String[]{
            MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID, MediaStore.Images.Media.TITLE, MediaStore.Images.Media.DISPLAY_NAME
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursor);
        closeCursor();
    }

    private void closeCursor() {
        Cursor cursor = getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, results, null, null, null);
        if (cursor != null) {
            int photoIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

            while (cursor.moveToNext()) {
                String photoPath = cursor.getString(photoIndex);
            }
            cursor.close();
        }
    }
}

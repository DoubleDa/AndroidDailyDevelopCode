package com.dyx.ltd.db;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Environment;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dyx.ltd.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Da on 2016/3/29.
 * backup and restore database
 */
public class BackupRestoreDb {
    public static final int BACKUP_DATABASE = 1;
    public static final int RESTORE_DATABASE = 2;

    public static final int DIALOG_WHICH_OK = 0;
    public static final int DIALOG_WHICH_CONFIRM = -1;
    public static final int DIALOG_WHICH_CANCEL = -2;

    private Context mContext = null;
    //database file list
    private String[] dbFiles = null;
    //the position of database list
    private int chooseDbPosition = 3;
    private AlertDialog mAlertDialog = null;
    private String BACKUP_FOLDER = "backup_folder";
    private String APP_NAME = "my_app";

    public BackupRestoreDb(Context mContext) {
        this.mContext = mContext;
    }

    /**
     * restore database
     */
    public void restoreDb() {
        dbFiles = getDbFilesList();
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.restore_db);
        builder.setSingleChoiceItems(getDbFilesList(), -1, new DialogClick());
        builder.setPositiveButton(R.string.confirm, new DialogClick());
        builder.setNegativeButton(R.string.cancel, new DialogClick());
        builder.show();
    }

    /**
     * backup database
     */
    public void backupDb() {
        showDialog(R.string.is_backup_db, BACKUP_DATABASE);
    }

    private void showDialog(int resId, int tag) {
        final int sign = tag;
        new AlertDialog.Builder(mContext).setTitle(resId).setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (sign) {
                    case BACKUP_DATABASE:
                        // backup database
                        if (mAlertDialog == null) {
                            mAlertDialog = awaitDialog(mContext);
                        } else {
                            mAlertDialog.show();
                        }
                        new ExecuteTask().execute(BACKUP_DATABASE);
                        break;
                    case RESTORE_DATABASE:
                        //restore database
                        break;
                    default:
                        break;
                }
            }


        }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
    }


    private class ExecuteTask extends AsyncTask<Integer, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Integer... params) {
            int sign = params[0];
            if (sign == BACKUP_DATABASE) {
                doBackupTask();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (mAlertDialog != null) {
                mAlertDialog.dismiss();
            }
        }
    }

    private boolean doBackupTask() {
        boolean isOk = false;
        String sp = File.separator;
        File sdFiles = sdCardOk();
        if (sdFiles != null) {
            try {
                String[] dbNames = {"database name"};
                //create date file folder
                String datePre = getDatePreFix();
                File file = new File(sdFiles.getAbsolutePath() + sp + datePre);
                if (!file.exists()) {
                    file.mkdir();
                }
                for (int i = 0; i < dbNames.length; i++) {
                    String dbName = dbNames[i];
                    File dbFile = dbOk(dbName);
                    if (dbFile != null) {
                        File backupFile = new File(file.getAbsolutePath() + sp + dbFile.getName());
                        backupFile.createNewFile();
                        isOk = fileCopy(backupFile, dbFile.getAbsoluteFile());
                        if (isOk) {
                            break;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isOk;
    }

    private boolean fileCopy(File backupFile, File absoluteFile) throws IOException {
        if (backupFile == null || absoluteFile == null) {
            return false;
        }
        boolean isOk = true;
        //only read
        FileChannel inChannel = new FileInputStream(absoluteFile).getChannel();
        //only write
        FileChannel outChannel = new FileOutputStream(backupFile).getChannel();
        try {
            long size = inChannel.transferTo(0, inChannel.size(), outChannel);
            if (size <= 0) {
                isOk = false;
            }
        } catch (Exception e) {
            isOk = false;
            e.printStackTrace();
        } finally {
            if (inChannel != null) {
                inChannel.close();
            }
            if (outChannel != null) {
                outChannel.close();
            }
        }
        return isOk;
    }

    private File dbOk(String dbName) {
        String sp = File.separator;
        String absPath = Environment.getDataDirectory().getAbsolutePath();
        String packPath = mContext.getPackageName();
        String dbPath = absPath + sp + "data" + sp + packPath + sp + "databases" + sp + dbName;
        File file = new File(dbPath);
        if (!file.exists()) {
            return file;
        } else {
            return null;
        }
    }

    /**
     * get date pre fix
     *
     * @return
     */
    private String getDatePreFix() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        return format.format(date);
    }

    /**
     * sdcard is exist
     *
     * @return
     */
    private File sdCardOk() {
        File backupFile = null;
        String fileState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(fileState)) {
            String sp = File.separator;
            String backupFilePath = Environment.getExternalStorageDirectory() + sp + APP_NAME + sp + BACKUP_FOLDER;
            backupFile = new File(backupFilePath);
            if (!backupFile.exists()) {
                backupFile.mkdirs();
            } else {
                return backupFile;
            }
        } else {
            Toast.makeText(mContext, R.string.sd_card_is_not_exist, Toast.LENGTH_SHORT).show();
        }
        return backupFile;
    }

    /**
     * get database file list
     *
     * @return
     */
    private String[] getDbFilesList() {
        String dbFiles[] = null;
        File file = sdCardOk();
        if (file != null) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                dbFiles = new String[files.length];
                for (int i = 0; i < files.length; i++) {
                    dbFiles[i] = files[i].getName();
                }
            }
        }
        return dbFiles;
    }

    private AlertDialog awaitDialog(Context mContext) {
        ProgressBar progressBar = new ProgressBar(mContext);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        AlertDialog dialog = new AlertDialog.Builder(mContext).create();
        dialog.setCancelable(false);
        dialog.show();

        Window window = dialog.getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = 50;
        params.height = 50;
        window.setAttributes(params);
        window.setContentView(progressBar);
        return dialog;
    }


    private class DialogClick implements DialogInterface.OnClickListener {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            if (which == DIALOG_WHICH_CONFIRM) {
                //confirm
                if (chooseDbPosition < 0) {
                    Toast.makeText(mContext, R.string.select_data_base, Toast.LENGTH_SHORT).show();
                    return;
                }
                String sp = File.separator;
                String folderName = dbFiles[chooseDbPosition];
                String backupPath = Environment.getExternalStorageDirectory() + sp + APP_NAME + sp + BACKUP_FOLDER + sp + folderName;
                File file = new File(backupPath);
                if (file.isDirectory()) {
                    File[] files = file.listFiles();
                    boolean isOk = false;
                    for (int i = 0; i < files.length; i++) {
                        File f = files[i];
                        isOk = restore(f.getName(), f);
                        if (!isOk) {
                            String fileMsg = "恢复失败：" + f.getName();
                            Toast.makeText(mContext, fileMsg, Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    if (isOk) {
                        //TODO update new data
                    }
                }
            } else if (which == DIALOG_WHICH_CANCEL) {
                //cancel
            } else if (which == DIALOG_WHICH_OK) {
                chooseDbPosition = which;
            }
        }


    }

    private boolean restore(String name, File f) {
        boolean isOk = false;
        if (f != null) {
            File dbFile = dbOk(name);
            try {
                if (dbFile != null) {
                    isOk = fileCopy(dbFile, f.getAbsoluteFile());
                } else {
                    isOk = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isOk;
    }
}

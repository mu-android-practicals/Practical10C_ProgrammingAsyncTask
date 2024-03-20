package com.example.practical10c;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyTask extends AsyncTask<Void,Integer,String> {

    Context context;
    Button button;
    TextView textView;
    ProgressDialog progressDialog;


    MyTask(Context context, TextView textView, Button button) {
        this.context = context;
        this.textView = textView;
        this.button = button;
    }


    @Override
    protected String doInBackground(Void... voids) {

        int i = 0;
        synchronized (this)
        {
            while ((i < 10)){
                try {

                    wait(1000);
                    i++;
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
        }
    }
    return"Download Finish";
}


    @Override
    protected void onPreExecute() {

        progressDialog = new ProgressDialog(context);
        progressDialog.setTitle("Download in progress");
        progressDialog.setMax(10);
        progressDialog.setProgress(0);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.show();


    }

    @Override
    protected void onPostExecute(String result) {


        textView.setText(result);
        button.setEnabled(true);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {

        int progress= values[0];
        progressDialog.setProgress (progress);
        textView.setText("Download In Progress");

    }
}

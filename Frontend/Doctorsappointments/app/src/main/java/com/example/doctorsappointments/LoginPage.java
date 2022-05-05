package com.example.doctorsappointments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends AppCompatActivity {
    String success;
    TextView email ;
    TextView password;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        getSupportActionBar().hide();
        email = (TextView) findViewById(R.id.Email);
        password = (TextView) findViewById(R.id.Password);

        if(password.getText().toString().equals("") && email.getText().toString().equals("")){
            btn.setEnabled(false);
        }
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (password.getText().toString().equals("")){
                    btn.setEnabled(false);
                }
                else{
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (password.getText().toString().equals("")){
                    btn.setEnabled(false);
                }
                else{
                    btn.setEnabled(true);
                }
            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (email.getText().toString().equals("")){
                    btn.setEnabled(false);
                }
                else{
                    btn.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (email.getText().toString().equals("")){
                    btn.setEnabled(false);
                }
                else{
                    btn.setEnabled(true);
                }
            }
        });
    }
    public void toSignUp(View v){
        Intent intent = new Intent(this, SignUpPage.class);
        startActivity(intent);
    }
    public void logIn(View v){
        if(sendPostRequest(email.getText().toString(), password.getText().toString())){
            startActivity(new Intent(this , Menu.class));
        }
        else{
            Toast.makeText(this , "Retry" , Toast.LENGTH_LONG);
        }


    }

    private boolean sendPostRequest(String givenEmail, String givenPassword) {

        class SendPostReqAsyncTask extends AsyncTask<String, Void, String> {

            @Override
            protected String doInBackground(String... params) {

                String paramEmail = params[0];
                String paramPassword = params[1];


                HttpClient httpClient = new DefaultHttpClient();


                HttpPost httpPost = new HttpPost("http://192.168.1.64/FinalProject/backend/login.php");


                BasicNameValuePair emailBasicNameValuePair = new BasicNameValuePair("email", paramEmail);
                BasicNameValuePair passwordBasicNameValuePAir = new BasicNameValuePair("password", paramPassword);


                List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>();
                nameValuePairList.add(emailBasicNameValuePair);
                nameValuePairList.add(passwordBasicNameValuePAir);


                try {

                    UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(nameValuePairList);

                    httpPost.setEntity(urlEncodedFormEntity);

                    try {

                        HttpResponse httpResponse = httpClient.execute(httpPost);


                        InputStream inputStream = httpResponse.getEntity().getContent();

                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                        StringBuilder stringBuilder = new StringBuilder();

                        String bufferedStrChunk = null;

                        while ((bufferedStrChunk = bufferedReader.readLine()) != null) {
                            stringBuilder.append(bufferedStrChunk);
                        }

                        return stringBuilder.toString();

                    } catch (ClientProtocolException cpe) {
                        System.out.println("First Exception case of HttpResponse :" + cpe);
                        cpe.printStackTrace();
                    } catch (IOException ioe) {
                        System.out.println("Second Exception case of HttpResponse :" + ioe);
                        ioe.printStackTrace();
                    }

                } catch (UnsupportedEncodingException uee) {
                    System.out.println("An Exception given because of UrlEncodedFormEntity argument :" + uee);
                    uee.printStackTrace();
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);

                try {
                    JSONObject json = new JSONObject(s);
                    success = json.getString("success");
                    Log.i("success", success);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        SendPostReqAsyncTask sendPostReqAsyncTask = new SendPostReqAsyncTask();
        sendPostReqAsyncTask.execute(givenEmail, givenPassword);
        if (success.equals("0")) return true;
        else return false;
    }
}
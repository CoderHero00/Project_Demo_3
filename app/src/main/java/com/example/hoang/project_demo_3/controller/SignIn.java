package com.example.hoang.project_demo_3.controller;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.hoang.project_demo_3.common.Common;
import com.example.hoang.project_demo_3.entity.Account;
import com.example.hoang.project_demo_3.retrofit.network.ApiServices;
import com.example.hoang.project_demo_3.utilities.hash.PasswordUtility;
import com.google.gson.Gson;
import com.hbb20.CountryCodePicker;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.example.hoang.project_demo_3.R;

import org.jsoup.Jsoup;

import java.io.IOException;

public class SignIn extends AppCompatActivity {

    MaterialEditText editPhone, editPassword;
    Button btnSignIn;
    CountryCodePicker ccp;
    private ApiServices mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        editPassword = (MaterialEditText) findViewById(R.id.edtPassword);
        editPhone = (MaterialEditText) findViewById(R.id.edtPhone);

        editPhone.setText("1900561252");
        editPassword.setText("@bc123Xyz");

        ccp = findViewById(R.id.ccp_signin);

        btnSignIn = (Button) findViewById(R.id.btnSignIn);


        //get API in here. Or get DB in here.
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PasswordUtility passwordUtility = new PasswordUtility();
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                //validate
                final Editable phone = editPhone.getText();
                final Editable password = editPassword.getText();

                final String phoneNumber = ccp.getSelectedCountryCode() + phone;
//                mService = ApiUtils.getApiervice();
//                mService.resForAccount(phoneNumber).enqueue(new Callback<Account>() {
//                    @Override
//                    public void onResponse(Call<Account> call, Response<Account> response) {
//                        if (response.isSuccessful()) {
//                            Account getAccount = response.body();
//                            Account inputAccount = new Account(phoneNumber, password.toString());
//                            String salt = getAccount.getSalt();
//                            String passBeforEncrypt = inputAccount.getPassword() + salt;
//                            String passEncrypt = passwordUtility.md5(passBeforEncrypt);
//
//                            if (!inputAccount.getPhone().equals(getAccount.getPhone()) || !passEncrypt.equals(getAccount.getPassword())) {
//                                Toast.makeText(SignIn.this, "Sign In Fail. Please re-check phone number or password.", Toast.LENGTH_SHORT).show();
//                                finish();
//                            } else if (inputAccount.getPhone().equals(getAccount.getPhone()) && passEncrypt.equals(getAccount.getPassword())) {
//                                Toast.makeText(SignIn.this, "Sign In Success.", Toast.LENGTH_SHORT).show();
//                                Intent homeIntent = new Intent(SignIn.this, Home.class);
//                                //set Common.currentUser = user;
//                                Common.currentAccount = getAccount;
//                                startActivity(homeIntent);
//                                finish();
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<Account> call, Throwable t) {
//                        Toast.makeText(SignIn.this, "Failure Connect to Server.", Toast.LENGTH_SHORT).show();
//                        finish();
//                    }
//                });


                try {
                    String url = "https://thawing-temple-67882.herokuapp.com/api/account/" + phoneNumber;
                    String account = Jsoup.connect(url).ignoreContentType(true).get().body().text();
                    account = account.replace("[", "");
                    account = account.replace("]", "");
                    System.out.println(account.toString());
                    Account getAccount = new Gson().fromJson(account, Account.class);
                    Account inputAccount = new Account(phoneNumber, password.toString());
                    String salt = getAccount.getSalt();
                    String passBeforEncrypt = inputAccount.getPassword() + salt;
                    String passEncrypt = passwordUtility.md5(passBeforEncrypt);
                    if (!inputAccount.getPhone().equals(getAccount.getPhone()) || !passEncrypt.equals(getAccount.getPassword())) {
                        Toast.makeText(SignIn.this, "Something Error", Toast.LENGTH_SHORT).show();
                        finish();
                    } else if (inputAccount.getPhone().equals(getAccount.getPhone()) && passEncrypt.equals(getAccount.getPassword())) {
                        Toast.makeText(SignIn.this, "Sign In Success", Toast.LENGTH_SHORT).show();
                        Intent homeIntent = new Intent(SignIn.this, Home.class);
                        Common.currentAccount = getAccount;
                        startActivity(homeIntent);
                        finish();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
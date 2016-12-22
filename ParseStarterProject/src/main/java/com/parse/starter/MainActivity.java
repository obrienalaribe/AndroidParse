/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FunctionCallback;
import com.parse.ParseCloud;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseAnalytics;
import com.parse.SaveCallback;

import java.util.HashMap;


public class MainActivity extends ActionBarActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());

//    ParseObject testObject = new ParseObject("TestObject");
//    testObject.put("foo", "bar");
//    testObject.saveInBackground(new SaveCallback() {
//      @Override
//      public void done(ParseException e) {
//        if (e != null) {
//          System.out.println(e);
//          return;
//        }
//        System.out.println("parse saved object");
//      }
//    });

    Button submitBtn = (Button) findViewById(R.id.submitBtn);

    submitBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        String email = ((TextView) findViewById(R.id.email)).getText().toString();
        String password = ((TextView) findViewById(R.id.password)).getText().toString();
        System.out.println("you entered email: " + email  + " and pass" + password );

        final HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("email", "obrien@gmail.com");
        ParseCloud.callFunctionInBackground("hello", params, new FunctionCallback<Object>() {
          public void done(Object response, ParseException e) {
            if (e == null) {
              Log.e("cloud code example", "response: " + response);

            }else{

            }
          }
        });
      }
    });

  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}

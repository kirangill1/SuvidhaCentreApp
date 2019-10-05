package com.example.suvidhacentreapp;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.widget.FrameLayout;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.android.volley.DefaultRetryPolicy;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;

        import org.json.JSONException;
        import org.json.JSONObject;

public class Statistics extends AppCompatActivity {
    TextView textView1, textView2,textView3, textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        textView1 = (TextView) findViewById(R.id.customers);
        textView2 =(TextView) findViewById(R.id.suvidha_centre);
        textView3 = (TextView)findViewById(R.id.distributor);
        textView4 = (TextView) findViewById(R.id.super_distributor);

        textView1.setText(getIntent().getStringExtra(""));
        textView2.setText(getIntent().getStringExtra("address_key"));
        textView3.setText(getIntent().getStringExtra("email_key"));
        textView4.setText(getIntent().getStringExtra("password_key"));
        get_values();

        JSONObject job = new JSONObject();
        try {
            job.put("username", user_id);
            job.put("", password);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jobjreq = new JsonObjectRequest(" http://reitindia.org/suraksha/login_user/login", job, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {

                    if (response.getString("key").equals("false")) {
                        Toast.makeText(Statistics.this, "check your user id", Toast.LENGTH_SHORT).show();
                    }
                    else if (response.getString("key").equals("true")) {
                        Toast.makeText(Statistics.this, "done", Toast.LENGTH_SHORT).show();

                        Intent i = new Intent(Statistics.this, FrameLayout.class);
                        startActivity(i);
                        finish();
                    }
                    else {
                        Toast.makeText(Statistics.this, "error", Toast.LENGTH_SHORT).show();

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                {
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println(error);

                    }
                });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(2000, 2, 2));

        AppController app = new AppController(Statistics.this);
        app.addToRequestQueue(jobjreq);

    }


}


    }
    }

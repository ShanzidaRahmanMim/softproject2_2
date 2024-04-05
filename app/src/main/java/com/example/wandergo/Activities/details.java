package com.example.wandergo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.wandergo.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class details extends AppCompatActivity {

    private ListView listView;
    private TextView tv;
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> types = new ArrayList<>();
    private ArrayList<String> locations = new ArrayList<>();
    private ArrayList<String> descriptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

       listView = findViewById(R.id.detailsListView);
        //tv=findViewById(R.id.tv);

        Intent intent = getIntent();
      //  int position = intent.getIntExtra("position", -1);
        String selectedname=intent.getStringExtra("selectedname");
        Log.e("check",selectedname);

        String selected = intent.getStringExtra("selected");
        String url="https://api.myjson.online/v1/records/2611eb8c-ca90-4d57-98fa-28980f2cf116";
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                parseJson(response,selectedname);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(stringRequest);


    }

    private void parseJson(String response,String selectedname) {

        Log.e("check2",selectedname);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonObject2=jsonObject.getJSONObject("data");
                    JSONArray jsonArray = jsonObject2.getJSONArray("locations");
                    Log.e("check3",selectedname);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        Log.e("check4",selectedname);
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String type = obj.getString("type");
                        String name = obj.getString("name");
                        String near="";
                        JSONArray hoteldetails=obj.getJSONArray("nearbyHotels");
//                        for (int j = 0; j < hoteldetails.length(); j++) {
//                            JSONObject obj2 = hoteldetails.getJSONObject(j);
//                            String nname=obj2.getString("name");
//                            String nrating=obj2.getString("rating");
//                           // String namenities=obj2.getString("amenities");
//
//                            JSONArray arr3 = obj2.getJSONArray("amenities");
//
//                            String animities="";
//                            for (int k = 0; k < arr3.length(); k++){
//                                animities=animities+arr3.getString(k)+"\n";
//
//                            }
//
//                            near="name: "+nname+"\n"
//                                    +"rating: "+nrating+"\n"+
//                                    "animities "+animities;
//                           names.add(near);
//
//                            }

                        if (name.equals(selectedname)) {


                            Log.e("final1",selectedname);

                           names.add(obj.getString("name"));
                           names.add(obj.getString("type"));
                           names.add(obj.getString("location"));
                           names.add(obj.getString("description"));
                         //   names.add(near);

                            for (int j = 0; j < hoteldetails.length(); j++) {
                                JSONObject obj2 = hoteldetails.getJSONObject(j);
                                String nname=obj2.getString("name");
                                String nrating=obj2.getString("rating");
                                // String namenities=obj2.getString("amenities");

                                JSONArray arr3 = obj2.getJSONArray("amenities");

                                String animities="";
                                for (int k = 0; k < arr3.length(); k++){
                                    animities=animities+arr3.getString(k)+"\n";

                                }

                                near="name: "+nname+"\n"
                                        +"rating: "+nrating+"\n"+
                                        "animities "+animities;
                                names.add(near);

                            }

                         //tv.setText(name);
                        Log.e("check5",name);
                           break;
                        }


                    }
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, names);
                    listView.setAdapter(arrayAdapter);



                } catch (JSONException e) {
                    e.printStackTrace();
                }



    }
}

package com.example.wandergo.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import com.example.wandergo.R;

import java.util.ArrayList;

public class BeachListActivity extends AppCompatActivity {
    private TextView Category ;
    private ListView listView;
    private ArrayList<String> beachNames = new ArrayList<>();
    private ArrayList<String> mountainNames = new ArrayList<>();
    private ArrayList<String> touristPlaceNames = new ArrayList<>();
    private ArrayList<String> forestNames = new ArrayList<>();
    private ArrayList<String> islandNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beach_list);
        Intent intent=getIntent();
        String selected = getIntent().getStringExtra("selected");

        Category = findViewById(R.id.Category) ;
        Category.setText(selected);

        listView = findViewById(R.id.list);
        extractData(selected);
//
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                String selectedLocation = (String) adapterView.getItemAtPosition(position);
//
//                // Check the type and open the appropriate activity
//                if (beachNames.contains(selectedLocation)) {
//                    openLocationActivity("Beach", selectedLocation);
//                } else if (mountainNames.contains(selectedLocation)) {
//                    openLocationActivity("Mountain", selectedLocation);
//                } else if (touristPlaceNames.contains(selectedLocation)) {
//                    openLocationActivity("Tourist Place", selectedLocation);
//                } else if (forestNames.contains(selectedLocation)) {
//                    openLocationActivity("Forest", selectedLocation);
//                } else if (islandNames.contains(selectedLocation)) {
//                    openLocationActivity("Island", selectedLocation);
//                }
//            }
//        });
    }

    public void extractData(String selected) {
        String url = "https://api.myjson.online/v1/records/2611eb8c-ca90-4d57-98fa-28980f2cf116";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonObject2=jsonObject.getJSONObject("data");
                    JSONArray jsonArray = jsonObject2.getJSONArray("locations");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String type = obj.getString("type");
                        String name = obj.getString("name");
                            if(type.equals("Beach"))
                            {
                                beachNames.add(name);
//                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, beachNames);
//                                listView.setAdapter(arrayAdapter);
                            }
                            else if (type.equals("Mountain"))
                            {   mountainNames.add(name);
//                            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mountainNames);
//                            listView.setAdapter(arrayAdapter);
                            }
                            else if (type.equals("Tourist Place"))
                            {   touristPlaceNames.add(name);
//                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, touristPlaceNames);
//                                listView.setAdapter(arrayAdapter);
                            }
                            else if (type.equals("Forest"))
                            {   forestNames.add(name);
//                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, forestNames);
//                                listView.setAdapter(arrayAdapter);
                            }
                            else if (type.equals("Island"))
                            {   islandNames.add(name);
//                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, islandNames);
//                                listView.setAdapter(arrayAdapter);
                            }
                        // Add names to the appropriate list based on the type
//                        switch (type) {
//                            case "Beach":
//                                beachNames.add(name);
//                                break;
//                            case "Mountain":
//                                mountainNames.add(name);
//                                break;
//                            case "Tourist Place":
//                                touristPlaceNames.add(name);
//                                break;
//                            case "Forest":
//                                forestNames.add(name);
//                                break;
//                            case "Island":
//                                islandNames.add(name);
//                                break;
//                        }
                    }


                    if(selected.equals("Beach"))
                    {

                               ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, beachNames);
                               listView.setAdapter(arrayAdapter);

                               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                   @Override
                                   public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                       String selectedName = (String) adapterView.getItemAtPosition(i);

                                       Intent intent=new Intent(BeachListActivity.this, details.class);
                                    //   intent.putExtra("position",i);
                                       intent.putExtra("selectedname",selectedName);
                                       startActivity(intent);




                                   }
                               });
                    }
                    else if (selected.equals("Mountain"))
                    {
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, mountainNames);
                        listView.setAdapter(arrayAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String selectedName = (String) adapterView.getItemAtPosition(i);

                                Intent intent=new Intent(BeachListActivity.this, details.class);
                                //   intent.putExtra("position",i);
                                intent.putExtra("selectedname",selectedName);
                                startActivity(intent);




                            }
                        });
                    }
                   else if (selected.equals("Tourist Place"))
                    {
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, touristPlaceNames);
                        listView.setAdapter(arrayAdapter);
                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String selectedName = (String) adapterView.getItemAtPosition(i);

                                Intent intent=new Intent(BeachListActivity.this, details.class);
                                //   intent.putExtra("position",i);
                                intent.putExtra("selectedname",selectedName);
                                startActivity(intent);




                            }
                        });
                   }
                    else if (selected.equals("Forest"))
                    {
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, forestNames);
                        listView.setAdapter(arrayAdapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String selectedName = (String) adapterView.getItemAtPosition(i);

                                Intent intent=new Intent(BeachListActivity.this, details.class);
                                //   intent.putExtra("position",i);
                                intent.putExtra("selectedname",selectedName);
                                startActivity(intent);




                            }
                        });
                    }
                    else if (selected.equals("Island"))
                    {
                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, islandNames);
                        listView.setAdapter(arrayAdapter);

                        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                String selectedName = (String) adapterView.getItemAtPosition(i);

                                Intent intent=new Intent(BeachListActivity.this, details.class);
                                //   intent.putExtra("position",i);
                                intent.putExtra("selectedname",selectedName);
                                startActivity(intent);




                            }
                        });
                    }


                    // Set up the initial adapter with all names
//                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, beachNames);
//                    listView.setAdapter(arrayAdapter);

                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Handle error response if needed
            }
        });

        requestQueue.add(stringRequest);
    }

//    private void openLocationActivity(String type, String name) {
//        Intent intent = new Intent(BeachListActivity.this, LocationActivity.class);
//        intent.putExtra("Type", type);
//        intent.putExtra("Name", name);
//        startActivity(intent);
//    }
    }

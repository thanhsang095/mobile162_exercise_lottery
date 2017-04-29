package com.developer.sangbarca.lotteryresult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

import static com.developer.sangbarca.lotteryresult.MainActivity.arrayNameProvince;
import static com.developer.sangbarca.lotteryresult.MainActivity.urlWebservice;

/**
 * Created by SANG BARCA on 4/29/2017.
 */

public class Fragment_1 extends Fragment {
    TextView txtDBvalue, txtGiai1value, txtGiai2value, txtGiai3value1, txtGiai3value2,
    txtGiai4value1, txtGiai4value2, txtGiai4value3, txtGiai4value4, txtGiai4value5, txtGiai4value6, txtGiai4value7,
            txtGiai5value, txtGiai6value1, txtGiai6value2, txtGiai6value3,
            txtGiai7value, txtGiai8value;

    String nameProvin;
    String date;

    public Fragment_1(String nameProvin, String date) {
        this.nameProvin = nameProvin;
        this.date = date;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        AnhXa(view);

        GetLotteryInfo(urlWebservice);
        return view;
    }
    public void GetLotteryInfo(String url){
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        final JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Iterator<String> iterator = response.keys();
                            while(iterator.hasNext()){
                                String key = iterator.next();
                                arrayNameProvince.add(key);
                            }
                            JSONObject jsonProvince = response.getJSONObject(nameProvin);
                            JSONObject jsonDate = jsonProvince.getJSONObject(date);

                            JSONArray jsonGiaiDB = jsonDate.getJSONArray("DB");
                            txtDBvalue.setText(jsonGiaiDB.getString(0));

                            JSONArray jsonGiai1 = jsonDate.getJSONArray("1");
                            txtGiai1value.setText(jsonGiai1.getString(0));

                            JSONArray jsonGiai2 = jsonDate.getJSONArray("2");
                            txtGiai2value.setText(jsonGiai2.getString(0));

                            JSONArray jsonGiai3 = jsonDate.getJSONArray("3");
                            txtGiai3value1.setText(jsonGiai3.getString(0));
                            txtGiai3value2.setText(jsonGiai3.getString(1));

                            JSONArray jsonGiai4 = jsonDate.getJSONArray("4");
                            txtGiai4value1.setText(jsonGiai4.getString(0));
                            txtGiai4value2.setText(jsonGiai4.getString(1));
                            txtGiai4value3.setText(jsonGiai4.getString(2));
                            txtGiai4value4.setText(jsonGiai4.getString(3));
                            txtGiai4value5.setText(jsonGiai4.getString(4));
                            txtGiai4value6.setText(jsonGiai4.getString(5));
                            txtGiai4value7.setText(jsonGiai4.getString(6));

                            JSONArray jsonGiai5 = jsonDate.getJSONArray("5");
                            txtGiai5value.setText(jsonGiai5.getString(0));

                            JSONArray jsonGiai6 = jsonDate.getJSONArray("6");
                            txtGiai6value1.setText(jsonGiai6.getString(0));
                            txtGiai6value2.setText(jsonGiai6.getString(1));
                            txtGiai6value3.setText(jsonGiai6.getString(2));

                            JSONArray jsonGiai7 = jsonDate.getJSONArray("7");
                            txtGiai7value.setText(jsonGiai7.getString(0));

                            JSONArray jsonGiai8 = jsonDate.getJSONArray("8");
                            txtGiai8value.setText(jsonGiai8.getString(0));



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonRequest);
    }
    private void AnhXa(View view){
        txtDBvalue = (TextView) view.findViewById(R.id.textViewDBvalue);
        txtGiai1value = (TextView) view.findViewById(R.id.textViewGiai1value);
        txtGiai2value = (TextView) view.findViewById(R.id.textViewGiai2value);
        txtGiai3value1 = (TextView) view.findViewById(R.id.textViewGiai3value1);
        txtGiai3value2 = (TextView) view.findViewById(R.id.textViewGiai3value2);
        txtGiai4value1 = (TextView) view.findViewById(R.id.textViewGiai4value1);
        txtGiai4value2 = (TextView) view.findViewById(R.id.textViewGiai4value2);
        txtGiai4value3 = (TextView) view.findViewById(R.id.textViewGiai4value3);
        txtGiai4value4 = (TextView) view.findViewById(R.id.textViewGiai4value4);
        txtGiai4value5 = (TextView) view.findViewById(R.id.textViewGiai4value5);
        txtGiai4value6 = (TextView) view.findViewById(R.id.textViewGiai4value6);
        txtGiai4value7 = (TextView) view.findViewById(R.id.textViewGiai4value7);
        txtGiai5value = (TextView) view.findViewById(R.id.textViewGiai5value);
        txtGiai6value1 = (TextView) view.findViewById(R.id.textViewGiai6value1);
        txtGiai6value2 = (TextView) view.findViewById(R.id.textViewGiai6value2);
        txtGiai6value3 = (TextView) view.findViewById(R.id.textViewGiai6value3);
        txtGiai7value = (TextView) view.findViewById(R.id.textViewGiai7value);
        txtGiai8value = (TextView) view.findViewById(R.id.textViewGiai8value);

    }
}

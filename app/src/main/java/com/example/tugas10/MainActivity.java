package com.example.tugas10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ListAdapter adapter;

    String API_KEY = "d650f837d25338f33a742f36fe36fd3e";
    String Language = "en-US";
    String Category = "popular";
    int Page = 1;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMovie); // Menyimpan referensi ke RecyclerView

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        CallRetrofit();
    }

    private void CallRetrofit() {
        API APIinterface = APIClient.getClient().create(API.class);
        Call<Movie> caller = APIinterface.getMovie(Category, API_KEY, Language, Page);
        caller.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                List<Movie> mList = response.body().getResults();
                adapter = new ListAdapter(MainActivity.this, mList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                t.printStackTrace();
                // Tambahkan penanganan kesalahan sesuai kebutuhan
            }
        });
    }
}

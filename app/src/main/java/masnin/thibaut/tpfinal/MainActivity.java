package masnin.thibaut.tpfinal;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import masnin.thibaut.tpfinal.Adapter.MyService;
import masnin.thibaut.tpfinal.Adapter.PaysAdapter;
import masnin.thibaut.tpfinal.Model.Pays;

public class MainActivity extends AppCompatActivity {

    private static String TAG = MainActivity.class.getSimpleName();
    private String API_BASE_URL = "https://restcountries.eu/rest/v2/all";
    private ArrayList<Pays> pays = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callWithAsyncTask();
        callWithRetrofit();

        PaysAdapter contactAdapter = new PaysAdapter(getApplicationContext());
        ListView listView = (ListView)this.findViewById(R.id.countryList);
        listView.setAdapter(contactAdapter);
    }

    private void callWithAsyncTask(){
        //Some url endpoint that you may have
        String myUrl = API_BASE_URL + "products";
        //String to place our result in
        String result;
        //Instantiate new instance of our class
        MyRequest getRequest = new MyRequest();
        //Perform the doInBackground method, passing in our url
        try{
            result = getRequest.execute(myUrl).get();
        }catch (Exception e){
            Log.e("joyPAD","error in request " + e.getLocalizedMessage());
        }
    }
    private void callWithRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        MyService service = retrofit.create(MyService.class);
        Call<List<Pays>> listProducts = service.getPays();
        listProducts.enqueue(new Callback<List<Pays>>() {
            @Override
            public void onResponse(Call<List<Pays>> call, Response<List<Pays>>
                    response) {
                pays.addAll(response.body());
                Log.d("joyPAD","on a retrouvé " + pays.size() + " produits");
            }
            @Override
            public void onFailure(Call<List<Pays>> call, Throwable t) {
            }
        });
        Call<List<Pays>> listProductsFromCat = service.getPays();
        listProductsFromCat.enqueue(new Callback<List<Pays>>() {
            @Override
            public void onResponse(Call<List<Pays>> call, Response<List<Pays>>
                    response) {
                Log.d("joyPAD","Réponse requête produits de catégorie : " + response.toString());
            }
            @Override
            public void onFailure(Call<List<Pays>> call, Throwable t) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy()");
    }
}
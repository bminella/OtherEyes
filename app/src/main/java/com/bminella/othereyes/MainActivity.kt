package com.bminella.othereyes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bminella.othereyes.Adapter.OtherEyesAdapter
import com.bminella.othereyes.Model.OtherEyesModel
import com.bminella.othereyes.Model.UnsplashQueryResult
import com.bminella.othereyes.api.ApiInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var otherEyesList = ArrayList<OtherEyesModel>()
    private lateinit var rvOtherEyes: RecyclerView
    private lateinit var adapter: OtherEyesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvOtherEyes = findViewById(R.id.rvOtherEyes)
        rvOtherEyes.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        adapter = OtherEyesAdapter(this, otherEyesList)
        rvOtherEyes.adapter = adapter

        otherEyesAssemble()

        val apiInterface = ApiInterface.create().getPhotosBySearch()

        //apiInterface.enqueue( Callback<List<Movie>>())
        apiInterface.enqueue( object : Callback<UnsplashQueryResult> {
            override fun onResponse(call: Call<UnsplashQueryResult>?, response: Response<UnsplashQueryResult>?) {

                if(response?.body() != null){
                    Log.d("test",response.body()!!.toString())
                    Log.d("test",response.body()!!.results.toString())
                    val url = response.body()!!.results[0].urls.small
                    Log.d("test",url)
                }
                //    recyclerAdapter.setMovieListItems(response.body()!!)
            }

            override fun onFailure(call: Call<UnsplashQueryResult>?, t: Throwable?) {

            }
        })



    }

    private fun otherEyesAssemble() {
        val photo1 = OtherEyesModel(R.drawable.cafe, "Café")
        otherEyesList.add(photo1)

        val photo2 = OtherEyesModel(R.drawable.campo, "Campo")
        otherEyesList.add(photo2)

        val photo3 = OtherEyesModel(R.drawable.carro, "Carro")
        otherEyesList.add(photo3)

        val photo4 = OtherEyesModel(R.drawable.cidade, "Cidade")
        otherEyesList.add(photo4)

        val photo5 = OtherEyesModel(R.drawable.homem, "Homem")
        otherEyesList.add(photo5)

        val photo6 = OtherEyesModel(R.drawable.mulher, "Mulher")
        otherEyesList.add(photo6)

        val photo7 = OtherEyesModel(R.drawable.pessoa, "Pessoa")
        otherEyesList.add(photo7)

        val photo8 = OtherEyesModel(R.drawable.praia, "Praia")
        otherEyesList.add(photo8)


    }
}
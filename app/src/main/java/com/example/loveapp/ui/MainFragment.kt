package com.example.loveapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.loveapp.APP
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentMainBinding
import com.example.loveapp.model.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClick()
        binding.history.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }

    private fun doRequest(firstName:String,secondName:String){
        APP.api.calculate(firstName,secondName).enqueue(object : Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                val list = arrayListOf(LoveModel(0,response.body()!!.firstName,response.body()!!.secondName,response.body()!!.percentage,
                    response.body()!!.result))
                val loveModel: LoveModel = response.body()!!
                APP.database.loveModelDao().insert(loveModel)
                val bundle = Bundle()
                bundle.putSerializable("result",loveModel)
                parentFragmentManager.setFragmentResult("love_model", bundle)
                findNavController().navigate(R.id.resultFragment, bundle)
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {

            }

        })
    }

    private fun onClick(){
        binding.lottieHeart.setOnClickListener {
            doRequest(binding.firstName.text.toString(),binding.secondName.text.toString())
        }
    }

}
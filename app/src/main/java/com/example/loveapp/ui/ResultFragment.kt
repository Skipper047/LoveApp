package com.example.loveapp.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.loveapp.APP
import com.example.loveapp.databinding.FragmentResultBinding
import com.example.loveapp.model.LoveModel
import java.util.*


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    private var lm : LoveModel? = null
    private var percent: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lm = arguments?.getSerializable("result") as LoveModel?
        lm?.firstName
        with(binding){
            firstName.text = lm?.firstName
            secondName.text = lm?.secondName
            percent = lm?.percentage?.toInt()
            tvResult.text = lm?.result

        }

        setupAnimation()

    }
    private fun setupAnimation(){
        val animation = binding.thirdLottie

        val handler = Handler()
        handler.postDelayed(Runnable {
            binding.lottieMain.visibility = View.GONE
            binding.secondLottie.visibility = View.VISIBLE
            val handler2 = Handler()
            handler2.postDelayed({
                binding.secondLottie.visibility = View.GONE
                binding.thirdLottie.visibility = View.VISIBLE
                when {
                    percent== 0 -> {
                        animation.cancelAnimation()
                    }
                    percent!! < 20 -> {
                        stopAnim(1000)
                    }
                    percent!! < 35 -> {
                        stopAnim(1500)
                    }
                    percent!! < 45 -> {
                        stopAnim(3000)
                    }
                    percent!! < 55 -> {
                        stopAnim(3500)
                    }
                    percent!! < 65 -> {
                        stopAnim(4500)
                    }
                    percent!! < 75 -> {
                        stopAnim(5000)
                    }
                    percent!! < 85 -> {
                        stopAnim(5800)
                    }
                    percent!! < 90 -> {
                        stopAnim(7000)
                    }
                    else -> {
                        stopAnim(8500)
                    }
                }
            }, 4000)
        }, 2000)


    }

    private fun stopAnim(time:Long){
        val animation = binding.thirdLottie
        val handler = Handler()
        handler.postDelayed({
            animation.cancelAnimation()
            allShow()
        },time)
    }

    private fun allShow(){
        binding.tvPercentage.text = percent.toString()
        binding.tvPercentage.visibility = View.VISIBLE
        binding.tvResult.visibility = View.VISIBLE
    }

}
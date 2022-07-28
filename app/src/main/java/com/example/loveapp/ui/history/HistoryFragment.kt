package com.example.loveapp.ui.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.loveapp.R
import com.example.loveapp.databinding.FragmentHistoryBinding
import com.example.loveapp.databinding.FragmentResultBinding
import com.example.loveapp.model.LoveModel


class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    private lateinit var adapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = HistoryAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        parentFragmentManager.setFragmentResultListener("love_model", viewLifecycleOwner){ requestKey,
                                                                                           bundle->
            val loveModel = bundle.getSerializable("result") as LoveModel
            adapter.addItem(loveModel)
        }

        binding.recycleView.adapter = adapter


    }

}
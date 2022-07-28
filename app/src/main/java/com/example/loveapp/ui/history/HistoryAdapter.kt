package com.example.loveapp.ui.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.loveapp.databinding.ItemHistoryBinding
import com.example.loveapp.model.LoveModel

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    private val list = arrayListOf<LoveModel>()
    inner class ViewHolder(private var binding: ItemHistoryBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(loveModel: LoveModel) {
            binding.tvFName.text = loveModel.firstName
            binding.tvSName.text = loveModel.secondName
            binding.tvResult.text = loveModel.result
            binding.tvPercentage.text = loveModel.percentage
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemHistoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount()= list.size
    fun addItem(loveModel: LoveModel) {
        list.add(loveModel)
        notifyDataSetChanged()
    }

    fun addItems(list: List<LoveModel>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }
}
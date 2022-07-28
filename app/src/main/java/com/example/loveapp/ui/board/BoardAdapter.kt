package com.example.loveapp.ui.board

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.loveapp.R
import com.example.loveapp.databinding.PagerBoardBinding
import com.example.loveapp.model.Board

class BoardAdapter(private val onClickStart: ()-> Unit) : RecyclerView.Adapter<BoardAdapter.ViewHolder>(){

    private val listBoard = arrayListOf<Board>(Board("Have a good time",
        "You should take the time to help those who need you"),
        Board("Cherishing love","it is now no longer possible for you cherish love"),Board("Lets play",
            "its Fun's and Many more"))

    inner class ViewHolder(private var binding: PagerBoardBinding)
        :RecyclerView.ViewHolder(binding.root){
        fun bind(board: Board) {
            with(binding){
                textTitle.text = board.title
                textDesc.text = board.Description
                when(position){
                    0-> lottieV.setAnimation(R.raw.on_the_garden_flower)
                    1-> lottieV.setAnimation(R.raw.wedding)
                    2-> lottieV.setAnimation(R.raw.love_anim)

                }

                if (position != listBoard.size-1){
                    btnStart.visibility = View.INVISIBLE
                }else {
                    btnStart.visibility = View.VISIBLE
                }
                btnStart.setOnClickListener {
                    onClickStart()
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PagerBoardBinding.inflate
            (LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listBoard[position])
    }

    override fun getItemCount()=listBoard.size
}
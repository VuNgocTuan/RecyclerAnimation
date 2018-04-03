package com.example.framgiavungoctuan.customview

import android.animation.ObjectAnimator
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateOvershootInterpolator
import android.widget.ImageView

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var mTexts = ArrayList<String>()

    init {
        for (i in 1..50) {
            mTexts.add("1")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent,
                false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mTexts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(mTexts[position])
        startAnimation(holder.itemView, position)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image_item)

        fun setData(text: String) {
            println("Text: " + text)
            if (text == "x"){
                image.setImageResource(R.drawable.manga_2)
            }
        }
    }

    fun removeItem(position: Int) {
        mTexts.removeAt(position)
        notifyItemRemoved(position)
    }

    fun addItem(text: String, position: Int) {
        mTexts.add(position, text)
        notifyItemInserted(position)
    }

    private fun startAnimation(itemView: View, position: Int) {
        val animator = ObjectAnimator.ofFloat(itemView, "translationY", 0f, 300 * (1 - position / 10.0f)
                , 0f)
        animator.interpolator = AnticipateOvershootInterpolator()
        animator.startDelay = 100
        animator.duration = 1000
        animator.start()
    }
}

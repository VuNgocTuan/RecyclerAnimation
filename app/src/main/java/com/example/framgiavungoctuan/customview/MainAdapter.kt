package com.example.framgiavungoctuan.customview

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnticipateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import android.view.animation.BounceInterpolator
import android.view.animation.TranslateAnimation
import android.widget.ImageView
import jp.wasabeef.recyclerview.animators.holder.AnimateViewHolder

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    private var mTexts = ArrayList<String>()

    init {
        mTexts.add("1")
        mTexts.add("2")
        mTexts.add("3")
        mTexts.add("4")
        mTexts.add("5")
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
        if (mTexts[position] == "x") {
            holder.image.setImageResource(R.drawable.manga_2)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), AnimateViewHolder {
        val image: ImageView = view.findViewById(R.id.image_item)

        override fun preAnimateAddImpl(holder: RecyclerView.ViewHolder?) {
            itemView.translationY = -itemView.height * 1.5f
        }

        override fun preAnimateRemoveImpl(holder: RecyclerView.ViewHolder?) {
            ViewCompat.setTranslationZ(itemView, -1f)
        }

        override fun animateAddImpl(holder: RecyclerView.ViewHolder?, listener: ViewPropertyAnimatorListener?) {
            ViewCompat.animate(itemView)
                    .translationY(0f)
                    .setInterpolator(AnticipateOvershootInterpolator())
                    .setDuration(500)
                    .setListener(listener)
                    .start()
        }

        override fun animateRemoveImpl(holder: RecyclerView.ViewHolder?, listener: ViewPropertyAnimatorListener?) {
            ViewCompat.animate(itemView)
                    .translationY(0f)
                    .alpha(0f)
                    .setInterpolator(AnticipateInterpolator())
                    .setDuration(600)
                    .setListener(listener)
                    .start()
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

    fun startAnimation(itemView: View) {
        itemView.translationY = 50f
        ViewCompat.animate(itemView)
                .translationY(0f)
                .setInterpolator(AnticipateOvershootInterpolator())
                .setDuration(500)
                .start()
    }
}

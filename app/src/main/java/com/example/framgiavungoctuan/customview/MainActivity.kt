package com.example.framgiavungoctuan.customview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import jp.wasabeef.recyclerview.animators.SlideInDownAnimator

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mButtonAnimation: Button
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButtonAnimation = findViewById(R.id.buttonAnimation)
        mButtonAnimation.setOnClickListener(this)
        mRecyclerView = findViewById(R.id.recyclerMain)
        mRecyclerView.layoutManager = LinearLayoutManager(this,
                LinearLayout.VERTICAL, false)
        mAdapter = MainAdapter()
        //item animator
        val animator = SlideInDownAnimator()
        mRecyclerView.itemAnimator = animator
        //animation adapter
        mRecyclerView.adapter = mAdapter
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.buttonAnimation -> {
//                mAdapter.removeItem(0)
                mAdapter.addItem("x", 0)
                mRecyclerView.scrollToPosition(0)
//                val itemView = mRecyclerView.findViewHolderForAdapterPosition(1).itemView
//                val itemViewSecond = mRecyclerView.findViewHolderForAdapterPosition(2).itemView
//                mAdapter.startAnimation(itemView)
//                mAdapter.startAnimation(itemViewSecond)

            }
        }
    }
}

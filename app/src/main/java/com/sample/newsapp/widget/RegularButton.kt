package com.sample.newsapp.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import butterknife.ButterKnife
import com.sample.newsapp.R

class RegularButton constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
  constructor(context: Context) : this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  //todo add support for changing button text and image
  init {
    val rootView = inflate(context, R.layout.partial_regular_button, this)
    ButterKnife.bind(this, rootView)
  }
}
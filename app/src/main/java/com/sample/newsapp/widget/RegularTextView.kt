package com.sample.newsapp.widget

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

open class RegularTextView constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
  AppCompatTextView(context, attrs, defStyleAttr) {

  constructor(context: Context): this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  init {
    if (!isInEditMode) {
      makeRegular()
    }
  }

  fun makeRegular() {
    val typeface = Typeface.createFromAsset(context.assets, "font/oswald_regular.ttf")
    setTypeface(typeface)
  }

  fun makeBold() {
    val typeface = Typeface.createFromAsset(context.assets, "font/oswald_semi_bold.ttf")
    setTypeface(typeface)
  }
}

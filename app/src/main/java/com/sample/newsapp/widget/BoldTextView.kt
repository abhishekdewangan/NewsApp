package com.sample.newsapp.widget

import android.content.Context
import android.util.AttributeSet

class BoldTextView constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
  RegularTextView(context, attrs, defStyleAttr) {
  constructor(context: Context): this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  init {
    if (!isInEditMode) {
      makeBold()
    }
  }

}

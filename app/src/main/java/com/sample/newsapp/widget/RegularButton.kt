package com.sample.newsapp.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import butterknife.BindView
import butterknife.ButterKnife
import com.sample.newsapp.R


class RegularButton constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {
  constructor(context: Context) : this(context, null)

  constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

  @BindView(R.id.img_btn)
  lateinit var buttonImage:AppCompatImageView

  @BindView(R.id.tv_button_text)
  lateinit var buttonText: RegularTextView

  init {
    val rootView = inflate(context, R.layout.partial_regular_button, this)
    ButterKnife.bind(this, rootView)
    val styleAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.RegularButton)
    val text = styleAttributes.getText(R.styleable.RegularButton_text)
    val image = styleAttributes.getResourceId(R.styleable.RegularButton_image, R.drawable.ic_arrow_forward)
    buttonImage.setImageResource(image)
    buttonText.text = text
  }
}
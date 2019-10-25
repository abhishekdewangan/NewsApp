package com.sample.newsapp.news_category

import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.sample.newsapp.R
import com.sample.newsapp.base.OnItemClickListener
import com.sample.newsapp.widget.RegularTextView
import news_category.view.NewsCategoryVM

class NewsCategoryItemViewHolder(
    view: View,
    val itemClickListener: OnItemClickListener<NewsCategoryVM>,
    val adapter: NewsCategoryRecyclerAdapter) : RecyclerView.ViewHolder(view) {
  init {
    ButterKnife.bind(this, view)
  }

  @BindView(R.id.tv_news_category)
  lateinit var newsCategoryText: RegularTextView
  @BindView(R.id.layout_news_category_item)
  lateinit var newsCategoryItemLayout: ConstraintLayout

  fun render(viewModel: NewsCategoryVM) {
    newsCategoryText.text = viewModel.name
    if (viewModel.isSelected) {
      newsCategoryText.setTextColor(ContextCompat.getColor(newsCategoryText.context, R.color.colorDarkBackground))
      newsCategoryItemLayout.background = ContextCompat.getDrawable(newsCategoryItemLayout.context, R.drawable.bg_round_solid_white_enable)
    } else {
      newsCategoryText.setTextColor(ContextCompat.getColor(newsCategoryText.context, R.color.colorGrey))
      newsCategoryItemLayout.background = ContextCompat.getDrawable(newsCategoryItemLayout.context, R.drawable.bg_round_solid_grey_disable)
    }
    newsCategoryItemLayout.setOnClickListener {
      itemClickListener.onItemClicked(adapter.getItem(adapterPosition))
    }
  }
}
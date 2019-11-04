package com.sample.newsapp.news_category

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.newsapp.R
import com.sample.newsapp.base.OnItemClickListener
import news_category.view.NewsCategoryVM

class NewsCategoryRecyclerAdapter(private val itemClickListener: OnItemClickListener<NewsCategoryVM>) : RecyclerView.Adapter<NewsCategoryItemViewHolder>() {
  private var categories = emptyList<NewsCategoryVM>()

  fun setData(categories: List<NewsCategoryVM>) {
    this.categories = categories
    Log.e("CategoryRecyclerAdapter", "categories size :: ${categories.size}")
    notifyDataSetChanged()
  }

  fun getItem(position: Int): NewsCategoryVM {
    return categories[position]
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCategoryItemViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.partial_news_category_item, parent, false)
    return NewsCategoryItemViewHolder(view, itemClickListener = itemClickListener, adapter = this)
  }

  override fun getItemCount(): Int {
    return categories.size
  }

  override fun onBindViewHolder(holder: NewsCategoryItemViewHolder, position: Int) {
    holder.render(categories[position])
  }
}
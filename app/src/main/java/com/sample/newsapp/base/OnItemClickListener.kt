package com.sample.newsapp.base

interface OnItemClickListener<in T: Any> {
  fun onItemClicked(item: T)
}
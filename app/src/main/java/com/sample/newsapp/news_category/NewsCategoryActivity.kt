package com.sample.newsapp.news_category

import android.content.Context
import android.widget.GridLayout.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import butterknife.BindView
import com.russhwolf.settings.AndroidSettings
import com.sample.newsapp.R
import com.sample.newsapp.base.BaseActivity
import com.sample.newsapp.base.OnItemClickListener
import com.sample.newsapp.widget.RegularButton
import constants.SharedPrefConstants.Companion.PREFERENCE_NAME
import kotlinx.coroutines.Dispatchers
import news_category.data.NewsCategoryRepoImpl
import news_category.view.NewsCategoriesVM
import news_category.view.NewsCategoryContract
import news_category.view.NewsCategoryPresenter
import news_category.view.NewsCategoryVM

class NewsCategoryActivity : BaseActivity(), NewsCategoryContract.View {

  @BindView(R.id.recycler_news_category)
  lateinit var newsCategoryRecycler: RecyclerView
  @BindView(R.id.btn_continue)
  lateinit var continueButton: RegularButton

  private lateinit var presenter: NewsCategoryContract.Presenter
  private lateinit var adapter: NewsCategoryRecyclerAdapter

  private fun setupPresenter() {
    val sharedPreferences = applicationContext
      .getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
    val coroutineScope = Dispatchers.Main
    presenter = NewsCategoryPresenter(NewsCategoryRepoImpl(AndroidSettings(sharedPreferences), coroutineScope))
  }

  override fun getLayoutId(): Int {
    return R.layout.activity_news_category
  }

  override fun onCreateFinished() {
    setupRecyclerView()
    setupPresenter()
    presenter.onStart(this)
  }

  override fun render(viewModel: NewsCategoriesVM) {
    adapter.setData(viewModel.categoriesVM)
  }

  private fun setupRecyclerView() {
    newsCategoryRecycler.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
    adapter = NewsCategoryRecyclerAdapter(object : OnItemClickListener<NewsCategoryVM> {
      override fun onItemClicked(item: NewsCategoryVM) {
        presenter.onCategorySelected(item.name)
      }
    })
    newsCategoryRecycler.adapter = adapter
  }
}
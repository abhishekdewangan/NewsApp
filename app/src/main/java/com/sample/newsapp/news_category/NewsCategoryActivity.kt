package com.sample.newsapp.news_category

import android.widget.GridLayout.VERTICAL
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import butterknife.BindView
import com.sample.newsapp.application.NewsApplication
import com.sample.newsapp.R
import com.sample.newsapp.base.BaseActivity
import com.sample.newsapp.base.OnItemClickListener
import com.sample.newsapp.widget.RegularButton
import news_category.view.NewsCategoriesVM
import news_category.view.NewsCategoryContract
import news_category.view.NewsCategoryVM
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class NewsCategoryActivity : BaseActivity(), NewsCategoryContract.View, KodeinAware {
  override val kodein = Kodein.lazy {
    extend((application as NewsApplication).kodein)
    import(NewsCategoryModule(coroutineContext).newsCategoryModule)
  }

  @BindView(R.id.recycler_news_category)
  lateinit var newsCategoryRecycler: RecyclerView
  @BindView(R.id.btn_continue)
  lateinit var continueButton: RegularButton

  private val presenter: NewsCategoryContract.Presenter by instance()

  private lateinit var adapter: NewsCategoryRecyclerAdapter

  override fun getLayoutId(): Int {
    return R.layout.activity_news_category
  }

  override fun onCreateFinished() {
    setupRecyclerView()
    presenter.onStart(this)
  }

  override fun render(viewModel: NewsCategoriesVM) {
    adapter.setData(viewModel.categoriesVM)
  }

  private fun setupRecyclerView() {
    newsCategoryRecycler.layoutManager = StaggeredGridLayoutManager(2, VERTICAL)
    adapter = NewsCategoryRecyclerAdapter(ItemClickListener())
    newsCategoryRecycler.adapter = adapter
  }

  inner class ItemClickListener : OnItemClickListener<NewsCategoryVM> {
    override fun onItemClicked(item: NewsCategoryVM) {
      presenter.onCategorySelected(item.name)
    }
  }
}
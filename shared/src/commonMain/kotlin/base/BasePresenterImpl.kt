package base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import paltfrom_expectations.appCoroutineContext
import kotlin.coroutines.CoroutineContext

abstract class BasePresenterImpl<in T: BaseView> : BasePresenter<T>, CoroutineScope {

  private val job = Job()
  private lateinit var view: BaseView

  override fun onStart(view: T) {
    this.view = view
  }

  override val coroutineContext: CoroutineContext
    get() = appCoroutineContext + job

  override fun onDestroy() {
    job.cancel()
  }

}
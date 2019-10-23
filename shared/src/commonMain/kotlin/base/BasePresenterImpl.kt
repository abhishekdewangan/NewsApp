package base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import paltfrom_expectations.appCoroutineContext
import kotlin.coroutines.CoroutineContext

abstract class BasePresenterImpl<T: BaseView> : BasePresenter<T>, CoroutineScope {

  private val job = Job()
  lateinit var view: T

  override suspend fun onStart(view: T) {
    this.view = view
    start()
  }

  override val coroutineContext: CoroutineContext
    get() = appCoroutineContext + job

  open suspend fun start() {

  }
  override fun onDestroy() {
    job.cancel()
  }

}
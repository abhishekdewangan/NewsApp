package base

import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

abstract class BasePresenterImpl<T : BaseView>(override val coroutineContext: CoroutineContext) : BasePresenter<T>, CoroutineScope {

  lateinit var view: T

  override fun onStart(view: T) {
    this.view = view
    start()
  }

  open fun start() {

  }

  override fun onDestroy() {

  }

}
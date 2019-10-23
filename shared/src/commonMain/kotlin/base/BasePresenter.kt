package base
interface BasePresenter<in T: BaseView> {
    fun onStart(view: T)
    fun onDestroy()
}
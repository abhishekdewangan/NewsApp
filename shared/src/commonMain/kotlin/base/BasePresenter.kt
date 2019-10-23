package base
interface BasePresenter<in T: BaseView> {
    suspend fun onStart(view: T)
    fun onDestroy()
}
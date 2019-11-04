package base

interface BaseView {
  fun showMessage(message: String)
  fun showError(error: Throwable)
  fun showLoader()
  fun hideLoader()
}
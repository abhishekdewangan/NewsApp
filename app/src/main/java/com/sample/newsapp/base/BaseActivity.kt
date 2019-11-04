package com.sample.newsapp.base

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import base.BaseView
import butterknife.BindView
import butterknife.ButterKnife
import com.sample.newsapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import platform_expectations.appCoroutineContext
import kotlin.coroutines.CoroutineContext

abstract class BaseActivity : AppCompatActivity(), BaseView, CoroutineScope {
  private val job = Job()
  override val coroutineContext: CoroutineContext = appCoroutineContext + job

  @BindView(R.id.view_loader)
  lateinit var loaderView: ProgressBar

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(getLayoutId())
    ButterKnife.bind(this)
    onCreateFinished()
  }
  open fun onCreateFinished() {

  }

  override fun showMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
  }

  override fun showError(error: Throwable) {
    Log.e("BaseActivity", error.message, error)
  }

  override fun showLoader() {
    loaderView.visibility = View.VISIBLE
  }

  override fun hideLoader() {
    loaderView.visibility = View.GONE
  }

  override fun onDestroy() {
    super.onDestroy()
    job.cancel()
  }

  abstract fun getLayoutId(): Int

}
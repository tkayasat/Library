package ImageConverter.main

import ImageConverter.interfaces.IMySchedulers
import ImageConverter.model.Converter
import ImageConverter.view.ImageConverterView
import android.net.Uri
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class ImageConverterPresenter(
    private val converter: Converter,
    private val schedulers: IMySchedulers,
    val router: Router
) : MvpPresenter<ImageConverterView>() {

    var disposables = CompositeDisposable()

    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    override fun onDestroy() {
        disposables.clear()
    }

    fun startConvertingPressed(imageUri: Uri) {

        viewState.btnAbortConvertEnabled()
        converter
            .convertRx(imageUri)
            .subscribeOn(schedulers.computation())
            .observeOn(schedulers.main())
            .subscribe(object : SingleObserver<Uri> {
                override fun onSubscribe(d: Disposable?) {
                    disposables.add(d)
                }

                override fun onSuccess(t: Uri?) {
                    if (t != null) {
                        onConvertingSuccess(t)
                    }
                }

                override fun onError(e: Throwable) {
                    onConvertingError(e)
                }
            })
    }

    private fun onConvertingSuccess(uri: Uri) {
        viewState.showConvertedImage(uri)
        viewState.btnAbortConvertDisabled()
    }

    private fun onConvertingError(e: Throwable?) {
        viewState.btnAbortConvertDisabled()
    }

    fun abortConvertImagePressed() {
        schedulers.shutdown()
        viewState.btnAbortConvertDisabled()
        viewState.signAbortConvertShow()
        schedulers.start()
    }

    fun originalImageSelected(imageUri: Uri) {
        viewState.showOriginImage(imageUri)
        viewState.btnStartConvertEnable()
    }
}
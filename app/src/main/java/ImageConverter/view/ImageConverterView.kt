package ImageConverter.view

import android.net.Uri
import moxy.MvpView

open class ImageConverterView :  MvpView {
    fun init() {}

    fun showOriginImage(uri: Uri) {}

    fun showConvertedImage(uri: Uri) {}

    fun btnStartConvertEnable() {}

    fun btnAbortConvertEnabled() {}

    fun btnAbortConvertDisabled() {}

    fun signAbortConvertShow() {}
}
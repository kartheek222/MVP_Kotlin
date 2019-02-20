package creativeminds.mvp

interface BaseView {

    //shows the progress to user
    fun showProgress()

    //dismiss the progress
    fun dismissProgress()

    //displaying internet error message to user
    fun showInternetError()

    //handling failure response
    fun onFailure(t: Throwable, request: Int)
}
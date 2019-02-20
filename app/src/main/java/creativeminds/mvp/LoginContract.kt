package creativeminds.mvp

import com.google.gson.JsonObject
import org.json.JSONObject

class LoginContract {

    interface View : BaseView {

        fun onLoginSuccess(login: JSONObject)
    }

    interface Presenter {
        fun doLogin(email: String, password: String)
    }
}
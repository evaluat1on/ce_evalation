package ce.evalution.ce_evaluation

import org.json.JSONObject

interface VolleyCallback {
    fun onSuccess(result: String)
    fun onSuccess(result: JSONObject)
}
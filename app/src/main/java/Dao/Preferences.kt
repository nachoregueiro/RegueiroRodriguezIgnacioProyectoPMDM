package Dao

import android.content.Context

class Preferences(val context: Context) {
    val NOMBREARCHIVO = "MiBaseDatos"
    val pref = context.getSharedPreferences(NOMBREARCHIVO, 0)

    fun guardar(token: String) {
        pref.edit().putString("token", token).commit()
    }

    fun sacarToken() : String? {
        return pref.getString("token", "")
    }
}
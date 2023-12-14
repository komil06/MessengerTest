package uz.ictschool.messengertest.data

import android.content.Context
import android.content.SharedPreferences

class UserRepository(context: Context) {
           private val shared: SharedPreferences by lazy{
                 context.getSharedPreferences(shared_users,Context.MODE_PRIVATE)
           }
           fun loadUsers():User?{
                 val userId = shared.getString(userId,null)?: return null
                 val userName = shared.getString(userName,null)?:return null
                 val userPhone = shared.getString(userPhone,null)?:return null
//                 val userToken = shared.getString(userToken,null)?:return null
                 val userImage = shared.getInt("user_image", userImage.toInt())

               return User(id = userId.toInt(), name = "$userName", photo = userImage, phoneNumber = "$userPhone" )
           }

        fun loadApiKey():String?{
            return shared.getString(api_key,null)
        }

    fun saveUsers(user: User){
          shared.edit()
              .putString(userId, userId)
              .putString(userName, userName)
              .putString(userPhone, userPhone)
              .putString(userImage, userImage)
              .apply()
    }
    fun clearUsers(){
           shared.edit()
               .clear()
               .apply()
    }


companion object{
const val shared_users = "User"
    private const val api_key = "api_key"
    const val userId = "user_id"
    const val userName = "user_name"
    const val userImage = "user_image"
//    const val userToken = "user_token"
    const val userPhone = "user_phone"
}
}
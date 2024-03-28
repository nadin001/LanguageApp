package com.example.languageapp.activities.profile

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.lifecycleScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.languageapp.Application
import com.example.languageapp.activities.base.BaseActivity
import com.example.languageapp.R.drawable.default_user_photo
import com.example.languageapp.R.string.profile_switch_to_dark
import com.example.languageapp.R.string.profile_switch_to_light
import com.example.languageapp.R.string.profile_welcome
import com.example.languageapp.database.UserInfo
import com.example.languageapp.databinding.ActivityUserProfileBinding
import com.example.languageapp.databinding.ActivityUserProfileBinding.inflate
import com.example.languageapp.activities.language.LanguageActivity
import com.example.languageapp.account.login.LoginActivity
import io.github.jan.supabase.gotrue.auth
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json.Default.decodeFromString

class UserProfileActivity : BaseActivity<ActivityUserProfileBinding>() {

    override val screenBinding: ActivityUserProfileBinding by lazy {
        inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val receivedDataJson = intent.getStringExtra("UserInfo")

        val userInfo = receivedDataJson?.let { decodeFromString<UserInfo>(it) }

        val isDark = resources.configuration.uiMode and
                Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES


        if (isDark) {
            screenBinding.btnSwitchTheme.text = getString(profile_switch_to_light)
        } else {
            screenBinding.btnSwitchTheme.text = getString(profile_switch_to_dark)
        }

        screenBinding.btnSwitchTheme.setOnClickListener {
            changeTheme(isDark)
        }

        screenBinding.tvUserWelcome.text = getString(profile_welcome, userInfo?.firstName)

        screenBinding.ivUserPhoto.load(userInfo?.userPhotoUrl) {
            fallback(default_user_photo)
            transformations(CircleCropTransformation())
        }

        screenBinding.btnChangeLanguage.setOnClickListener {
            changeLanguage()
        }

        screenBinding.btnLogout.setOnClickListener {
            logout()
        }

        setContentView(screenBinding.root)
    }

    private fun changeTheme(isDark : Boolean) {
        if (isDark) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }

    private fun changeLanguage() {
        val intent = Intent(this, LanguageActivity::class.java)
        intent.putExtra("ProfileChange", true)
        startActivity(intent)
    }

    private fun logout() {
        lifecycleScope.launch {
            Application.supabaseClient.auth.clearSession()
            Application.storage.saveString("SessionAccessToken", "")
            Application.storage.saveString("SessionRefreshToken", "")
            val intent = Intent(this@UserProfileActivity, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finishAffinity()
        }
    }
}
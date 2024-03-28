package com.example.languageapp.activities.language

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.languageapp.activities.base.BaseActivity
import com.example.languageapp.account.login.LoginActivity
import com.example.languageapp.databinding.ActivityLanguageSelectBinding
import com.example.languageapp.databinding.ActivityLanguageSelectBinding.inflate
import com.example.languageapp.activities.base.setLocale
import com.example.languageapp.activities.base.MainActivity

class LanguageActivity : BaseActivity<ActivityLanguageSelectBinding>() {

   override val screenBinding: ActivityLanguageSelectBinding by lazy {
        inflate(layoutInflater)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(screenBinding.root)

        val languages = listOf(
            LanguageItem("Russian"),
            LanguageItem("English"),
            LanguageItem("Chinese"),
            LanguageItem("Belarus"),
            LanguageItem("Kazakh"),
        )

        screenBinding.rvLanguageButtons.layoutManager = LinearLayoutManager(this)
        screenBinding.rvLanguageButtons.adapter = LanguageAdapter(languages) {
            languages.forEachIndexed { index, item ->
                item.isSelectActivity = index == it
            }
            screenBinding.rvLanguageButtons.adapter?.notifyDataSetChanged()
        }

        screenBinding.btnChooseLanguage.setOnClickListener {
            var id = -1
            var name = ""
            languages.forEachIndexed { index, item ->
                if (item.isSelectActivity) {
                    name = item.name
                    id = index
                }
            }
            if (id != -1) {
                val selectedLocale = when (name) {
                    "Russian" -> "ru"
                    "English" -> "en"
                    "Chinese" -> "ch"
                    "Belarus" -> "be"
                    "Kazakh" -> "ka"
                    else -> "en"
                }
                setLocale(selectedLocale, this)
                recreate()

                val isProfileChange = intent.getBooleanExtra("ProfileChange", false)
                if (!isProfileChange)  {
                    startActivity(Intent(this, LoginActivity::class.java))
                } else {
                    startActivity(Intent(this, MainActivity::class.java))
                }

                finish()
            }
        }

    }

}
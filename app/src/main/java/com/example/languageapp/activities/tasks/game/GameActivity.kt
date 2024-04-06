package com.example.languageapp.activities.tasks.game

import android.os.Bundle
import com.example.languageapp.activities.base.BaseActivity
import com.example.languageapp.databinding.ActivityGameBinding

class GameActivity : BaseActivity<ActivityGameBinding>() {

    override val screenBinding: ActivityGameBinding by lazy {
        ActivityGameBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(screenBinding.root)
    }
}
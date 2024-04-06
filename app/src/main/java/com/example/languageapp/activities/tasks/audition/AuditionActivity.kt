package com.example.languageapp.activities.tasks.audition

import android.os.Bundle
import com.example.languageapp.activities.base.BaseActivity
import com.example.languageapp.databinding.ActivityAuditionExerciseBinding

class AuditionActivity : BaseActivity<ActivityAuditionExerciseBinding>() {

    override val screenBinding: ActivityAuditionExerciseBinding by lazy {
        ActivityAuditionExerciseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(screenBinding.root)
    }
}
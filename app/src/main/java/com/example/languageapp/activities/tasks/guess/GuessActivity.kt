package com.example.languageapp.activities.tasks.guess

import android.os.Bundle
import com.example.languageapp.activities.base.BaseActivity
import com.example.languageapp.databinding.ActivityAnimalExerciseBinding

class GuessActivity : BaseActivity<ActivityAnimalExerciseBinding>() {

    override val screenBinding: ActivityAnimalExerciseBinding by lazy {
        ActivityAnimalExerciseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(screenBinding.root)
    }
}
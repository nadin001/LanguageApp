package com.example.languageapp.activities.tasks.texting

import android.os.Bundle
import com.example.languageapp.databinding.ActivityTextingExerciseBinding
import com.example.languageapp.activities.base.BaseActivity

class TextPracticeActivity : BaseActivity<ActivityTextingExerciseBinding>() {
    override val screenBinding: ActivityTextingExerciseBinding by lazy {
        ActivityTextingExerciseBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        screenBinding.btnAction.setText("Hm")
        screenBinding.rvWords.adapter = null


        screenBinding.tvEnglishVariant.text = "Скоро"
        screenBinding.tvTranscription.text = "Будет"

        setContentView(screenBinding.root)
    }
}
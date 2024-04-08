package com.example.languageapp.utils

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.languageapp.activities.base.isNameValid
import com.example.languageapp.activities.base.isPasswordValid
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UtilsTest {
    @Test
    fun isNameValidOk() {
        assertTrue(isNameValid("Kora"))
    }

    @Test
    fun isNameValidError() {
        assertFalse(isNameValid("123"))
    }

    @Test
    fun isPasswordValidOk() {
        assertTrue(isPasswordValid("12345678"))
    }

    @Test
    fun isPasswordValidError() {
        assertFalse(isPasswordValid("123"))
    }
}
package com.example.f1bingo.viewmodels.mainactivity

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.f1bingo.repository.RepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


private const val TAG = "MAHFVM"
@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    repository: RepositoryImpl
): ViewModel() {
    init {
        Log.d(TAG,"$repository")
    }

}
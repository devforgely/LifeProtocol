package com.devforgely.lifeprotocol.ui.morningprotocol

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devforgely.lifeprotocol.data.repository.QuestionRepository
import com.devforgely.lifeprotocol.domain.model.Question
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MorningProtocolViewModel @Inject constructor(
    private val repository: QuestionRepository
) : ViewModel() {
    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    private val _currentIndex = MutableStateFlow(0)

    val maxQuestions = 3
    // Expose only the current question to the UI
    val currentQuestion: StateFlow<Question?> = combine(_questions, _currentIndex) { list, index ->
        list.getOrNull(index)
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), null)

    val progress: StateFlow<Int> = _currentIndex
        .map { index -> index + 1 }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = 1
        )

    init {
        loadQuestions()
    }

    private fun loadQuestions() {
        viewModelScope.launch {
            val questions = repository.getQuestionsByType("vision")
            _questions.value = questions.shuffled().take(maxQuestions)
        }
    }

    fun moveToNext() {
        if (progress.value < maxQuestions) {
            _currentIndex.value += 1
        }
    }
}
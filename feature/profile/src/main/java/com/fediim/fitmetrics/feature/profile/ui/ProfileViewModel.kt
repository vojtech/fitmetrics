package com.fediim.fitmetrics.feature.profile.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fediim.fitmetrics.domain.model.Badge
import com.fediim.fitmetrics.domain.model.UserProfile
import com.fediim.fitmetrics.domain.usecase.GetUserBadgesUseCase
import com.fediim.fitmetrics.domain.usecase.GetUserProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class ProfileViewModel
@Inject
constructor(
    private val getUserProfile: GetUserProfileUseCase,
    private val getUserBadges: GetUserBadgesUseCase
) : ViewModel() {
    private val _state = MutableStateFlow(ProfileState())
    val state: StateFlow<ProfileState> = _state

    init {
        refresh(false)
    }

    fun refresh(force: Boolean) {
        _state.update { it.copy(isLoading = true, error = null) }
        viewModelScope.launch {
            val profileRes = getUserProfile(force)
            val badgesRes = getUserBadges(force)

            val profile = profileRes.getOrNull()
            val badges = badgesRes.getOrNull()
            val error = profileRes.exceptionOrNull()?.message ?: badgesRes.exceptionOrNull()?.message

            _state.update {
                it.copy(
                    isLoading = false,
                    profile = profile,
                    badges = badges ?: emptyList(),
                    error = error
                )
            }
        }
    }
}

data class ProfileState(
    val isLoading: Boolean = false,
    val profile: UserProfile? = null,
    val badges: List<Badge> = emptyList(),
    val error: String? = null
)

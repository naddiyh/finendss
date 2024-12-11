package com.unos.finends.features.bucket.addBucket

import androidx.lifecycle.ViewModel
import com.unos.finends.data.model.GoalsData

class GoalsViewModel : ViewModel() {


    fun createGoalData(
        goalType: String,
        titleText: String,
        titleRandom: String,
        goalAmount: String? = null,
        goalAmountRandom: String? = null,
        planPerInterval: String? = null,
        targetDate: String? = null,
        frequency: String,
        imageUrl: String? = null,
        category : String
    ): GoalsData? {
        return when (goalType) {
            "Random Add" -> createRandomAddGoal(
                titleRandom, goalAmountRandom, frequency, imageUrl, category
            )
            "Planned Out" -> createPlannedOutGoal(
                titleText, goalAmount, planPerInterval, targetDate, frequency, category
            )
            else -> null
        }
    }

    private fun createRandomAddGoal(
        titleRandom: String,
        goalAmountRandom: String?,
        frequency: String,
        imageUrl: String? = null,
        category : String
    ): GoalsData {
        return GoalsData(
            type = "Random Add",
            title = titleRandom,
            goalAmount = goalAmountRandom ?: "0",  // Fallback to "0" if null
            frequency = frequency,
            imageUrl = imageUrl,
            category = category
        )
    }

    private fun createPlannedOutGoal(
        titleText: String,
        goalAmount: String?,
        planPerInterval: String?,
        targetDate: String?,
        frequency: String,
        category: String,
        imageUrl: String? = null
    ): GoalsData {
        return GoalsData(
            type = "Planned Out",
            title = titleText,
            goalAmount = goalAmount ?: "0",  // Fallback to "0" if null
            planPerInterval = planPerInterval,
            targetDate = targetDate,
            frequency = frequency,
            imageUrl = imageUrl,
            category = category
        )
    }

}


package com.example.comp304_group7sec003_lab3.viewmodels
/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.comp304_group7sec003_lab3.database.schedule.AirSchedule
import com.example.comp304_group7sec003_lab3.database.schedule.AirScheduleDao
import kotlinx.coroutines.flow.Flow

class AirlineScheduleViewModel(private val airScheduleDao: AirScheduleDao): ViewModel() {

    fun fullSchedule(): Flow<List<AirSchedule>> = airScheduleDao.getAll()

    fun scheduleForAirlineName(name: String): Flow<List<AirSchedule>> = airScheduleDao.getByStopName(name)
}

class AirlineScheduleViewModelFactory(
    private val airScheduleDao: AirScheduleDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AirlineScheduleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AirlineScheduleViewModel(airScheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

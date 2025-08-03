package com.fediim.fitmetrics.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.fediim.fitmetrics.data.local.entity.BadgeEntity

@Dao
interface BadgeDao {
    @Query("SELECT * FROM badges ORDER BY name ASC")
    suspend fun getBadges(): List<BadgeEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(badges: List<BadgeEntity>)

    @Query("DELETE FROM badges")
    suspend fun clear()
}

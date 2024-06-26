package com.njhyuk.codi.core.price.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.time.LocalDateTime

@Entity
@Table(
    name = "brand_category_lowest_price",
    uniqueConstraints = [UniqueConstraint(columnNames = ["brand", "category"])]
)
data class BrandCategoryLowestPrice(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val brand: String,
    val category: String,
    var productNo: Long,
    var productPrice: Long,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

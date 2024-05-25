package com.njhyuk.codi.core.product.command

import com.njhyuk.codi.core.price.exception.NotExistsProductException
import com.njhyuk.codi.core.product.domian.ProductRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductDeleter(
    private val productRepository: ProductRepository
) {
    @Transactional
    fun delete(command: UpdateProductCommand) {
        val product = productRepository.findByIdOrNull(command.id)
            ?: throw NotExistsProductException()

        productRepository.delete(product)
    }
}

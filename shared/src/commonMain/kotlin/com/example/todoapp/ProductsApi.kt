package com.example.todoapp

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ProductsApi {
    fun testProduct() = Product(
        id = 1,
        title = "My Product",
        description = "My product description.",
        category = "Man",
        price = 100.0,
        image = ""
    )

    fun fetchProducts(limit: Int): Flow<RequestState> {
        return flow {
            emit(RequestState.Success(
                data = Products(listOf(testProduct()))
            ))
        }
    }
}
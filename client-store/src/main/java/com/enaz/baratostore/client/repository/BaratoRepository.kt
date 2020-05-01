//package com.enaz.baratostore.client.repository
//
//import com.enaz.baratostore.client.BaratoApiClient
//import com.enaz.baratostore.client.model.ProductResponse
//import com.enaz.baratostore.common.util.safeDispose
//import com.enaz.baratostore.database.dao.ProductDao
//import com.enaz.baratostore.database.entity.ProductEntity
//import io.reactivex.Completable
//import io.reactivex.Single
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.disposables.Disposable
//import io.reactivex.schedulers.Schedulers
//
///**
// * Created by eduardo.delito on 4/29/20.
// */
//interface BaratoRepository {
//
//    fun getProductResponse(): Single<ProductResponse>
//
//    fun getProductsFromDB(): Single<List<ProductEntity>>
//
//    fun insertDummyProducts(productList: List<ProductEntity>?)
//}
//
//class BaratoRepositoryImpl(
//    private val baratoApiClient: BaratoApiClient,
//    private val productDao: ProductDao
//) : BaratoRepository {
//
//    private var saveProductsDisposable : Disposable? = null
//
//    override fun getProductResponse(): Single<ProductResponse> {
//        TODO("Not yet implemented")
//    }
//
//    override fun getProductsFromDB(): Single<List<ProductEntity>> {
//        return productDao.getAllProducts()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//    }
//
//    override fun insertDummyProducts(productList: List<ProductEntity>?) {
//        saveProductsDisposable = Completable.fromCallable {
//            productDao.deleteProducts()
//            productList?.let {
//                productDao.saveProducts(it)
//                println("it==========${it.size}")
//            }
//        }
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//                saveProductsDisposable?.safeDispose()
//            }
//    }
//}

package com.bminella.othereyes.Model

data class UnsplashQueryResult(val total: Int, val total_pages: Int, val results:List<UnsplashImageModel>)

data class UnsplashImageModel(val id: String, val urls:UnsplashImageUrls)

data class UnsplashImageUrls(val small: String, val full: String,val raw: String,val thumb: String,val small_s3: String,val regular: String,)

data class OtherEyesModel(val image: Int, val name: String)
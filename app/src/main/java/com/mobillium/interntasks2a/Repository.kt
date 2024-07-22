package com.mobillium.interntasks2a

class Repository {

    fun getWeatherItem():ArrayList<Model>{
        return ArrayList<Model>().apply {
            add(Model(1, "İstanbul", "30°", "14°- 27°", "Güneşli", R.drawable.ic_sunny))
            add(Model(2, "Ankara", "26°", "14°- 27°", "Bulutlu", R.drawable.ic_cloudy))
            add(Model(3, "Erzurum", "23°", "14°- 27°", "Yağmurlu", R.drawable.ic_rainy))
            add(Model(4, "Sakarya", "31°", "14°- 27°", "Güneşli", R.drawable.ic_sunny))
        }
    }
}
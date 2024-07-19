package com.mobillium.interntasks2a

class Repository {

    fun getWeatherItem():ArrayList<Model>{

        val item =ArrayList<Model>()

        item.add(Model(1,"İstanbul","30°","14°- 27°","Güneşli",R.drawable.ic_sunny))
        item.add(Model(2,"Ankara","26°","14°- 27°","Bulutlu",R.drawable.ic_cloudy))
        item.add(Model(3,"Erzurum","23°","14°- 27°","Yağmurlu",R.drawable.ic_rainy))
        item.add(Model(4,"Sakarya","31°","14°- 27°","Güneşli",R.drawable.ic_sunny))

        return item
    }
}
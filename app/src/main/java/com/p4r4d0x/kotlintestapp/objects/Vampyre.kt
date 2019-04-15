package com.p4r4d0x.kotlintestapp.objects

open class Vampyre(name: String, hitPoints : Int = 20) : Enemy(name, hitPoints, 3) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage / 2)
    }

}
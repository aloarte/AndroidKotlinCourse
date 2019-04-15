package com.p4r4d0x.kotlintestapp.objects

class Weapon(val name: String, val damageInflicted: Int){
    override fun toString(): String {
        return "$name inflicts $damageInflicted points of damage"
    }
}

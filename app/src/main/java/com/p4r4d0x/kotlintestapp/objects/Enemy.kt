package com.p4r4d0x.kotlintestapp.objects

/**
 * Open makes a class extendable
 */
open class Enemy (val name: String, var hitPoints: Int , var lives: Int){
    open fun takeDamage(damage: Int){
         val remainingHitPoints = hitPoints - damage
        if (remainingHitPoints > 0 ){
            hitPoints = remainingHitPoints
            println("$name took $damage points of damage, and has $hitPoints left")
        }
        else {
            lives -= 1
            if (lives > 0){
                println("$name lost a life")
            }
            else {
                println ("Lives left: $lives")
            }
        }
    }

    override fun toString(): String {
        return "Name: $name, Hitpoints: $hitPoints, Lives: $lives"
    }
}
package com.p4r4d0x.kotlintestapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.p4r4d0x.kotlintestapp.objects.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun printPlayer() {

        var tim = Player("Tim The bad", 1, 3)
        val redPotion = Loot(
            "Red Potion",
            LootType.POTION,
            7.50
        )
        tim.setLoot(redPotion)
        val chestArmor = Loot(
            "+3 Chest Armor",
            LootType.ARMOR,
            80.00
        )
        tim.setLoot(chestArmor)
        tim.showInventory()
        tim.setLoot(
            Loot(
                "Ring of protection +2",
                LootType.RING,
                40.25
            )
        )
        tim.setLoot(
            Loot(
                "Invisibility Potion",
                LootType.POTION,
                35.95
            )
        )
        tim.showInventory()
        tim.dropLoot(redPotion)

        val connan = Player("Connan")
        connan.setLoot(
            Loot(
                "Invisibility",
                LootType.POTION,
                1.0
            )
        )
        connan.setLoot(
            Loot(
                "Mithril",
                LootType.ARMOR,
                2.0
            )
        )
        connan.setLoot(
            Loot(
                "Ring of speed",
                LootType.RING,
                3.0
            )
        )
        connan.setLoot(
            Loot(
                "Red Potion",
                LootType.POTION,
                4.0
            )
        )
        connan.setLoot(
            Loot(
                "Cursed Shield",
                LootType.ARMOR,
                5.0
            )
        )
    }

    fun printEnemies() {

        val uglyTroll = Troll("Ugly Troll")
        uglyTroll.takeDamage(8)

        val vlad = Vampyre("Vlad")
        vlad.takeDamage(8)

        val dracula = SuperVampire("Dracula")

        while (dracula.lives > 0) {
            if(dracula.dodges()){
                continue
            }
            if (dracula.runAway()) {
                println("Dracula run away")
                break
            } else {
                dracula.takeDamage(12)
            }
        }
    }


    fun playWithFors() {

        //for (i in 0..10) - from 0 to 10
        for (i in 0 until 10) { //from 0 to 9
            println("$i squared is ${i * i}")
        }
        for (i in 10 downTo 0 step 2) { //from 9 to 0 by 2|
            println("$i squared is ${i * i}")
        }
    }

    /**
     * This functions should print the numbers from 0 to 100 that are divisible by both 3 and 5
     */
    fun printDivisors() {
        for (value in 3..100 step 3) {
            if (value % 5 == 0) {

            }
        }
    }
}

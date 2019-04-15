package com.p4r4d0x.kotlintestapp.objects


class Player(val name: String, var level: Int = 1, var lives: Int = 3, var score: Int = 0) {
    var weapon: Weapon = Weapon("Fist", 1)
    private var inventory = ArrayList<Loot>()
    fun show() {
        var lifeState: String = when {
            lives < 3 -> "alive"
            else -> "dead"
        }
        println(lifeState)
    }

    fun showInventory() {
        var total = 0.0
        println("$name's inventory")
        for (item in inventory) {
            println(item)
            total += item.value
        }
        println("====================")
        println("Total score is $total")
    }

    fun setLoot(item: Loot) {
        inventory.add(item)
    }

    fun dropLoot(item: Loot): Boolean {
        return if (inventory.contains(item)) {
            inventory.remove(item)
            true
        } else {
            false
        }
    }

    fun dropLoot(name: String): Boolean {
        println("$name will be dropped")
        return inventory.removeIf { it.name == name }
    }

    override fun toString(): String {
        return """
            name: $name
            level: $level
            lives: $lives
            score: $score
            weapon: $weapon

        """
    }
}
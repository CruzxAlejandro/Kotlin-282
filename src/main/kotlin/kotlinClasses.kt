/************************************************************
 *  Name:         Alex Cruz
 *  Date:         2/14/23
 *  Assignment:   Kotlin Classes
 *  Class Number: CIS 282
 *  Description:
 ************************************************************/

class Person ( var firstName : String, var lastName : String, var age : Int, var hairColor : String, var eyeColor : String) {
    override fun toString(): String {
        return "PERSON: \n   firstName: ${firstName} \n   lastName: ${lastName} \n   age: ${age} \n   hairColor: ${hairColor} \n   eyeColor: ${eyeColor} "
    }
}



class Address ( var line1 : String, var line2 : String, var city : String, var state : String, var zip: Int) {
    override fun toString(): String {

        return "ADDRESS: \n   line1: ${line1} \n   line2: ${line2} \n   city: ${city} \n   state: ${state} \n   zip: ${zip}"
    }
}

class Character ( var name : String, var race : String, var hitPoints: Int, var gold : Int) {
    private var weaponInventory : MutableList<String> = mutableListOf()
    private var clothingInventory : MutableList<String> = mutableListOf()

    override fun toString(): String {
        var weaponStr = ""
        for (i in weaponInventory) {
        weaponStr += i + ", "
        }

        var clothingStr = ""
        for (i in clothingInventory) {
            clothingStr += i + ", "
        }

        weaponStr = weaponStr.trimEnd(' ').trimEnd(',')
        clothingStr = clothingStr.trimEnd(' ').trimEnd(',')

        return "CHARACTER: \n   name: ${name} \n   lastName: ${race} \n   hitPoints: ${hitPoints} \n   gold: ${gold} \n   weapons: ${weaponStr} \n   clothes: ${clothingStr}"
    }
    fun addWeapon (weapon_name : String) {
        weaponInventory.add(weapon_name)
    }

    fun dropWeapon (weapon_name: String) {
        weaponInventory.remove(weapon_name)
    }
    fun addClothing (item : String) {
        clothingInventory.add(item)
    }

    fun removeClothing(item: String) {
        clothingInventory.remove(item)
    }




}



fun main(){
    var alex = Person("Alex", "Cruz", 24, "Brown", "Brown" )
    println(alex)
    alex.age = 53
    alex.hairColor = "White"
    alex.eyeColor = "Blue"
    println(alex)

    var home = Address("19000 9th Ave", "Unit C", "Snohomish", "WA", 99605 )
    println(home)
    home.line2 = "Apt D42"
    home.city = "Spokane"
    home.zip = 98018
    println(home)

    var sora = Character("sora", "human", 2540, 5000)
    println(sora)
    sora.addWeapon("Keyblade")
    sora.addWeapon("Shield")
    sora.addClothing("Ring of magic")
    sora.addClothing("Backpack")
    println(sora)
    sora.dropWeapon("Keyblade")
    sora.addWeapon("Lightsaber")
    sora.removeClothing("Ring of magic")
    println(sora)

    var shrek = Character("shrek", "ogre", 10000, 10)
    println(shrek)
    shrek.addWeapon("Used pitchfork")
    shrek.addWeapon("Onion")
    shrek.addClothing("Full knight armor")
    println(shrek)

}





/*
Person Class:
Attributes: firstName, lastName, age, hairColor, eyeColor
Methods: getter and setter for each attribute (May be implied)
.toString() - print out a nice representation of the attributes of this person class

Address Class:
Attributes: line1, line2, city, state, zip
Methods: getter and setter for each attribute (May be implied)
.toString() - print out a nice representation of the attributes of this address class.


Character Class:
Attributes:  name, race, hitPoints, gold,
   weapons (MutableList of weapon names). NOT TO BE IN THE PARAMETER LIST
   clothing (MutableList of clothing item's names) NOT TO BE IN THE PARAMETER LIST
Methods: getter and setter for each attribute except for weapons and clothing
(Use the 4 methods below for setting/getting those attributes)
toString() - print out a nice representation of the attributes of this Character class
.addWeapon( weapon_name )
.dropWeapon( weapon_name )
.addClothing( item )
.dropClothing( item )
 */
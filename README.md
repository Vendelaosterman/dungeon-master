# Dungeon Heroes

Dungeon Heroes is a Java-based text-based role-playing game where players can create and control heroes, equip them with weapons and armor, and engage in battles.

## Features

- Create heroes of different classes (Barbarian, Wizard, Archer, Swashbuckler).
- Equip heroes with weapons and/or armor.
- Calculate hero attributes and damage based on equipped items.
- Engage in battles with calculated damage.
- Detailed command-line interface for interaction.

### Prerequisites

- Java Development Kit (JDK) installed (Java 8 or later).
- A Java Integrated Development Environment (IDE) such as IntelliJ IDEA or Eclipse.

### Installation

1. Clone the repository or download the ZIP file.
2. Open the project in your preferred Java IDE.
3. Build and run the application.

## Usage

### Creating Heroes

To create a new hero, instantiate a hero object of a specific class, such as Barbarian, Wizard, Archer, or Swashbuckler. Each hero class has its unique attributes and abilities.

//
Hero barbarian = new Barbarian("Anne");
Hero wizard = new Wizard("Tom");
// ... and so on

### Equipping Items
Heroes can equip weapons and armor items. Use the equip method to equip an item. Make sure the item is of the correct type and the hero meets the level requirement.

// 
Weapon staff = new Weapon(name: "staff", WeaponType: WeaponType.STAFFS, requiredLevel: 5, weaponDamage: 22);
barbarian.equip(staff)
// 

### Battles
To simulate battles, calculate the hero's damage based on equipped items and attributes. Use the damage method to get the calculated damage.

### Displaying Hero Information

The `display()` method is a fundamental feature of Dungeon Heroes that allows you to view comprehensive information about your hero. When invoked, this method prints out the hero's details, including their name, class, level, attributes, equipped items, total attributes, and calculated damage.

//
hero.display();
//

## Authors

@VendelaOsterman
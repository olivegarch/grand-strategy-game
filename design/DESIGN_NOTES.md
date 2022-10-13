This is a document to store the parts of the game that I want to have, so that I have a clear idea of what I want to implement. It’s always easier to write up code and debug problems when I have a clear vision of the final product, so this is where that vision is recorded.
# Armies
## Actions:
    The user can type out actions to move armies

### Move

    Armies can move between provinces that are neighbors.

Armies can move to distant provinces, and they will move there using the shortest possible path.
If there are multiple shortest possible paths, the army will take the one that provides the greater defensive bonus.
If there are multiple shortest possible paths with the same defensive bonus, the army will randomly select a path.
Armies can move to distant provinces with defined intermediate steps. The army will move to the first location and then to the second location, 
following the shortest possible path in both movements.

  ![army movement example](C:\Users\alexv\IdeaProjects\Personal\GrandStrategy\design\Army_Movement_Example.jpg)
  > Ex. Even though the shortest path from Forest to City is through Hills, 
  > an army might want to avoid participating. 
  > 
  > To move _around_ the battle, the user can declare “move plains city” 
  > and the army would move using the shortest path to Plains, 
  > then move using the shortest path to City, bypassing the battle in Hills

###Attack
    Armies can attack other armies in provinces

Armies will attack enemy armies if they share the same province.
Multiple friendly armies can attack multiple enemy armies.
Armies can retreat from battles
Attackers: Retreating is free and has no penalty.
Defenders: Retreating takes ½ a day’s worth of damage before retreating.
If an Army is fighting in a battle, then they have the option to retreat from the battle into an unoccupied or friendly-occupied province.
If an Army attacks an enemy Army while they are in the middle of moving, then the enemy Army stops moving and starts the battle as the defender. allowing the attacking army to deal a 1 day’s worth of damage before the battle starts.

### Support
    Armies can support other friendly Armies that are in the middle of a battle

Attacking: Supporting an attacking Army gives a buff to damage dealt.
Defenders: Supporting a defending Army gives both a buff to damage reduction and damage dealt (though not as large as the supported attack buff).
Armies can support other friendly Armies in movement, moving together alongside the moving Army.
The movement speed is reduced (based on the supporting army’s strength), but if the moving army is attacked, the supporting army participates in the battle.

### Recover 
*[Change to “Encamp”, also acts as a defensive stance alongside recovering strength]*

    Armies can recover their strength by resting in a town or city.
Multiple armies can rest in a city, but at a reduced rate.
City: Can recover up to 3 armies at once.
Town: Can recover up to 2 armies at once.
Province: Can recover only 1 army at once

## Properties:
    Armies have properties that stores information about it


### Name
The name of the army. 

### Active 
If true: the army is currently doing an action 

If false: the army is not currently doing an action; idle

### Health
A culmination of the number of and health of all soldiers in the army. 

### Strength
The battle power of an army, used to determine attack and defense

### Speed
How fast an army moves between provinces. 

# Provinces

## Properties

### Neighbors
Each province has neighbors that border it.
Each border has a movement cost associated with moving between those provinces. 

### Terrain
Each Province has a terrain.
The terrain affects how fast armies move through the Province. 

### Infrastructure
Each Province has infrastructure. 
The infrastructure affects how many Armies can recover in the Province at one time. 
Game Ends

# Game Modes
## Deathmatch
Description:
Players fight in open combat
Win Conditions:
When one player’s armies are completely eliminated, then the remaining player is victorious
## King of the Hill
Description:
Players fight for control of a single location
Win Conditions:
When one player hold the “Hill” for a defined length of time, then that player is victorious
## Attack/Defend
Description:
One player is the “attacker” and has a limited amount of time to complete an objective. The other player is the “defender”.
Win Conditions:
If the attacker achieves the defined objective within the time limit, then they are victorious, otherwise the defender is victorious. 

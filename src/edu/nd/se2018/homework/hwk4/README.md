#Design Rationale

I think my design does a good job of solving the problem in a relatively easy, efficient way. I used hashsets to store point locations of the ship and the pirateships. I separated the problem into four main classes: `OceanExplorer`, `OceanMap`, `Ship`, and `PirateShip`. `OceanExplorer` contains the methods for initializng the JavaFx window. `OceanMap` has methods for drawing the initial map and containers for storing pirateship location. `Ship` is an observable object and contains for moving the ship object within the window. `PirateShip` is an observer object which receives updates from `Ship`. These updates come in the form of a point object. The new point is used to determine updated positions for the ship through the `java.math` library. Overall, the approach works very well and provides ample opportunities to debug and periodically examine values. However, one shortcoming is a lack of data protection. I am still learning how Java utilizes data hiding and that is something I would definitely implement more uniformly if I were to redo this project. Moreover, I would move some of the methods from `OceanExplorer` to `PirateShip` to prevent `OceanExplorer` from becoming too encompassing.

For the implementation of the first stretch feature, I would modify `OceanExplorer` to add a button to the window along with a handler. When the button is pushed. The map would be redrawn, generating a new group of islands and pirateships. For the second stretch feature, we can utilize the existing 2-D array `oceanGrid` to flag open ocean areas to be filled with an image of the ocean  and island rects to be filled with an image of an island. The actual addition of the ImageViews to the `ObervableList` would be done in `OceanExplorer`.
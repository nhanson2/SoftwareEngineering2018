Design Rationale

For my solution to this problem, I used an object oriented design pattern.
I implemented the strategy as a set of inherited classes. The "strategy" 
class was an abstract base class with undefined methods and variables. The three
different strategies extend the base class. I only used one method within the strategies
which took in the distance the horse had run and returned a new "effort" value based on it.
I also implemented a horse class, of which there was an instance of for every horse registered
for the race. I implemented the various getter/setter methods as well as a method to take a  
"time" interval and updated the distance run, as well as the horse's speed. The race class will
manage the enrollment and execution of the race. The horse objects are stored in a
Java ArrayList, since this list can be dynammically sized to the number of horses in the race.
I have two control loops: A for nested inside a while loop. The for loop
updates the position and speed of each of the horses. The while loop continues until
the function returns when a winner is chosen. 
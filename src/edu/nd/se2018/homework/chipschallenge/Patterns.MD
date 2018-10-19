Pattern 1:

Pattern Name: Singleton
Class Name: ChipMan
Role in Pattern: Single instance of Chip Character
Purpose: Prevent multiple instances of Chip from being created and return references
to the original chip

Pattern 2:

Pattern Name: Composite
Class Name(1): Level
Role in Pattern(1):
Class Name(2): Part, Whole
Role in Pattern(2): Part, Whole
Purpose: Allow the Levels and Chip instances to easily interact

Pattern 3:

Pattern Name: Observer
Class Name(1):Portal
Role in Pattern(1): Observer
Class Name(2): Gate
Role in Pattern(2): Observable
Purpose: Allows for gate tokens to enable transportation to the next stage of the game
one they gate has been "unlocked"
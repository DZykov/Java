1) Variables

class Environment (integers):

SCALE: length and width of squares
WIDTH: number of squares in width
HEIGHT: number of squares in height
POPULATION: number of individuals in first population
DIED: number of individuals who are died 
SPEED: number of commands per 1 second (must be bigger than 1)
GENERATION: how many generations were created
HEALTH_APPLE: the amount of health which apple gives (recomended to be positive)
HEALTH_POSION: the amount of health which posion gives (recomended to be negative)
POINTS_APPLE: points of fitness per apple
POINTS_POISON: points of fitness per poison
AMOUNT_APPLE: the maximum amount of apples oh the field
AMOUNT_POISON: the maximum amount of poison oh the field
COUNTS: counting how many loops were ran (using to calculate time)
TIME_GEN: how many seconds current population is alive
TIME: how many seconds GA is running
run: crunch to create an information window in first run
gene_number: taking a gene from a chromosome

class FitnessCalc (int arrays):
solution: storing our solution (if setted)

class Individual (integers):

defaultGeneLength: length of the gene
direction: dirction of move
health: the amount of health per individual
xPos: coordinate of x (horizontal)
yPos: coordinate of y (vertical)
xPosPrev: previous position of x
yPosPrev: previous position of y
apple_COUNT: how many apples individual ate
poison_COUN: how many poison individual ate
STEP (final): size of an individual's step (should be equal to SCALE)
fitness (private): storing points of fitness

class Individual (int arrays):
genes (private): storing genes of an individual 

class Individual (booleans):
food
posion
wall

class Algorithm (integers):
tournamentSize: the amount of individuals in tournament

class Algorithm (doubles):
uniformRate: possibilty of uniform
mutationRate: possibility of mutation

class Algorithm (booleans):
eletism

class Population (individual array):
individuals: stroring all individuals

class Apples (integers):
SCALE (final): size of an apple (should be equal to SCALE)
xPos: x position of apple
yPos: y position of apple

class Poison (integers):
SCALE (final): size of a poison (should be equal to SCALE)
xPos: x position of poison
yPos: y position of poison

class HorizontalWall (integers):
xPos: x position of the beginning of a wall
yPos: y position of the beginning of a wall
endX: ending of x position of a wall

class VerticalWall (integers):
xPos: x position of the beginning of a wall
yPos: y position of the beginning of a wall
endY: ending of y position of a wall

2) Graphics
All objects suppose to be in a special order, otherwise we won't be able to see all objects properly
(Java draws object on other objects, because of that order ia important)
	1) colour background
	2) colour all individuals
	3) draw lines
	4) draw walls (drawing walls before apples, and poison, because if apple or poison are going to be on a wall, Java will draw it, 
	and then redraw it due to the code)
	5) draw apples
	6) draw poison

3) Gene commands
0 - move up
1 - move right
2 - move down
3 - move left
4 - look up by 3 squares
5 - look right by 3 squares
6 - look down by 3 squares
7 - look left by 3 squares

4) GA (short description)
brain of individuals:
	Right know, individuals have no idea about walls, and how to properly see apples and poison, due to the lack of my code. (it 	
	is more correct to say "due to the fact of my laziness"). Due to the fact that individuals have no idea about walls, and how to 
	properly see apples and poison, best solution for this current problem is stay on the same spot, do not move. So, gene is going 
	to contain only "look" commands. *GA find this solution. It took 1867 generations (approximately 16-17 hours). Probably, it    	
	could be faster or slowly. It depends on a luck of a mutation. Mutation is the main force of GA*

function FitnessCalc.setSolution("integer with length of 32")
	If FitnessCalc.setSolution("int") was setted, GA is going to work qucker, but GA will give only one solution (our solution.it 	
	will be find approximately in 400-500 generations). Also, if FitnessCalc.setSolution("int") was setted, line 34 in java 	
	FitnessCalc have to be uncommented. If not, it will have no impact.
	If FitnessCalc.setSolution("int") was not setted *FitnessCalc.setSolution("")*, GA is going to work slow, but GA will give 	
	more solutions (first solution will be find approximately in 1700-2000 generations). Also, if FitnessCalc.setSolution("int") was 
	not setted, line 34 in java FitnessCalc have to be commented. If not, it will have an error      				
	(java.lang.arrayindexoutofboundsexception).








































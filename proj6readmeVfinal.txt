Readme Project 6

-----------------------------------------------------------------------------------------------------------------------------------------------------

The following readme pertains to a program to make simple animations. It provides an overview of the interfaces IModel and Shape, and the classes
IModelImpl, AbstractShape, Circle, Oval, Rectangle, Point2D, Color, Ticker, and Transormation. For each class, its purpose is described, the data
it contains is given, and its constructor, getter, and mutator methods are described.

This program supports animations made with shapes of three types - Circle, Oval, and Rectangle. It allows shapes to change size, color, and position.
The program tracks these changes and can provide a readable transformation history.

-----------------------------------------------------------------------------------------------------------------------------------------------------


Interface IModel
- Represents the animation cs5004.animator.model object
- Declares methods necessary to the animation cs5004.animator.model implementation


Class IModelImpl
- Implements methods declared in IModel interface
- Contains data:
	- List of shapes in animation (Shape)
	- Count of shapes in animation (Int)
- Methods allow object to:
	Mutate:
	 - Add and remove shapes from animation 
	Get:
	 - A specified shape
	 - A list of shapes a specified time (method uses class ShapeTimeComparator)
	 - A count of shapes in animation
	 - A string representation of the animation 


-----------------------------------------------------------------------------------------------------------------------------------------------------

The following are the types that compose IModel objects

Interface Shape
- Represents a shape object
- Declares methods necessary to the class AbstractShape and its child classes Circle, Oval, and Rectangle


Class AbstractShape
- Implements the methods declared in the Shape interface
- Contains data:
	- Reference point (Point2D)
	- Color (Color)
	- Time (Ticker)
	- ShapeType (ShapeType, an enumeration with values CIRCLE, RECTANGLE, and OVAL)
	- A list tracking the transformations of the shape (Transformation)
- Constructor method takes arguments for the:
	- X coordinate and Y coordinate (double, double)
	- Red, green, and blue values (int, int, int)
	- Time shape appears and disappeares (int, int)
	- Name (String)
- Methods allow object to:
	Mutate:
	 - Color and position
	Get:
	 - X and Y coordinates; distance from the origin
  	 - Red, green, and blue values
	 - Appeareance and disappeareance times
	 - Name
	 - Area and perimeter
	 - Shape type and a string representation of the shape


Class Circle
- Extends AbstractShape
- Contains additional data: radius (double)
- Contructor method takes additional argument: radius (double) 
- Methods give additional ability to: get radius 


Class Oval
- Extends AbstractShape
- Contains additional data: radiusX and radiusY (double, double)
- Contructor method takes additional arguments: radiusX and radiusY (double, double) 
- Methods give additional ability to: mutate size/radii 


Class Rectangle
- Extends AbstractShape
- Contains additional data: width and height (double, double)
- Contructor method takes additional arguments: width and height (double, double) 
- Methods give additional ability to: get width and height


-----------------------------------------------------------------------------------------------------------------------------------------------------

The following type composes Shape objects and in turn is composed by Shape objects

Class Transformation
- Represents a Transformation object, the type that is contained in Shape objects in a list tracking shape transformations
- A Transformation object tracks a transformation of a single shape. It can represents shapes of all types (Circle, Oval, Rectangle).
- Contains data:
	- Shape object (Shape)
	- Tranformation type (TransformationType, an enum with values SIZE, COLOR, MOVE)
	- New width and new height if Rectangle (double, double)
	- RadiusX and radiusY if Oval, radius if Circle (double, double, double)
	- Start and end locations (Point2D, Point2D)
	- Start and end colors (Color, Color)
	- the period of time for a color change and/or size change and/or location change (Ticker, Ticker, Ticker)
- Constructor method:
	For changing Rectangle height, width, location, and/or color takes arguments:
		- Shape and transformation type (Shape, TransformationType)
		- New height, new width, start location, and end location (double, double, Point2D, Point2D)
		- Size change period (Ticker)
		- Start and end colors (Color, Color)
		- Color change period (Ticker)
	For changing Oval size, color, and/or location takes arguments:
		- Shape and transformation type (Shape, TransformationType)
		- Start location and end location (Point2D, Point2D)
		- Size change period (Ticker)
		- Start and end colors (Color, Color)
		- Color change period (Ticker)
		- New radius X and radius Y (double, double)
	For changing Circle size, color, and/or location takes arguments: 
		- Shape and transformation type (Shape, TransformationType)
		- Start location and end location (Point2D, Point2D)
		- Size change period (Ticker)
		- Start and end colors (Color, Color)
		- Color change period (Ticker)
		- New radius (double)
	For changing color alone takes arguments:
		- Shape and transformation type (Shape, TransformationType)
		- New red, green, and blue values (int, int, int)
		- Start and end times (int, int)
	For changing location alone takes arguments:
		- Shape and transformation type (Shape, TransformationType)
		- New x and y coordinates (double, double)
		- Start and end times (int, int)
- Methods allow object to:
	Get:
	 - Starting X and Y coordinates, ending X and Y coordinates 
	 - Starting time and ending time 
	 - Starting color and ending color 
	 - Color change start time and end time 
	 - A string representation of the transformation 


-----------------------------------------------------------------------------------------------------------------------------------------------------

The following are the types that compose both Shape objects and Transformation objects

Class Point 2D
- Represents a point in cartesian coordinates
- Contains data:
	- x coordinate (double) 
	- y coordinate (double)
- Constructor method takes arguments for:
	- X coordiate and y coordinate (double, double)
- Methods allow object to:
	Get:
	 - Distance to the origin
	 - X coordinate and Y coordinate 
	Mutate:
	 - X coordinate and Y coordinate


Class Color
- Reperesents a color an an RGB value
- Contains data:
	- Red (int)
	- Green (int)
	- Blue (int)
- Constructor method takes arguments for:
	- Red, green, and blue (int, int, int)
- Methods allow object to:
	Get: 
	 - Red, green, and blue
	 - String representation of color



Class Ticker
- Represents a length of time
- Contains data:
	- Start range (int) 
	- End range (int) 
- Constructor method takes arguments for:
	- Start and end ranges (int, int)
- Methods allow object to:
	Get:
	 - Start and end ranges


END 

-----------------------------------------------------------------------------------------------------------------------------------------------------
	



	
	
	
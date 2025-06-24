# Heim & Leben - Interactive Floor Planning Application

A comprehensive Java-based floor planning application that enables users to design and visualize residential floor plans through an intuitive drag-and-drop interface[1][2]. Built with Java Swing, this application provides a complete toolkit for creating detailed floor plans with rooms, furniture, fixtures, and architectural openings.

---

## 1. Project Overview

Heim & Leben (German for "Home & Life") is a desktop application designed to simplify the process of floor plan creation and interior design visualization[2]. The application combines the precision of grid-based placement with the flexibility of free-form design, allowing users to create detailed floor plans that accurately represent their living spaces.

The project demonstrates object-oriented programming principles while delivering a practical tool for homeowners, interior designers, and architects who need to visualize spatial arrangements before implementation.

---

## 2. Technology Stack and Language

The application is built entirely in **Java**, leveraging the robust Swing framework for GUI development[2]. This choice provides several advantages:

  - **Platform Independence**: Runs on any system with Java Runtime Environment
  - **Rich GUI Components**: Utilizes Swing's comprehensive widget library
  - **Event-Driven Architecture**: Implements responsive user interactions through event listeners
  - **Layered Rendering**: Uses JLayeredPane for sophisticated visual layering of components

The codebase follows Java best practices with clear method separation, proper exception handling, and comprehensive user input validation[2].

---

## 3. Repository Structure

The project maintains a clean, organized structure that separates code from assets effectively[1][3]:

```
oops-project/
├── images/                    # Visual assets directory
│   ├── bathtub.png           # Bathroom fixtures
│   ├── bed.png               # Bedroom furniture
│   ├── chair.png             # Seating furniture
│   ├── couch.png             # Living room furniture
│   ├── commode.png           # Bathroom fixtures
│   ├── dining_set.png        # Dining room furniture
│   ├── horizontalDoor.png    # Architectural openings
│   ├── horizontalWindow.png  # Architectural openings
│   ├── image.png             # Application logo
│   ├── logo.png              # Branding assets
│   ├── sink.png              # Kitchen fixtures
│   ├── stove.png             # Kitchen appliances
│   ├── table.png             # General furniture
│   ├── verticalDoor.png      # Architectural openings
│   ├── verticalWindow.png    # Architectural openings
│   └── washbasin.png         # Bathroom fixtures
├── FloorPlanner.java         # Application entry point
├── Grid.java                 # Main application logic
├── Grid.class                # Compiled Java class
├── .gitignore                # Git ignore rules
└── README.md                 # Project documentation
```

  - **Modular Asset Organization**: All visual elements are centralized in the images directory, making asset management straightforward
  - **Clean Code Separation**: Core logic is contained in dedicated Java files with clear responsibilities
  - **Scalable Structure**: The organization supports easy addition of new furniture types and features

---

## 4. Core Architecture and Design Highlights

The application employs a sophisticated multi-layered architecture that enables complex visual interactions while maintaining code clarity[2]:

### 4.1 Layered Rendering System

  - **Base Grid Layer**: Provides the foundational coordinate system with a 30x75 grid
  - **Room Layer**: Handles room rendering with color-coded visualization
  - **Furniture Layer**: Manages movable furniture and fixture placement
  - **Openings Layer**: Renders doors and windows with proper wall attachment
  - **UI Layer**: Contains the top navigation strip and control elements

### 4.2 Event-Driven Interaction Model

The application implements comprehensive mouse event handling for intuitive user interaction[2]:

  - **Mouse Press Events**: Capture initial click positions for drag operations
  - **Mouse Drag Events**: Enable real-time object movement with visual feedback
  - **Mouse Release Events**: Perform validation and collision detection
  - **Mouse Click Events**: Trigger context menus and object-specific actions

### 4.3 Geometric Collision Detection

The codebase includes sophisticated overlap detection algorithms that handle multiple scenarios[2]:

  - **Room-to-Room Overlap**: Prevents rooms from intersecting using Rectangle.intersects()
  - **Furniture-to-Room Overlap**: Ensures furniture placement within room boundaries
  - **Furniture-to-Furniture Overlap**: Prevents furniture items from overlapping
  - **Boundary Validation**: Keeps all elements within the defined floor plan area (1500x600 pixels)

---

## 5. Comprehensive Feature Set

### 5.1 Room Management System

The application supports four distinct room types, each with unique visual characteristics[2]:

  - **Living Room**: Green translucent overlay (0, 100, 0, 128)
  - **Bedroom**: Red translucent overlay (100, 0, 0, 128)
  - **Kitchen**: Yellow translucent overlay (100, 100, 0, 128)
  - **Bathroom**: Blue translucent overlay (0, 0, 100, 128)

**Advanced Room Features**:
  - **Relative Room Addition**: Create new rooms adjacent to existing ones in cardinal directions
  - **Dynamic Sizing**: Specify custom dimensions for each room during creation
  - **Interactive Deletion**: Right-click context menu for room removal
  - **Drag-and-Drop Repositioning**: Move entire rooms while maintaining collision detection

### 5.2 Furniture and Fixture Library

The application includes a comprehensive catalog of furniture and fixtures with realistic dimensions[2]:

**Furniture Collection**:
  - **Table**: 55x30 pixels - Perfect for dining or work surfaces
  - **Couch**: 85x35 pixels - Scaled for living room arrangements
  - **Chair**: 20x25 pixels - Compact seating option
  - **Bed**: 65x80 pixels - Bedroom centerpiece with realistic proportions
  - **Dining Set**: 55x70 pixels - Complete dining solution

**Fixture Collection**:
  - **Sink**: 30x30 pixels - Kitchen and utility placement
  - **Commode**: 35x45 pixels - Bathroom essential
  - **Bathtub**: 60x80 pixels - Large bathroom fixture
  - **Stove**: 40x40 pixels - Kitchen appliance
  - **Wash Basin**: 30x35 pixels - Bathroom accessory

### 5.3 Architectural Openings System

The application features a sophisticated door and window placement system that validates proper wall attachment[2]:

**Opening Types**:
  - **Horizontal Doors**: 20x4 pixels - For standard wall openings
  - **Vertical Doors**: 4x20 pixels - For perpendicular wall placement
  - **Horizontal Windows**: 20x4 pixels - Wall-mounted fenestration
  - **Vertical Windows**: 4x20 pixels - Side wall fenestration

**Validation Logic**:
  - **Edge Detection**: Ensures doors and windows are placed only on room edges
  - **Border Validation**: Windows must align with exterior walls
  - **Geometric Verification**: Complex algorithms verify proper wall attachment

---

## 6. Advanced Functionality and User Experience

### 6.1 Intelligent Interaction Design

The application prioritizes user experience through thoughtful interaction patterns[2]:

  - **Visual Feedback**: Real-time visual updates during drag operations
  - **Error Prevention**: Comprehensive validation prevents invalid placements
  - **Contextual Dialogs**: Informative messages guide user actions
  - **Undo Functionality**: Automatic reversion to previous positions on invalid moves

### 6.2 Flexible Placement System

  - **Coordinate-Based Precision**: Users can specify exact positions for mathematical precision
  - **Visual Drag-and-Drop**: Intuitive mouse-based placement for quick iterations
  - **Boundary Enforcement**: Automatic constraint to the 1500x600 pixel floor plan area
  - **Smart Collision Avoidance**: Prevents overlapping placements with helpful error messages

### 6.3 Dynamic Asset Management

The application dynamically loads and scales images based on object type[2]:

  - **Automatic Scaling**: Images are resized to appropriate dimensions using SCALE_SMOOTH
  - **Memory Efficiency**: Images are loaded on-demand rather than preloaded
  - **Quality Preservation**: Smooth scaling maintains visual fidelity

---

## 7. Code Organization and Development Practices

### 7.1 Method Structure and Responsibilities

The Grid.java file demonstrates excellent separation of concerns[2]:

  - **Overlap Detection Methods**: Dedicated methods for different collision scenarios
  - **Event Handler Methods**: Separate methods for drag-and-drop, deletion, and relative addition
  - **Validation Methods**: Specialized methods for door/window placement validation
  - **UI Construction Methods**: Organized approach to building the user interface

### 7.2 Error Handling and User Safety

  - **Input Validation**: Try-catch blocks handle non-numeric input gracefully
  - **Boundary Checking**: Comprehensive validation prevents out-of-bounds placement
  - **User Feedback**: Clear error messages explain validation failures
  - **State Recovery**: Automatic reversion to previous valid states on errors

### 7.3 Extensibility and Maintainability

The codebase structure supports easy extension[2]:

  - **Modular Design**: New furniture types can be added by extending existing patterns
  - **Asset Integration**: New images can be incorporated through the existing loading system
  - **Feature Addition**: The layered architecture accommodates new functionality

---

## 8. Application Flexibility and Customization

### 8.1 Scalable Design Framework

The application's architecture supports various customization levels:

  - **Room Customization**: Users can create rooms of any size within the floor plan boundaries
  - **Furniture Flexibility**: All items can be positioned anywhere within valid areas
  - **Layout Adaptability**: The grid system accommodates both structured and free-form designs

### 8.2 Multi-Use Scenarios

The application serves multiple use cases effectively:

  - **Home Planning**: Homeowners can visualize room arrangements before moving
  - **Interior Design**: Designers can experiment with furniture placement
  - **Educational Tool**: Students can learn spatial reasoning and design principles
  - **Architectural Visualization**: Preliminary floor plan creation and validation

This comprehensive floor planning application demonstrates the power of well-structured Java development, combining sophisticated geometric calculations with intuitive user interaction to create a practical tool for spatial design and visualization. 

---

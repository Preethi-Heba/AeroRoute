# ✈️ AeroRoute – Flight Scheduling & Route Optimization System

AeroRoute is a **Java-based console application** for managing airports, flights, flight schedules, flight statuses, and ticket bookings. The system uses a **graph-based representation** of flight connections to discover routes and perform route optimization.

In AeroRoute, **airports are represented as vertices (nodes)** and **flights are represented as directed edges**. The project demonstrates Java Object-Oriented Programming, Collections Framework, graph algorithms, recursion, and in-memory data management.

---

## 🎯 Project Objectives

- Manage airport information.
- Manage flight information.
- Represent flight connections using a directed graph.
- Find routes between airports using BFS and DFS.
- Find the cheapest available route.
- Find the fastest available route.
- Manage flight schedules.
- Update flight status.
- Provide ticket booking functionality.
- Generate a unique PNR for each booking.
- Demonstrate Java OOP and Collections Framework concepts.

---

## 🚀 Features

### 👤 User Management

- User registration
- User login
- User logout
- Basic username and password validation

### 🛫 Airport Management

- Add airport
- Display all airports
- Search for an airport
- Delete an airport

### ✈️ Flight Management

- Add flight
- Display all flights
- Delete flight
- Display flight graph
- Store source and destination airport connections

### 🗺️ Route Finding

AeroRoute supports multiple route-finding and optimization methods:

- **BFS (Breadth-First Search)** – Finds a route with the minimum number of flight segments in the graph.
- **DFS (Depth-First Search)** – Finds a valid route using depth-first traversal.
- **Cheapest Route** – Finds the route with the minimum total fare.
- **Fastest Route** – Finds the route with the minimum total travel duration.

### 🕐 Flight Scheduling

- Add flight schedules
- View available flight schedules
- Store departure and arrival information

### 📍 Flight Status

- Update flight status
- Set flights as:
  - On Time
  - Delayed
  - Cancelled

### 🎫 Ticket Booking

- Book a flight
- Enter passenger name
- Select seat number
- Generate a unique PNR
- View booking details

---

## 🧠 Algorithms Used

| Algorithm / Technique | Purpose |
|---|---|
| BFS | Finds a route with the minimum number of flight segments |
| DFS | Finds a valid route using depth-first traversal |
| Recursive Graph Traversal | Used for route exploration |
| Route Comparison | Compares possible routes based on fare |
| Route Comparison | Compares possible routes based on duration |
| Adjacency List | Represents flight connections |

---

## 🏗️ System Architecture

``
                         USER
                           │
                           ▼
                  ┌─────────────────┐
                  │ Console / Menu  │
                  └────────┬────────┘
                           │
                           ▼
                  ┌─────────────────┐
                  │    Services     │
                  └────────┬────────┘
                           │
          ┌────────────────┼────────────────┐
          │                │                │
          ▼                ▼                ▼
   Route Service      User Service    Booking Service
          │                                 │
          │                ┌────────────────┤
          │                │                │
          ▼                ▼                ▼
   Flight Graph     Schedule Service   Status Service
          │
          ▼
 ┌────────────────────────────┐
 │ Java Collections Framework │
 │ HashMap + ArrayList +      │
 │ Queue + HashSet            │
 └─────────────┬──────────────┘
               │
               ▼
        Route Results
🛠️ Technologies Used
Programming Language: Java
Development Environment: Visual Studio Code
Version Control: Git and GitHub
Data Structures:
HashMap
ArrayList
Queue
LinkedList
HashSet
Programming Concepts:
Object-Oriented Programming
Encapsulation
Classes and Objects
Collections Framework
Graph Representation
Recursion
Searching
Route Optimization
Storage: In-memory Java collections
📁 Project Structure
AeroRoute/
│
├── src/
│   │
│   ├── graph/
│   │   └── FlightGraph.java
│   │
│   ├── main/
│   │   └── Main.java
│   │
│   ├── menu/
│   │   └── Menu.java
│   │
│   ├── model/
│   │   ├── Airport.java
│   │   ├── Booking.java
│   │   ├── Flight.java
│   │   ├── FlightSchedule.java
│   │   ├── RouteResult.java
│   │   └── User.java
│   │
│   ├── service/
│   │   ├── BookingService.java
│   │   ├── FlightScheduleService.java
│   │   ├── FlightStatusService.java
│   │   ├── RouteService.java
│   │   └── UserService.java
│   │
│   └── util/
│       └── Validation.java
│
├── screenshots/
│   └── AeroRoute_Output.png
│
├── .gitignore
└── README.md
🔄 System Workflow
Start Application
       │
       ▼
 User Registration / Login
       │
       ▼
    Main Menu
       │
       ├── Airport Management
       │
       ├── Flight Management
       │
       ├── Graph Display
       │
       ├── BFS Route Search
       │
       ├── DFS Route Search
       │
       ├── Cheapest Route
       │
       ├── Fastest Route
       │
       ├── Flight Schedule
       │
       ├── Flight Status
       │
       └── Ticket Booking
       │
       ▼
     Logout
       │
       ▼
      Exit
📊 Graph Representation

AeroRoute uses an adjacency list to represent the flight network.

For example:

DEL
 ├──→ BLR
 ├──→ MAA
 └──→ HYD

BLR
 ├──→ BOM
 └──→ MAA

MAA
 └──→ BOM

HYD
 └──→ BOM

The graph is internally maintained using Java collections:

HashMap<String, ArrayList<Flight>>

The airport code is used as the key, and the corresponding list stores flights leaving that airport.

🧪 Sample Airport Data
Code	Airport	City	Country
DEL	Indira Gandhi International Airport	Delhi	India
BOM	Chhatrapati Shivaji Maharaj International Airport	Mumbai	India
BLR	Kempegowda International Airport	Bengaluru	India
MAA	Chennai International Airport	Chennai	India
HYD	Rajiv Gandhi International Airport	Hyderabad	India
✈️ Sample Flight Data

The following data can be used to test the application:

Flight Number	Source	Destination	Fare	Duration
AR101	DEL	BLR	₹5000	2 hrs
AR102	BLR	BOM	₹4500	2 hrs
AR103	DEL	MAA	₹3000	3 hrs
AR104	MAA	BOM	₹2500	2 hrs
AR105	DEL	HYD	₹3500	2.5 hrs
AR106	HYD	BOM	₹2800	2.5 hrs
AR107	BLR	MAA	₹2000	1.5 hrs

Note: The airport codes represent real airport codes. The flight numbers, fares, and durations above are sample project data used for testing and demonstration.

🗺️ Example Route Analysis
Route 1
DEL → BLR → BOM
Total Fare     : ₹9500
Total Duration : 4 hours
Route 2
DEL → MAA → BOM
Total Fare     : ₹5500
Total Duration : 5 hours
Route 3
DEL → HYD → BOM
Total Fare     : ₹6300
Total Duration : 5 hours
Result
Cheapest Route:
DEL → MAA → BOM
Fare: ₹5500

Fastest Route:
DEL → BLR → BOM
Duration: 4 hours

This demonstrates that the cheapest route and fastest route do not necessarily have to be the same.

🔍 BFS vs DFS
Feature	BFS	DFS
Full Form	Breadth-First Search	Depth-First Search
Data Structure	Queue	Recursion / Stack
Traversal	Level by level	Depth first
Route Property	Minimum number of edges in an unweighted graph	Finds a valid route
Guaranteed Cheapest?	No	No
Guaranteed Fastest?	No	No

BFS and DFS are used for route discovery, while cheapest and fastest route functions compare route costs based on fare and duration.

🖥️ Main Menu

The application provides the following options:

===== AEROROUTE MAIN MENU =====

1. Add Airport
2. Add Flight
3. Display Airports
4. Display Flights
5. Search Airport
6. Delete Airport
7. Delete Flight
8. Display Graph
9. Find Route using BFS
10. Find Route using DFS
11. Find Cheapest Route
12. Find Fastest Route
13. Add Flight Schedule
14. View Flight Schedule
15. Update Flight Status
16. Book Ticket
17. View Bookings
18. Logout
🎫 Sample Booking Output
===== BOOKINGS =====

PNR: AR1001
Passenger: PREETHI
Flight: AR101
Seat: 12A

The flight number identifies the flight, while the PNR uniquely identifies the passenger's booking.

▶️ How to Run the Project
Prerequisites

Make sure Java is installed.

Check the Java version:

java -version

Check the Java compiler:

javac -version
Run Using VS Code

Open the AeroRoute project folder in Visual Studio Code.

Open the integrated terminal and make sure you are inside the project root:

AeroRoute

Compile the Java source files:

javac -d out src/*/*.java

Run the application:

java -cp out main.Main
🔐 Demo Login

For project demonstration, the default test account is:

Username: admin
Password: admin123

This is a sample academic/demo credential and should not be used as a real password.

📸 Output Screenshots

The screenshots folder contains screenshots of the working AeroRoute application.

The main output screenshot can be displayed below:

🧩 Java Concepts Demonstrated
Object-Oriented Programming

The project demonstrates:

Classes and Objects
Encapsulation
Constructors
Methods
Getters and Setters
Separation of responsibilities
Collections Framework

The project uses:

HashMap
ArrayList
Queue
LinkedList
HashSet
Graph Concepts

The project demonstrates:

Vertices
Directed edges
Adjacency list
Graph traversal
Route discovery
Route comparison
Recursion

DFS uses recursive traversal to explore connected airports.

📈 Complexity Overview
Operation	Typical Complexity
HashMap access	Average O(1)
Add airport	Average O(1)
Add flight	Average O(1) for adjacency-list insertion
BFS	O(V + E)
DFS	O(V + E) for traversal
Graph display	O(V + E)

Where:

V = Number of airports (vertices)
E = Number of flights (edges)

Route optimization in the current educational implementation explores possible simple routes, so its worst-case running time can grow significantly with the number of possible paths.

💡 Current Implementation

The current version provides:

User registration and login
Airport management
Flight management
Graph representation
BFS route discovery
DFS route discovery
Cheapest route search
Fastest route search
Flight schedule management
Flight status management
Ticket booking
PNR generation
Booking display

The application currently uses in-memory Java collections, so data is available while the program is running.

🔮 Future Scope

The following enhancements can be added in future versions:

MySQL database integration
GUI / Web application
Real-time flight API integration
Dijkstra / A* based weighted route optimization
Layover validation
Online payment and e-ticketing
Admin dashboard
Role-based user access
Flight delay and cancellation notifications
Cloud deployment
Improved scalability
Persistent user and booking data
⚠️ Limitations
Data is currently stored in memory.
Data is lost when the application terminates.
The current application is console-based.
Flight information is sample project data.
Real-time airline data is not currently connected.
Layover validation is not currently integrated into route calculation.
Database persistence is not currently implemented.
🎓 Academic Purpose

AeroRoute is developed as an academic Java project to demonstrate the practical application of:

Data Structures
Graph Algorithms
Object-Oriented Programming
Java Collections Framework
Console Application Development
Software Design and Modular Programming
👩‍💻 Project Team

Preethi Balaji
Hagathiya Saravanan

Faculty Guide: Mrs. Geetha

Institution: Chennai Institute of Technology

📌 Project Information

Project Name: AeroRoute

Project Title:
A Graph-Based Flight Scheduling and Route Optimization System

Domain: Java / Data Structures / Graph Algorithms

Application Type: Console-Based Java Application

Development Environment: Visual Studio Code

Version Control: Git and GitHub

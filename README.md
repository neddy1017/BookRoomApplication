# BookRoomApplication

Assignment  
Assuming that we only have a mee2ng room to use:
- Build API with Spring Services for Book Room, Cancel Room, Fetch Available Rooms, and Fetch Booked Rooms.
- Your code must check for booking conflict if your “to book” period is overlapping with an exis2ng booked room.
- Create your applica2on using Spring Boot CRUD with Maven. Use Spring Data and JPA for your data model. Add addi2onal unit test to support your REST API. Use Basic or JWT Token for Authen2ca2on for your REST API.  

Steps  
1. Create a repository on github.
2. Start working on the assignment. Now you have 2 days to complete this assignment. 3. If possible, please deploy your work and add proper setup guidelines.
4. Use postman or test class to execute your flow (Front-end interface is not required)  

Bonus  
It’s nice bonus if applicant’s assignment includes:  
• Docker or AWS deployment  
• Web Socket  
• Spring Security  


### Test Case
## 1. Book Room. 

TestURL:http://localhost:8080/bookingroom/book_room
<img width="1014" alt="bookroom" src="https://user-images.githubusercontent.com/23652206/223165941-7e766fa1-4ec9-4e4d-9c31-05e7ac692278.png">

check if overlapping
<img width="1018" alt="bookroom_overlap" src="https://user-images.githubusercontent.com/23652206/223166102-de3179e3-13a5-4bcc-9445-b7e73c0d66df.png">

## 2. Cancel Room

TestURL: http://localhost:8080/bookingroom/cancel_room?id=16
<img width="549" alt="cancel_room" src="https://user-images.githubusercontent.com/23652206/223167081-f945a24f-849d-44db-8560-c9552c92e9ab.png">

Before Cancel: <img width="650" alt="mysql" src="https://user-images.githubusercontent.com/23652206/223167164-7d578889-d8a9-41fa-bf0b-273723322c22.png">

After Cancel: <img width="651" alt="after_cancel" src="https://user-images.githubusercontent.com/23652206/223167263-56cf85cb-51b4-415b-bc24-d9521abd4f0c.png">

### 3.Fetch Available Rooms

TestURL: http://localhost:8080/bookingroom/fetch_available_rooms

Need startDateTime & endDateTime to get Available Rooms.  
Default Room have Room1 & Room2.
<img width="892" alt="AVAIBLE Rooms" src="https://user-images.githubusercontent.com/23652206/223169030-bb7b4084-73c1-41c4-8681-e7ccbdeed867.png">


### 4.Fetch Booked Rooms

TestURL: http://localhost:8080/bookingroom/fetch_booked_rooms

Get all booked room 

<img width="612" alt="Fetch Booked Rooms" src="https://user-images.githubusercontent.com/23652206/223169528-6be01ea0-8533-4997-8132-09c82d229559.png">






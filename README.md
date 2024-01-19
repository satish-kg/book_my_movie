A backend application built using Java, Spring Boot and Maven which uses MySQL as database. 
Libraries used : jakarta.persistence, org.springframework, lombok. APIs and entity list are provided below.

The APIs created are :
1. (POST) addMovie API : Accepts a MovieEntryDTO and returns a response entity after converting MovieEntryDTO to movieEntity and saving it.
2. (POST) addShow API : Accepts a ShowEntryDTO and returns a response entity after converting ShowEntryDTO to showEntity and saving it.
3. (POST) addTheater API : Accepts a TheaterEntryDTO and returns a response entity after converting TheaterEntryDTO to theaterEntity and saving it.
4. (POST) bookTicket API : Accepts a TicketEntryDTO and returns a response entity after converting TicketEntryDTO to ticketEntity and saving it.
5. (POST) addUser API : Accepts a UserEntryDTO and returns a response entity after converting UserEntryDTO to userEntity and saving it.

The Entities and their relations are :
1. MovieEntity : @OneToMany(mappedBy = "movieEntity", cascade = CascadeType.ALL)
                 private List<ShowEntity> showEntityList  = new ArrayList<>();
2. ShowEntity : @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
                private List<ShowSeatEntity> listOfShowSeats = new ArrayList<>();
                @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
                private List<TicketEntity> listOfBookedTickets = new ArrayList<>();
3. ShowSeatEntity (used for ticket booking) :
                    @ManyToOne
                    @JoinColumn
                    private ShowEntity showEntity;
4. TheaterEntity :  @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
                    private List<ShowEntity> showEntityList = new ArrayList<>();
                    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
                    private List<TheaterSeatEntity> theaterSeatEntityList = new ArrayList<>();
5. TheaterSeatEntity (used for ticket booking) :
                    @ManyToOne
                    @JoinColumn
                    private TheaterEntity theaterEntity;
6. TicketEntity :   @ManyToOne
                    @JoinColumn
                    private UserEntity userEntity;
                    @ManyToOne
                    @JoinColumn
                    private ShowEntity showEntity;
7. UserEntity :     @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
                    private List<TicketEntity> bookedTicketList = new ArrayList<>();

   


    private final PurchaseService purchaseService;
    private final TourScheduleService tourScheduleService;
    private final TravelAgentService travelAgentService;
    private final ClientService clientService;
    private final TransportService transportService;
    private final TransportSeatService transportSeatService;

    @Autowired
    public PurchaseServiceTest(PurchaseService purchaseService,
                               TourScheduleService tourScheduleService,
                               TravelAgentService travelAgentService,
                               ClientService clientService,
                               TransportService transportService,
                               TransportSeatService transportSeatService) {
        this.purchaseService = purchaseService;
        this.tourScheduleService = tourScheduleService;
        this.travelAgentService = travelAgentService;
        this.clientService = clientService;
        this.transportService = transportService;
        this.transportSeatService = transportSeatService;
    }

    @Test
    public void list() {
        Integer expected = 1;
        Integer actual = purchaseService.list().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getById() {
        Purchase purchase = purchaseService.getById(1);
        Integer actual = purchase.getId();
        Integer expected = 1;

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void save() {
        LocalDateTime localDateTime = LocalDateTime.now();
        Purchase newPurchase = new Purchase(tourScheduleService.getById(2),travelAgentService.getById(2),clientService.getById(2),transportService.getById(2),transportSeatService.getById(2), localDateTime);
        purchaseService.save(newPurchase);

        Assert.assertNotNull(purchaseService.getById(2));
    }

    @Test
    public void delete() {
        LocalDateTime localDateTime = LocalDateTime.now();

        Purchase newPurchase = new Purchase(tourScheduleService.getById(2),travelAgentService.getById(2),clientService.getById(2),transportService.getById(2),transportSeatService.getById(2),localDateTime);
        purchaseService.save(newPurchase);

        Assert.assertNotNull(purchaseService.getById(2));

        purchaseService.delete(2);
        Assert.assertEquals(1,purchaseService.list().size());
    }
}
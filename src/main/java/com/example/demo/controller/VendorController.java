@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    private final VendorService service;

    public VendorController(VendorService service) {
        this.service = service;
    }

    @PostMapping public Vendor create(@RequestBody Vendor v){ return service.create(v); }
    @GetMapping("/{id}") public Vendor get(@PathVariable Long id){ return service.getById(id); }
    @GetMapping public List<Vendor> all(){ return service.getAll(); }
    @PutMapping("/{id}") public Vendor update(@PathVariable Long id,@RequestBody Vendor v){ return service.update(id,v); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ service.delete(id); }
}

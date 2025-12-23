@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository repo;

    public VendorServiceImpl(VendorRepository repo) {
        this.repo = repo;
    }

    public Vendor create(Vendor v) { return repo.save(v); }

    public Vendor update(Long id, Vendor v) {
        Vendor e = repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
        e.setName(v.getName());
        e.setContactEmail(v.getContactEmail());
        e.setContactPhone(v.getContactPhone());
        e.setActive(v.getActive());
        return repo.save(e);
    }

    public Vendor getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("not found"));
    }

    public List<Vendor> getAll() { return repo.findAll(); }

    public void delete(Long id) { repo.deleteById(id); }
}

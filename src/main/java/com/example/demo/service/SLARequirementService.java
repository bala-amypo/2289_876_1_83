public interface SLARequirementService {
    SLARequirement create(SLARequirement r);
    SLARequirement update(Long id, SLARequirement r);
    SLARequirement getById(Long id);
    List<SLARequirement> getAll();
    void delete(Long id);
}

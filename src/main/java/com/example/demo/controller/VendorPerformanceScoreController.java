@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class VendorPerformanceScoreController {

    private final VendorPerformanceScoreService vendorPerformanceScoreService;

    /**
     * Calculate score for a vendor
     */
    @PostMapping("/calculate/{vendorId}")
    public ResponseEntity<String> calculateScore(
            @PathVariable Long vendorId) {

        // VendorPerformanceScoreDto score =
        //         vendorPerformanceScoreService.calculateScore(vendorId);
        return ResponseEntity.ok("vendorId: "+ vendorId);
    }

    /**
     * Get latest score for a vendor
     */
    @GetMapping("/latest/{vendorId}")
    public ResponseEntity<String> getLatestScore(
            @PathVariable Long vendorId) {

        // VendorPerformanceScoreDto latestScore =
        //         vendorPerformanceScoreService.getLatestScore(vendorId);
        return ResponseEntity.ok("vendorId: "+ vendorId);
    }

    /**
     * Get score history for a vendor
     */
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<String> getScoreHistory(
            @PathVariable Long vendorId) {

        // List<VendorPerformanceScoreDto> scores =
        //         vendorPerformanceScoreService.getScoreHistory(vendorId);
        return ResponseEntity.ok("vendorId: "+ vendorId);
    }
}
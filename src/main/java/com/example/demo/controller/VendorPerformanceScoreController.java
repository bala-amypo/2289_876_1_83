@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class VendorPerformanceScoreController {

    private final VendorPerformanceScoreService vendorPerformanceScoreService;

    /**
     * Calculate score for a vendor
     */
    @PostMapping("/calculate/{vendorId}")
    public ResponseEntity<VendorPerformanceScoreDto> calculateScore(
            @PathVariable Long vendorId) {

        // VendorPerformanceScoreDto score =
        //         vendorPerformanceScoreService.calculateScore(vendorId);
        return ResponseEntity.ok("vendorId: "+ vendorId);
    }

    /**
     * Get latest score for a vendor
     */
    @GetMapping("/latest/{vendorId}")
    public ResponseEntity<VendorPerformanceScoreDto> getLatestScore(
            @PathVariable Long vendorId) {

        VendorPerformanceScoreDto latestScore =
                vendorPerformanceScoreService.getLatestScore(vendorId);
        return ResponseEntity.ok(latestScore);
    }

    /**
     * Get score history for a vendor
     */
    @GetMapping("/vendor/{vendorId}")
    public ResponseEntity<List<VendorPerformanceScoreDto>> getScoreHistory(
            @PathVariable Long vendorId) {

        List<VendorPerformanceScoreDto> scores =
                vendorPerformanceScoreService.getScoreHistory(vendorId);
        return ResponseEntity.ok(scores);
    }
}
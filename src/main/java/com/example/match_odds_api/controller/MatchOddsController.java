package com.example.match_odds_api.controller;

import com.example.match_odds_api.entity.MatchOdds;
import com.example.match_odds_api.service.MatchOddsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odds")
public class MatchOddsController {

    private final MatchOddsService matchOddsService;

    public MatchOddsController(MatchOddsService matchOddsService) {
        this.matchOddsService = matchOddsService;
    }

    @PostMapping
    public MatchOdds createOdds(@RequestBody MatchOdds odds) {
        return matchOddsService.createOdds(odds);
    }

    @GetMapping
    public List<MatchOdds> getAllOdds() {
        return matchOddsService.getAllOdds();
    }

    @GetMapping("/{id}")
    public Optional<MatchOdds> getOddsById(@PathVariable Long id) {
        return matchOddsService.getOddsById(id);
    }

    @PutMapping("/{id}")
    public MatchOdds updateOdds(@PathVariable Long id, @RequestBody MatchOdds odds) {
        return matchOddsService.updateOdds(id, odds);
    }

    @DeleteMapping("/{id}")
    public void deleteOdds(@PathVariable Long id) {
        matchOddsService.deleteOdds(id);
    }
}
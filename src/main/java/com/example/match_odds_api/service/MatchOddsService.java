package com.example.match_odds_api.service;

import com.example.match_odds_api.entity.MatchOdds;
import com.example.match_odds_api.repository.MatchOddsRepository;
import com.example.match_odds_api.repository.MatchRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchOddsService {

    private final MatchOddsRepository matchOddsRepository;
    private final MatchRepository matchRepository;

    public MatchOddsService(MatchOddsRepository matchOddsRepository, MatchRepository matchRepository) {
    this.matchOddsRepository = matchOddsRepository;
    this.matchRepository = matchRepository;
}

    public MatchOdds createOdds(MatchOdds odds) {
    if (!matchRepository.existsById(odds.getMatchId())) {
        throw new RuntimeException("Match with id " + odds.getMatchId() + " does not exist");
    }

    return matchOddsRepository.save(odds);
}

    public List<MatchOdds> getAllOdds() {
        return matchOddsRepository.findAll();
    }

    public Optional<MatchOdds> getOddsById(Long id) {
        return matchOddsRepository.findById(id);
    }

    public MatchOdds updateOdds(Long id, MatchOdds updatedOdds) {
        return matchOddsRepository.findById(id)
                .map(odds -> {
                    odds.setMatchId(updatedOdds.getMatchId());
                    odds.setSpecifier(updatedOdds.getSpecifier());
                    odds.setOdd(updatedOdds.getOdd());
                    return matchOddsRepository.save(odds);
                })
                .orElseThrow(() -> new RuntimeException("Odds not found"));
    }

    public void deleteOdds(Long id) {
        matchOddsRepository.deleteById(id);
    }
}
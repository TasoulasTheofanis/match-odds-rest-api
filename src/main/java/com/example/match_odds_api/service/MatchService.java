package com.example.match_odds_api.service;

import com.example.match_odds_api.entity.Match;
import com.example.match_odds_api.repository.MatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatchService {

    private final MatchRepository matchRepository;

    public MatchService(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    public Optional<Match> getMatchById(Long id) {
        return matchRepository.findById(id);
    }

    public Match updateMatch(Long id, Match updatedMatch) {
        return matchRepository.findById(id)
                .map(match -> {
                    match.setDescription(updatedMatch.getDescription());
                    match.setMatchDate(updatedMatch.getMatchDate());
                    match.setMatchTime(updatedMatch.getMatchTime());
                    match.setTeamA(updatedMatch.getTeamA());
                    match.setTeamB(updatedMatch.getTeamB());
                    match.setSport(updatedMatch.getSport());
                    return matchRepository.save(match);
                })
                .orElseThrow(() -> new RuntimeException("Match not found"));
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
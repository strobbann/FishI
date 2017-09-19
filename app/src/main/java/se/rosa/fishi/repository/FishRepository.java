package se.rosa.fishi.repository;

import java.util.List;

import se.rosa.fishi.model.Fish;

public interface FishRepository {
    Fish addFish(Fish fish);
    Fish getFish(String id);
    List<Fish> getFishes();
}

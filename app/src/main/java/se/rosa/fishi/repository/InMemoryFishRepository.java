package se.rosa.fishi.repository;

import java.util.ArrayList;
import java.util.List;

import se.rosa.fishi.model.Fish;

public class InMemoryFishRepository implements FishRepository {

    private static final List<Fish> fishes = new ArrayList<>();

    public InMemoryFishRepository() {
        fillRepo();
    }

    private static void fillRepo(){
        for (int i = 0; i < 10 ; i++){
            Fish fish = new Fish(String.valueOf(i), Fish.FishType.PERCH, i, i*i);
            Fish fish2 = new Fish(String.valueOf(i), Fish.FishType.PIKE, i, i*i);
            fishes.add(fish);
            fishes.add(fish2);
        }
    }

    @Override
    public Fish addFish(Fish fish) {
        fishes.add(fish);
        return fish;
    }

    @Override
    public Fish getFish(String id) {
        return fishes.get(Integer.valueOf(id));
    }

    @Override
    public List<Fish> getFishes() {
        return new ArrayList<>(fishes);
    }
}

package ai;

import ai.state.AIState;
import entity.NPC;
import game.state.State;

public class Stand extends AIState {

    private  int updateAlive;

    @Override
    protected AITransition initializeTransition() {
        return new AITransition("wander",((state, currentCharacter) -> updateAlive >=state.getTime().getUpdateFromSeconds(3)));
    }

    @Override
    public void update(State state, NPC currentCharacter) {
            updateAlive ++;
    }
}

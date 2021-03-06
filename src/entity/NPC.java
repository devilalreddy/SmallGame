package entity;

import ai.AIManager;
import controller.Controller;
import game.state.State;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import javax.print.attribute.standard.MediaSize;

public class NPC extends MovingEntity {
    private AIManager aiManager;

    public NPC(Controller controller, SpriteLibrary spriteLibrary) {
        super(controller, spriteLibrary);
        animationManager =  new AnimationManager(spriteLibrary.getUnit("dave"));
        aiManager = new AIManager();
    }

    @Override
    public void update(State state) {
        super.update(state);
        aiManager.update(state,this);
    }

    @Override
    protected void handleCollision(GameObject other) {
        if (other instanceof Player) {
            motion.stop(willCollideX(other),willCollideY(other));
        }
    }
}

/**
 * An action that can be taken by an entity
 */
public final class Action {
    private final ActionKind kind;
    private final Entity entity;
    private final WorldModel world;
    private final ImageStore imageStore;
    private final int repeatCount;

    public Action(ActionKind kind, Entity entity, WorldModel world, ImageStore imageStore, int repeatCount) {
        this.kind = kind;
        this.entity = entity;
        this.world = world;
        this.imageStore = imageStore;
        this.repeatCount = repeatCount;
    }

    private void executeActivityAction(EventScheduler scheduler) {

        switch (this.entity.getKind()) {
            case SAPLING:
                entity.executeSaplingActivity(this.world, this.imageStore, scheduler);
                break;
            case TREE:
                entity.executeTreeActivity(this.world, this.imageStore, scheduler);
                break;
            case FAIRY:
                entity.executeFairyActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_NOT_FULL:
                entity.executeDudeNotFullActivity(this.world, this.imageStore, scheduler);
                break;
            case DUDE_FULL:
                entity.executeDudeFullActivity(this.world, this.imageStore, scheduler);
                break;
            default:
                throw new UnsupportedOperationException(String.format("executeActivityAction not supported for %s", this.entity.getKind()));
        }
    }
    public void executeAction(EventScheduler scheduler) {
        switch (this.kind) {
            case ACTIVITY:
                executeActivityAction(scheduler);
                break;

            case ANIMATION:
                executeAnimationAction(scheduler);
                break;
        }
    }
    private void executeAnimationAction(EventScheduler scheduler) {
        entity.nextImage();

        if (this.repeatCount != 1) {
            scheduler.scheduleEvent(this.entity, entity.createAnimationAction(Math.max(this.repeatCount - 1, 0)), entity.getAnimationPeriod());
        }
    }
}
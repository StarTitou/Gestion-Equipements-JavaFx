package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;

/**
 * Animate a fade in left effect on a node
 * <p>
 * Port of FadeInLeft from Animate.css http://daneden.me/animate by Dan Eden
 * <p>
 * {@literal @}keyframes fadeInLeft {
 * 0% {
 * opacity: 0;
 * transform: translateX(-20px);
 * }
 * 100% {
 * opacity: 1;
 * transform: translateX(0);
 * }
 * }
 *
 * @author Jasper Potts
 */
@SuppressWarnings("deprecation")
public class FadeInLeftTransition1 extends configAnimasi {
    /**
     * Create new FadeInLeftTransition
     *
     * @param node The node to affect
     */
    public FadeInLeftTransition1(final Node node) {
        super(
                node,
                TimelineBuilder.create()
                        .keyFrames(
                                new KeyFrame(Duration.millis(0),
                                        new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                                        new KeyValue(node.translateXProperty(), -20, WEB_EASE)
                                ),
                                new KeyFrame(Duration.millis(700),
                                        new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                                        new KeyValue(node.translateXProperty(), 0, WEB_EASE)
                                )
                        )
                        .build()
        );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0));
    }
}

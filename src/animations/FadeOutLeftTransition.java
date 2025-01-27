/*
    Animation For JavaFX
*/

package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.TimelineBuilder;
import javafx.scene.Node;
import javafx.util.Duration;


/* 
    Created on : Sep 13, 2014, 8:45:48 AM
    Author     : herudi-pc
*/

public class FadeOutLeftTransition extends configAnimasi {
    /**
     * Create new FadeOutUpTransition
     *
     * @param node The node to affect
     */
    public FadeOutLeftTransition(final Node node) {
        super(
                node,
                TimelineBuilder.create()
                        .keyFrames(
                                new KeyFrame(Duration.millis(50),
                                        new KeyValue(node.opacityProperty(), 1, WEB_EASE),
                                        new KeyValue(node.translateXProperty(), 0, WEB_EASE)
                                ),
                                new KeyFrame(Duration.millis(500),
                                        new KeyValue(node.opacityProperty(), 0, WEB_EASE),
                                        new KeyValue(node.translateXProperty(), -10, WEB_EASE)
                                )
                        )
                        .build()
        );
        setCycleDuration(Duration.seconds(1));
        setDelay(Duration.seconds(0));
    }

    @Override
    protected void stopping() {
        super.stopping();
        node.setTranslateX(0);
        node.toBack();// restore default
    }
}

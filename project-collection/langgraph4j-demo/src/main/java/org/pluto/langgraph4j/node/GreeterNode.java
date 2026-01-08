package org.pluto.langgraph4j.node;

import org.bsc.langgraph4j.action.NodeAction;
import org.pluto.langgraph4j.state.SimpleState;

import java.util.Map;

public class GreeterNode implements NodeAction<SimpleState> {
    @Override
    public Map<String, Object> apply(SimpleState state) throws Exception {
        System.out.println("GreeterNode executing. Current messages: " + state.messages());
        return Map.of(SimpleState.MESSAGES_KEY, "Hello from GreeterNode!");
    }

}

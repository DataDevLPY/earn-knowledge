package org.pluto.langgraph4j.app;

import org.bsc.langgraph4j.GraphStateException;
import org.bsc.langgraph4j.StateGraph;
import org.pluto.langgraph4j.node.GreeterNode;
import org.pluto.langgraph4j.node.ResponderNode;
import org.pluto.langgraph4j.state.SimpleState;

import java.util.Map;

import static org.bsc.langgraph4j.GraphDefinition.END;
import static org.bsc.langgraph4j.GraphDefinition.START;
import static org.bsc.langgraph4j.action.AsyncNodeAction.node_async;

public class SimpleGraphApp {

    public static void main(String[] args) throws GraphStateException {
        // 创建状态图
        var stateGraph = new StateGraph<>(SimpleState.SCHEMA,
                initData -> new SimpleState(initData))
                .addNode("greeter", node_async(new GreeterNode()))
                .addNode("responder", node_async(new ResponderNode()))
                .addEdge(START, "greeter")
                .addEdge("greeter", "responder")
                .addEdge("responder", END);

        // 编译图
        var compiledGraph = stateGraph.compile();

        // 运行图
        for (var item : compiledGraph.stream(Map.of(SimpleState.MESSAGES_KEY, "Let's begin!"))) {
            System.out.println(item);
        }
    }
}
